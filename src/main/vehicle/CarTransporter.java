package vehicle;
import vehicle.helperAttributes.EasyPlatform;
import vehicle.helperAttributes.Flatbed;

import java.awt.*;

/**
 * A CarTransporter is a Truck that can carry a certain number of cars on a flatbed
 */
public class CarTransporter extends Truck implements ILoadCar {

    private final LoaderHelper<CarTransporter> loaderHelper;
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
        if(platform.motionAllowed()){
            super.move();
            if(!loaderHelper.isEmpty()){
                loaderHelper.moveLoad(this);
            }
        }
        else System.out.println("The platform needs to be raised before moving!");
    }

    @Override
    public void loadCar(Car car){
        if(platform.loadingAllowed())
        loaderHelper.loadCar(car, this);
        else System.out.println("You need to lower the ramp to load a car");
    }
<<<<<<< Updated upstream
    /**
     * Loads off the car that was last loaded onto the flatbed
     */
=======

    @Override
>>>>>>> Stashed changes
    public void loadOffCar(){
        if(platform.loadingAllowed())
        loaderHelper.loadOffCar();
        else System.out.println("You need to lower them to unload a car");
    }

    /**
     * Returns an array displaying the vehicles being carried
     * @return the load that is loaded upon the flatbed
     */
    public MotorVehicle[] getLoad(){
        return loaderHelper.getLoad();
    }

    public EasyPlatform getPlatform(){
        return platform;
    }
}
