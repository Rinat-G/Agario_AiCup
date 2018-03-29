import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DebugLogger {

    private static DebugLogger instance = new DebugLogger();
    private final Logger log = Logger.getLogger(Main.class.getName());

    private DebugLogger() {


        FileHandler fileHandler = null;

        try {
            fileHandler = new FileHandler("strategy_log.txt", 10000000, 5);
            fileHandler.setFormatter(new SimpleFormatter());
            log.addHandler(fileHandler);
            log.setUseParentHandlers(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static DebugLogger getInstance() {
        return instance;
    }

    public void info(String string) {
        log.info(string);

    }

    public void warning(String string) {
        log.warning(string);
    }


}
