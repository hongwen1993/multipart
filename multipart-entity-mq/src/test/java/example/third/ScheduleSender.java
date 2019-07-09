package example.third;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ScheduledMessage;

import javax.jms.*;

public class ScheduleSender {

    public static void main(String[] args) throws JMSException{
        ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(session.createQueue("Test.ScheduleQueue"));
        Message message = session.createTextMessage("message : DELAY & REPEAT");
        message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 15000);
        message.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, 3);
        producer.send(message);
        session.commit();
        connection.close();
    }

}
