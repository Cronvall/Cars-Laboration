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
        controller.cars.add(new Volvo240(2, new Engine(100, 1.5),Color.red));
        controller.cars.add(new Saab95(2,new TurboEngine(250),Color.red));
        controller.cars.add(new Scania(new Engine(500),Color.red,4,new Platform()));

        controller.frame = new CarView("Cars-laboration",controller);
        controller.getTimer().start();
    }

    private static void scaniaRun(){
        Platform rampForScania = new Platform();
        Scania firstScania = new Scania(new Engine(420), Color.RED, 6.0, rampForScania);
        firstScania.getRamp().raise(90);
    }

    private static void volvoRun(){
        Volvo240 v1 = new Volvo240(2, new Engine(125), Color.green);

        System.out.println("Before running speed: " + v1.getCurrentSpeed()+ " and position: " + v1.getPosition());

        v1.startEngine();
        System.out.println("Engine started: " + v1.getCurrentSpeed() + " speed");
        v1.gas(0.69);
        v1.move();
        System.out.println("Gassing: " + v1.getCurrentSpeed() + " speed");
        System.out.println("new pos: " + v1.getPosition());

        v1.brake(0.5);
        v1.move();
        System.out.println("Braking: " + v1.getCurrentSpeed() + " speed");
        System.out.println("New pos: " + v1.getPosition());

        v1.stopEngine();
        v1.move();
        System.out.println("Standing still: " + v1.getCurrentSpeed() + " speed");
        System.out.println("Position: " + v1.getPosition());

    }

    private static void saabRun(){
        Saab95 saab = new Saab95(2, new TurboEngine(125), Color.red);

        saab.startEngine();

    }



}
