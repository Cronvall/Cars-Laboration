import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import vehicle.*;
import vehicle.helperAttributes.Engine;

import java.awt.*;

public class testCar {
    @Test
    void testGetNrOfDoors(){
        Volvo240 volvo = new Volvo240(2,new Engine(200),Color.RED);
        assertEquals(2, volvo.getNrOfDoors());


    }

    @Test
    void testToString(){
        Volvo240 volvo = new Volvo240(2,new Engine(200),Color.RED);
        String carToString = volvo.toString();
        assertTrue(carToString instanceof String);
    }

}
