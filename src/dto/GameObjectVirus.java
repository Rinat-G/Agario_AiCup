package dto;

public class GameObjectVirus extends GameObject {


    String  id;
    float mass;

    public GameObjectVirus(float x, float y, String  id, float mass) {
        super(x, y, Type.Virus);
        this.id = id;
        this.mass = mass;
    }

    
}
