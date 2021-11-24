import attributes.Platform;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import vehicle.Scania;

import java.awt.*;

public class testTruck {

    @Test
    void testSpeedFactor(){
        Platform platform = new Platform();
        double grossWeight = 8.5;
        Scania scania = new Scania(400, Color.green,grossWeight, platform, 2);
        double assumedSpeedFactor = scania.getCurrentSpeed() - (0.01 * scania.getGrossWeightInTons());

        assertEquals(assumedSpeedFactor, scania.speedFactor());
    }
}
