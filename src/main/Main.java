import vehicle.*;
import vehicle.helperAttributes.Platform;
import workshops.*;

import java.awt.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        carTransportRun();
    }

    private static void scaniaRun(){
        Platform rampForScania = new Platform();
        Scania firstScania = new Scania(420, Color.RED, 6.0, rampForScania, 2);
        firstScania.getRamp().raise(90);
    }

    private static void workshop(){
        VolvoExclusiveWorkShop volvo = new VolvoExclusiveWorkShop(new Point(10, 20), 8);
        Volvo240 vol = new Volvo240(2, 300, Color.red);
        Saab95 saab = new Saab95(2, 300, Color.green);

        WorkShop w1 = new WorkShop(new Point(2, 3), 4);
        Ferry f1 = new Ferry(100, 10);
        //w1.addVehicle(f1);

        volvo.addVehicle(vol);
        volvo.addVehicle(vol);

        WorkShop work = new WorkShop(new Point(2, 3), 2);
        Scania scan = new Scania(320, Color.RED, 4,new Platform(), 2);

        //volvo.removeVehicle(saab);
        volvo.changeOilFilter(vol);
    }

    private static void volvoRun(){
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

    private static void saabRun(){
        Saab95 saab = new Saab95(2, 100, Color.red);

        saab.startEngine();

        saab.move();
        saab.gas(0.9);
        saab.turnRight();
        saab.move();
        saab.stopEngine();
        System.out.println(saab.getPosition());
    }

    private static void ferryRun(){
        Ferry f1 = new Ferry(100, 20);
        Saab95 saab = new Saab95(2,100,Color.red);

        f1.getPlatform().lower(70);
        f1.loadCar(saab);
        f1.getPlatform().raise(70);
        System.out.println("-----------First-----------");
        System.out.println(Arrays.toString(f1.getLoad()));
        f1.startEngine();
        f1.move();
        f1.move();
        System.out.println(Arrays.toString(f1.getLoad()));

        System.out.println("-----------Second-----------");
        f1.loadOffCar();
        System.out.println(Arrays.toString(f1.getLoad()));
        System.out.println("ferry position: " + f1.getPosition());
        System.out.println("saab position: "+ saab.getPosition());
        System.out.println("saab pace: "+ saab.getCurrentSpeed());

        System.out.println("-----------Third-----------");
        f1.move();
        System.out.println("ferry position: " + f1.getPosition());
        System.out.println("saab position: "+ saab.getPosition());
    }

    private static void carTransportRun(){
        CarTransporter transporter = new CarTransporter(2);
        Volvo240 volvo240 = new Volvo240(2,100,Color.black);

        transporter.getRamp().lower();
        transporter.loadCar(volvo240);
        transporter.getRamp().raise();
        transporter.startEngine();
        transporter.move();
        System.out.println(transporter.getPosition());
        System.out.println(Arrays.toString(transporter.getLoad()));
        System.out.println(volvo240.getPosition());
    }

}
