package com.wih;

import java.util.List;

import org.kie.api.event.process.ProcessCompletedEvent;
import org.kie.api.event.process.ProcessEventListener;
import org.kie.api.event.process.ProcessNodeLeftEvent;
import org.kie.api.event.process.ProcessNodeTriggeredEvent;
import org.kie.api.event.process.ProcessStartedEvent;
import org.kie.api.event.process.ProcessVariableChangedEvent;
import org.kie.api.event.process.SLAViolatedEvent;
import org.kie.server.api.model.instance.NodeInstance;
import org.kie.server.api.model.instance.TaskInstance;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.QueryServicesClient;
import org.kie.server.client.UserTaskServicesClient;

public class TaskListener implements ProcessEventListener {

	public void beforeProcessStarted(ProcessStartedEvent event) {
		// TODO Auto-generated method stub

	}

	public void afterProcessStarted(ProcessStartedEvent event) {
		// TODO Auto-generated method stub

	}

	public void beforeProcessCompleted(ProcessCompletedEvent event) {
		// TODO Auto-generated method stub

	}

	public void afterProcessCompleted(ProcessCompletedEvent event) {
		// TODO Auto-generated method stub

	}

	public void beforeNodeTriggered(ProcessNodeTriggeredEvent event) {
		// TODO Auto-generated method stub

	}

	public void afterNodeTriggered(ProcessNodeTriggeredEvent event) {
		// TODO Auto-generated method stub
		System.out.println("after node triggered!!!!" + event);

	}

	public void beforeNodeLeft(ProcessNodeLeftEvent event) {
		// TODO Auto-generated method stub

	}

	public void afterNodeLeft(ProcessNodeLeftEvent event) {
		// TODO Auto-generated method stub

	}

	public void beforeVariableChanged(ProcessVariableChangedEvent event) {
		// TODO Auto-generated method stub

	}

	public void afterVariableChanged(ProcessVariableChangedEvent event) {
		// TODO Auto-generated method stub

	}

	public void afterSLAViolated(SLAViolatedEvent event) {
		TaskInstance taskInstance = null;
		KieServerConfiguration serverClient = new KieServerConfiguration();
		KieServicesClient kieServicesClient = null;
		kieServicesClient = serverClient.getKieClient();
		QueryServicesClient queryServicesClient = kieServicesClient.getServicesClient(QueryServicesClient.class);
		UserTaskServicesClient taskClient = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
		List<NodeInstance> nodeInstanceList = queryServicesClient
				.findActiveNodeInstances(event.getProcessInstance().getId(), 0, 10);

		if (nodeInstanceList != null && !nodeInstanceList.isEmpty()) {
			
			for(NodeInstance nodeInstance : nodeInstanceList) {
				if(nodeInstance.getName().equals("task")) {
					taskInstance = taskClient.findTaskByWorkItemId(nodeInstanceList.get(0).getWorkItemId());
					
					if(!taskInstance.getStatus().equals("Ready")){
						taskClient.releaseTask(nodeInstance.getContainerId(), taskInstance.getId(), taskInstance.getActualOwner());
						
					}
				}
			}
			
		}

	}
}
