package example.first;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ClientAckReceiver {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
        MessageConsumer consumer = session.createConsumer(session.createQueue("clientAckQueue"));
        for (int i = 0; i < 5; i++) {
            TextMessage textMessage = (TextMessage) consumer.receive();
            textMessage.acknowledge();
            System.out.println(textMessage.getText());
        }
        //session.commit();
        connection.close();
    }
}
