package dto;

import java.lang.reflect.Field;

public abstract class GameObject {
    enum Type {Food, Ejection, Virus, Player}

    final float x;
    final float y;

    GameObject(float x, float y, Type type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    private final Type type;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Type getType() {
        return type;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        Class<? extends GameObject> clazz = this.getClass();
        Class<?> clazzSuper = super.getClass();
        Field[] fieldsSuper = clazzSuper.getDeclaredFields();
        Field[] fields = clazz.getDeclaredFields();
        try {

            for (Field fieldSuper :
                    fieldsSuper) {

                sb.append(fieldSuper.getName()).append(fieldSuper.get(this)).append("\n");

            }



            for (Field field :
                    fields) {

                sb.append(field.getName()).append(field.get(this)).append("\n");

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


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
