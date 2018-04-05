package dto;


public abstract class GameObject {
    enum Type {Food, Ejection, Virus, Player, Mine, Point}

    private final float x;
    private final float y;
    private final Type type;

    GameObject(float x, float y, Type type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }



    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Type getType() {
        return type;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GameObject{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }


}
