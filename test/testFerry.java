import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import vehicle.*;
import vehicle.helperAttributes.Engine;
import vehicle.helperAttributes.TurboEngine;

import java.awt.*;
import java.util.Arrays;

public class testFerry {


    @Test
    void test_Ferry(){
        Ferry f = new Ferry(20);

        double desiredSpeedFactor = 200 * (0.1 / 500);
        assertEquals(desiredSpeedFactor,f.speedFactor(), "Test of the speedfactor");

        f.getPlatform().lower(70);
        f.loadCar(new Saab95(2,200, Color.red));
        f.loadCar(new Volvo240(4,200, Color.red));
        f.getPlatform().raise(70);
        f.move();
        assertEquals(f.getPosition(), f.getLoad()[0].getPosition(), "Asserts that the load move with the ferry");

        assertNotNull(f.getLoad()[0], "Should be a SAAB here");
        assertNotNull(f.getLoad()[1], "Should be a volvo here");
        assertNull(f.getLoad()[2], "This slot should be empty");

        f.getPlatform().lower(70);
        f.loadOffCar();
        f.getPlatform().lower(70);
        assertNull(f.getLoad()[0], "This should now be empty (null)");
        assertNotNull(f.getLoad()[1], "The volvo should still be here");
    }
}
