import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import vehicle.MotorVehicle;
import vehicle.Saab95;
import vehicle.Volvo240;
import workshops.*;

import java.awt.*;
import java.util.ArrayList;

public class testWorkshops {


    @Test
    void addingVehicleToWorkshop(){

        VolvoExclusiveWorkShop volvoW = new VolvoExclusiveWorkShop(new Point(2,4), 5);
        Volvo240 volvo1 = new Volvo240(2, 120, Color.red);

        volvoW.addVehicle(volvo1);
        ArrayList<MotorVehicle> workshop = volvoW.getVehiclesInWorkshop();
        assertEquals(volvo1, workshop.get(0));
        volvoW.removeVehicle(volvo1);

    }

    @Test
    void maxCapacity(){
        VolvoExclusiveWorkShop volvoW = new VolvoExclusiveWorkShop(new Point(2, 2), 1);
        Volvo240 v1 = new Volvo240(2, 30, Color.green);
        Volvo240 v2 = new Volvo240(2, 34, Color.black);

        volvoW.addVehicle(v1);

        assertThrows(IllegalArgumentException.class,
                () -> volvoW.addVehicle(v2),
                "Expected to throw too many vehicles, but it didn't");

    }

    @Test
    void removingVehicleFromWorkshop(){
        SaabExclusiveWorkShop saabWorkS = new SaabExclusiveWorkShop(new Point(0, 1), 4);
        Saab95 saab1 = new Saab95(2,402, Color.green);

        saabWorkS.addVehicle(saab1);
        ArrayList<MotorVehicle> workshop = saabWorkS.getVehiclesInWorkshop();
        assertEquals(1, workshop.size());
        saabWorkS.removeVehicle(saab1);
        assertEquals(0, workshop.size());
    }

    @Test
    void methodsInGeneral(){
        VolvoExclusiveWorkShop v = new VolvoExclusiveWorkShop(new Point(1,2), 4);
        Volvo240 volv = new Volvo240(2, 30, Color.green);

        v.changeOilFilter(volv);
        v.changeTires(volv);
        v.repairWindShield(volv);

        v.addVehicle(volv);
        v.addVehicle(volv);
    }
}
