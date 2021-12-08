package vehicle.Factory;

import vehicle.*;
import vehicle.helperAttributes.Engine;
import vehicle.helperAttributes.Platform;
import vehicle.helperAttributes.TurboEngine;

import java.awt.*;

public final class MotorVehicleFactory {

    public static Volvo240 buildVolvo240(int nrDoors, Engine engine, Color color){
        Volvo240 volvo240 = new Volvo240(nrDoors, engine, color);
        return volvo240;
    }

    public static Saab95 buildSaab95(int nrDoors, TurboEngine engine, Color color){
        Saab95 saab95 = new Saab95(nrDoors, engine, color);
        return saab95;
    }

    public static Scania buildScania(Engine engine, Color color, double grossWeight){
        Scania scania = new Scania(engine, color, grossWeight, new Platform());
        return scania;
    }

    public static Ferry buildFerry(int capacity){
        Ferry ferry = new Ferry(capacity);
        return ferry;
    }

    public static CarTransporter buildCarTransporter(int capacity){
        CarTransporter carTransporter = new CarTransporter(capacity);
        return carTransporter;
    }





}
