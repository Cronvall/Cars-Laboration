package vehicle;
import vehicle.helperAttributes.Engine;
import vehicle.helperAttributes.Platform;
import vehicle.helperAttributes.Flatbed;
import java.awt.*;

/**
 * A Ferry is a MotorVehicle that can Carry a certain amount of Cars on its flatbed
 */
public class Ferry extends MotorVehicle implements ILoadCar {

    private LoaderHelper<Ferry> loaderHelper;
    private Flatbed flatbed;
    private Platform complexPlatform = new Platform();
    /**
     * Initiates a new MotorVehicle of the class Ferry
     */
    public Ferry( int capacity){
        super(200, Color.white,"vehicle.Ferry");
        this.flatbed = new Flatbed(capacity, Flatbed.LoadingMethod.FirstOnFirstOff);
        this.loaderHelper = new LoaderHelper<>(flatbed);
    }

    @Override
    public double speedFactor(){
        return this.getEnginePower() * (0.1 / 500);
    }

    @Override
    public void move(){
        if(complexPlatform.getAllowMotion()){

            super.move();
           if(!loaderHelper.isEmpty()){
               loaderHelper.moveLoad(this);
           }
        }
        else System.out.print("The complexPlatform needs to be raised before moving!");
    }

    /**
     * Loads a car on a vehicle
     * @param car that will be loaded on vehicle
     */
    @Override
    public void loadCar(Car car){
        if(complexPlatform.getAllowLoading())
        loaderHelper.loadCar(car, this);
        else System.out.println("You need to lower the ramp to be able to load a car.");
    }

    /**
     * Removes a car from a vehicle
     */
    @Override
    public void loadOffCar(){
        if(complexPlatform.getAllowLoading())
        loaderHelper.loadOffCar();
        else System.out.println("You need to lower the platform to be able to unload a car");
    }

    /**
     * Displays which vehicles are being carried
     * @return an array of motor-vehicles gets returned
     */
    public MotorVehicle[] getLoad(){
        return loaderHelper.getLoad();
    }

    /**
     * Gets the platform that's mounted on the ferry
     * @return an object of class Platform gets returned
     */
    public Platform getPlatform(){
        return complexPlatform;
    }
}
