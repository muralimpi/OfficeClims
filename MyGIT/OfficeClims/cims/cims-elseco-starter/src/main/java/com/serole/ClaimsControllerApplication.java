package com.serole;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.ConfigurableEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.serole.claims.config.CrosFilterConfig;
import com.serole.claims.config.SwaggerConfig;

@SpringBootApplication
@ComponentScan(basePackages ="com.serole.*")
@Import({ SwaggerConfig.class, CrosFilterConfig.class }) 
public class ClaimsControllerApplication {	
	
	 @Value("${claims.config.file.name}")
	 static String configFileName;
	 
	 @Value("${claims.config.file.location}")
	 static String configFileLocation;
	 
	 private static final Logger LOG = LogManager.getLogger(ClaimsControllerApplication.class);
		 
	@PostConstruct
    public void start() throws Exception {
        // some init code
    }

    @PreDestroy
    public static void tearDown() {
       // some destroy code
    }
    
	public static void main(String[] args) {
		LOG.info("======== Starting 	---> Elseco Claims Application ========");
		
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(ClaimsControllerApplication.class)
                .properties("spring.config.name:"+configFileName, "spring.config.location:file:"+configFileLocation)   
                .build().run(args);
		 					
        //ConfigurableEnvironment environment = applicationContext.getEnvironment(); 
        //LOG.info(" Application has an Active Profile set as :: "+environment.getProperty("spring.profiles.active"));
        
        LOG.info("======== Started  	---> Elseco Claims Application ========");
        
        LOG.error("---------------------         Message logged at ERROR level");
        LOG.warn("---------------------         Message logged at WARN level");
        LOG.info("---------------------         Message logged at INFO level");
        LOG.debug("---------------------         Message logged at DEBUG level");
        
        
		Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // write here any instructions that should be executed
                tearDown();
            }   
        });						
	}		
	
/*	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
	  TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
	      @Override
	      protected void postProcessContext(Context context) {
	        SecurityConstraint securityConstraint = new SecurityConstraint();
	        securityConstraint.setUserConstraint("CONFIDENTIAL");
	        SecurityCollection collection = new SecurityCollection();
	        collection.addPattern("/*");
	        securityConstraint.addCollection(collection);
	        context.addConstraint(securityConstraint);
	      }
	    };
	  
	  tomcat.addAdditionalTomcatConnectors(redirectConnector());
	  return tomcat;
	}

	private Connector redirectConnector() {
	  Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
	  connector.setScheme("http");
	  connector.setPort(8084);
	  connector.setSecure(false);
	  connector.setRedirectPort(8088);
	  
	  return connector;
	}*/
}
