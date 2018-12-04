package com.pam.springboot.service;

import java.util.List;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.kie.server.api.model.instance.NodeInstance;
import org.kie.server.api.model.instance.ProcessInstance;
import org.kie.server.api.model.instance.TaskInstance;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.ProcessServicesClient;
import org.kie.server.client.QueryServicesClient;
import org.kie.server.client.RuleServicesClient;
import org.kie.server.client.UserTaskServicesClient;

import com.pam.springboot.dto.ProcessDTO;
import com.pam.springboot.dto.TaskDTO;

public class KieServerClient {


	//public String workFlowName = "jbpmProj.customAPIExample";
	public String workFlowName = "com.myspace.sample.throwSignal";
	public String containerName = "sample";

	public Long invokeWorkFlow(ProcessDTO processDTO) {
		KieServerConfiguration serverClient = new KieServerConfiguration();
		KieServicesClient kieServicesClient = null;
		kieServicesClient = serverClient.getKieClient();
		ProcessServicesClient processClient = kieServicesClient.getServicesClient(ProcessServicesClient.class);		
		Long processInstanceId = processClient.startProcess(processDTO.getContainerId(), processDTO.getProcessName());
		System.out.println("Process Instance Id Is ::::"+processInstanceId);
		return processInstanceId;
	}

	public static void main(String args[]) {
		KieServerClient serverClient = new KieServerClient();
		//serverClient.invokeWorkFlow();
		//serverClient.getContainerInfoByTaskId();
		//serverClient.getContainerInfoByProcessId();
		//serverClient.getHumanTaskRelatedInfo();
	}

	public void getContainerInfoByTaskId() {
		KieServerConfiguration serverClient = new KieServerConfiguration();
		KieServicesClient kieServicesClient = null;
		// creating kie services client using configuration and factory ..
		kieServicesClient = serverClient.getKieClient();
		UserTaskServicesClient taskClient = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
		TaskInstance taskInstance = taskClient.findTaskById(1L);
		System.out.println("Container Id Using Task is ::::" + taskInstance.getContainerId());
	}

	public void getContainerInfoByProcessId() {
		KieServerConfiguration serverClient = new KieServerConfiguration();
		KieServicesClient kieServicesClient = null;
		// creating kie services client using configuration and factory ..
		kieServicesClient = serverClient.getKieClient();
		QueryServicesClient queryServicesClient = kieServicesClient.getServicesClient(QueryServicesClient.class);
		
		ProcessInstance processInstance = queryServicesClient.findProcessInstanceById(1L);
		List<NodeInstance> nodeInstanceList = queryServicesClient.findActiveNodeInstances(1L, 0, 10);
		for(NodeInstance nodeInstance : nodeInstanceList) {
			System.out.println("Active Node Instance info :::"+nodeInstance.getWorkItemId());
		}
		
		System.out.println("Container Id using Process Instance is ::::" + processInstance.getContainerId());
	}
	
	public void getHumanTaskRelatedInfo() {
		KieServerConfiguration serverClient = new KieServerConfiguration();
		KieServicesClient kieServicesClient = null;
		// creating kie services client using configuration and factory ..
		kieServicesClient = serverClient.getKieClient();
		UserTaskServicesClient taskClient = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
		//List<org.kie.server.api.model.instance.TaskSummary> taskSummaryList = taskClient.findTasksAssignedAsPotentialOwner("bpmsAdmin", 0, 10);
		List<org.kie.server.api.model.instance.TaskSummary> taskSummaryList = taskClient.findTasksAssignedAsPotentialOwner("anil", 0, 10);
		for(org.kie.server.api.model.instance.TaskSummary taskSummary : taskSummaryList) {
			System.out.println("task name is :::::"+taskSummary.getName());
			//taskClient.startTask(containerName, taskSummary.getId(), "bpmsAdmin");
			//taskClient.completeTask(containerName, taskSummary.getId(), "bpmsAdmin", null);
		}
	}
	
	public void ruleInvoker() {
		KieServerConfiguration serverClient = new KieServerConfiguration();
		KieServicesClient kieServicesClient = null;
		// creating kie services client using configuration and factory ..
		kieServicesClient = serverClient.getKieClient();
		
		RuleServicesClient ruleClient=  kieServicesClient.getServicesClient(RuleServicesClient.class);
		//ruleClient.executeCommands(id, cmd)
	}
	
	public void startTask(TaskDTO taskDTO) throws Exception {		
		String containerId = taskDTO.getContainerId();
		Integer taskId = Integer.parseInt(taskDTO.getTaskId());
		String userName = taskDTO.getUser();
		ClientRequest request = new ClientRequest(
	            "http://localhost:8080/kie-server/services/rest/server/containers/"+containerId+"/tasks/"+taskId+"/states/started?user="+userName);
		request.header("Content-Type", "application/json");
		request.header("Authorization","Basic cmhwYW1BZG1pbjpyaHBhbUFkbWluQDE=");
		ClientResponse<String> response = request.put(String.class);
		System.out.println("status from startTask ::"+response.getStatus());
		
	}
	public void completeTask(TaskDTO taskDTO) throws Exception {		
		String containerId = taskDTO.getContainerId();
		Integer taskId = Integer.parseInt(taskDTO.getTaskId());
		String userName = taskDTO.getUser();
		ClientRequest request = new ClientRequest(
		       "http://localhost:8080/kie-server/services/rest/server/containers/"+containerId+"/tasks/"+taskId+"/states/completed?user="+userName);
		request.header("Content-Type", "application/json");
		request.header("Authorization","Basic cmhwYW1BZG1pbjpyaHBhbUFkbWluQDE=");
		ClientResponse<String> response = request.put(String.class);
		System.out.println("status from completeTask ::"+response.getStatus());
	}
	public void claimTask(TaskDTO taskDTO) throws Exception {		
		String containerId = taskDTO.getContainerId();
		Integer taskId = Integer.parseInt(taskDTO.getTaskId());
		String userName = taskDTO.getUser();
		ClientRequest request = new ClientRequest(
	            "http://localhost:8080/kie-server/services/rest/server/containers/"+containerId+"/tasks/"+taskId+"/states/claimed?user="+userName);
		request.header("Content-Type", "application/json");
		request.header("Authorization","Basic cmhwYW1BZG1pbjpyaHBhbUFkbWluQDE=");
		ClientResponse<String> response = request.put(String.class);
		System.out.println("status from claimTask ::"+response.getStatus());
		
		
	}
	public void delegateTask(TaskDTO taskDTO) throws Exception {		
		String containerId = taskDTO.getContainerId();
		Integer taskId = Integer.parseInt(taskDTO.getTaskId());
		String userName = taskDTO.getUser();
		String targetUser = taskDTO.getTargetUserId();
		ClientRequest request = new ClientRequest(
	            "http://localhost:8080/kie-server/services/rest/server/containers/"+containerId+"/tasks/"+taskId+"/states/delegated?user="+userName+"&targetUser="+targetUser);
		request.header("Content-Type", "application/json");
		request.header("Authorization","Basic cmhwYW1BZG1pbjpyaHBhbUFkbWluQDE=");
		ClientResponse<String> response = request.put(String.class);
		System.out.println("status from claimTask ::"+response.getStatus());
	}

}
