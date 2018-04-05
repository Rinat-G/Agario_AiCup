package engine;

import dto.*;
import env.GlobalConfig;
import env.TickState;
import helper.*;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class StrategyEngine {

    private static int splitBlockFactor = 0;


    public static StrategyType chooseStrategy(TickState tickState) {


        if (tickState.getMineList().size() == 0) {
            return StrategyType.DIED;
        }


        ArrayList<Mine> mineList = tickState.getMineList();
        ArrayList<Food> foodList = tickState.getFoodList();
        ArrayList<Player> playerList = tickState.getPlayerList();

        if (playerList.size() > 0) {

            splitBlock(200);

            double mineAverageMass = MineHelper.mineAverageMass(mineList);
            double enemyAverageMass = PlayerHelper.playerAverageMass(playerList);
            double mineSummaryMass = MineHelper.mineSummaryMass(mineList);
            double playerSummaryMass = PlayerHelper.playerSummaryMass(playerList);

            //если моя средняя масса больше чем средняя масса врага *1.2 (и общая масса больше) - нападение
            if (mineAverageMass > (enemyAverageMass * 1.2) && mineSummaryMass > playerSummaryMass) {
                return StrategyType.HUNTING;
            }

            //если моя средняя масса *1.1 меньше чем средняя масса врага - побег
            if (mineAverageMass * 1.1 < enemyAverageMass) {
                return StrategyType.EVADING;
            }


//             НЕ УДАЛЯТЬ! БЕКАП РАБОЧЕЙ СХЕМЫ !!!
//            Mine mineSmallest = MineHelper.getSmallest(mineList);
//            Player playerBiggest = PlayerHelper.getBiggest(playerList);
//
//            if (mineSmallest.getMass() > playerBiggest.getMass() * 1.2) {
//
//                return StrategyType.HUNTING;
//            }
//
//            if (mineSmallest.getMass() * 1.1 < playerBiggest.getMass()) {
//
//                return StrategyType.EVADING;
//
//            }
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
        if (MineHelper.getBiggest(tickState.getMineList()).getMass() > 120 && !isSplitBlocked()) {
            command.put("Split", true);
            command.put("Debug", command.getString("Debug") + " Safe split!");
        }
        return MoveEngine.toRandomPoint(tickState.getMineList(), command);
    }

    public static JSONObject doFeeding(TickState tickState, JSONObject command) {
        command.put("Debug", "FEEDING");
        if (MineHelper.getBiggest(tickState.getMineList()).getMass() > 120 && !isSplitBlocked()) {
            command.put("Split", true);
            command.put("Debug", command.getString("Debug") + " Safe split!");
        }

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

            Vector mySpeedVector = new Vector(myShardClosestToEnemy.getSx(), myShardClosestToEnemy.getSy());

            Vector toClosestEnemyVector = new Vector(
                    enemyShardClosestToMe.getX() - myShardClosestToEnemy.getX(),
                    enemyShardClosestToMe.getY() - myShardClosestToEnemy.getY()
            );

            //косинус угла между вектором моей скорости и вектором к ближайшему противнику >0.98
            if (Geometry.cosVectors(mySpeedVector, toClosestEnemyVector) > 0.98d) {
                command.put("Split", true);
                command.put("Debug", command.getString("Debug") + " Attack split!");
            }


        }
        command.put("X", playerBiggest.getX());
        command.put("Y", playerBiggest.getY());
        return command;
    }


    public static void splitBlock(int ticks) {
        splitBlockFactor = ticks;
    }

    public static boolean isSplitBlocked() {
        return splitBlockFactor != 0;
    }

    public static void splitBlockFactorDecrement() {
        if (splitBlockFactor > 0) {
            splitBlockFactor--;
        }
    }
}
