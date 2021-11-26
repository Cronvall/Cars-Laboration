package vehicle;
import vehicle.helperAttributes.Flatbed;

import java.awt.*;

/**
 * A Ferry is a Vehicle that can Carry a certain amount of Cars on its flatbed
 */
public class Ferry extends Vehicle  {

    private final LoaderHelper<Ferry> LoaderHelper;

    /**
     * Initiates a new Vehicle of the class Ferry
     * @param weight Describes the Ferry's weight
     */
    public Ferry(double weight){
        super(500, Color.white,"vehicle.Ferry");
        LoaderHelper = new LoaderHelper<>(20, Flatbed.LoadingMethod.FirstOnFirstOff);
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * (0.1 / 500);
    }

    @Override
    public void move(){
        if(LoaderHelper.getPlatform().getAngle() == 0){
            super.move();
           if(!LoaderHelper.isEmpty()){
               LoaderHelper.moveLoad(this);
           }
        }
        else System.out.printf("The platform needs to be raised before moving, current angle: %d", LoaderHelper.getPlatform().getAngle());
    }

    /**
     * Loads a car onto the Ferry
     * @param car the car to be loaded
     */
    public void loadCar(Car car){
        LoaderHelper.loadCar(car, this);
    }

    /**
     * Offloads a car from the Ferry
     */
    public void loadOffCar(){
        LoaderHelper.loadOffCar();
    }

    /**
     * Displays which cars are being carried
     * @return
     */
    public Car[] getLoad(){
        return LoaderHelper.getLoad();
    }
}
