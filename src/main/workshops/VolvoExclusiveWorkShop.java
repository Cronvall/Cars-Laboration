package workshops;

import vehicle.Volvo240;
import workshops.WorkShop;

import java.awt.*;

/**
 * A VolvoExclusiveWorkshop is a Workshop that can only handle Volvo cars
 */
public class VolvoExclusiveWorkShop extends WorkShop<Volvo240> {
    /**
     * Initiates a new Workshop of the class VolvoExclusiveWorkShop
     * @param gpsLocation Describes the location of the Workshop
     * @param capacity Describes the amount of cars that can be parked simultaneously
     */
    public VolvoExclusiveWorkShop(Point gpsLocation, int capacity){
        super(gpsLocation, capacity);
    }

    /**
     * Inserts a vehicle to the end of the list
     * @param car to be added to the workshop
     */
    @Override
    public void addVehicle(Volvo240 car){
        super.addVehicle(car);
    }

    /**
     * Removes the specified element from the workshop
     * @param car to be removed from the workshop
     */
    @Override
    public void removeVehicle(Volvo240 car){
        super.removeVehicle(car);
    }

}
