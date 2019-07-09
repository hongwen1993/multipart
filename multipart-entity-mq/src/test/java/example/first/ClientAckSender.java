package example.first;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ClientAckSender {
    public static void main(String[] args) throws JMSException, InterruptedException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(session.createQueue("clientAckQueue"));
        for (int i = 0; i < 5; i++) {
            producer.send(session.createTextMessage("ClientAckSender message : " + i));
            Thread.sleep(2000);
        }
        //session.commit();
        connection.close();
    }
}
