package vehicle;

import vehicle.helperAttributes.EasyPlatform;
import vehicle.helperAttributes.Flatbed;
import vehicle.helperAttributes.Platform;

import java.awt.*;

/**
 * A CarTransporter is a Truck that can carry a certain number of cars on a flatbed
 */
public class CarTransporter extends Truck {

    private final LoaderHelper loaderHelper;
    private final Flatbed flatbed;
    private EasyPlatform platform = new EasyPlatform();
    /**
     * Initiates a new Truck of the class CarTransporter
     * @param slots Describes how many cars the CarTransporter can carry
     */
    public CarTransporter(int slots){
        super(300, Color.CYAN, "DAF",
                true, 20, 2);
        this.flatbed = new Flatbed(slots, Flatbed.LoadingMethod.FirstOnLastOff);
        this.loaderHelper = new LoaderHelper(flatbed);
    }

    @Override
    public void move(){
        if(platform.motionAllowed())
            super.move();
        else System.out.println("The platform needs to be raised before moving!");
    }

    /**
     * Starts carrying a car
     * @param car the Car to be carried
     */
    public void loadCar(Car car){
        loaderHelper.loadCar(car, this);
    }

    /**
     * Loads off the car that was last loaded onto the flatbed
     */
    public void loadOffCar(){
        loaderHelper.loadOffCar();
    }

    /**
     * Returns an array displaying the vehicles being carried
     * @return
     */
    public Vehicle[] getLoad(){
        return loaderHelper.getLoad();
    }
}
