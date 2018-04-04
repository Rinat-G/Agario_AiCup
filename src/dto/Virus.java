package dto;

public class Virus extends GameObject {


    private String  id;
    private float mass;

    public Virus(float x, float y, String  id, float mass) {
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
