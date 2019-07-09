package example.second;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class PrioritySender01 {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(session.createQueue("priorityQueue"));
        for (int i = 0; i < 5; i++) {
            producer.send(session.createTextMessage("message : " + i), DeliveryMode.PERSISTENT, 9, 20000);
        }
        connection.close();
    }

}
