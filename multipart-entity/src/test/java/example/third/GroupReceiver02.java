package example.third;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQPrefetchPolicy;

import javax.jms.*;

public class GroupReceiver02 {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        ActiveMQConnection connection = (ActiveMQConnection) factory.createConnection();

        ActiveMQPrefetchPolicy prefetchPolicy = new ActiveMQPrefetchPolicy();
        prefetchPolicy.setQueuePrefetch(3);
        connection.setPrefetchPolicy(prefetchPolicy); //预取策略
        connection.setOptimizeAcknowledge(true);
        connection.setOptimizeAcknowledgeTimeOut(10000);
        connection.start();
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer consumer = session.createConsumer(session.createQueue("Test.GroupQueue?consumer.prefetchSize=3"));
        consumer.setMessageListener(message -> {
            try {
                TextMessage textMessage = (TextMessage) message;

                if (textMessage != null) {
                    //textMessage.acknowledge();
                    System.out.println(textMessage.getText());
                    Thread.sleep(5000);
                }

            } catch (JMSException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //connection.close();
    }

}
