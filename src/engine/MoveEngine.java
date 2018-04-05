package engine;

import dto.*;
import helper.Geometry;
import helper.MineHelper;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class MoveEngine {

    private static int currentRandomX = 0;
    private static int currentRandomY = 0;
    private static Random rnd = new Random();


    private static int getCurrentRandomX() {
        if (currentRandomX == 0) {
            currentRandomX = rnd.nextInt(660) + 1;
        }
        return currentRandomX;
    }


    private static int getCurrentRandomY() {
        if (currentRandomY == 0) {
            currentRandomY = rnd.nextInt(660) + 1;
        }

        return currentRandomY;
    }




    public static JSONObject toNearestFood(ArrayList<Food> foodArrayList,
                                            ArrayList<Mine> mineArrayList,
                                            JSONObject command) {


        Mine biggestMine = MineHelper.getBiggest(mineArrayList);



        GameObject nearestFood = Geometry.nearestTo(foodArrayList, biggestMine);



        command.put("X", nearestFood.getX());
        command.put("Y", nearestFood.getY());

        return command;

    }

    public static JSONObject toRandomPoint(ArrayList<Mine> mine, JSONObject command) {
        if (MineHelper.isInRadius(
                MineHelper.getBiggest(mine), getCurrentRandomX(), getCurrentRandomY())) {
            currentRandomX = 0;
            currentRandomY = 0;
        }


        command.put("X", getCurrentRandomX());
        command.put("Y", getCurrentRandomY());


        return command;
    }


}
