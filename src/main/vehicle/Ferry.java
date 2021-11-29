package vehicle;
import vehicle.helperAttributes.Flatbed;
import vehicle.helperAttributes.Platform;

import java.awt.*;

/**
 * A Ferry is a Vehicle that can Carry a certain amount of Cars on its flatbed
 */
public class Ferry extends Vehicle  {

    private LoaderHelper loaderHelper;
    private Flatbed loadOn;
    private Platform platform = new Platform();
    /**
     * Initiates a new Vehicle of the class Ferry
     * @param weight Describes the Ferry's weight
     */
    public Ferry(double weight, int capacity){
        super(500, Color.white,"vehicle.Ferry");
        this.loadOn = new Flatbed(capacity, Flatbed.LoadingMethod.FirstOnFirstOff);
        this.loaderHelper = new LoaderHelper(loadOn);
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * (0.1 / 500);
    }

    @Override
    public void move(){
        if(platform.getAngle() == 0){
            super.move();
           if(!loaderHelper.isEmpty()){
               loaderHelper.moveLoad(this);
           }
        }
        else System.out.printf("The platform needs to be raised before moving!");
    }

    /**
     * Loads a car onto the Ferry
     * @param car the car to be loaded
     */
    public void loadCar(Car car){
        loaderHelper.loadCar(car, this);
    }

    /**
     * Offloads a car from the Ferry
     */
    public void loadOffCar(){
        loaderHelper.loadOffCar();
    }

    /**
     * Displays which vehicles are being carried
     * @return
     */
    public Vehicle[] getLoad(){
        return loaderHelper.getLoad();
    }
}
