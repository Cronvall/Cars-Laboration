import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import vehicle.*;
import java.awt.*;
import java.util.Arrays;

public class testCarTransporter {

    @Test
    void test_transport(){
        CarTransporter transporter = new CarTransporter(3);

        transporter.getPlatform().lower();
        transporter.loadCar(new Saab95(2,100, Color.red));
        transporter.loadCar(new Volvo240(4,150, Color.red));
        transporter.getPlatform().raise();
        transporter.move();
        assertEquals(transporter.getPosition(), transporter.getLoad()[0].getPosition(), "Asserts that the load move with the ferry");

        System.out.println(Arrays.toString(transporter.getLoad()));
        assertNotNull(transporter.getLoad()[0], "Should be a SAAB here");
        assertNotNull(transporter.getLoad()[1], "Should be a volvo here");
        assertNull(transporter.getLoad()[2], "This slot should be empty");

        transporter.getPlatform().lower();
        transporter.loadOffCar();
        transporter.getPlatform().raise();
        System.out.println(Arrays.toString(transporter.getLoad()));
        assertNull(transporter.getLoad()[1], "This should now be empty (null)");
        assertNotNull(transporter.getLoad()[0], "The SAAB should still be here");
    }
}
