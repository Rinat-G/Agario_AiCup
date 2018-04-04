package helper;

import dto.GameObject;
import dto.GameObjectMine;

public class Physics {

    public static float linearSpeed(GameObjectMine mine){

        return  (float) Math.sqrt(Math.pow(mine.getSx(), 2) + Math.pow(mine.getSy(), 2));

    }


}
