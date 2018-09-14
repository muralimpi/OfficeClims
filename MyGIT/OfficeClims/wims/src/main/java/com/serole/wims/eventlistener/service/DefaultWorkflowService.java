package com.serole.wims.eventlistener.service;

import org.springframework.stereotype.Service;

import com.serole.wims.eventlistener.model.ActivitiLog;
import com.serole.wims.eventlistener.model.WrapperTaskResp;

@Service
public interface DefaultWorkflowService extends AbstractWorkflowService {
	
	public String maintask();

	public Object newTask();  

	public Object newTask(java.lang.String arg0);  

	public Object saveTask(Object arg0);  

	public String deleteTask(java.lang.String arg0);  
		
	public void deleteTasks(java.util.Collection arg0);  

	public void deleteTask(java.lang.String arg0, boolean arg1);  

	public void deleteTasks(java.util.Collection arg0, boolean arg1);  
		
	public void deleteTask(java.lang.String arg0, java.lang.String arg1);  
		
	public void deleteTasks(java.util.Collection arg0, java.lang.String arg1);  
		
	public void claim(java.lang.String arg0, java.lang.String arg1);  
		
	public void unclaim(java.lang.String arg0);  
		
	public void complete(java.lang.String arg0);  

	public void delegateTask(java.lang.String arg0, java.lang.String arg1); 

	public void resolveTask(java.lang.String arg0);  
		
	public void resolveTask(java.lang.String arg0, java.util.Map arg1);  
		
	public void complete(java.lang.String arg0, java.util.Map arg1);  
		
	public void complete(java.lang.String arg0, java.util.Map arg1, boolean arg2);  
		
	public void setAssignee(java.lang.String arg0, java.lang.String arg1);  
		
	public void setOwner(java.lang.String arg0, java.lang.String arg1);  

	public java.util.List getIdentityLinksForTask(java.lang.String arg0);  

	public void addCandidateUser(java.lang.String arg0, java.lang.String arg1);   

	public void addCandidateGroup(java.lang.String arg0, java.lang.String arg1);   

	public void addUserIdentityLink(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2);   

	public void addGroupIdentityLink(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2);   

	public void deleteCandidateUser(java.lang.String arg0, java.lang.String arg1);   

	public void deleteCandidateGroup(java.lang.String arg0, java.lang.String arg1);   

	public void deleteUserIdentityLink(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2);   

	public void deleteGroupIdentityLink(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2);   

	public void setPriority(java.lang.String arg0, int arg1);   

	public void setDueDate(java.lang.String arg0, java.util.Date arg1);   

	public String createTaskQuery();  

	public String createNativeTaskQuery();    

	public void setVariable(java.lang.String arg0, java.lang.String arg1, java.lang.Object arg2);  

	public void setVariables(java.lang.String arg0, java.util.Map arg1);   

	public void setVariableLocal(java.lang.String arg0, java.lang.String arg1, java.lang.Object arg2);   

	public void setVariablesLocal(java.lang.String arg0, java.util.Map arg1);   

	public java.lang.Object getVariable(java.lang.String arg0, java.lang.String arg1);  

	public java.lang.Object getVariable(java.lang.String arg0, java.lang.String arg1, java.lang.Class arg2);   

	public boolean hasVariable(java.lang.String arg0, java.lang.String arg1);    

	public java.lang.Object getVariableLocal(java.lang.String arg0, java.lang.String arg1);   

	public java.lang.Object getVariableLocal(java.lang.String arg0, java.lang.String arg1, java.lang.Class arg2);   

	public boolean hasVariableLocal(java.lang.String arg0, java.lang.String arg1);    

	public java.util.Map getVariables(java.lang.String arg0);   

	public java.util.Map getVariablesLocal(java.lang.String arg0);   

	public java.util.Map getVariables(java.lang.String arg0, java.util.Collection arg1);   

	public java.util.Map getVariablesLocal(java.lang.String arg0, java.util.Collection arg1);    

	public java.util.List getVariableInstancesLocalByTaskIds(java.util.Set arg0);    

	public void removeVariable(java.lang.String arg0, java.lang.String arg1);   

	public void removeVariableLocal(java.lang.String arg0, java.lang.String arg1);   

	public void removeVariables(java.lang.String arg0, java.util.Collection arg1);   

	public void removeVariablesLocal(java.lang.String arg0, java.util.Collection arg1);   

	public String addComment(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2);   

	public String addComment(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
			java.lang.String arg3);   

	public String getComment(java.lang.String arg0);   

	public void deleteComments(java.lang.String arg0, java.lang.String arg1);   

	public void deleteComment(java.lang.String arg0);   

	public java.util.List getTaskComments(java.lang.String arg0);    

	public java.util.List getTaskComments(java.lang.String arg0, java.lang.String arg1);   

	public java.util.List getCommentsByType(java.lang.String arg0);   

	public java.util.List<WrapperTaskResp> getTaskEvents(java.lang.String arg0);   

	public boolean getEvent(java.lang.String arg0);    

	public java.util.List getProcessInstanceComments(java.lang.String arg0);    

	public java.util.List getProcessInstanceComments(java.lang.String arg0, java.lang.String arg1);   

	public boolean createAttachment(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
			java.lang.String arg3, java.lang.String arg4, java.io.InputStream arg5);   

	public boolean createAttachment(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
			java.lang.String arg3, java.lang.String arg4, java.lang.String arg5);    

	public void saveAttachment(String arg0);   

	public String getAttachment(java.lang.String arg0);   

	public java.io.InputStream getAttachmentContent(java.lang.String arg0);   

	public java.util.List getTaskAttachments(java.lang.String arg0);   

	public java.util.List getProcessInstanceAttachments(java.lang.String arg0);   

	public void deleteAttachment(java.lang.String arg0);   

	public java.util.List getSubTasks(java.lang.String arg0);   

}