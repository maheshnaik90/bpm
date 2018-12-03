package com.wih;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

public class PushMessageWIH implements WorkItemHandler {
	//private final Logger logger = LoggerFactory.getLogger(PushMessageWIH.class);
	private SecureRandom random = new SecureRandom();

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		/*String taskName = generateTaskName();
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("sampleQueue");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            String text = "Hello from: " + taskName + " : " + this.hashCode();
            TextMessage message = session.createTextMessage(text);
            //logger.info("Sent message hash code: "+ message.hashCode() + " : " + taskName);
            producer.send(message);
            session.close();
            connection.close();
            manager.completeWorkItem(workItem.getId(), null);
        } catch (JMSException e) {
            //logger.error("Sender createTask method error", e);
        }*/
	}	

	private String generateTaskName() {
		return new BigInteger(20, random).toString(16);
	}
	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		// TODO Auto-generated method stub

	}
}
