package example.third;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ExclusiveReceiver {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(session.createQueue("TEST.QUEUE?consumer.exclusive=true"));
        for (int i = 0; i < 5; i++) {
            Message message = session.createTextMessage("message : " + i);
            producer.send(message);
        }
        connection.close();
    }

}
