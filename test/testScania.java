import vehicle.helperAttributes.ComplexPlatform;
import org.junit.jupiter.api.*;
import vehicle.Scania;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

public class testScania {

    @Test
    void testGetRamp(){
        ComplexPlatform complexPlatform = new ComplexPlatform();
        Scania scania = new Scania(300, Color.CYAN, 10, complexPlatform, 2);
        assertEquals(complexPlatform, scania.getRamp());
    }
}
