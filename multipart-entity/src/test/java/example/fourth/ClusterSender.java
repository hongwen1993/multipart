package example.fourth;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;

import javax.jms.*;

public class ClusterSender {

    public static void main(String[] args) throws JMSException, InterruptedException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,// tcp://192.168.0.188:61616,tcp://192.168.0.188:61626
                "failover:(tcp://192.168.0.188:61616,tcp://192.168.0.188:61617)?Randomize=false");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        ActiveMQMessageProducer producer = (ActiveMQMessageProducer) session.createProducer(session.createQueue("Test.ClusterQueue.06"));
        for (int i = 0; i < 5; i++) {
            TextMessage message = session.createTextMessage("message : " + i);

            producer.send(message);
            producer.send(message, new AsyncCallback() {
                @Override
                public void onSuccess() {
                    //Math.pow()
                }

                @Override
                public void onException(JMSException exception) {

                }
            });
            Thread.sleep(5000);
        }
        connection.close();
    }
}
