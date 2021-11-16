import java.awt.*;
import java.lang.System.*;

public class Main {

    public static void main(String[] args){

        Saab95 Saab = new Saab95(2,125,Color.red);

        volvoForArun();

        Saab.startEngine();
        Saab.turnRight();
        Saab.incrementSpeed(1);
        Saab.move();
        Saab.turnRight();
        Saab.move();
        Saab.setTurboOn();
        Saab.turnLeft();
        Saab.move();
        System.out.println(Saab.getPosition());
    }

    public static void volvoForArun(){
        Volvo240 v1 = new Volvo240(2, 125, Color.green);


        System.out.println("Before running: " + v1.getCurrentSpeed()+ " and position: " + v1.getPosition());
        v1.startEngine();
        System.out.println("Engine started: " + v1.getCurrentSpeed() + "speed");
        v1.gas(0.69);
        v1.move();
        System.out.println("Gassing: " + v1.getCurrentSpeed() + " speed");
        v1.brake(0.5);
        v1.move();
        System.out.println("Braking: " + v1.getCurrentSpeed() + " speed");
        v1.stopEngine();
        v1.move();
        System.out.println("Standing still: " + v1.getCurrentSpeed() + " speed");
        System.out.println("Position: " + v1.getPosition());

    }

}
