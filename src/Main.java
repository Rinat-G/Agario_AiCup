import java.io.*;

import org.json.*;

class Main {


    private static DebugLogger log = DebugLogger.getInstance();
    private static MoveEngine moveEngine;

    public static void main(String[] args) {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            line = in.readLine();
            JSONObject config = new JSONObject(line);
            log.warning(config.toString());
            GlobalConfig.init(config);


            moveEngine = new MoveEngine();


            while ((line = in.readLine()) != null && line.length() != 0) {
                JSONObject tickState = new JSONObject(line);
                JSONObject command = onTick(tickState);
                System.out.println(command.toString());
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static JSONObject onTick(JSONObject tickState) {
        JSONArray mine = tickState.getJSONArray("Mine");
        JSONObject command = new JSONObject();

        if (mine.length() > 0) {

            command = moveEngine.doMove(tickState);
//            JSONArray objects = parsed.getJSONArray("Objects");
//            JSONObject food = findFood(objects);
//            if (food != null) {
//                command.put("X", food.getInt("X"));
//                command.put("Y", food.getInt("Y"));
//            } else {
//                command.put("X", moveEngine.getCurrentX());
//                command.put("Y", moveEngine.getCurrentY());
//                command.put("Debug", "No food");
//            }
        } else {
            command.put("X", 0);
            command.put("Y", 0);
            command.put("Debug", "Died");
        }
        log.info(command.toString());
        return command;
    }


}