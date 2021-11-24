import attributes.Ramp;
import org.junit.jupiter.api.*;
import vehicle.Scania;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

public class testScania {

    @Test
    void testGetRamp(){
        Ramp ramp = new Ramp();
        Scania scania = new Scania(300, Color.CYAN, 10, ramp);
        assertEquals(ramp, scania.getRamp());
    }
}
