import java.awt.*;
import java.lang.System.*;

public class Main {

    public static void main(String[] args){
        
        Saab95 Saab = new Saab95(2,125,Color.red);

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
}
