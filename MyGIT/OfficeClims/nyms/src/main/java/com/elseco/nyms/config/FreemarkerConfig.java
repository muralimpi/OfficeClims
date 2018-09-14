package com.elseco.nyms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

/**
 * 
 * @author vadivel
 *
 */
@Configuration
public class FreemarkerConfig {
	@Bean
	public FreeMarkerConfigurationFactoryBean freeMarkerConfiguration() {
		final FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
		bean.setTemplateLoaderPath("/templates/");
		return bean;
	}
}