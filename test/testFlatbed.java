import org.junit.jupiter.api.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

public class testFlatbed {

    @Test
    void testFlatbedFunctionality(){
        Flatbed fb = new Flatbed(2, Flatbed.LoadingMethod.FirstOnFirstOff);

        fb.loadCar(new Volvo240(2,100,Color.red));
        fb.loadCar(new Volvo240(2,110,Color.red));
        fb.loadCar(new Volvo240(2,120,Color.red));
        assertEquals(2,fb.getCarLoad().length);

        fb.removeCar();
        assertEquals(2,fb.getCarLoad().length);
        assertNull(fb.getCarLoad()[0]);

        fb = new Flatbed(2, Flatbed.LoadingMethod.FirstOnLastOff);
        fb.loadCar(new Volvo240(2,100,Color.red));
        fb.loadCar(new Volvo240(2,110,Color.red));
        fb.loadCar(new Volvo240(2,120,Color.red));
        assertEquals(2,fb.getCarLoad().length);

        fb.removeCar();
        assertEquals(2,fb.getCarLoad().length);
        assertNull(fb.getCarLoad()[1]);
    }

}
