package com.serole.wims.eventlistener.initializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;

import com.serole.wims.eventlistener.exception.WorkflowException;
import com.serole.wims.eventlistener.utils.LoadAsJavaObject;


public class PropertyMapsInitializer {

	private static final Logger LOG = LoggerFactory.getLogger(PropertyMapsInitializer.class);
	
	private static PropertyMapsInitializer oPropertyMapsInitializer = null;
	private static Map<String, String> oVariousPropertiesMap = new HashMap<String, String>();

	@Autowired
	private LoadAsJavaObject oLoadAsJavaObject;
	
	private PropertyMapsInitializer() {
		// TODO Auto-generated constructor stub
	}

	public static synchronized PropertyMapsInitializer getInstance(){
        if(oPropertyMapsInitializer == null){
        	oPropertyMapsInitializer = new PropertyMapsInitializer();
        }
        
        return oPropertyMapsInitializer;
    }

	public Map<String, String> init(){
	
		Properties prop = new Properties();
		InputStream input = null;

		try {

			YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
	        try {
	            PropertySource<?> applicationYamlPropertySource = loader.load(
	                "properties", new ClassPathResource("/apps.yml"), null);// null indicated common properties for all profiles.
	            Map source = ((MapPropertySource) applicationYamlPropertySource).getSource();
	            //Properties properties = new Properties();
	            prop.putAll(source);
	            //return properties;
	        } catch (IOException e) {
	            LOG.error("application.yml file cannot be found.");
	        }
			
			
			
			input = LoadAsJavaObject.class.getResourceAsStream("/apps.properties");

			// load a properties file
			prop.load(input);

			Enumeration keys = prop.propertyNames();
	        while(keys.hasMoreElements()) {
	            String key = (String)keys.nextElement();
	            oVariousPropertiesMap.put(key,prop.getProperty(key));
	        }

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return oVariousPropertiesMap;
		
	}
	
}

