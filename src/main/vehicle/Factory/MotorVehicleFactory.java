package vehicle.Factory;
import vehicle.*;
import vehicle.helperAttributes.Platform;

import java.awt.*;

public final class MotorVehicleFactory {

    public static Volvo240 buildVolvo240(int nrDoors, int enginePower , Color color, double trimFactor){
        Volvo240 volvo240 = new Volvo240(nrDoors, enginePower, color, trimFactor);
        return volvo240;
    }

    public static Saab95 buildSaab95(int nrDoors, int enginePower, Color color){
        Saab95 saab95 = new Saab95(nrDoors, enginePower, color);
        return saab95;
    }

    public static Scania buildScania(int enginePower, Color color, double grossWeight){
        Scania scania = new Scania(100, color, grossWeight, new Platform());
        return scania;
    }


}
