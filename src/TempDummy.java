import dto.GameObject;
import dto.GameObjectMine;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class TempDummy {


    public static void main(String[] args) throws IOException {


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

            ArrayList<GameObjectMine> mine = tickState.getMineList();
            System.out.println(mine);

////            ArrayList<GameObject> gameObjects = tickState.getGameObjectList();
//
//
//            for (GameObject gameObject :
//                    gameObjects) {
//                System.out.println(gameObject.toString());
//            }
//            System.out.println(gameObjects);
        }








    }
}
