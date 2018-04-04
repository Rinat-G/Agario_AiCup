package env;

import dto.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TickState {

    private int tickNumber;
    private ArrayList<GameObjectMine> mineList;
    private ArrayList<GameObjectFood> gameObjectFoodList;
    private ArrayList<GameObjectEjection> gameObjectEjectionList;
    private ArrayList<GameObjectVirus> gameObjectVirusList;
    private ArrayList<GameObjectPlayer> gameObjectPlayerList;

    public TickState(JSONObject parsedTickState ,int tickNumber) {

        this.tickNumber = tickNumber;
        JSONArray mineJSONArray = parsedTickState.getJSONArray("Mine");
        JSONArray objects = parsedTickState.getJSONArray("Objects");
        mineList = new ArrayList<>();
//        gameObjectList = new ArrayList<>();
        gameObjectFoodList = new ArrayList<>();
        gameObjectEjectionList = new ArrayList<>();
        gameObjectVirusList = new ArrayList<>();
        gameObjectPlayerList = new ArrayList<>();


        for (int i = 0; i < mineJSONArray.length(); i++) {
            JSONObject mineJSONObject = mineJSONArray.getJSONObject(i);
            GameObjectMine mineDTO = new GameObjectMine(
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

            switch (objectJSONObject.getString("T")) {
                case "F":
                    gameObjectFoodList.add(
                            new GameObjectFood(
                                    objectJSONObject.getFloat("X"),
                                    objectJSONObject.getFloat("Y")
                            )
                    );
                    break;
                case "E":
                    gameObjectEjectionList.add(
                            new GameObjectEjection(
                                    objectJSONObject.getFloat("X"),
                                    objectJSONObject.getFloat("Y")
                            )
                    );
                    break;
                case "V":
                    gameObjectVirusList.add(
                            new GameObjectVirus(
                                    objectJSONObject.getFloat("X"),
                                    objectJSONObject.getFloat("Y"),
                                    objectJSONObject.getString("Id"),
                                    objectJSONObject.getFloat("M")
                            )
                    );
                    break;
                case "P":
                    gameObjectPlayerList.add(
                            new GameObjectPlayer(
                                    objectJSONObject.getFloat("X"),
                                    objectJSONObject.getFloat("Y"),
                                    objectJSONObject.getString("Id"),
                                    objectJSONObject.getFloat("M"),
                                    objectJSONObject.getFloat("R")

                            )
                    );
                    break;
            }

//            gameObjectList.add(i, gameObjectDTO);

        }


    }

    public int getTickNumber() {
        return tickNumber;
    }

    public ArrayList<GameObjectMine> getMineList() {
        return mineList;
    }


    public ArrayList<GameObjectFood> getGameObjectFoodList() {
        return gameObjectFoodList;
    }

    public ArrayList<GameObjectEjection> getGameObjectEjectionList() {
        return gameObjectEjectionList;
    }

    public ArrayList<GameObjectVirus> getGameObjectVirusList() {
        return gameObjectVirusList;
    }

    public ArrayList<GameObjectPlayer> getGameObjectPlayerList() {
        return gameObjectPlayerList;
    }
}
