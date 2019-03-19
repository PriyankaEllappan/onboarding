/**
 * 
 */
package com.cts.nw.onboarding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 656579
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.cts.nw.onboarding" })
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp().prefix("/WEB-INF/views/").suffix(".jsp");
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	    resolver.setDefaultEncoding("utf-8");
	    resolver.setMaxInMemorySize(1048576);
	    resolver.setMaxUploadSize(20971520);
	    return resolver;
	}
	
}
