package helper;

import dto.HasMass;
import dto.Mine;
import dto.Player;
import env.GlobalConfig;

public class Physics {

    public static float linearSpeed(Mine mine) {

        return (float) Math.sqrt(Math.pow(mine.getSx(), 2) + Math.pow(mine.getSy(), 2));

    }

    /**
     * Formula S = (a*(t^2))/2 + vt
     * a - viscosity
     * v - ejectSpeed
     * t (flightTime) = a/v
     *
     * @return ejectFlightDistance
     */

    public static float ejectFlightDistance() {
        float ejectSpeed = 8.0f;
        float viscosity = GlobalConfig.getInstance().getVISCOSITY();
        float flightTime = ejectSpeed / viscosity;

        return (float) ((viscosity * Math.pow(flightTime, 2)) / 2) + (ejectSpeed * flightTime);

    }
    public static double maxSpeed(HasMass object){
        return GlobalConfig.getInstance().getSPEED_FACTOR()/ Math.sqrt(object.getMass());
    }




}
