package helper;

import dto.GameObject;
import dto.GameObjectMine;

import java.util.ArrayList;

public class MineHelper {
    
    public static GameObjectMine getBiggest(ArrayList<GameObjectMine> mineArrayList){
        GameObjectMine tmpBiggestMine = mineArrayList.get(0);

        for (GameObjectMine mine :
                mineArrayList) {

            if(mine.getMass() > tmpBiggestMine.getMass()){
                tmpBiggestMine = mine;
            }
        }

        return  tmpBiggestMine;
        
    }
    public static boolean isInRadius(GameObjectMine mine, float x, float y){
        return mine.getRadius() > Geometry.distance(mine, x, y);

    }

    public static boolean isInOneTickRange(GameObjectMine mine, float x, float y){



        return false;


    }
}
