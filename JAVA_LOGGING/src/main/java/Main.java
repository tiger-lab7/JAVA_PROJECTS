import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    static Logger logger;

    static {
        try (BufferedInputStream bufferedInputStream =
                     new BufferedInputStream(
                             new FileInputStream("C:\\Users\\A12\\IdeaProjects\\JAVA_LOGGING\\src\\main\\resources\\logger.cfg"))) {

            LogManager.getLogManager().readConfiguration(bufferedInputStream);
            logger = Logger.getLogger(Main.class.getName());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        logger.log(Level.INFO, "Запуск main");
        try {
            throw new RuntimeException("Ошибка!");
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Что-то пошло не так: ", ex);
        }
        logger.log(Level.SEVERE, () -> "Завершение программы...");
    }
}
