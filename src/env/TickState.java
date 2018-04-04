package env;

import dto.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TickState {

    private int tickNumber;
    private ArrayList<Mine> mineList;
    private ArrayList<Food> foodList;
    private ArrayList<Ejection> ejectionList;
    private ArrayList<Virus> virusList;
    private ArrayList<Player> playerList;

    public TickState(JSONObject parsedTickState ,int tickNumber) {

        this.tickNumber = tickNumber;
        JSONArray mineJSONArray = parsedTickState.getJSONArray("Mine");
        JSONArray objects = parsedTickState.getJSONArray("Objects");
        mineList = new ArrayList<>();
//        gameObjectList = new ArrayList<>();
        foodList = new ArrayList<>();
        ejectionList = new ArrayList<>();
        virusList = new ArrayList<>();
        playerList = new ArrayList<>();


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

            switch (objectJSONObject.getString("T")) {
                case "F":
                    foodList.add(
                            new Food(
                                    objectJSONObject.getFloat("X"),
                                    objectJSONObject.getFloat("Y")
                            )
                    );
                    break;
                case "E":
                    ejectionList.add(
                            new Ejection(
                                    objectJSONObject.getFloat("X"),
                                    objectJSONObject.getFloat("Y")
                            )
                    );
                    break;
                case "V":
                    virusList.add(
                            new Virus(
                                    objectJSONObject.getFloat("X"),
                                    objectJSONObject.getFloat("Y"),
                                    objectJSONObject.getString("Id"),
                                    objectJSONObject.getFloat("M")
                            )
                    );
                    break;
                case "P":
                    playerList.add(
                            new Player(
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

    public ArrayList<Mine> getMineList() {
        return mineList;
    }


    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public ArrayList<Ejection> getEjectionList() {
        return ejectionList;
    }

    public ArrayList<Virus> getVirusList() {
        return virusList;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
}
