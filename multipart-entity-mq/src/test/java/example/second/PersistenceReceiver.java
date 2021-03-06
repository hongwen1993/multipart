package example.second;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class PersistenceReceiver {
    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = factory.createConnection();
        connection.setClientID("con01");
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer consumer = session.createDurableSubscriber(session.createTopic("PersistenceTopic"), "TT");
        TextMessage message = (TextMessage) consumer.receive();
        session.commit();
        while (message != null) {
            System.out.println(message.getText());
            message = (TextMessage) consumer.receive();
            session.commit();
        }
        session.close();
        connection.close();

    }
}
