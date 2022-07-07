import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        Sender.sendMessage("Hello from Rabbit MQ!");
        Receiver.receiveMessage();
        Sender.sendMessage("stop");

        //Thread.sleep(5000);
    }
}
