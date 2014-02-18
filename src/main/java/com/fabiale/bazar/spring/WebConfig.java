package com.fabiale.bazar.spring;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fabiale.bazar.gson.GSONHttpMessageConverter;

@Configuration
@EnableWebMvc
@ComponentScan("com.fabiale.bazar")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**").addResourceLocations("/js/**");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/**");
		registry.addResourceHandler("/img/**").addResourceLocations("/img/**");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/**");
		registry.addResourceHandler("/home.html").addResourceLocations("/home.html");
		super.addResourceHandlers(registry);
	}
	
	@Bean
    public ViewResolver getViewResolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/pages/");
        resolver.setSuffix(".jsp");

        return resolver;
	}
	
	@Bean public GSONHttpMessageConverter jsonConverter() {
		return new GSONHttpMessageConverter();
	}
	
	@Bean public Jaxb2RootElementHttpMessageConverter xmlConverter() {
		return new Jaxb2RootElementHttpMessageConverter();
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(jsonConverter());
		converters.add(xmlConverter());
		super.configureMessageConverters(converters);
	}
}
