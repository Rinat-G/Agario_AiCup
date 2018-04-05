package helper;


import dto.Food;
import dto.Mine;
import env.GlobalConfig;

import java.util.ArrayList;


public class FoodHelper {


    public static void cornerFoodFilter(ArrayList<Food> foodList, Mine biggestMine){
        float radius = biggestMine.getRadius();
        GlobalConfig gc = GlobalConfig.getInstance();
        foodList.removeIf(food -> (Math.abs(food.getX() - gc.getGAME_WIDTH()/2) > gc.getGAME_WIDTH()/2 - radius )
                && (Math.abs(food.getY() - gc.getGAME_HEIGHT()/2) > gc.getGAME_HEIGHT()/2 - radius));

    }


}
