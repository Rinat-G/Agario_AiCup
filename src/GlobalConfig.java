import org.json.JSONObject;

public final class GlobalConfig {
     static int GAME_WIDTH;
     static int GAME_HEIGHT;
     static int GAME_TICKS;
     static float FOOD_MASS;
     static int MAX_FRAGS_CNT;
     static int TICKS_TIL_FUSION;
     static float VIRUS_RADIUS;
     static float VIRUS_SPLIT_MASS;
     static float VISCOSITY;
     static float INERTION_FACTOR;
     static float SPEED_FACTOR;


    GlobalConfig(JSONObject config){
        this.GAME_WIDTH = config.getInt("GAME_WIDTH");
        this.GAME_HEIGHT = config.getInt("GAME_HEIGHT");
        this.GAME_TICKS = config.getInt("GAME_TICKS");
        this.FOOD_MASS = config.getFloat("FOOD_MASS");
        this.MAX_FRAGS_CNT = config.getInt("MAX_FRAGS_CNT");
        this.TICKS_TIL_FUSION = config.getInt("TICKS_TIL_FUSION");
        this.VIRUS_RADIUS = config.getFloat("VIRUS_RADIUS");
        this.VIRUS_SPLIT_MASS = config.getFloat("VIRUS_SPLIT_MASS");
        this.VISCOSITY = config.getFloat("VISCOSITY");
        this.INERTION_FACTOR = config.getFloat("INERTION_FACTOR");
        this.SPEED_FACTOR = config.getFloat("SPEED_FACTOR");
    }





}
