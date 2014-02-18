package com.fabiale.bazar.spring.context;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

import com.fabiale.bazar.spring.RepositoryConfig;
import com.fabiale.bazar.spring.RestTemplateConfig;
import com.fabiale.bazar.spring.WebConfig;

@Configuration
@ComponentScan(value = "com.fabiale.bazar", excludeFilters = @ComponentScan.Filter(Configuration.class))
@Import({ WebConfig.class, RepositoryConfig.class, RestTemplateConfig.class })
public class SpringConfig {

	@Bean
	public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("application.properties"));
		ppc.setIgnoreUnresolvablePlaceholders(true);
		return ppc;
	}
}
