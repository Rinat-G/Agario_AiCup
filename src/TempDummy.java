import dto.GameObject;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        DebugLogger log = DebugLogger.getInstance();


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;

        line = in.readLine();


        JSONObject config = new JSONObject(line);
        log.warning(config.toString());
        GlobalConfig.init(config);

        System.out.println(GlobalConfig.getInstance().toString());


        while (true){//(line = in.readLine()) != null && line.length() != 0) {
            line = in.readLine();
            JSONObject tickStateJSON = new JSONObject(line);
            TickState tickState = new TickState(tickStateJSON);

            ArrayList<Mine> mine = tickState.getMineList();
            System.out.println(mine);

            ArrayList<GameObject> gameObjects = tickState.getGameObjectList();


            for (GameObject gameObject :
                    gameObjects) {
                System.out.println(gameObject.toString());
            }
            System.out.println(gameObjects);
        }





//        try {
//            line = in.readLine();
//            JSONObject config = new JSONObject(line);
//            log.warning(config.toString());
//            new GlobalConfig(config);
//
//            moveEngine = new MoveEngine();
//
//
//            while ((line = in.readLine()) != null && line.length() != 0) {
//                JSONObject tickState = new JSONObject(line);
//                JSONObject command = onTick(tickState);
//                System.out.println(command.toString());
//            }
//        } catch (IOException e) {
//            System.err.println(e);
//        }


    }
}
