package com.example.demo.repository;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class CorsImpl implements WebMvcConfigurer {
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*").maxAge(3600);
    }
	
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

	    config.getCorsRegistry().addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*").maxAge(3600);
	  }

}
