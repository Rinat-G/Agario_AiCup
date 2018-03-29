import java.io.*;

import org.json.*;

class Main {


    private static DebugLogger log = DebugLogger.getInstance();
    private static Move moveEngine;

    public static void main(String[] args) {



        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            line = in.readLine();
            JSONObject config = new JSONObject(line);

             moveEngine = new Move(config);

            log.warning(config.toString());

            while ((line = in.readLine()) != null && line.length() != 0) {
                JSONObject parsed = new JSONObject(line);
                JSONObject command = onTick(parsed, config);
                System.out.println(command.toString());
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static JSONObject onTick(JSONObject parsed, JSONObject config) {
        JSONArray mine = parsed.getJSONArray("Mine");
        JSONObject command = new JSONObject();
        if (mine.length() > 0) {
            JSONArray objects = parsed.getJSONArray("Objects");
            JSONObject food = findFood(objects);
            if (food != null) {
                command.put("X", food.getInt("X"));
                command.put("Y", food.getInt("Y"));
            } else {
                command.put("X", moveEngine.getCurrentX());
                command.put("Y", moveEngine.getCurrentY());
                command.put("Debug", "No food");
                JSONObject spriteObject = new JSONObject();
                spriteObject.put("Id", mine.getJSONObject(0).getFloat("Id"));
                spriteObject.put("S", "Test Mesage");
                command.put("Sprite", spriteObject);
            }
        } else {
            command.put("X", 0);
            command.put("Y", 0);
            command.put("Debug", "Died");
        }
        log.info(command.toString());
        return command;
    }

    public static JSONObject findFood(JSONArray objects) {
        for (int i = 0; i < objects.length(); i++) {
            JSONObject obj = objects.getJSONObject(i);
            if (obj.getString("T").equals("F")) {
                return obj;
            }
        }
        return null;
    }
}