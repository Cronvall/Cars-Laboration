import java.awt.*;

public class Main {

    public static void main(String[] args){

        volvoRun();
        saabRun();
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

}
