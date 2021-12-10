package vehicle;
import vehicle.helperAttributes.Engine;
import vehicle.helperAttributes.Platform;
import vehicle.helperAttributes.Flatbed;
import java.awt.*;

/**
 * A Ferry is a MotorVehicle that can Carry a certain amount of Cars on its flatbed
 */
public class Ferry extends MotorVehicle implements ILoadCar {

    private Flatbed flatbed;
    private Platform complexPlatform = new Platform();
    /**
     * Initiates a new MotorVehicle of the class Ferry
     */
    public Ferry( int capacity){
        super(200, Color.white,"vehicle.Ferry");
        this.flatbed = new Flatbed(capacity, Flatbed.LoadingMethod.FirstOnFirstOff);

    }


    @Override
    public Car[] getCargo(){
        return this.flatbed.getCarLoad();
    }

    @Override
    public Flatbed getFlatbed() {
        return this.flatbed;
    }

    @Override
    public double speedFactor(){
        return this.getEnginePower() * (0.1 / 500);
    }

    @Override
    public void move(){
        if(complexPlatform.getAllowMotion()){

            super.move();
           if(!this.flatbed.getLoaderHelper().isEmpty(flatbed.getCarLoad())){
               this.flatbed.getLoaderHelper().moveLoad(flatbed.getCarLoad(), this);
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
        this.flatbed.getLoaderHelper().loadCar(car, this);
        else System.out.println("You need to lower the ramp to be able to load a car.");
    }

    /**
     * Removes a car from a vehicle
     */
    @Override
    public void loadOffCar(){
        if(complexPlatform.getAllowLoading())
        this.flatbed.getLoaderHelper().loadOffCar(this.flatbed);
        else System.out.println("You need to lower the platform to be able to unload a car");
    }

    /**
     * Displays which vehicles are being carried
     * @return an array of motor-vehicles gets returned
     */
    public MotorVehicle[] getLoad(){
        return this.flatbed.getCarLoad();
    }

    /**
     * Gets the platform that's mounted on the ferry
     * @return an object of class Platform gets returned
     */
    public Platform getPlatform(){
        return complexPlatform;
    }
}
