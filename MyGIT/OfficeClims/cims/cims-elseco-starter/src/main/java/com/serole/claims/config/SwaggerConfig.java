package com.serole.claims.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * A configuration class for Swagger UI implementation
 * 
 * @author Serole_Vijay
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Value("${swagger.api.title}")
	private String title;

	@Value("${swagger.api.description}")
	private String description;

	@Value("${swagger.api.version}")
	private String version;

	@Value("${swagger.api.termsOfServiceUrl}")
	private String termsOfServiceUrl;

	@Value("${swagger.api.license}")
	private String license;

	@Value("${swagger.api.licenseUrl}")
	private String licenseUrl;

	@Value("${swagger.api.contact.name}")
	private String name;

	@Value("${swagger.api.contact.url}")
	private String url;

	@Value("${swagger.api.contact.email}")
	private String email;
		
	@Bean
	public Docket docketApi() {
		return new Docket(DocumentationType.SWAGGER_2).pathMapping("").select()
				.apis(RequestHandlerSelectors.basePackage("com.serole.claims.controller")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
	}

	@SuppressWarnings("deprecation")
	public ApiInfo apiInfo() {
		/*
		 * final ApiInfo apiInfo = new ApiInfo(title, description, version,
		 * termsOfServiceUrl, new Contact(name, url, email), license,
		 * licenseUrl);
		 */
		return new ApiInfo(title, description, version, termsOfServiceUrl, name, license, licenseUrl);

	}
}
