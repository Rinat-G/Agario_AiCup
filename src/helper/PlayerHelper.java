package helper;

import dto.GameObjectPlayer;

import java.util.ArrayList;


public class PlayerHelper {


    public static GameObjectPlayer getBiggest(ArrayList<GameObjectPlayer> playerArrayList){
        GameObjectPlayer tmpBiggestPlayer = playerArrayList.get(0);

        for (GameObjectPlayer player :
                playerArrayList) {

            if(player.getMass() > tmpBiggestPlayer.getMass()){
                tmpBiggestPlayer = player;
            }
        }

        return  tmpBiggestPlayer;

    }
}
