package example.third;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ScheduledMessage;

import javax.jms.*;

public class GroupSender {

    public static void main(String[] args) throws JMSException, InterruptedException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(session.createQueue("Test.GroupQueue"));
        for (int i = 0; i < 20; i++) {
            int a = (int) (Math.random() * 10);
            Message message = session.createTextMessage("message : " + i + ";a : " + a);
            message.setStringProperty("JMSXGroupID", "Group01");
            message.setIntProperty("JMSXGroupSeq", a);
            //message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 15000);
            producer.send(message);
            //Thread.sleep(1000);
        }
        //session.commit();
        connection.close();
    }

}
