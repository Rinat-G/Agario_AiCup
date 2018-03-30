package dto;

public class GameObjectPlayer extends  GameObject{
    String id;
    float mass;
    float radius;

    public GameObjectPlayer(float x, float y, String  id, float mass, float radius) {
        super(x, y, Type.Player);
        this.id = id;
        this.mass = mass;
        this.radius = radius;
    }
}
