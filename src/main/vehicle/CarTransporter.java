package vehicle;
import vehicle.helperAttributes.Engine;
import vehicle.helperAttributes.Ramp;
import vehicle.helperAttributes.Flatbed;
import java.awt.*;

/**
 * A CarTransporter is a Truck that can carry a certain number of cars on a flatbed
 */
public class CarTransporter extends Truck implements ILoadCar {

    private final Flatbed flatbed;
    private Ramp ramp = new Ramp();

    /**
     * Initiates a new Truck of the class CarTransporter
     * @param slots Describes how many cars the CarTransporter can carry
     */
    public CarTransporter(int slots){
        super(300, Color.CYAN, "DAF",
                true, 20, 2);
        this.flatbed = new Flatbed(slots, Flatbed.LoadingMethod.FirstOnLastOff);
    }

    @Override
    public Car[] getCargo(){
       return this.flatbed.getCarLoad();
    }


    /**
     * Moves the vehicle one of four directions in a 2d plane
     */
    @Override
    public void move(){
        if(ramp.getAllowMotion()){
            super.move();
            if(!flatbed.isEmpty()){
                flatbed.moveCargo(this);
            }
        }
        else throw new IllegalArgumentException("The ramp needs to be raised in order to move!");
    }

    @Override
    public Flatbed getFlatbed(){
        return this.flatbed;
    }

    /**
     * Loads a car on a vehicle
     * @param car that will be loaded on vehicle
     */
    @Override
    public void loadCar(Car car){
        if(ramp.getAllowLoading())
        flatbed.getLoaderHelper().loadCar(car, this);
        else System.out.println("You need to lower the ramp to load a car");
    }
    /**
     * Removes a car from a vehicle
     */
    @Override
    public void loadOffCar(){
        if(ramp.getAllowLoading())
        flatbed.getLoaderHelper().loadOffCar(this.flatbed);
        else System.out.println("You need to lower the ramp to unload a car");
    }

    /**
     * Returns an array displaying the vehicles being carried
     * @return the load that is loaded upon the flatbed
     */
    public MotorVehicle[] getLoad(){
        return flatbed.getCarLoad();
    }

    /**
     * Returns the car-transporters mounted Ramp
     * @return an object of class ramp
     */
    public Ramp getRamp(){
        return ramp;
    }
}
