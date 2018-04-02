import org.json.JSONObject;

public final class GlobalConfig {
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

    public String toString() {


        return String.format(
                "GAME_WIDTH %s %n" +
                        "GAME_HEIGHT %s %n" +
                        "GAME_TICKS %s %n" +
                        "FOOD_MASS %s %n" +
                        "MAX_FRAGS_CNT %s %n" +
                        "TICKS_TIL_FUSION %s %n" +
                        "VIRUS_RADIUS %s %n" +
                        "VIRUS_SPLIT_MASS %s %n" +
                        "VISCOSITY %s %n" +
                        "INERTION_FACTOR %s",
                this.GAME_WIDTH,
                this.GAME_HEIGHT,
                this.GAME_TICKS,
                this.FOOD_MASS,
                this.MAX_FRAGS_CNT,
                this.TICKS_TIL_FUSION,
                this.VIRUS_RADIUS,
                this.VIRUS_SPLIT_MASS,
                this.VISCOSITY,
                this.INERTION_FACTOR);
    }
}
