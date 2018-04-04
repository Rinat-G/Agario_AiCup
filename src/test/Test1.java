package test;

import dto.GameObject;
import dto.GameObjectPoint;
import helper.Geometry;

public class Test1 {

    public static void main(String[] args) {
        GameObjectPoint objectPoint1 = new GameObjectPoint(33, 33);
        GameObjectPoint objectPoint2 = new GameObjectPoint(90, 90);

        GameObjectPoint objectPoint3 = Geometry.getOppositPoint(objectPoint1, objectPoint2);

        System.out.println(objectPoint3.getX() + " " + objectPoint3.getY());


    }



}
