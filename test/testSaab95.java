import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

public class testSaab95 {

    @Test
    void testSpeedFactor(){
        Saab95 saab = new Saab95(4,150, Color.black);
        saab.setTurboOff();
        double desiredVal = 150 * 0.01;
        assertEquals(desiredVal,saab.speedFactor(), "Test without turbo.");
        saab.setTurboOn();
        desiredVal = 150 * 0.01 * 1.3;
        assertEquals(desiredVal,saab.speedFactor(), "Test with turbo");
    }

}
