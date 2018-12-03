package com.wih;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

public class TestWIH implements WorkItemHandler {
	int count = 0;
	Map<String, Object> map = new HashMap<String, Object>();

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		this.executeWorkItemCustom(workItem, manager, count);
	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		// TODO Auto-generated method stub

	}

	public void executeWorkItemCustom(WorkItem workItem, WorkItemManager manager, int count) {
		try {
			int n = 2 / 0;
		} catch (Exception e) {
			count++;
			if (count < 3) {
				this.executeWorkItemCustom(workItem, manager, count);
			} else {
				map.put("exceptionFlag_", true);
				manager.completeWorkItem(workItem.getId(), map);
			}

		}

	}

}
