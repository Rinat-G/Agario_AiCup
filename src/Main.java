import java.io.*;

import org.json.*;

class Main {


    private static DebugLogger log = DebugLogger.getInstance();
    private static MoveEngine moveEngine;

    public static void main(String[] args) {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            line = in.readLine();
            JSONObject config = new JSONObject(line);
            log.warning(config.toString());
            GlobalConfig.init(config);


            moveEngine = new MoveEngine();

            int tick = 0;
            while ((line = in.readLine()) != null && line.length() != 0) {
                log.info("TICK = " + ++tick);
                JSONObject tickStateJSON = new JSONObject(line);
                JSONObject command = onTick(tickStateJSON);
                System.out.println(command.toString());
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static JSONObject onTick(JSONObject tickStateJSON) {
        TickState tickState = new TickState(tickStateJSON);
        JSONObject command = new JSONObject();

        if (tickState.getMineList().size() > 0) {

            command = moveEngine.doMove(tickState, command);


        } else {
            command.put("X", 0);
            command.put("Y", 0);
            command.put("Debug", "Died");
            log.warning("getMineList().size() <= 0. DIED.");
        }
        log.info(command.toString());
        return command;
    }


}