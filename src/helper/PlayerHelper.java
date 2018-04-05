package helper;

import dto.Mine;
import dto.Player;

import java.util.ArrayList;


public class PlayerHelper {


    public static Player getBiggest(ArrayList<Player> playerArrayList) {
        Player tmpBiggestPlayer = playerArrayList.get(0);

        for (Player player :
                playerArrayList) {

            if (player.getMass() > tmpBiggestPlayer.getMass()) {
                tmpBiggestPlayer = player;
            }
        }

        return tmpBiggestPlayer;

    }

    /**
     * smallest enemy that can eat this my fragment
     */

    public static Player dangerousPlayer(Mine mine, ArrayList<Player> playerArrayList) {
        Player dangerousPlayer = PlayerHelper.getBiggest(playerArrayList);

        for (Player thisPlayer :
                playerArrayList) {

            if (thisPlayer.getMass() < dangerousPlayer.getMass() && thisPlayer.getMass() > (mine.getMass() * 1.2)) {
                dangerousPlayer = thisPlayer;
            }

        }

        return dangerousPlayer;

    }

    public static double playerSummaryMass(ArrayList<Player> playerList){
        return playerList.stream().mapToDouble(Player::getMass).sum();
    }

    public static double playerAverageMass(ArrayList<Player> playerList){

        double mass =  playerSummaryMass(playerList);
        return mass / playerList.size();
    }


}
