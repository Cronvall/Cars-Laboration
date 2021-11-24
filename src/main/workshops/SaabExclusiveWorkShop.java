package workshops;
import vehicle.Saab95;
import java.awt.*;

public class SaabExclusiveWorkShop extends WorkShop<Saab95> {

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
