package engine;

import dto.*;
import env.GlobalConfig;
import env.TickState;
import helper.*;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class StrategyEngine {


    public static StrategyType chooseStrategy(TickState tickState) {


        if (tickState.getMineList().size() == 0) {
            return StrategyType.DIED;
        }


        ArrayList<Mine> mineList = tickState.getMineList();
        ArrayList<Food> foodList = tickState.getFoodList();
        ArrayList<Player> playerList = tickState.getPlayerList();

        if (playerList.size() > 0) {

            Mine mineSmallest = MineHelper.getSmallest(mineList);
            Player playerBiggest = PlayerHelper.getBiggest(playerList);

            if (mineSmallest.getMass() > playerBiggest.getMass() * 1.2) {

                return StrategyType.HUNTING;
            }

            if (mineSmallest.getMass() * 1.2 < playerBiggest.getMass()) {

                return StrategyType.EVADING;

            }
        }

        Mine biggestMine = MineHelper.getBiggest(mineList);
        FoodHelper.cornerFoodFilter(foodList, biggestMine);

        if (foodList.size() > 0) {
            return StrategyType.FEEDING;
        } else {
            return StrategyType.SEEKING;
        }

    }


    public static JSONObject doDied(TickState tickState, JSONObject command) {
        command.put("X", 0);
        command.put("Y", 0);
        command.put("Debug", "Died");
        return command;

    }

    public static JSONObject doSeeking(TickState tickState, JSONObject command) {
        command.put("Debug", "SEEKING");
        return MoveEngine.toRandomPoint(tickState.getMineList(), command);
    }

    public static JSONObject doFeeding(TickState tickState, JSONObject command) {
        command.put("Debug", "FEEDING");
        return MoveEngine.toNearestFood(tickState.getFoodList(), tickState.getMineList(), command);
    }

    public static JSONObject doEvading(TickState tickState, JSONObject command) {
        command.put("Debug", "EVADING");

        Mine mineSmallest = MineHelper.getSmallest(tickState.getMineList());

        Player dangerousPlayer = PlayerHelper.dangerousPlayer(mineSmallest, tickState.getPlayerList());

        Mine mineBiggest = MineHelper.getBiggest(tickState.getMineList());
        Point point = Geometry.getOppositePoint(mineBiggest, dangerousPlayer);
        command.put("X", point.getX());
        command.put("Y", point.getY());
        return command;


    }

    public static JSONObject doHunting(TickState tickState, JSONObject command) {
        command.put("Debug", "HUNTING");

        Player playerBiggest = PlayerHelper.getBiggest(tickState.getPlayerList());
        Mine mineSmallest = MineHelper.getSmallest(tickState.getMineList());

        HashMap<String, GameObject> closestMineAndEnemyShards =
                Geometry.closestMineAndEnemyShards(tickState.getMineList(), tickState.getPlayerList());


        Mine myShardClosestToEnemy = (Mine) closestMineAndEnemyShards.get("Mine");
        Player enemyShardClosestToMe = (Player) closestMineAndEnemyShards.get("Enemy");

        float distanceToEnemy = Geometry.distance(myShardClosestToEnemy, enemyShardClosestToMe);


        float splitFlightDistance = Physics.ejectFlightDistance();


        if (playerBiggest.getMass() * 2.5 < mineSmallest.getMass() && distanceToEnemy < splitFlightDistance) {

            //&& мое направление совпадает с ближайшим врагом
            long roundedSpeedTheta = Math.round(Math.atan2(myShardClosestToEnemy.getSx(), myShardClosestToEnemy.getSy()));

            long roundedToEnemyTheta = Math.round(Math.atan2(
                    (enemyShardClosestToMe.getX() - myShardClosestToEnemy.getX()),
                    (enemyShardClosestToMe.getY() - myShardClosestToEnemy.getY()))
            );
            if (roundedSpeedTheta == roundedToEnemyTheta){
                command.put("Split", true);

            }
        }
        command.put("X", playerBiggest.getX());
        command.put("Y", playerBiggest.getY());
        return command;
    }
}
