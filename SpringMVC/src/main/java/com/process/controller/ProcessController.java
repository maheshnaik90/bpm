package com.process.controller;

import org.kie.server.client.KieServicesClient;
import org.kie.server.client.ProcessServicesClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.serverinvoker.KieServerConfiguration;
import com.serverinvoker.ProcessDTO;

@Controller
@RequestMapping("/processController")
public class ProcessController {
	
	public String workFlowName = "com.myspace.tasksla.taskSLAExample";
	public String containerName = "taskSLA";
	
	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name, ModelMap model) {

		model.addAttribute("movie", name);
		return "list";

	}
	
	@RequestMapping(value="/{startProcess}", method = RequestMethod.POST)	
	//@Consumes("application/json")
	//@Produces("application/json")
	public void startProcess(@ModelAttribute ProcessDTO processDTO) {
		System.out.print(processDTO.getContainerId());
		System.out.print(processDTO.getProcessId());
		KieServerConfiguration serverClient = new KieServerConfiguration();
		KieServicesClient kieServicesClient = null;
		kieServicesClient = serverClient.getKieClient();
		ProcessServicesClient processClient = kieServicesClient.getServicesClient(ProcessServicesClient.class);		
		Long processInstanceId = processClient.startProcess("taskSLA", "com.myspace.tasksla.taskSLAExample");
		System.out.println("Process Instance Id Is ::::"+processInstanceId);
		
	}
	
}