package dto;

public class GameObjectVirus extends GameObject {


    private String  id;
    private float mass;

    public GameObjectVirus(float x, float y, String  id, float mass) {
        super(x, y, Type.Virus);
        this.id = id;
        this.mass = mass;
    }

    public String getId() {
        return id;
    }

    public float getMass() {
        return mass;
    }
}
