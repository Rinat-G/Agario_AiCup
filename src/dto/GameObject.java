package dto;

public abstract class GameObject {
    enum Type {Food, Ejection, Virus, Player}

    final float x;
    final float y;

    GameObject(float x, float y, Type type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    final Type type;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
