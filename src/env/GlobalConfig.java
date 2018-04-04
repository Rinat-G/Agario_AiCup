package env;

import org.json.JSONObject;

public class GlobalConfig {
    //singleton
    private static GlobalConfig instance;
    private static JSONObject gameConfig;

    private int GAME_WIDTH;
    private int GAME_HEIGHT;
    private int GAME_TICKS;
    private float FOOD_MASS;
    private int MAX_FRAGS_CNT;
    private int TICKS_TIL_FUSION;
    private float VIRUS_RADIUS;
    private float VIRUS_SPLIT_MASS;
    private float VISCOSITY;
    private float INERTION_FACTOR;
    private float SPEED_FACTOR;


    private GlobalConfig(JSONObject config) {
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


    public static void init(JSONObject gameConfig) {
        GlobalConfig.gameConfig = gameConfig;

    }

    public static GlobalConfig getInstance() {
        if (instance == null) {
            instance = new GlobalConfig(gameConfig);
        }

        return instance;
    }

    public int getGAME_WIDTH() {
        return GAME_WIDTH;
    }

    public int getGAME_HEIGHT() {
        return GAME_HEIGHT;
    }

    public int getGAME_TICKS() {
        return GAME_TICKS;
    }

    public float getFOOD_MASS() {
        return FOOD_MASS;
    }

    public int getMAX_FRAGS_CNT() {
        return MAX_FRAGS_CNT;
    }

    public int getTICKS_TIL_FUSION() {
        return TICKS_TIL_FUSION;
    }

    public float getVIRUS_RADIUS() {
        return VIRUS_RADIUS;
    }

    public float getVIRUS_SPLIT_MASS() {
        return VIRUS_SPLIT_MASS;
    }

    public float getVISCOSITY() {
        return VISCOSITY;
    }

    public float getINERTION_FACTOR() {
        return INERTION_FACTOR;
    }

    public float getSPEED_FACTOR() {
        return SPEED_FACTOR;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GlobalConfig{");
        sb.append("GAME_WIDTH=").append(GAME_WIDTH);
        sb.append(", GAME_HEIGHT=").append(GAME_HEIGHT);
        sb.append(", GAME_TICKS=").append(GAME_TICKS);
        sb.append(", FOOD_MASS=").append(FOOD_MASS);
        sb.append(", MAX_FRAGS_CNT=").append(MAX_FRAGS_CNT);
        sb.append(", TICKS_TIL_FUSION=").append(TICKS_TIL_FUSION);
        sb.append(", VIRUS_RADIUS=").append(VIRUS_RADIUS);
        sb.append(", VIRUS_SPLIT_MASS=").append(VIRUS_SPLIT_MASS);
        sb.append(", VISCOSITY=").append(VISCOSITY);
        sb.append(", INERTION_FACTOR=").append(INERTION_FACTOR);
        sb.append(", SPEED_FACTOR=").append(SPEED_FACTOR);
        sb.append('}');
        return sb.toString();
    }
}
