package workshops;

import vehicle.Volvo240;
import workshops.WorkShop;

import java.awt.*;

public class VolvoExclusiveWorkShop extends WorkShop<Volvo240> {

    public VolvoExclusiveWorkShop(Point gpsLocation, int capacity){
        super(gpsLocation, capacity);
    }
    @Override
    public void addVehicle(Volvo240 car){
        super.addVehicle(car);
    }
    @Override
    public void removeVehicle(Volvo240 car){
        super.removeVehicle(car);
    }

}
