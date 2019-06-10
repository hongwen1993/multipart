package example.third;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Random;

public class GroupReceiver {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer consumer = session.createConsumer(session.createQueue("Test.GroupQueue?consumer.prefetchSize=5"));
        for (int i = 0; i < 5; i++) {
            TextMessage textMessage = (TextMessage) consumer.receive();
            System.out.println(textMessage.getText());
            System.out.println(textMessage.getIntProperty("JMSXGroupSeq"));

        }
        //session.commit();
        connection.close();
    }

}
