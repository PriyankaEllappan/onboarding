/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.service.LDAPService;
import com.cts.nw.onboarding.util.EmployeeDetails;

/**
 * @author 616550
 *
 */
@PropertySource(value = { "classpath:ldap.properties" })

@Service
public class LDAPServiceImpl implements LDAPService {

	@Autowired
	private Environment environment;
	
	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.service.LDAPService#getEmployee(java.lang.String, java.lang.String)
	 */
	@Override
	public EmployeeDetails getEmployee(String empIdtoSearch) {
		EmployeeDetails employeeDetails = null;
		try {
			employeeDetails = getValidEmployee(empIdtoSearch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeDetails;
	}

	/**
	 * @param searchProperty
	 * @param empIdtoSearch
	 * @return
	 */
	private EmployeeDetails getValidEmployee(String empIdtoSearch) {
		DirContext ctx = null;
		@SuppressWarnings("rawtypes")
		NamingEnumeration results = null;
		EmployeeDetails profile = null;
		Attribute name = null;
		Attribute associateId = null;
		Attribute distinguishedname = null;
		Attribute title = null;
		Attribute email = null;

		try {
			ctx = new InitialDirContext(getConnection());
			SearchControls controls = new SearchControls();
			controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			String searchFilter = null;
			if ("sAMAccountName".equals(environment.getRequiredProperty("SEARCHPROPERTY"))) {
				searchFilter = "sAMAccountName=" + empIdtoSearch;
			}
			results = ctx.search("OU=Cognizant,DC=cts,DC=com", searchFilter, controls);

			while (results.hasMore()) {
				SearchResult searchResult = (SearchResult) results.next();
				Attributes attributes = searchResult.getAttributes();
				if (attributes != null) {
					name = attributes.get("cn");
					associateId = attributes.get("sAMAccountName");
					email = attributes.get("mail");
					distinguishedname = attributes.get("distinguishedname");
					title = attributes.get("title");
				} else {
					System.out.println("attributes is null");
				}
				profile = assignValuestoEmployeeObject(name, associateId, distinguishedname, title, email);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (results != null) {
					results.close();
				}
				if (ctx != null) {
					ctx.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return profile;
	}

	/**
	 * @param name
	 * @param associateId
	 * @param distinguishedname
	 * @param title
	 * @param email
	 * @return
	 * @throws NamingException
	 */
	private EmployeeDetails assignValuestoEmployeeObject(Attribute name, Attribute associateId,
			Attribute distinguishedname, Attribute title, Attribute email) throws NamingException {
		EmployeeDetails employeProfile = new EmployeeDetails();
		try {
			employeProfile.setName(isNull(name) ? null : (String) name.get()); 
			employeProfile.setAssociateId(isNull(associateId) ? null : Integer.parseInt((String) associateId.get())); 
			employeProfile.setEmailId(isNull(email) ? null : (String) email.get()); 
			employeProfile.setDistinguishedName(isNull(distinguishedname) ? null : (String) distinguishedname.get()); 
			employeProfile.setDesignation(isNull(title) ? null : (String) title.get()); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeProfile;
	}

	/**
	 * @param name
	 * @return
	 */
	private boolean isNull(Attribute name) {
		return name != null ? false : true;
	}

	private Hashtable<String, String> getConnection() {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, environment.getRequiredProperty("INITIAL_CONTEXT_FACTORY"));
		env.put(Context.PROVIDER_URL, environment.getRequiredProperty("PROVIDER_URL"));
		env.put(Context.SECURITY_AUTHENTICATION, environment.getRequiredProperty("SECURITY_AUTHENTICATION"));
		env.put(Context.SECURITY_PRINCIPAL, environment.getRequiredProperty("SECURITY_PRINCIPAL") );
		env.put(Context.SECURITY_CREDENTIALS, environment.getRequiredProperty("SECURITY_CREDENTIALS"));
		return env;
	}

}
