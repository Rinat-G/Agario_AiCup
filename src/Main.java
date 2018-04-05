import java.io.*;

import engine.MoveEngine;
import engine.StrategyEngine;
import engine.StrategyType;
import env.GlobalConfig;
import env.TickState;
import org.json.*;
import engine.ActionEngine;

class Main {


    private static MoveEngine moveEngine;
    private static ActionEngine actionEngine;

    public static void main(String[] args) {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            line = in.readLine();
            JSONObject config = new JSONObject(line);
//            log.warning(config.toString());
            GlobalConfig.init(config);


            moveEngine = new MoveEngine();
            actionEngine = new ActionEngine();

            int tick = 0;
            while ((line = in.readLine()) != null && line.length() != 0) {
                tick++;
                JSONObject tickStateJSON = new JSONObject(line);
                JSONObject command = onTick(tickStateJSON, tick);
                if (tick < 10) {
                    command.put("Debug", GlobalConfig.getInstance().toString());
                }
                System.out.println(command.toString());
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static JSONObject onTick(JSONObject tickStateJSON, int tickNumber) {

        StrategyEngine.splitBlockFactorDecrement();

        TickState tickState = new TickState(tickStateJSON, tickNumber);
        JSONObject command = new JSONObject();

        StrategyType strategyType = StrategyEngine.chooseStrategy(tickState);


        switch (strategyType) {
            case DIED:
                command = StrategyEngine.doDied(tickState, command);
                break;
            case SEEKING:
                command = StrategyEngine.doSeeking(tickState, command);
                break;
            case FEEDING:
                command = StrategyEngine.doFeeding(tickState, command);
                break;
            case EVADING:
                command = StrategyEngine.doEvading(tickState, command);
                break;
            case HUNTING:
                command = StrategyEngine.doHunting(tickState, command);
                break;
        }


        return command;
    }


}