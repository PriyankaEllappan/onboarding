package com.cts.nw.onboarding.util;

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

import com.cts.nw.onboarding.vo.EmployeeDetails;

public class LDAPUtil {
	private static String ldapMasterUserName = "CN=Suresh Baskar,OU=Users,OU=WCB,OU=Chennai,OU=India,OU=APAC,OU=Cognizant,DC=cts,DC=com";
	private static String  ldapMasterPassword = "$ureDec18"; //give your windows username in above line (replace 659029 with your username) & password in this line
	private static String ldapProviderUrl = "ldap://10.242.29.15:389";
		
	public EmployeeDetails validateEmployee(String userName, String password)  {
		EmployeeDetails employee = getEmployee("sAMAccountName", userName);
		EmployeeDetails validEmployee = null;
		try{
			validEmployee = getValidEmployee("sAMAccountName", userName,employee.getDistinguishedName(), password);	
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null; //returning null response, as we had exception here
		}
		
		if (null != validEmployee && null != validEmployee.getEmailId()) {
			return validEmployee;
		}
		return validEmployee;
	}
	
	public EmployeeDetails getEmployee(String property, String value) {
		try {

			return getValidEmployee(property, value, ldapMasterUserName, ldapMasterPassword);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new EmployeeDetails();
		}
	}
	
	private EmployeeDetails getValidEmployee(String searchAttribute, String searchAttributeValue,String ldapUserName,String password) {
		DirContext ctx = null;
		NamingEnumeration results = null;
		EmployeeDetails profile = new EmployeeDetails(); // create a new pogo
		try {
			ctx = new InitialDirContext(getConnection(ldapUserName, ldapProviderUrl, password));
			SearchControls controls = new SearchControls();
			controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			String searchFilter = null;
			/*switch (searchAttribute) {
				case "sAMAccountName":
					searchFilter = "sAMAccountName=" + searchAttributeValue;
					break;
				default:
					break;
			}*/
			if("sAMAccountName".equals(searchAttribute)){
				searchFilter = "sAMAccountName=" + searchAttributeValue;
			}
			results = ctx.search("OU=Cognizant,DC=cts,DC=com", searchFilter,
					controls);
			
			while (results.hasMore()) {
				SearchResult searchResult = (SearchResult) results.next();
				Attributes attributes = searchResult.getAttributes();
				Attribute name = null;
				Attribute associateId = null;
				Attribute distinguishedname = null;
				Attribute title = null;
				Attribute email = null;
				if(attributes != null){
					name = attributes.get("cn");
					associateId = attributes.get("sAMAccountName");
					email = attributes.get("mail");
					distinguishedname = attributes.get("distinguishedname");
					title = attributes.get("title");
				}
				else{
					System.out.println("attributes is null");
				}
				
				if(name != null){
					profile.setName((String) name.get());
				} else {
					System.out.println("name is null");
				}
				
				if(associateId != null){
					profile.setAssociateId(Integer.parseInt((String) associateId.get()));

				} else {
					System.out.println("associateId is null");
				}
				
				if(email != null){
					profile.setEmailId((String) email.get());
				} else {
					System.out.println("email is null");
				}
				
				if(distinguishedname != null){
					profile.setDistinguishedName(null == distinguishedname ? "" : (String)distinguishedname.get());
				} else {
					System.out.println("distinguishedname is null");
				}
				
				if(title != null){
					profile.setDesignation(null == title ? "" : (String) title.get());
				} else {
					System.out.println("title is null");
				}
				
			}
		} 
		catch (NamingException e) {
			System.out.println("" + e.getMessage());
			return null;//returning null response, as we had exception here
		} catch (Exception e) {
			System.out.println("" + e.getMessage());
			return null;//returning null response, as we had exception here
		} finally {
			if (results != null) {
				try {
					results.close();
				} catch (Exception e) {
				}
			}
			if (ctx != null) {
				try {
					ctx.close();
				} catch (Exception e) {
				}
			}
		}
		return profile;
	}
	
	private static Hashtable<String, String> getConnection(String userName,
             String ldapProviderUrl, String password) {
     Hashtable<String, String> env = new Hashtable<String, String>();
     env.put(Context.INITIAL_CONTEXT_FACTORY,
                  "com.sun.jndi.ldap.LdapCtxFactory");
     env.put(Context.PROVIDER_URL, ldapProviderUrl);
     env.put(Context.SECURITY_AUTHENTICATION, "Simple");
     env.put(Context.SECURITY_PRINCIPAL, ldapMasterUserName);
     env.put(Context.SECURITY_CREDENTIALS, ldapMasterPassword);
     return env;
} 
	

}
