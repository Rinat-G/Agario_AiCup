import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class TempDummy {


    public static void main(String[] args) throws IOException {

//        Logger log = Logger.getLogger(Main.class.getName());
//        FileHandler fileHandler =  new FileHandler("strategy_log.txt", 10000000, 5 );
//        fileHandler.setFormatter(new SimpleFormatter());
//        log.addHandler(fileHandler);
//


        System.out.println("Hello");
        DebugLogger.getInstance().info("hello");

    }
}
