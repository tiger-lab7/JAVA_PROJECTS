import org.apache.log4j.Logger;


public class LOG4J {
    final static Logger logger = Logger.getLogger(LOG4J.class);

    public static void main(String[] args) {

        logger.info("Hello LOG4J!");
        logger.debug("Starting main method!");
        logger.warn("Something wrong...");
        logger.error("Achtung!");

    }
}
