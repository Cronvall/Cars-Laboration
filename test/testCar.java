import org.junit.jupiter.api.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

public class testCar {

    @Test
    void testTurnLeft(){
        Volvo240 volvo = new Volvo240(2,420,Color.red);

        assertEquals(1, volvo.getDirection(), "Assert start direction is forward (1)");
        volvo.turnLeft();
        assertEquals(4,volvo.getDirection(), "Asserts that turn left on exception case");
        volvo.turnLeft();
        assertEquals(3,volvo.getDirection(), "Asserts that turn left on normal case");
    }

    @Test
    void testTurnRight(){
        Saab95 saab = new Saab95(2,16,Color.CYAN);
        assertEquals(1, saab.getDirection(), "Asserts start direction is forward (1)");
        saab.turnRight();
        assertEquals(2, saab.getDirection(), "Asserts that turn right turns right");
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        assertEquals(1,saab.getDirection(), "Asserts that all rotations went well");
    }

    @Test
    void testMovement(){
        Volvo240 volvo = new Volvo240(4,120,Color.red);
        volvo.startEngine();

        volvo.incrementSpeed(1);
        double desiredSpeed = 0.1 + (120 * 0.01 * 1.25);
        assertEquals(desiredSpeed,volvo.getCurrentSpeed(), "Asserts the correct speed is set.");

        assertEquals(0, volvo.getPosition().x,"Asserts starting x position");
        assertEquals(0, volvo.getPosition().y,"Asserts starting y position");

        //Drive forward
        volvo.move();
        System.out.println(volvo.getPosition());
        assertEquals(0,volvo.getPosition().x, "Assert car stayed put in x-axis");
        assertEquals(1,volvo.getPosition().y, "Asserts car moved forward");
        //Drive right
        volvo.turnRight();
        volvo.move();
        assertEquals(1,volvo.getPosition().y, "Asserts car stayed put in y-axis");
        assertEquals(1,volvo.getPosition().x, "Assert car moved right");
        //Drive reverse
        volvo.turnRight();
        volvo.move();
        assertEquals(1,volvo.getPosition().x, "Assert car stayed put in x-axis");
        assertEquals(0, volvo.getPosition().y, "Assert car reversed (y-axis)");
        //Drive left
        volvo.turnRight();
        volvo.move();
        assertEquals(0,volvo.getPosition().y, "Asserts car stayed put in y-axis");
        assertEquals(0,volvo.getPosition().x, "Asserts car moved left");
    }


    @Test
    void testAccelerationDeceleration(){
        Saab95 saab = new Saab95(2,120,Color.black);
        saab.startEngine();

        saab.incrementSpeed(1);
        double desiredSpeed = 0.1 + (120 * 0.01);
        assertEquals(desiredSpeed, saab.getCurrentSpeed(), "Asserts we have the wanted speed after acceleration");

        saab.incrementSpeed(0.5);
        desiredSpeed += (120 * 0.01 * 0.5);
        assertEquals(desiredSpeed, saab.getCurrentSpeed(), "Asserts we have the wanted speed after acceleration");

        saab.decrementSpeed(0.5);
        desiredSpeed -= (120 * 0.01 * 0.5);
        assertEquals(desiredSpeed, saab.getCurrentSpeed(), "Asserts we have the wanted speed after deceleration");

        saab.decrementSpeed(0.3);
        desiredSpeed -= (120 * 0.01 * 0.3);
        assertEquals(desiredSpeed, saab.getCurrentSpeed(), "Asserts we have the wanted speed after deceleration");

    }
}
