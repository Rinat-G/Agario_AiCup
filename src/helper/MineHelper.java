package helper;

import dto.Mine;

import java.util.ArrayList;

public class MineHelper {

    public static Mine getBiggest(ArrayList<Mine> mineArrayList) {
        Mine tmpBiggestMine = mineArrayList.get(0);

        for (Mine mine :
                mineArrayList) {

            if (mine.getMass() > tmpBiggestMine.getMass()) {
                tmpBiggestMine = mine;
            }
        }

        return tmpBiggestMine;

    }

    public static Mine getSmallest(ArrayList<Mine> mineArrayList) {
        Mine tmpSmallestMine = mineArrayList.get(0);

        for (Mine mine :
                mineArrayList) {

            if (mine.getMass() < tmpSmallestMine.getMass()) {
                tmpSmallestMine = mine;
            }
        }

        return tmpSmallestMine;

    }


    public static boolean isInRadius(Mine mine, float x, float y) {
        return mine.getRadius() + 10 > Geometry.distance(mine, x, y);

    }

    public static boolean isInOneTickRange(Mine mine, float x, float y) {


        return false;


    }

    public static double mineSummaryMass(ArrayList<Mine> mineList){
        return mineList.stream().mapToDouble(Mine::getMass).sum();
    }

    public static double mineAverageMass(ArrayList<Mine> mineList){

        double mass = mineSummaryMass(mineList);
        return mass / mineList.size();
    }
}
