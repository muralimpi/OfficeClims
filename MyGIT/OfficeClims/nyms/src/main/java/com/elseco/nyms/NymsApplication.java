package com.elseco.nyms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Properties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 
 * @author vadivel
 *
 */
@SpringBootApplication
public class NymsApplication {
	public static void main(String[] args) {
		//SpringApplication.run(NymsApplication.class, args);
                try{
		Resource resource = new ClassPathResource("application.yml");
		Properties properties = PropertiesLoaderUtils.loadProperties(resource);
   	        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(NymsApplication.class)
                .properties("spring.config.name:"+properties.get("nymsConfigFileName"),"spring.config.location:file:"+properties.get("nymsConfigFileLocation"))
                .build().run(args);
                  }catch(Exception e){
			
		}
	}
}