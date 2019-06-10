package example.second;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class NoPersistenceSender {

    public static void main(String[] args) throws JMSException, InterruptedException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(session.createTopic("noPersistenceTopic"));
        for (int i = 0; i < 5; i++) {
            producer.send(session.createTextMessage("message : " + i));
            session.commit();
            Thread.sleep(1000);
        }
        session.close();
        connection.close();
    }

}
