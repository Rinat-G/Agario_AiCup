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


    public JSONObject doMove(TickState tickState, JSONObject command) {

        ArrayList<GameObjectMine> mineList = tickState.getMineList();
        ArrayList<GameObjectFood> foodList = tickState.getGameObjectFoodList();
        ArrayList<GameObjectPlayer> playerList = tickState.getGameObjectPlayerList();

        if (playerList.size() > 0) {
            GameObjectMine mineBiggest = MineHelper.getBiggest(mineList);
            GameObjectPlayer playerBiggest = PlayerHelper.getBiggest(playerList);


            if (mineBiggest.getMass() > playerBiggest.getMass() * 1.2) {
                command.put("X", playerBiggest.getX());
                command.put("Y", playerBiggest.getY());
                return command;
            }

            if (mineBiggest.getMass() * 1.2 < playerBiggest.getMass()) {
                GameObjectPoint point = Geometry.getOppositPoint(mineBiggest, playerBiggest);
                command.put("X", point.getX());
                command.put("Y", point.getY());

            }
        }

        if (foodList.size() > 0) {
            command = toNearestFood(foodList, mineList, command);


            JSONObject sprite = new JSONObject();
            sprite.put("id", mineList.get(0).getId());
            sprite.put("s", "test message");
            command.put("Sprite", sprite);
            return command;
        } else {
            command = toRandomPoint(mineList, command);
        }

        return command;

    }


    private JSONObject toNearestFood(ArrayList<GameObjectFood> foodArrayList,
                                     ArrayList<GameObjectMine> mineArrayList,
                                     JSONObject command) {




        GameObjectMine biggestMine = MineHelper.getBiggest(mineArrayList);

        FoodHelper.cornerFoodFilter(foodArrayList, biggestMine);

        GameObject nearestFood = Geometry.nearestTo(foodArrayList, biggestMine);

//        List<GameObject> approvedFood = foodArrayList.stream().filter(FoodHelper::isRestrict).collect(Collectors.toList());



        command.put("X", nearestFood.getX());
        command.put("Y", nearestFood.getY());

        return command;

    }

    private JSONObject toRandomPoint(ArrayList<GameObjectMine> mine, JSONObject command) {
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
