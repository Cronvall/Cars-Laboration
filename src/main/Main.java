import attributes.*;
import vehicle.*;
import workshops.*;

import java.awt.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        workshop();
        scaniaRun();
        volvoRun();
    }

    public static void scaniaRun(){
        Ramp rampForScania = new Ramp();
        Scania firstScania = new Scania(420, Color.RED, 6.0, rampForScania);
        firstScania.getRamp().raise(90);
    }

    public static void workshop(){
        VolvoExclusiveWorkShop volvo = new VolvoExclusiveWorkShop(new Point(10, 20), 8);
        Volvo240 vol = new Volvo240(2, 300, Color.red);
        Saab95 saab = new Saab95(2, 300, Color.green);

        volvo.addVehicle(vol);
        volvo.addVehicle(vol);

        //volvo.removeVehicle(saab);
        volvo.changeOilFilter(vol);
    }

    public static void volvoRun(){
        Volvo240 v1 = new Volvo240(2, 125, Color.green);

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

    public static void saabRun(){
        Saab95 saab = new Saab95(2, 100, Color.red);

        saab.startEngine();

        saab.move();
        saab.gas(0.9);
        saab.turnRight();
        saab.move();
        saab.stopEngine();
        System.out.println(saab.getPosition());
    }

    public static void ferryRun(){
        Ferry f1 = new Ferry(100);
        System.out.println(Arrays.toString(f1.getLoad()));
        f1.loadCar(new Saab95(2,100,Color.red));
        System.out.println(Arrays.toString(f1.getLoad()));
        f1.startEngine();
        System.out.println(f1.getPosition());
        f1.move();
        System.out.println(f1.getPosition());
        f1.loadOffCar();
        System.out.println(Arrays.toString(f1.getLoad()));
    }

}
