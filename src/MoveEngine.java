import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Random;

public class MoveEngine {

    private int currentRandomX = 0;
    private int currentRandomY = 0;
    private Random rnd = new Random();


    private int getCurrentRandomX() {
        if (currentRandomX == 0) {
            currentRandomX = rnd.nextInt(660) + 1;
        }
        return currentRandomX;
    }


    private int getCurrentRandomY() {
        if (currentRandomY == 0) {
            currentRandomY = rnd.nextInt(660) + 1;
        }

        return currentRandomY;
    }

    JSONObject doMove(JSONObject tickState) {

        JSONObject command = new JSONObject();
        JSONArray mine = tickState.getJSONArray("Mine");
        JSONArray objects = tickState.getJSONArray("Objects");
        JSONObject food = findFood(objects);

        if (food != null) {
            command = toFood(food, command);
            return command;
        }
        command = toRandomPoint(mine, command);


        return command;

    }


    private JSONObject findFood(JSONArray objects) {
        for (int i = 0; i < objects.length(); i++) {
            JSONObject obj = objects.getJSONObject(i);
            if (obj.getString("T").equals("F")) {
                return obj;
            }
        }
        return null;
    }

    private JSONObject toRandomPoint(JSONArray mine, JSONObject command) {

//        mine.
//        for (JSONObject mineFrag :
//                mine) {
//
//        }
        

        return command;
    }


    private JSONObject toFood(JSONObject food, JSONObject command) {

        command.put("X", food.getInt("X"));
        command.put("Y", food.getInt("Y"));
        return command;

    }

}
