package test;

import dto.GameObject;
import dto.GameObjectFood;
import helper.Geometry;

public class TestGeometry {


    public static void main(String[] args) {
        GameObject object1 = new GameObjectFood(400, 400);
        GameObject object2 = new GameObjectFood(500, 700);


        System.out.println(Geometry.distance(object1,object2));


    }
}
