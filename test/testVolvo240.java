import org.junit.jupiter.api.*;
import vehicle.Volvo240;
import vehicle.helperAttributes.Engine;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

public class testVolvo240 {

    @Test
    void testSpeedFactor(){
        Volvo240 volvo = new Volvo240(4,420,Color.yellow, 1.25);
        double desiredVal = 420 * 0.01 * 1.25;
        assertEquals(desiredVal,volvo.speedFactor());
    }
}
