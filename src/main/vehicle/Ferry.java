package vehicle;
import vehicle.helperAttributes.Platform;
import vehicle.helperAttributes.Flatbed;
import java.awt.*;

/**
 * A Ferry is a MotorVehicle that can Carry a certain amount of Cars on its flatbed
 */
public class Ferry extends MotorVehicle implements ILoadCar {

    // TODO what is the reason for this LoaderHelper being parametrized?
    private LoaderHelper<Ferry> loaderHelper;
    private Flatbed loadOn;
    private Platform complexPlatform = new Platform();
    /**
     * Initiates a new MotorVehicle of the class Ferry
     * @param weight Describes the Ferry's weight
     */
    public Ferry(double weight, int capacity){
        super(500, Color.white,"vehicle.Ferry");
        this.loadOn = new Flatbed(capacity, Flatbed.LoadingMethod.FirstOnFirstOff);
        this.loaderHelper = new LoaderHelper<Ferry>(loadOn);
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * (0.1 / 500);
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

    @Override
    public void loadCar(Car car){
        if(complexPlatform.getAllowLoading())
        loaderHelper.loadCar(car, this);
        else System.out.println("You need to lower the ramp to be able to load a car.");
    }

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
