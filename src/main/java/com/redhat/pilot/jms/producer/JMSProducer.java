package com.redhat.pilot.jms.producer;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQSslConnectionFactory;

public class JMSProducer {

	public void run(String txt) {

		Connection connection = null;
		Session session = null;
		MessageProducer producer = null;

		try {

			String url = "ssl://broker-amq-tcp-ssl-redhat-test.151f.gsat-corp.openshiftapps.com:443";

			ActiveMQSslConnectionFactory connectionFactory = new ActiveMQSslConnectionFactory(url);

			connectionFactory.setUserName("userOlF");
			connectionFactory.setPassword("abDC5KlR");

			connectionFactory.setTrustStore("keys/client.ts");
			connectionFactory.setTrustStorePassword("redhat@123");

			connectionFactory.setKeyStore("keys/client.ks");
			connectionFactory.setKeyStorePassword("redhat@123");

			connection = connectionFactory.createConnection();
			connection.start();

			Queue queue = new Queue() {
				public String getQueueName() throws JMSException {
					return "test";
				}
			};

			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			producer = session.createProducer(queue);

			TextMessage message = session.createTextMessage(txt);

			producer.send(message);
			System.out.println("Sended: " + message);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if(producer != null)
					producer.close();
				
				if(session != null)
					session.close();
				
				if(connection != null)
					connection.close();

			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

	}

}
