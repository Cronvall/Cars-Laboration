import org.junit.jupiter.api.*;
import vehicle.Saab95;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

public class testSaab95 {

    @Test
    void testSpeedFactorWithTurboOff(){
        Saab95 saab = new Saab95(4,150, Color.black);
        saab.setTurboOff();
        double desiredVal = 150 * 0.01;
        assertEquals(desiredVal,saab.speedFactor(), "Test without turbo");
    }

    @Test
    void testSpeedFactorWithTurboOn(){
        Saab95 saab = new Saab95(4,150, Color.black);
        saab.setTurboOn();
        double desiredVal = 150 * 0.01 * 1.3;
        assertEquals(desiredVal,saab.speedFactor(), "Test with turbo.");

    }

    @Test
    void turboOff(){
        Saab95 saab = new Saab95(4, 150, Color.red);
        saab.setTurboOff();
        assertFalse(saab.getTurbo());
    }

    @Test
    void turboOn(){
        Saab95 saab = new Saab95(4, 150, Color.red);
        saab.setTurboOn();
        assertTrue(saab.getTurbo());
    }
}
