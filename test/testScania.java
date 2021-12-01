import vehicle.helperAttributes.Platform;
import org.junit.jupiter.api.*;
import vehicle.Scania;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class testScania {

    @Test
    void testGetRamp(){
        Platform complexPlatform = new Platform();
        Scania scania = new Scania(300, Color.CYAN, 10, complexPlatform, 2);
        assertEquals(complexPlatform, scania.getRamp());
    }

    @Test
    void scaniaMove(){
        Scania scan = new Scania(420, Color.RED, 4, new Platform(), 5);
        scan.startEngine();
        scan.gas(10);
        scan.move();

        Point2D.Double startPosition = new Point2D.Double(0, 0);
        assertNotEquals(scan.getPosition(),startPosition);
    }

    @Test
    void raisePlatform(){
        Scania scan = new Scania(420, Color.RED, 4, new Platform(), 5);
        scan.raisePlatform(10);
        Platform platform = new Platform();
        platform.raise(10);

        assertEquals(platform.getAngle(), scan.getRamp().getAngle());
    }

    @Test
    void lowerPlatform(){
        Scania scan = new Scania(420, Color.RED, 4, new Platform(), 5);
        scan.lowerPlatform(10);
        Platform platform = new Platform();
        platform.lower(10);

        assertEquals(scan.getRamp().getAngle(), platform.getAngle());
    }

    @Test
    void moveWhenPlatformIsDown(){
        Scania scan = new Scania(420, Color.RED, 4, new Platform(), 5);
        scan.lowerPlatform(90);
        System.out.println("Current angle: " + scan.getRamp().getAngle());
        scan.startEngine();
        scan.move();
        Point2D.Double startPosition = new Point2D.Double(0,0);
        assertEquals(startPosition, scan.getPosition(), "Has the truck moved");
    }
}
