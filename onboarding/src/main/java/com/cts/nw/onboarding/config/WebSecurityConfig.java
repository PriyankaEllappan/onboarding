/**
 * 
 */
package com.cts.nw.onboarding.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 656579
 *
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enabled" + " from users where username=?")
				.authoritiesByUsernameQuery("select username, authority " + "from authorities where username=?")
				.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/* Authenticate users with HTTP basic authentication */
		/*
		 * http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
		 * .and() .httpBasic();
		 */
		http.authorizeRequests()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/admin/**").hasAnyRole("ADMIN")
		.antMatchers("/process/**").hasAnyRole("ADMIN", "PROCESSOR")
		.antMatchers("/").hasAnyRole("ADMIN", "REQUESTER", "PROCESSOR")
		.antMatchers("/request/**").hasAnyRole("ADMIN", "REQUESTER", "PROCESSOR")
		.antMatchers("/team/**").hasAnyRole("ADMIN", "REQUESTER", "PROCESSOR")
		.antMatchers("/role/**").hasAnyRole("ADMIN", "REQUESTER", "PROCESSOR")
		.antMatchers("/country/**").hasAnyRole("ADMIN", "REQUESTER", "PROCESSOR")
		.antMatchers("/status/**").hasAnyRole("ADMIN", "REQUESTER", "PROCESSOR")
		.antMatchers("/release/**").hasAnyRole("ADMIN", "REQUESTER", "PROCESSOR")
		.antMatchers("/band/**").hasAnyRole("ADMIN", "REQUESTER", "PROCESSOR")
		.antMatchers("/movement/**").hasAnyRole("ADMIN", "REQUESTER", "PROCESSOR")
		.antMatchers("/resource/**").hasAnyRole("ADMIN", "REQUESTER", "PROCESSOR")
		.and().formLogin().loginPage("/login").permitAll()
		.and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/")
		.and().exceptionHandling().accessDeniedPage("/accessDenied");
		
		http.csrf().disable();
	}
}
