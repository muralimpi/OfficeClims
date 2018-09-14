package com.serole.wims.eventlistener.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

//import com.serole.wims.client.WimsRestclient;
import com.serole.wims.eventlistener.initializer.PropertyMapsInitializer;
import com.serole.wims.eventlistener.initializer.TaskMapsInitializer;
import com.serole.wims.eventlistener.model.ActivitiLog;
import com.serole.wims.eventlistener.model.RestfulTask;
import com.serole.wims.eventlistener.model.ServiceTask;
import com.serole.wims.eventlistener.model.UserTask;
import com.serole.wims.eventlistener.model.WrapperTaskResp;
import com.serole.wims.eventlistener.model.data;
import com.serole.wims.eventlistener.utils.JsonUtils;

@Service
public class DefaultWorkflowServiceImpl implements DefaultWorkflowService {

	/*
	 * @Autowired WimsRestclient wimsRestclient;
	 */
	/**
	 * 
	 * @return
	 */
	public Object newTask() {
		return null;
	}

	/**
	 * 
	 * @param arg0
	 * @return
	 */
	public Object newTask(java.lang.String arg0) {

		return null;
	}

	/**
	 * 
	 * @param arg0
	 */
	public Object saveTask(Object arg0) {

		return null;
	}

	/**
	 * 
	 * @param arg0
	 */
	public void deleteTasks(java.util.Collection arg0) {

	}

	public void deleteTask(java.lang.String arg0, boolean arg1) {

	}

	public void deleteTasks(java.util.Collection arg0, boolean arg1) {

	}

	public void deleteTask(java.lang.String arg0, java.lang.String arg1) {

	}

	public void deleteTasks(java.util.Collection arg0, java.lang.String arg1) {

	}

	public void claim(java.lang.String arg0, java.lang.String arg1) {

	}

	public void unclaim(java.lang.String arg0) {

	}

	public void complete(java.lang.String arg0) {

	}

	public void delegateTask(java.lang.String arg0, java.lang.String arg1) {

	}

	public void resolveTask(java.lang.String arg0) {

	}

	public void resolveTask(java.lang.String arg0, java.util.Map arg1) {

	}

	public void complete(java.lang.String arg0, java.util.Map arg1) {

	}

	public void complete(java.lang.String arg0, java.util.Map arg1, boolean arg2) {

	}

	public void setAssignee(java.lang.String arg0, java.lang.String arg1) {

	}

	public void setOwner(java.lang.String arg0, java.lang.String arg1) {

	}

	public java.util.List getIdentityLinksForTask(java.lang.String arg0) {
		return null;
	}

	public void addCandidateUser(java.lang.String arg0, java.lang.String arg1) {
	}

	public void addCandidateGroup(java.lang.String arg0, java.lang.String arg1) {
	}

	public void addUserIdentityLink(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) {
	}

	public void addGroupIdentityLink(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) {
	}

	public void deleteCandidateUser(java.lang.String arg0, java.lang.String arg1) {
	}

	public void deleteCandidateGroup(java.lang.String arg0, java.lang.String arg1) {
	}

	public void deleteUserIdentityLink(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) {
	}

	public void deleteGroupIdentityLink(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) {
	}

	public void setPriority(java.lang.String arg0, int arg1) {
	}

	public void setDueDate(java.lang.String arg0, java.util.Date arg1) {
	}

	public String createTaskQuery() {
		return null;
	}

	public String createNativeTaskQuery() {
		return null;
	}

	public void setVariable(java.lang.String arg0, java.lang.String arg1, java.lang.Object arg2) {

	}

	public void setVariables(java.lang.String arg0, java.util.Map arg1) {
	}

	public void setVariableLocal(java.lang.String arg0, java.lang.String arg1, java.lang.Object arg2) {
	}

	public void setVariablesLocal(java.lang.String arg0, java.util.Map arg1) {
	}

	public java.lang.Object getVariable(java.lang.String arg0, java.lang.String arg1) {
		return null;
	}

	public java.lang.Object getVariable(java.lang.String arg0, java.lang.String arg1, java.lang.Class arg2) {
		return null;
	}

	public boolean hasVariable(java.lang.String arg0, java.lang.String arg1) {
		return true;
	}

	public java.lang.Object getVariableLocal(java.lang.String arg0, java.lang.String arg1) {
		return null;
	}

	public java.lang.Object getVariableLocal(java.lang.String arg0, java.lang.String arg1, java.lang.Class arg2) {
		return null;
	}

	public boolean hasVariableLocal(java.lang.String arg0, java.lang.String arg1) {
		return true;
	}

	public java.util.Map getVariables(java.lang.String arg0) {
		return null;
	}

	public java.util.Map getVariablesLocal(java.lang.String arg0) {
		return null;
	}

	public java.util.Map getVariables(java.lang.String arg0, java.util.Collection arg1) {
		return null;
	}

	public java.util.Map getVariablesLocal(java.lang.String arg0, java.util.Collection arg1) {
		return null;
	}

	public java.util.List getVariableInstancesLocalByTaskIds(java.util.Set arg0) {
		return null;
	}

	public void removeVariable(java.lang.String arg0, java.lang.String arg1) {
	}

	public void removeVariableLocal(java.lang.String arg0, java.lang.String arg1) {
	}

	public void removeVariables(java.lang.String arg0, java.util.Collection arg1) {
	}

	public void removeVariablesLocal(java.lang.String arg0, java.util.Collection arg1) {
	}

	public String addComment(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) {
		return null;
	}

	public String addComment(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
			java.lang.String arg3) {
		return null;
	}

	public String getComment(java.lang.String arg0) {
		return null;
	}

	public void deleteComments(java.lang.String arg0, java.lang.String arg1) {
	}

	public void deleteComment(java.lang.String arg0) {
	}

	public java.util.List getTaskComments(java.lang.String arg0) {
		return null;
	}

	public java.util.List getTaskComments(java.lang.String arg0, java.lang.String arg1) {
		return null;
	}

	public java.util.List getCommentsByType(java.lang.String arg0) {
		return null;
	}

	public java.util.List<WrapperTaskResp> getTaskEvents(java.lang.String arg0) {
		return null;
	}

	public boolean getEvent(java.lang.String arg0) {
		return true;
	}

	public java.util.List getProcessInstanceComments(java.lang.String arg0) {
		return null;
	}

	public java.util.List getProcessInstanceComments(java.lang.String arg0, java.lang.String arg1) {
		return null;
	}

	public boolean createAttachment(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
			java.lang.String arg3, java.lang.String arg4, java.io.InputStream arg5) {
		return true;
	}

	public boolean createAttachment(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
			java.lang.String arg3, java.lang.String arg4, java.lang.String arg5) {
		return true;
	}

	public void saveAttachment(String arg0) {
	}

	public String getAttachment(java.lang.String arg0) {
		return null;
	}

	public java.io.InputStream getAttachmentContent(java.lang.String arg0) {
		return null;
	}

	public java.util.List getTaskAttachments(java.lang.String arg0) {
		return null;
	}

	public java.util.List getProcessInstanceAttachments(java.lang.String arg0) {
		return null;
	}

	public void deleteAttachment(java.lang.String arg0) {
	}

	public java.util.List getSubTasks(java.lang.String arg0) {
		return null;
	}

	/*
	 * { "activityuniqueid": "u001", "productuniqueid": "p001", "moduleuniqueid":
	 * "m001", "produniquename": "elseco", "activityuniquename": "review",
	 * "moduleuniquename": "claims", "activitytype": "usertasks", "activitydetails":
	 * "review", "previousstatus": "s", "currentstatus": "",
	 * "previoususergrpassigned": "frontoffice", "currentusergrpassigned": "",
	 * "systemipaddress": "10.10.10.10", "notificationreqd": "y",
	 * "notificationsent": "", "notificationrecipients": "dchakras@gmail.com",
	 * "createdby": "1001", "createddate": "", "lastmodifiedby": "1001",
	 * "lastmodifieddate": "" }
	 */
	@Override
	public String startProcessFlow(String jsonData) {

		String jsonDataResp = null;

		try {
			ActivitiLog oActivitiLog = (ActivitiLog) JsonUtils.convertJsonToObj(jsonData);

			// TODO Auto-generated method stub
			// set data into this pojo oActivitiLog obj
			Map<String, String> oPropMap = PropertyMapsInitializer.getInstance().init();
			Map<String, List<Object>> oTaskMap = TaskMapsInitializer.getInstance().init(oPropMap.get("tasktypes"));

			String oType = "";
			if (oActivitiLog.getActivityUniqueId().toString().contains("u"))
				oType = "usertasks";
			else if (oActivitiLog.getActivityUniqueId().toString().contains("s"))
				oType = "servicetasks";
			else if (oActivitiLog.getActivityUniqueId().toString().contains("r"))
				oType = "restfultasks";

			List<ActivitiLog> oActivitiLogEventList = new ArrayList<ActivitiLog>();
			// oActivitiLogEventList.add(oActivitiLog);

			if (oType != null && !oType.isEmpty()) {
				performTask(oActivitiLogEventList, oType, oTaskMap, oActivitiLog);
			}

			data oData = new data();
			oData.setoActivitiLogs(oActivitiLogEventList);

			jsonDataResp = JsonUtils.convertObjTojson(oData);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * String strresponse = wimsRestclient.sendMail();
		 * jsonDataResp.concat(strresponse); System.out.println(jsonDataResp);
		 */
		return jsonDataResp;
	}

	public String maintask() {
		String ret = null;
		try {
			String jsonData = new String(Files.readAllBytes(Paths.get("e://jsondata.txt")));

			// ActivitiLog oActivitiLog = (ActivitiLog) JsonUtils.processJsonReq(jsonData);

			// String ret = JsonUtils.convertObjTojson(oActivitiLog);
			DefaultWorkflowService oDefaultWorkflowService = new DefaultWorkflowServiceImpl();
			ret = oDefaultWorkflowService.startProcessFlow(jsonData);

			System.out.println(ret);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

	@Override
	public ActivitiLog startTask(ActivitiLog oActivitiLog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String completeTask(String jsonData) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * { "activityuniqueid": "u001", "productuniqueid": "p001", "moduleuniqueid":
	 * "m001", "produniquename": "elseco", "activityuniquename": "review",
	 * "moduleuniquename": "claims", "activitytype": "usertasks", "activitydetails":
	 * "review", "previousstatus": "s", "currentstatus": "",
	 * "previoususergrpassigned": "frontoffice", "currentusergrpassigned": "",
	 * "systemipaddress": "10.10.10.10", "notificationreqd": "y",
	 * "notificationsent": "", "notificationrecipients": "dchakras@gmail.com",
	 * "createdby": "1001", "createddate": "", "lastmodifiedby": "1001",
	 * "lastmodifieddate": "" }
	 */
	@Override
	public void performTask(List<ActivitiLog> oActivitiLogEventList, String key, Map<String, List<Object>> oMap,
			ActivitiLog oActivitiLog) {
		// TODO Auto-generated method stub
		List<UserTask> oUserTasks = new ArrayList<UserTask>();
		List<ServiceTask> oServiceTasks = new ArrayList<ServiceTask>();
		List<RestfulTask> oRestfulTasks = new ArrayList<RestfulTask>();

		// ActivitiLog oActivitiLog =
		// oActivitiLogEventList.get(oActivitiLogEventList.size()-1);

		for (Map.Entry<String, List<Object>> entry : oMap.entrySet()) {
			String keyFinal = entry.getKey();
			Object oListFinal = (Object) entry.getValue();

			if (keyFinal.equalsIgnoreCase("usertasks") && keyFinal.equalsIgnoreCase(key)) {

				for (int k = 0; k < entry.getValue().size(); k++) {
					oUserTasks.add((UserTask) entry.getValue().get(k));
				}

				for (UserTask oUserTask : (List<UserTask>) oUserTasks) {
					if (oActivitiLog.getActivityUniqueId().toString().equalsIgnoreCase(oUserTask.getId())) {

						oActivitiLog.setActivityUniqueId(oUserTask.getId());
						oActivitiLog.setActivityUniqueName(oUserTask.getActivityUniqueName());
						
						oActivitiLog.setExistingStatus(oUserTask.getOldstatus());
						oActivitiLog.setExistingUserGroupAssigned(oUserTask.getOldusergroupassigned());

						oActivitiLog.setExpectedNewStatus(oUserTask.getNewstatus());
						oActivitiLog.setExpectedNewUserGroupToBeAssigned(oUserTask.getNewusergroupassigned());

						if (oActivitiLog.getIsNotificationRequired() != null
								&& !oActivitiLog.getIsNotificationRequired().isEmpty()) {
							// TO DO NYMS call here
							oActivitiLog.setIsNotificationSent("Y");
						}

						oActivitiLog.setCreatedDate("" + new Date());
						oActivitiLog.setLastModifiedDate("" + new Date());

						oActivitiLogEventList.add(oActivitiLog);

						if (oUserTask.getAutoswitchtaskid() != null && !oUserTask.getAutoswitchtaskid().isEmpty()) {
							if (oUserTask.getAutoswitchtasktype() != null
									&& !oUserTask.getAutoswitchtasktype().isEmpty()) {


								ActivitiLog tempActivitiLog;
								try {
									tempActivitiLog = (ActivitiLog) oActivitiLog.clone();
									tempActivitiLog.setActivityUniqueId(oUserTask.getAutoswitchtaskid());
									tempActivitiLog.setActivityType(oUserTask.getAutoswitchtasktype());

									performTask(oActivitiLogEventList, oUserTask.getAutoswitchtasktype().toString(),
											oMap, tempActivitiLog);
								} catch (CloneNotSupportedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
				}
			}

			else if (keyFinal.equalsIgnoreCase("servicetasks") && keyFinal.equalsIgnoreCase(key)) {

				for (int k = 0; k < entry.getValue().size(); k++) {
					oServiceTasks.add((ServiceTask) entry.getValue().get(k));
				}

				for (ServiceTask oServiceTask : (List<ServiceTask>) oServiceTasks) {
					if (oActivitiLog.getActivityUniqueId().toString().equalsIgnoreCase(oServiceTask.getId())) {

						oActivitiLog.setActivityUniqueId(oServiceTask.getId());
						//oActivitiLog.setActivityUniqueName(oServiceTask.getActivityUniqueName());
						
						oActivitiLog.setExistingStatus(oServiceTask.getOldstatus());
						oActivitiLog.setExistingUserGroupAssigned(oServiceTask.getOldusergroupassigned());

						oActivitiLog.setExpectedNewStatus(oServiceTask.getNewstatus());
						oActivitiLog.setExpectedNewUserGroupToBeAssigned(oServiceTask.getNewusergroupassigned());

						if (oActivitiLog.getIsNotificationRequired() != null
								&& !oActivitiLog.getIsNotificationRequired().isEmpty()) {
							// TO DO NYMS call here
							oActivitiLog.setIsNotificationSent("Y");
						}

						oActivitiLog.setCreatedDate("" + new Date());
						oActivitiLog.setLastModifiedDate("" + new Date());

						oActivitiLogEventList.add(oActivitiLog);

						if (oServiceTask.getAutoswitchtaskid() != null
								&& !oServiceTask.getAutoswitchtaskid().isEmpty()) {
							if (oServiceTask.getAutoswitchtasktype() != null
									&& !oServiceTask.getAutoswitchtasktype().isEmpty()) {

								ActivitiLog tempActivitiLog;
								try {
									tempActivitiLog = (ActivitiLog) oActivitiLog.clone();
									tempActivitiLog.setActivityUniqueId(oServiceTask.getAutoswitchtaskid());
									tempActivitiLog.setActivityType(oServiceTask.getAutoswitchtasktype());
									oActivitiLogEventList.add(tempActivitiLog);

									performTask(oActivitiLogEventList, oServiceTask.getAutoswitchtasktype().toString(),
											oMap, tempActivitiLog);
								} catch (CloneNotSupportedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
				}
			}

			else if (keyFinal.equalsIgnoreCase("restfultasks") && keyFinal.equalsIgnoreCase(key)) {

				for (int k = 0; k < entry.getValue().size(); k++) {
					oRestfulTasks.add((RestfulTask) entry.getValue().get(k));
				}

				for (RestfulTask oRestfulTask : (List<RestfulTask>) oRestfulTasks) {
					if (oActivitiLog.getActivityUniqueId().toString().equalsIgnoreCase(oRestfulTask.getId())) {

						oActivitiLog.setActivityUniqueId(oRestfulTask.getId());
						oActivitiLog.setActivityUniqueName(oRestfulTask.getName());
						
						oActivitiLog.setExistingStatus(oRestfulTask.getOldstatus());
						oActivitiLog.setExistingUserGroupAssigned(oRestfulTask.getOldusergroupassigned());

						oActivitiLog.setExpectedNewStatus(oRestfulTask.getNewstatus());
						oActivitiLog.setExpectedNewUserGroupToBeAssigned(oRestfulTask.getNewusergroupassigned());

						if (oActivitiLog.getIsNotificationRequired() != null
								&& !oActivitiLog.getIsNotificationRequired().isEmpty()) {
							// TO DO NYMS call here
							oActivitiLog.setIsNotificationSent("Y");
						}

						oActivitiLog.setCreatedDate("" + new Date());
						oActivitiLog.setLastModifiedDate("" + new Date());

						oActivitiLogEventList.add(oActivitiLog);
						
						if (oRestfulTask.getAutoswitchtaskid() != null
								&& !oRestfulTask.getAutoswitchtaskid().isEmpty()) {
							if (oRestfulTask.getAutoswitchtasktype() != null
									&& !oRestfulTask.getAutoswitchtasktype().isEmpty()) {

								
								ActivitiLog tempActivitiLog;
								
								try {
									tempActivitiLog = (ActivitiLog) oActivitiLog.clone();
									tempActivitiLog.setActivityUniqueId(oRestfulTask.getAutoswitchtaskid());
									tempActivitiLog.setActivityType(oRestfulTask.getAutoswitchtasktype());
									

									performTask(oActivitiLogEventList, oRestfulTask.getAutoswitchtasktype().toString(),
											oMap, tempActivitiLog);
								} catch (CloneNotSupportedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
						}
					}
				}
			}

		}

		// return oActivitiLog;

	}

	@Override
	public String saveTask(String jsonData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTask(String jsonData) {
		// TODO Auto-generated method stub
		return null;
	}

}
