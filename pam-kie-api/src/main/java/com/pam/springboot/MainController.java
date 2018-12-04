package com.pam.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pam.springboot.dto.ProcessDTO;
import com.pam.springboot.dto.TaskDTO;
import com.pam.springboot.service.KieServerClient;

@RestController
public class MainController {

	KieServerClient kieServicesClient = new KieServerClient();

	@RequestMapping(value = "/startProcess", method = RequestMethod.POST)
	public ResponseEntity<String> startProcess(@RequestBody ProcessDTO process) {
		long processId = kieServicesClient.invokeWorkFlow(process);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@RequestMapping(value = "/startTask", method = RequestMethod.PUT)
	public ResponseEntity<String> startTask(@RequestBody TaskDTO task) throws Exception {
		kieServicesClient.startTask(task);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	@RequestMapping(value = "/completeTask", method = RequestMethod.PUT)
	public ResponseEntity<String> completeTask(@RequestBody TaskDTO task) throws Exception {
		 kieServicesClient.completeTask(task);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	@RequestMapping(value = "/claimTask", method = RequestMethod.PUT)
	public ResponseEntity<String> claimTask(@RequestBody TaskDTO task) throws Exception {
		 kieServicesClient.claimTask(task);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	@RequestMapping(value = "/delegateTask", method = RequestMethod.PUT)
	public ResponseEntity<String> delegateTask(@RequestBody TaskDTO task) throws Exception {
		 kieServicesClient.delegateTask(task);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@RequestMapping(value="/sample",method=RequestMethod.GET)
	public String getSample() {
		return "hello boss";
	}
}
