package com.elseco.mims;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.builder.SpringApplicationBuilder;
import com.serole.core.config.CrosFilterConfig;
import com.serole.core.config.SwaggerConfig;

import java.util.Properties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 
 * @author vadivel
 *
 */
@SpringBootApplication
//@PropertySource(value = "classpath:application.yml")
@Import({ SwaggerConfig.class, CrosFilterConfig.class })
public class MimsApplication {			
   
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
	
	public static void main(String[] args) {
		try{
		Resource resource = new ClassPathResource("application.yml");
		Properties properties = PropertiesLoaderUtils.loadProperties(resource);

		//SpringApplication.run(MimsApplication.class, args);
		
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MimsApplication.class)
                .properties("spring.config.name:"+properties.get("mimsConfigFileName"),"spring.config.location:file:"+properties.get("mimsConfigFileLocation"))
                .build().run(args);
					
		}catch(Exception e){ 
			
		}
	}

//	private final int TIMEOUT = (int) TimeUnit.SECONDS.toMillis(1000);

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate(clientHttpRequestFactory());
	}

	private ClientHttpRequestFactory clientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(1000*60);
		factory.setConnectTimeout(1000*60);
		return factory;
	}
}
