package com.wih;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import com.pojo.Employee;

public class CustomWIH implements WorkItemHandler {

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		List<Employee> employeeListResult = new ArrayList<Employee>();
		
		Map<String,Object> map =new HashMap<String,Object>();		
		
		System.out.println("RHPAM WIH CONFIGURED SUCCESSFULLY");		
		List<Employee> employeeListLocal = (List<Employee>) workItem.getParameter("employeeList");
		System.out.println("employeeListLocal size is :::"+employeeListLocal.size());
		
		if(employeeListLocal!=null && !employeeListLocal.isEmpty()) {
			for(int i=0;i<employeeListLocal.size();i++) {
				if(employeeListLocal.get(i).getName().equals("Anil")) {					
					Employee employeeModified = employeeListLocal.get(i);
					employeeModified.setName("kumar");
					employeeListResult.add(employeeModified);
					
				}
				else {
					employeeListResult.add(employeeListLocal.get(i));
				}
				
			}
		}
		map.put("employeeListOutput", employeeListResult);
		
		manager.completeWorkItem(workItem.getId(), map);
	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		// TODO Auto-generated method stub
		
	}

}
