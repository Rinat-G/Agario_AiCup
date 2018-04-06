package engine;

import dto.*;
import env.GlobalConfig;
import helper.Geometry;
import helper.MineHelper;
import helper.Physics;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class MoveEngine {

    private static int currentRandomX = 0;
    private static int currentRandomY = 0;
    private static Random rnd = new Random();
    private static final float avoidanceAreaPercent = 0.1f;


    private static int getCurrentRandomX() {
        if (currentRandomX == 0) {
            GlobalConfig gc = GlobalConfig.getInstance();
            do {
                currentRandomX = rnd.nextInt(660) + 1;
            }
            //фильтр значений заходящих за avoidanceArea
            while ((Math.abs(currentRandomX - gc.getGAME_WIDTH() / 2))
                    > (gc.getGAME_WIDTH() / 2) - (gc.getGAME_WIDTH() * avoidanceAreaPercent));
        }
        return currentRandomX;
    }


    private static int getCurrentRandomY() {
        if (currentRandomY == 0) {
            GlobalConfig gc = GlobalConfig.getInstance();
            do {
                currentRandomY = rnd.nextInt(660) + 1;
            }
            //фильтр значений заходящих за avoidanceArea
            while ((Math.abs(currentRandomY - gc.getGAME_HEIGHT() / 2))
                    > (gc.getGAME_HEIGHT() / 2) - (gc.getGAME_HEIGHT() * avoidanceAreaPercent));

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

    public static JSONObject runAwayYWall(Mine mine, Player player, JSONObject command) {
        command.put("X", mine.getX());

        if (mine.getY() > player.getY()) {
            command.put("Y", GlobalConfig.getInstance().getGAME_HEIGHT());
        } else {
            command.put("Y", 0);
        }

        return command;

    }

    public static JSONObject runAwayXWall(Mine mine, Player player, JSONObject command) {
        command.put("Y", mine.getY());

        if (mine.getX() > player.getX()) {
            command.put("X", GlobalConfig.getInstance().getGAME_WIDTH());
        } else {
            command.put("X", 0);
        }

        return command;

    }

    public static JSONObject standardRunAway(Mine mine, Player player, JSONObject command) {
        Point point = Geometry.getOppositePoint(mine, player);
        command.put("X", point.getX());
        command.put("Y", point.getY());
        return command;
    }


    public static JSONObject cornerRunAway(Mine mine, Player player, JSONObject command) {

        GlobalConfig gc = GlobalConfig.getInstance();

        if (Geometry.borderXDeviation(player) - Geometry.borderXDeviation(mine) <
                Geometry.borderYDeviation(player) - Geometry.borderYDeviation(mine)) {

            if (mine.getX() < gc.getGAME_WIDTH() / 2) {
                command.put("X", 0);
            } else {
                command.put("X", gc.getGAME_WIDTH());
            }
            command.put("Y", gc.getGAME_HEIGHT() / 2);
        } else {


            command.put("X", gc.getGAME_WIDTH() / 2);

            if (mine.getY() < gc.getGAME_HEIGHT() / 2) {
                command.put("Y", 0);
            } else {
                command.put("Y", gc.getGAME_HEIGHT());
            }

        }
        return command;


    }


}
