package com.spittr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc	// This annotation is the starting point for configuring Spring MVC with Java. The XML alternative to this is <mvc:annotation-driven>
@ComponentScan("com.spittr")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Bean	// Configure your own ViewResolver
	public ViewResolver viewResolver()	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		
		return resolver;
	}
	
	@Override	// Configure static content handling
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)	{
		configurer.enable();
	}
}
