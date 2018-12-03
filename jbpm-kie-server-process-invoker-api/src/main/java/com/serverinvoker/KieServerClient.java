package com.serverinvoker;

import java.util.List;

import org.kie.server.api.model.instance.NodeInstance;
import org.kie.server.api.model.instance.ProcessInstance;
import org.kie.server.api.model.instance.TaskInstance;
import org.kie.server.api.model.instance.WorkItemInstance;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.ProcessServicesClient;
import org.kie.server.client.QueryServicesClient;
import org.kie.server.client.RuleServicesClient;
import org.kie.server.client.UserTaskServicesClient;

public class KieServerClient {


	//public String workFlowName = "jbpmProj.customAPIExample";
	public String workFlowName = "com.myspace.tasksla.taskSLAExample";
	public String containerName = "taskSLA";

	public void invokeWorkFlow() {
		KieServerConfiguration serverClient = new KieServerConfiguration();
		KieServicesClient kieServicesClient = null;
		kieServicesClient = serverClient.getKieClient();
		ProcessServicesClient processClient = kieServicesClient.getServicesClient(ProcessServicesClient.class);		
		Long processInstanceId = processClient.startProcess(containerName, workFlowName);
		System.out.println("Process Instance Id Is ::::"+processInstanceId);
	}

	public static void main(String args[]) {
		KieServerClient serverClient = new KieServerClient();
		//serverClient.invokeWorkFlow();
		//serverClient.getContainerInfoByTaskId();
		//serverClient.getContainerInfoByProcessId();
		//serverClient.getHumanTaskRelatedInfo();
		serverClient.getTaskIdFromWorkItemId();
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
	
	public void getTaskIdFromWorkItemId() {
		KieServerConfiguration serverClient = new KieServerConfiguration();
		KieServicesClient kieServicesClient = null;
		kieServicesClient = serverClient.getKieClient();
		ProcessServicesClient processClient = kieServicesClient.getServicesClient(ProcessServicesClient.class);
		//WorkItemInstance wii= processClient.getWorkItem(containerName, 226L, 67L);
		
		UserTaskServicesClient taskClient = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
		
		QueryServicesClient queryServicesClient = kieServicesClient.getServicesClient(QueryServicesClient.class);
		List<NodeInstance> nodeInstanceList = queryServicesClient.findActiveNodeInstances(226L, 0, 10);
		TaskInstance taskInstance = taskClient.findTaskByWorkItemId(nodeInstanceList.get(0).getWorkItemId());
		System.out.println("task instance id is::"+taskInstance.getId());
		//queryServicesClient.
		//wii.get`
		//wii.get
		
	}

}
