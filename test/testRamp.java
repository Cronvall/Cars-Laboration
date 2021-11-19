import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class testRamp {

    @Test
    void testRampMovement(){
        Ramp ramp = new Ramp();

        ramp.raise(50);
        assertEquals(50, ramp.getAngle());

        ramp.lower(30);
        assertEquals(20, ramp.getAngle());

        //Since the input is invalid the angle shouldn't change
        ramp.lower(-100);
        assertEquals(20, ramp.getAngle());
        ramp.raise((-100));
        assertEquals(20, ramp.getAngle());

        //Since the new angle exceeds the desired interval [0,70] it should base to 70
        ramp.raise(70);
        assertEquals(70, ramp.getAngle());

        //Since the new angle exceeds the desired interval [0,70] it should base to 0
        ramp.lower(80);
        assertEquals(0, ramp.getAngle());
    }
}
