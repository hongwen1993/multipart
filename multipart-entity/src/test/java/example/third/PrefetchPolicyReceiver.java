package example.third;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQPrefetchPolicy;

import javax.jms.*;

public class PrefetchPolicyReceiver {

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        ActiveMQConnection connection = (ActiveMQConnection) factory.createConnection();

        ActiveMQPrefetchPolicy prefetchPolicy = new ActiveMQPrefetchPolicy();
        prefetchPolicy.setQueuePrefetch(10);
        connection.setPrefetchPolicy(prefetchPolicy); //预取策略
        connection.setOptimizeAcknowledge(true); //可优化的ACK，延迟确认
        connection.setOptimizeAcknowledgeTimeOut(1000);
        connection.start();

        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer consumer = session.createConsumer(session.createQueue("Test.PrefetchPolicyQueue"));
        for (int i = 0; i < 10; i++) {
            TextMessage textMessage = (TextMessage) consumer.receive();
            System.out.println(textMessage.getText());
            System.out.println(textMessage.getIntProperty("JMSXGroupSeq"));

        }
        //session.commit();
        connection.close();
    }

}
