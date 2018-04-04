package engine;

import dto.*;
import env.TickState;
import helper.FoodHelper;
import helper.Geometry;
import helper.MineHelper;
import helper.PlayerHelper;
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


//    public JSONObject doMove(TickState tickState, JSONObject command) {
//
//        ArrayList<Mine> mineList = tickState.getMineList();
//        ArrayList<Food> foodList = tickState.getFoodList();
//        ArrayList<Player> playerList = tickState.getPlayerList();
//
//        if (playerList.size() > 0) {
//            Mine mineBiggest = MineHelper.getBiggest(mineList);
//
//            Player playerBiggest = PlayerHelper.getBiggest(playerList);
//
//
//            if (mineBiggest.getMass() > playerBiggest.getMass() * 1.2) {
//                command.put("X", playerBiggest.getX());
//                command.put("Y", playerBiggest.getY());
//                return command;
//            }
//
//            if (mineBiggest.getMass() * 1.2 < playerBiggest.getMass()) {
//
//                Point point = Geometry.getOppositePoint(mineBiggest, playerBiggest);
//                command.put("X", point.getX());
//                command.put("Y", point.getY());
//                return command;
//
//            }
//        }
//
//        if (foodList.size() > 0) {
//            command = toNearestFood(foodList, mineList, command);
//
//
//            JSONObject sprite = new JSONObject();
//            sprite.put("id", mineList.get(0).getId());
//            sprite.put("s", "test message");
//            command.put("Sprite", sprite);
//            return command;
//        } else {
//            command = toRandomPoint(mineList, command);
//        }
//
//        return command;
//
//    }


    public static JSONObject toNearestFood(ArrayList<Food> foodArrayList,
                                            ArrayList<Mine> mineArrayList,
                                            JSONObject command) {


        Mine biggestMine = MineHelper.getBiggest(mineArrayList);



        GameObject nearestFood = Geometry.nearestTo(foodArrayList, biggestMine);

//        List<GameObject> approvedFood = foodArrayList.stream().filter(FoodHelper::isRestrict).collect(Collectors.toList());


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
