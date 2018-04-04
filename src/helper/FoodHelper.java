package helper;


import dto.GameObject;
import dto.GameObjectFood;
import dto.GameObjectMine;
import env.GlobalConfig;

import java.util.ArrayList;


public class FoodHelper {


//    public static boolean isRestrict(GameObjectFood food) {
//        GlobalConfig gc = GlobalConfig.getInstance();
//
//
//        if (Math.abs(food.getX() - gc.getGAME_HEIGHT()) > gc.getGAME_HEIGHT() - ) {
//
//        }
//
//        return
//    }
    public static void cornerFoodFilter(ArrayList<GameObjectFood> foodList, GameObjectMine biggestMine){
        float radius = biggestMine.getRadius();
        GlobalConfig gc = GlobalConfig.getInstance();
        foodList.removeIf(food -> (Math.abs(food.getX() - gc.getGAME_WIDTH()/2) > gc.getGAME_WIDTH()/2 - radius )
                && (Math.abs(food.getY() - gc.getGAME_HEIGHT()/2) > gc.getGAME_HEIGHT()/2 - radius));

    }


}
