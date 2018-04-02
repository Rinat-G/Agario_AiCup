import dto.GameObject;
import dto.GameObjectFood;
import dto.GameObjectMine;
import helper.Geometry;
import helper.MineHelper;
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

        if (foodList.size() > 0) {
            command = toNearestFood(foodList, mineList, command);
            return command;
        } else {
            command = toRandomPoint(mineList, command);
        }

        return command;

    }


    private JSONObject toNearestFood(ArrayList<GameObjectFood> foodArrayList, ArrayList<GameObjectMine> mineArrayList, JSONObject command) {
        GameObjectMine biggerMine = MineHelper.getBiggest(mineArrayList);
        GameObject nearestFood = Geometry.nearestTo(foodArrayList, biggerMine);

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
