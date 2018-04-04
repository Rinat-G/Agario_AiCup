package dto;

import java.lang.reflect.Field;

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

//    public String toString() {
//
//        StringBuilder sb = new StringBuilder();
//
//        Class<? extends GameObject> clazz = this.getClass();
//
//        Field[] fields = clazz.getDeclaredFields();
//        try {
//
//
//            for (Field field :
//                    fields) {
//
//                sb.append(field.getName()).append(field.get(this)).append("\n");
//
//            }
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//
//        return sb.toString();
//    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GameObject{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }


//    @Override
//    public String toString() {
//        return "GameObject{" +
//                "x=" + x +
//                ", y=" + y +
//                ", type=" + type +
//                '}';
//    }
}
