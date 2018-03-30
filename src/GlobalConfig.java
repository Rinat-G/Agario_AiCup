import org.json.JSONObject;

public final class GlobalConfig {
     private static int GAME_WIDTH;
     private static int GAME_HEIGHT;
     private static int GAME_TICKS;
     private static float FOOD_MASS;
     private static int MAX_FRAGS_CNT;
     private static int TICKS_TIL_FUSION;
     private static float VIRUS_RADIUS;
     private static float VIRUS_SPLIT_MASS;
     private static float VISCOSITY;
     private static float INERTION_FACTOR;
     private static float SPEED_FACTOR;


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


    public static int getGameWidth() {
        return GAME_WIDTH;
    }

    public static void setGameWidth(int gameWidth) {
        GAME_WIDTH = gameWidth;
    }

    public static int getGameHeight() {
        return GAME_HEIGHT;
    }

    public static void setGameHeight(int gameHeight) {
        GAME_HEIGHT = gameHeight;
    }

    public static int getGameTicks() {
        return GAME_TICKS;
    }

    public static void setGameTicks(int gameTicks) {
        GAME_TICKS = gameTicks;
    }

    public static float getFoodMass() {
        return FOOD_MASS;
    }

    public static void setFoodMass(float foodMass) {
        FOOD_MASS = foodMass;
    }

    public static int getMaxFragsCnt() {
        return MAX_FRAGS_CNT;
    }

    public static void setMaxFragsCnt(int maxFragsCnt) {
        MAX_FRAGS_CNT = maxFragsCnt;
    }

    public static int getTicksTilFusion() {
        return TICKS_TIL_FUSION;
    }

    public static void setTicksTilFusion(int ticksTilFusion) {
        TICKS_TIL_FUSION = ticksTilFusion;
    }

    public static float getVirusRadius() {
        return VIRUS_RADIUS;
    }

    public static void setVirusRadius(float virusRadius) {
        VIRUS_RADIUS = virusRadius;
    }

    public static float getVirusSplitMass() {
        return VIRUS_SPLIT_MASS;
    }

    public static void setVirusSplitMass(float virusSplitMass) {
        VIRUS_SPLIT_MASS = virusSplitMass;
    }

    public static float getVISCOSITY() {
        return VISCOSITY;
    }

    public static void setVISCOSITY(float VISCOSITY) {
        GlobalConfig.VISCOSITY = VISCOSITY;
    }

    public static float getInertionFactor() {
        return INERTION_FACTOR;
    }

    public static void setInertionFactor(float inertionFactor) {
        INERTION_FACTOR = inertionFactor;
    }

    public static float getSpeedFactor() {
        return SPEED_FACTOR;
    }

    public static void setSpeedFactor(float speedFactor) {
        SPEED_FACTOR = speedFactor;
    }
}
