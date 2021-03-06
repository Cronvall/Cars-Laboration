import org.junit.jupiter.api.*;
import vehicle.Saab95;
import vehicle.helperAttributes.TurboEngine;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

public class testSaab95 {

    @Test
    void testSpeedFactorWithTurboOff(){
        Saab95 saab = new Saab95(4,150, Color.black);
        saab.turboOff();
        double desiredVal = 150 * 0.01;
        assertEquals(desiredVal,saab.speedFactor(), "Test without turbo");
    }

    @Test
    void testSpeedFactorWithTurboOn(){
        Saab95 saab = new Saab95(4,150, Color.black);
        saab.turboOn();
        double desiredVal = 150 * 0.01 * 1.3;
        assertEquals(desiredVal,saab.speedFactor(), "Test with turbo.");

    }

    @Test
    void stopEngineSaab95(){
        Saab95 saab95 = new Saab95(2, 10, Color.green);
        saab95.startEngine();
        saab95.stopEngine();
        assertEquals(saab95.getCurrentSpeed(), 0);
        assertFalse(saab95.getTurbo());
    }

    @Test
    void turboOff(){
        Saab95 saab = new Saab95(4, 300, Color.red);
        saab.turboOff();
        assertFalse(saab.getTurbo());
    }

    @Test
    void turboOn(){
        Saab95 saab = new Saab95(4, 150, Color.red);
        saab.turboOn();
        assertTrue(saab.getTurbo());
    }
}
