import org.junit.jupiter.api.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

public class testCar {
    @Test
    void testGetNrOfDoors(){
        Volvo240 volvo = new Volvo240(2,100,Color.RED);
        assertEquals(2, volvo.getNrOfDoors());
    }
}
