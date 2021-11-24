package vehicle;

import attributes.Flatbed;
import attributes.Platform;
import vehicle.Truck;

import java.awt.*;

public class CarTransporter extends Truck {

    private final carLoader<CarTransporter> carLoader;

    public CarTransporter(int slots){
        super(300, Color.CYAN, "DAF",
                true, 20, 2);

        carLoader = new carLoader<>(slots, Flatbed.LoadingMethod.FirstOnLastOff);
    }

    @Override
    public void move(){
        if(carLoader.getPlatform().getAngle() == 0)
            super.move();
        else System.out.printf("The platform needs to be raised before moving, current angle: %d", carLoader.getPlatform().getAngle());
    }

    public void loadCar(Car car){
        carLoader.loadCar(car, this);
    }

    public void loadOffCar(){
        carLoader.loadOffCar();
    }

    public Car[] getLoad(){
        return carLoader.getLoad();
    }
}
