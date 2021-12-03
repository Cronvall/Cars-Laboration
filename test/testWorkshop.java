import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import vehicle.MotorVehicle;
import vehicle.Saab95;
import vehicle.Volvo240;
import vehicle.helperAttributes.Engine;
import vehicle.helperAttributes.TurboEngine;
import workshops.*;
import java.awt.*;
import java.util.ArrayList;

public class testWorkshop {


    @Test
    void addingVehicleToWorkshop(){
        VolvoExclusiveWorkShop volvoW = new VolvoExclusiveWorkShop(new Point(2,4), 5);
        Volvo240 volvo1 = new Volvo240(2, new Engine(150, 1.25), Color.red);

        volvoW.addVehicle(volvo1);
        ArrayList<MotorVehicle> workshop = volvoW.getVehiclesInWorkshop();

        assertEquals(volvo1, workshop.get(0));
        volvoW.removeVehicle(volvo1);

    }

    @Test
    void maxCapacity(){
        VolvoExclusiveWorkShop volvoW = new VolvoExclusiveWorkShop(new Point(2, 2), 1);
        Volvo240 v1 = new Volvo240(2, new Engine(30), Color.green);
        Volvo240 v2 = new Volvo240(2, new Engine(30), Color.black);

        volvoW.addVehicle(v1);

        assertThrows(IllegalArgumentException.class,
                () -> volvoW.addVehicle(v2),
                "Expected to throw too many vehicles, but it didn't");

    }

    @Test
    void removingVehicleFromWorkshop(){
        SaabExclusiveWorkShop saabWorkS = new SaabExclusiveWorkShop(new Point(0, 1), 4);
        Saab95 saab1 = new Saab95(2,new TurboEngine(420), Color.green);

        saabWorkS.addVehicle(saab1);
        ArrayList<MotorVehicle> workshop = saabWorkS.getVehiclesInWorkshop();
        assertEquals(1, workshop.size());
    }

    @Test
    void methodsInGeneral(){
        VolvoExclusiveWorkShop workshop = new VolvoExclusiveWorkShop(new Point(1,2), 4);
        Volvo240 volvo = new Volvo240(2, new Engine(30), Color.green);

        workshop.changeOilFilter(volvo);
        workshop.changeTires(volvo);
        workshop.repairWindShield(volvo);

    }

    @Test
    void removeSaabFromWorkshop(){
        Saab95 saab = new Saab95(2, new TurboEngine(330), Color.RED);
        Saab95 saabOtherOne = new Saab95(2, new TurboEngine(332), Color.RED);
        WorkShop<MotorVehicle> workshop = new WorkShop<MotorVehicle>(new Point(2, 2), 3);
        workshop.addVehicle(saab);
        workshop.addVehicle(saabOtherOne);

        workshop.removeVehicle(saab);

        assertEquals(1, workshop.getVehiclesInWorkshop().size());
    }

    @Test
    void vehicleAlreadyInWorkShop(){
        SaabExclusiveWorkShop saabW = new SaabExclusiveWorkShop(new Point(2,3), 3);
        Saab95 saab = new Saab95(2, new TurboEngine(320), Color.red);
        saabW.addVehicle(saab);

        assertThrows(IllegalArgumentException.class,
                () -> saabW.addVehicle(saab),
                "Vehicle is already in the workshop");


    }
}
