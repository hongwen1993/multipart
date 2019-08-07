package kagura.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/6 11:22
 * @since 1.0.0
 */
public class RabbitMQUtils {

    private static final String HOST = "192.168.66.66";
    private static final int PROT = 5672;
    private static final String VIRTUAL_HOST = "/";

    public static final String TOPIC = "topic";

    public static Connection getDefaultConnection() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(HOST);
        connectionFactory.setPort(PROT);
        connectionFactory.setVirtualHost(VIRTUAL_HOST);
        return connectionFactory.newConnection();
    }

    public static Connection getConnection(String virtualHost) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(HOST);
        connectionFactory.setPort(PROT);
        connectionFactory.setVirtualHost(virtualHost);
        return connectionFactory.newConnection();
    }


}
