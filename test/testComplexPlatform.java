import vehicle.helperAttributes.ComplexPlatform;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class testComplexPlatform {

    @Test
    void testRampMovement(){
        ComplexPlatform complexPlatform = new ComplexPlatform();

        complexPlatform.raise(50);
        assertEquals(50, complexPlatform.getAngle());

        complexPlatform.lower(30);
        assertEquals(20, complexPlatform.getAngle());

        //Since the input is invalid the angle shouldn't change
        complexPlatform.lower(-100);
        assertEquals(20, complexPlatform.getAngle());
        complexPlatform.raise((-100));
        assertEquals(20, complexPlatform.getAngle());

        //Since the new angle exceeds the desired interval [0,70] it should base to 70
        complexPlatform.raise(70);
        assertEquals(70, complexPlatform.getAngle());

        //Since the new angle exceeds the desired interval [0,70] it should base to 0
        complexPlatform.lower(80);
        assertEquals(0, complexPlatform.getAngle());
    }
}
