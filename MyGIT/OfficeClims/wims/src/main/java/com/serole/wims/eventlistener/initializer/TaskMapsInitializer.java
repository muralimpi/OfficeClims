package com.serole.wims.eventlistener.initializer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.yaml.snakeyaml.Yaml;

import com.serole.wims.eventlistener.model.RestfulTask;
import com.serole.wims.eventlistener.model.RestfulTasks;
import com.serole.wims.eventlistener.model.ServiceTask;
import com.serole.wims.eventlistener.model.ServiceTasks;
import com.serole.wims.eventlistener.model.UserTask;
import com.serole.wims.eventlistener.model.UserTasks;
import com.serole.wims.eventlistener.utils.LoadAsJavaObject;


public class TaskMapsInitializer implements TaskMapsInitializerConstants {

	private static final Logger LOG = LoggerFactory.getLogger(TaskMapsInitializer.class);
	
	@Autowired
	UserTasks oUserTasks;
//	@Autowired
//	UserTask oUserTask;
	
	@Autowired
	ServiceTasks oServiceTasks;
//	@Autowired
//	ServiceTask oServiceTask;
	
	@Autowired
	RestfulTasks oRestfulTasks;
//	@Autowired
//	RestfulTask oRestfulTask;
	
	@Autowired
	private LoadAsJavaObject oLoadAsJavaObject;

	private static TaskMapsInitializer oTaskMapsInitializer = null;
	private static Map<String, List<Object>> oVariousTypesTaskMap = new HashMap<String, List<Object>>();
	private static Yaml yaml = new Yaml();

	private TaskMapsInitializer() {
		// TODO Auto-generated constructor stub
	}

	public static synchronized TaskMapsInitializer getInstance() {
		if (oTaskMapsInitializer == null) {
			oTaskMapsInitializer = new TaskMapsInitializer();
		}

		return oTaskMapsInitializer;
	}

	public Map<String, List<Object>> init(String tasktypes) {

		String[] arrayTaskTypes = null;

		if (tasktypes != null) {
			arrayTaskTypes = tasktypes.split("\\,");
		}

		if (arrayTaskTypes != null && arrayTaskTypes.length > 0) {
			for (int j = 0; j < arrayTaskTypes.length; j++) {
				if (arrayTaskTypes[j].toString().equalsIgnoreCase(TASK_MAPS_INITIALIZER_CONSTANTS_USER_TASK)) {
					try {
						InputStream uIs = LoadAsJavaObject.class.getResourceAsStream("/usertasks.yml");
						List<Object> oUserTaskList = new ArrayList<Object>();

						oUserTasks = yaml.loadAs(uIs, UserTasks.class);

						for (UserTask oUserTask : oUserTasks.getUsertasks()) {
							oUserTaskList.add(oUserTask);
						}

						oVariousTypesTaskMap.put("usertasks", oUserTaskList);

					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (arrayTaskTypes[j].toString()
						.equalsIgnoreCase(TASK_MAPS_INITIALIZER_CONSTANTS_SERVICE_TASK)) {
					try {
						InputStream sIs = LoadAsJavaObject.class.getResourceAsStream("/servicetasks.yml");
						List<Object> oServiceTaskList = new ArrayList<Object>(); 
						
						oServiceTasks = yaml.loadAs(sIs, ServiceTasks.class);

						for (ServiceTask oServiceTask : oServiceTasks.getServicetasks()) {
							oServiceTaskList.add(oServiceTask);
						}

						oVariousTypesTaskMap.put("servicetasks", oServiceTaskList);

					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (arrayTaskTypes[j].toString()
						.equalsIgnoreCase(TASK_MAPS_INITIALIZER_CONSTANTS_RESTFUL_TASK)) {
					try {
						InputStream rIs = LoadAsJavaObject.class.getResourceAsStream("/restfultasks.yml");
						List<Object> oRestfulTaskList = new ArrayList<Object>(); 
						
						oRestfulTasks = yaml.loadAs(rIs, RestfulTasks.class); 

						for (RestfulTask oRestfulTask : oRestfulTasks.getRestfultasks()) {
							oRestfulTaskList.add(oRestfulTask);
						}

						oVariousTypesTaskMap.put("restfultasks", oRestfulTaskList);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		return oVariousTypesTaskMap;

	}

}
