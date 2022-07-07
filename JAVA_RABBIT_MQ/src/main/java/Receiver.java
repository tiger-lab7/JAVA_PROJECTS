import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Receiver {
    private static final String QUEUE_NAME = "First";

    public static void receiveMessage() throws Exception {
        // Getting connection to the Rabbit MQ server
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // Declaring async receiver callback
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            Main.logger.info("Received message: " + message);
            if (message.equals("stop")) {
                connection.close(); // Close the connection to stop, not channel
            }
        };
        // Binding callback to the Rabbit queue
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> Main.logger.info(consumerTag));
    }
}
