package com.serole.wims.eventlistener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.serole.wims.config.SwaggerConfig;
import com.serole.wims.eventlistener.initializer.PropertyMapsInitializer;
import com.serole.wims.eventlistener.initializer.TaskMapsInitializer;

/**
 * 
 * @author SONJOY CHAKRABORTY
 *
 */
@SpringBootApplication
@Import({ SwaggerConfig.class})
public class WimsWorkflowApplication {

	private static final Logger LOG = LoggerFactory.getLogger(WimsWorkflowApplication.class);

	private static Map<String, String> oPropertyMaps = new HashMap<String, String>();
	private static Map<String, List<Object>> oTaskMaps = new HashMap<String, List<Object>>();

	@Autowired
	private static PropertyMapsInitializer oPropertyMapsInitializer; 

	@Autowired
	private static TaskMapsInitializer oTaskMapsInitializer; 
	
	
	public static void main(String[] args) {

		try {
			if(oPropertyMapsInitializer==null){
				oPropertyMapsInitializer = PropertyMapsInitializer.getInstance();
				oPropertyMaps = oPropertyMapsInitializer.init();
			}
			
			if(oTaskMapsInitializer ==null) {
				oTaskMapsInitializer = TaskMapsInitializer.getInstance();
				oTaskMaps = oTaskMapsInitializer.init(oPropertyMaps.get("tasktypes"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator it = oTaskMaps.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        //List<Object> oList = (ArrayList)pair.getValue();
	        //it.remove(); // avoids a ConcurrentModificationException
	    }
		SpringApplication.run(WimsWorkflowApplication.class, args);
	}
}
