package dto;

public class Mine extends GameObject {

    private String id;
    private float radius;
    private float mass;
    private float sx;
    private float sy;
    //добавить TTF;


    public Mine(String id, float x, float y, float radius, float mass, float sx, float sy) {
        super(x,y,Type.Mine);
        this.id = id;
        this.radius = radius;
        this.mass = mass;
        this.sx = sx;
        this.sy = sy;
    }

    public String getId() {
        return id;
    }


    public float getRadius() {
        return radius;
    }

    public float getMass() {
        return mass;
    }

    public float getSx() {
        return sx;
    }

    public float getSy() {
        return sy;
    }
}
