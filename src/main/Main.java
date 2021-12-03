import vehicle.*;
import vehicle.helperAttributes.Engine;
import vehicle.helperAttributes.Platform;
import vehicle.helperAttributes.TurboEngine;
import workshops.*;
import java.awt.*;
import java.awt.image.ConvolveOp;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        CarController controller = new CarController();
        controller.cars.add(new Volvo240(2,new Engine(420),Color.red));
        controller.cars.add(new Saab95(2,new TurboEngine(10000),Color.red)); //This car is indeed fast, as

        controller.frame = new CarView("Cars-laboration",controller);
        controller.getTimer().start();

    }



}
