import org.junit.jupiter.api.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

public class testCar {


    @Test
    void test_getters(){
        int saab_horse_p = 100;
        int saab_doors = 2;
        Color saab_color = Color.green;

        Saab95 saab = new Saab95(saab_doors, saab_horse_p, saab_color);

        Point initial_position = new Point(0, 0);

        should_return_direction(saab);
        should_return_current_speed(saab);
        should_return_engine_pow(saab_horse_p,saab);
        should_return_start_position(saab, initial_position);
    }

    @Test
    static void should_return_engine_pow(int engine_pow, Saab95 saab){
        assertEquals(engine_pow, saab.getEnginePower(), "Saab engine power incorrect!");
    }
    @Test
    static void should_return_current_speed(Saab95 saab){
        assertEquals(saab.getCurrentSpeed(), 0, "Saab speed not zero!");
    }
    @Test
    static void should_return_direction(Saab95 saab){
        assertEquals(saab.getDirection(), 1, "Saab starts in wrong direction!");
    }
    @Test
    static void should_return_start_position(Saab95 saab, Point position){
        assertEquals(position, saab.getPosition(), "Saab starts at wrong position!");
    }

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

        assertEquals(0, volvo.getPosition().getX(),"Asserts starting x position");
        assertEquals(0, volvo.getPosition().getY(),"Asserts starting y position");

        //Drive forward
        volvo.move();
        System.out.println(volvo.getPosition());
        assertEquals(0,volvo.getPosition().getX(), "Assert car stayed put in x-axis");
        assertEquals(1,volvo.getPosition().getY(), "Asserts car moved forward");
        //Drive right
        volvo.turnRight();
        volvo.move();
        assertEquals(1,volvo.getPosition().getY(), "Asserts car stayed put in y-axis");
        assertEquals(1,volvo.getPosition().getX(), "Assert car moved right");
        //Drive reverse
        volvo.turnRight();
        volvo.move();
        assertEquals(1,volvo.getPosition().getX(), "Assert car stayed put in x-axis");
        assertEquals(0, volvo.getPosition().getY(), "Assert car reversed (y-axis)");
        //Drive left
        volvo.turnRight();
        volvo.move();
        assertEquals(0,volvo.getPosition().getY(), "Asserts car stayed put in y-axis");
        assertEquals(0,volvo.getPosition().getX(), "Asserts car moved left");
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

    @Test
    void testSetCurrentSpeed(){
        Volvo240 volvo = new Volvo240(2,100,Color.blue);
        volvo.startEngine();
        //Speed is only allowed to be in the range of (0, 100) this since 100 equals the engine power for this sample.

        for(int speed = -50; speed < 150; speed++){
            volvo.setCurrentSpeed(speed);
            if(speed <= 0)
                assertEquals(0,volvo.getCurrentSpeed(), "Asserts speed defaults to 0 if it is set lower or equal to zero.");

            else if(speed > 100)
                assertEquals(100, volvo.getCurrentSpeed(), "Asserts speed defaults to enginePower if it is set higher then the engine power.");

            else{
                assertEquals(speed, volvo.getCurrentSpeed(), "Since the the new speed was in the defined range it should now be the current speed.");
            }
        }
    }

    @Test
    void testGas(){
        Saab95 saab = new Saab95(2,100,Color.blue);

        for(int i = -50; i < 150; i++){
            double factor = i * 0.01;
            double oldSpeed = saab.getCurrentSpeed();
            saab.gas(factor);

            //If outside of range or equal to zero the speed should not change. It should therefore equal it's last recorded speed.
            if(factor <= 0 || factor > 1)
                assertEquals(oldSpeed, saab.getCurrentSpeed());

            else{
                //If within the desired input range there should now be a difference between the old speed and the new one.
                if (oldSpeed < 100) {
                    boolean newSpeedGreater = saab.getCurrentSpeed() > oldSpeed;
                    assertTrue(newSpeedGreater);
                }
                //If the oldSpeed is the max speed the new one should also be the max speed.
                else
                    assertEquals(oldSpeed, saab.getCurrentSpeed());
            }
        }
    }

    @Test
    void testBreak(){
        Saab95 saab = new Saab95(2,100,Color.blue);

        for(int i = -50; i < 150; i++){
            double factor = i * 0.01;
            double oldSpeed = saab.getCurrentSpeed();
            saab.brake(factor);

            //If outside of range or equal to zero the speed should not change. It should therefore equal it's last recorded speed.
            if(factor <= 0 || factor > 1)
                assertEquals(oldSpeed, saab.getCurrentSpeed());

            else{
                //If within the desired input range there should now be a difference between the old speed and the new one.
                if (oldSpeed > 0) {
                    boolean newSpeedGreater = saab.getCurrentSpeed() < oldSpeed;
                    assertTrue(newSpeedGreater);
                }
                //If the oldSpeed is 0 then the new one should also be 0 since be aren't considering negative values.
                else
                    assertEquals(oldSpeed, saab.getCurrentSpeed());
            }
        }

    }
}
