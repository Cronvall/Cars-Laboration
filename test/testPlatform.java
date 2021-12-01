import vehicle.helperAttributes.Platform;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class testPlatform {

    @Test
    void testRampMovement(){
        Platform platform = new Platform();

        platform.lower(50);
        assertEquals(50, platform.getAngle());

        platform.raise(30);
        assertEquals(20, platform.getAngle());

        //Since the input is invalid the angle shouldn't change
        platform.lower(-100);
        assertEquals(20, platform.getAngle());
        platform.raise((-100));
        assertEquals(20, platform.getAngle());

        //Since the new angle exceeds the desired interval [0,70] it should base to 70
        platform.lower(70);
        assertEquals(70, platform.getAngle());

        //Since the new angle exceeds the desired interval [0,70] it should base to 0
        platform.raise(80);
        assertEquals(0, platform.getAngle());
    }
}
