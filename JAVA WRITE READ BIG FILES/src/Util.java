import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public class Util {
    public static final Logger logger = Logger.getLogger("MyLogger");

    public static MessageDigest messageDigest = null;
    static {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            logger.severe(e.toString());
        }
    }
}
