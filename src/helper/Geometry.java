package helper;


import dto.GameObject;

import java.util.ArrayList;

public class Geometry {


    public static GameObject nearestTo(ArrayList<? extends  GameObject> gameObjectArrayList, GameObject target) {

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


}
