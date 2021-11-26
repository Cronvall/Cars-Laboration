import vehicle.helperAttributes.Platform;
import org.junit.jupiter.api.*;
import vehicle.Scania;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

public class testScania {

    @Test
    void testGetRamp(){
        Platform platform = new Platform();
        Scania scania = new Scania(300, Color.CYAN, 10, platform, 2);
        assertEquals(platform, scania.getRamp());
    }
}
