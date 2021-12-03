import vehicle.helperAttributes.Engine;
import vehicle.helperAttributes.Flatbed;
import org.junit.jupiter.api.*;
import vehicle.Volvo240;

import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

public class testFlatbed {

    @Test
    void testFlatbedFunctionality(){
        Flatbed fb = new Flatbed(2, Flatbed.LoadingMethod.FirstOnFirstOff);

        fb.loadCar(new Volvo240(2,new Engine(110),Color.red));
        fb.loadCar(new Volvo240(2,new Engine(110),Color.red));
        fb.loadCar(new Volvo240(2,new Engine(120),Color.red));
        assertEquals(2,fb.getCarLoad().length);

        fb.removeCar();
        assertEquals(2,fb.getCarLoad().length);
        assertNull(fb.getCarLoad()[0]);

        fb = new Flatbed(2, Flatbed.LoadingMethod.FirstOnLastOff);
        fb.loadCar(new Volvo240(2,new Engine(110),Color.red));
        fb.loadCar(new Volvo240(2,new Engine(110),Color.red));
        fb.loadCar(new Volvo240(2,new Engine(120),Color.red));
        assertEquals(2,fb.getCarLoad().length);

        fb.removeCar();
        assertEquals(2,fb.getCarLoad().length);
        assertNotNull(fb.getCarLoad()[1]);
    }

}
