package workshops;
import vehicle.Saab95;
import java.awt.*;

/**
 * A SaabExclusiveWorkshop is a Workshop that can only handle Saab cars
 */
public class SaabExclusiveWorkShop extends WorkShop<Saab95> {
    /**
     * Initiates a new Workshop of the class SaabExclusiveWorkShop
     * @param gpsLocation Describes the location of the Workshop
     * @param capacity Describes the amount of cars that can be parked simultaneously
     */
    public SaabExclusiveWorkShop(Point gpsLocation, int capacity){
        super(gpsLocation, capacity);
    }

     @Override
     public void addVehicle(Saab95 car){
        super.addVehicle(car);
    }

    @Override
    public void removeVehicle(Saab95 saab95){
         super.removeVehicle(saab95);
    }
}
