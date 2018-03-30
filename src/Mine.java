
public class Mine {

    private String id;
    private float x;
    private float y;
    private float radius;
    private float mass;
    private float sx;
    private float sy;
    //добавить TTF;


    public Mine(String id, float x, float y, float radius, float mass, float sx, float sy) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.mass = mass;
        this.sx = sx;
        this.sy = sy;
    }

    public String getId() {
        return id;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
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
