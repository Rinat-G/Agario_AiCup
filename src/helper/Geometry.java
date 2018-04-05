package helper;


import dto.*;
import env.GlobalConfig;

import java.util.ArrayList;
import java.util.HashMap;

public class Geometry {


    public static GameObject nearestTo(ArrayList<? extends GameObject> gameObjectArrayList, GameObject target) {

        GameObject nearest = gameObjectArrayList.get(0);
        float nearestDist = distance(nearest, target);

        for (GameObject gameObject :
                gameObjectArrayList) {

            float currObjDist = distance(gameObject, target);

            if (currObjDist < nearestDist) {
                nearest = gameObject;
                nearestDist = currObjDist;
            }


        }


        return nearest;
    }

    public static float distance(GameObject object1, GameObject object2) {

        double dist = Math.sqrt(Math.pow(object1.getX() - object2.getX(), 2) + Math.pow(object1.getY() - object2.getY(), 2));

        return (float) dist;

    }

    public static float distance(GameObject object1, float x, float y) {

        double dist = Math.sqrt(Math.pow(object1.getX() - x, 2) + Math.pow(object1.getY() - y, 2));

        return (float) dist;

    }

    public static double squareDistance(GameObject object1, GameObject object2) {

        return Math.pow(object1.getX() - object2.getX(), 2) + Math.pow(object1.getY() - object2.getY(), 2);
    }


    public static Point getOppositePoint(GameObject source, GameObject target) {
        float x = source.getX() * 2 - target.getX();
        float y = source.getY() * 2 - target.getY();
        return new Point(x, y);
    }

    /**
     * Returns two closest shards from Mine and other Player.
     *
     * @param mineList
     * @param enemyList
     * @return HashMap<String, GameObject> with 2 entry  where String  key is "Mine" or "Enemy".
     */


    public static HashMap<String, GameObject> closestMineAndEnemyShards(ArrayList<Mine> mineList,
                                                                        ArrayList<Player> enemyList) {
        Mine closestMine = mineList.get(0);
        Player closestEnemy = enemyList.get(0);
        double squareDistanceMin = Math.pow(GlobalConfig.getInstance().getGAME_HEIGHT(), 2);

        for (Mine aMine : mineList) {
            for (Player anEnemy : enemyList) {
                double squareDistance = squareDistance(aMine, anEnemy);
                if (squareDistance < squareDistanceMin) {
                    squareDistanceMin = squareDistance;
                    closestMine = aMine;
                    closestEnemy = anEnemy;

                }

            }


        }
        HashMap<String, GameObject> closestMineAndEnemyShards = new HashMap<>();
        closestMineAndEnemyShards.put("Mine", closestMine);
        closestMineAndEnemyShards.put("Enemy", closestEnemy);
        return closestMineAndEnemyShards;


    }

    public static boolean isCodirected(Vector vector1, Vector vector2) {
        return isCollinear(vector1, vector2) && scalarMultiplication(vector1, vector2) > 0;
    }

    public static boolean isCollinear(Vector vector1, Vector vector2) {
        return vector1.getX() / vector2.getX() == vector1.getY() / vector2.getY();
    }

    public static double scalarMultiplication(Vector vector1, Vector vector2) {
        return (vector1.getX() * vector2.getX()) + (vector1.getY() * vector2.getY());

    }

    public static double cosVectors(Vector vector1, Vector vector2){

        return scalarMultiplication(vector1, vector2) / (vectorModule(vector1) * vectorModule(vector2));
    }

    public  static  double vectorModule(Vector vector){
        return  Math.sqrt((Math.pow(vector.getX(), 2) + Math.pow(vector.getY(), 2)));
    }



}
