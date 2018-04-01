import dto.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TickState {

    private ArrayList<Mine> mineList;
    private ArrayList<GameObject> gameObjectList;

    public TickState(JSONObject parsedTickState) {

        JSONArray mineJSONArray = parsedTickState.getJSONArray("Mine");
        JSONArray objects = parsedTickState.getJSONArray("Objects");
        mineList = new ArrayList<>();
        gameObjectList = new ArrayList<>();


        for (int i = 0; i < mineJSONArray.length(); i++) {
            JSONObject mineJSONObject = mineJSONArray.getJSONObject(i);
            Mine mineDTO = new Mine(
                    mineJSONObject.getString("Id"),
                    mineJSONObject.getFloat("X"),
                    mineJSONObject.getFloat("Y"),
                    mineJSONObject.getFloat("R"),
                    mineJSONObject.getFloat("M"),
                    mineJSONObject.getFloat("SX"),
                    mineJSONObject.getFloat("SY")
                    //добавить TTF
            );
            mineList.add(i, mineDTO);
        }

        for (int i = 0; i < objects.length(); i++) {
            JSONObject objectJSONObject = objects.getJSONObject(i);
            GameObject gameObjectDTO = null;

            switch (objectJSONObject.getString("T")) {
                case "F":
                    gameObjectDTO = new GameObjectFood(
                            objectJSONObject.getFloat("X"),
                            objectJSONObject.getFloat("Y")
                    );
                    break;
                case "E":
                    gameObjectDTO = new GameObjectEjection(
                            objectJSONObject.getFloat("X"),
                            objectJSONObject.getFloat("Y")
                    );
                    break;
                case "V":
                    gameObjectDTO = new GameObjectVirus(
                            objectJSONObject.getFloat("X"),
                            objectJSONObject.getFloat("Y"),
                            objectJSONObject.getString("Id"),
                            objectJSONObject.getFloat("M")
                    );
                    break;
                case "P":
                    gameObjectDTO = new GameObjectPlayer(
                            objectJSONObject.getFloat("X"),
                            objectJSONObject.getFloat("Y"),
                            objectJSONObject.getString("Id"),
                            objectJSONObject.getFloat("M"),
                            objectJSONObject.getFloat("R")

                    );
                    break;
            }

            gameObjectList.add(i,gameObjectDTO);

        }


    }

    public ArrayList<Mine> getMineList() {
        return mineList;
    }

    public ArrayList<GameObject> getGameObjectList() {
        return gameObjectList;
    }
}
