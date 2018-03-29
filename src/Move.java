import org.json.JSONObject;

import java.util.Random;

public class Move {
    private JSONObject config;

    private int currentRandomX = 0;
    private int currentRandomY = 0;
    private Random rnd = new Random();


    public Move(JSONObject config) {
        this.config = config;
    }

    public int getCurrentX() {
        if (currentRandomX == 0) {
            currentRandomX = rnd.nextInt(660) + 1;
        }
        return currentRandomX;
    }


    public int getCurrentY() {
        if (currentRandomY == 0) {
            currentRandomY = rnd.nextInt(660) + 1;
        }

        return currentRandomY;
    }

}
