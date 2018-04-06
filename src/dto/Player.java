package dto;

public class Player extends  GameObject implements HasMass {
    private String id;
    private float mass;
    private float radius;

    public Player(float x, float y, String  id, float mass, float radius) {
        super(x, y, Type.Player);
        this.id = id;
        this.mass = mass;
        this.radius = radius;
    }

    public String getId() {
        return id;
    }

    public float getMass() {
        return mass;
    }

    public float getRadius() {
        return radius;
    }
}
