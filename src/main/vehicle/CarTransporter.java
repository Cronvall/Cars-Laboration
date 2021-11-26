package vehicle;

import attributes.Flatbed;

import java.awt.*;

/**
 * A CarTransporter is a Truck that can carry a certain number of cars on a flatbed
 */
public class CarTransporter extends Truck {

    private final LoaderHelper<CarTransporter> LoaderHelper;

    /**
     * Initiates a new Truck of the class CarTransporter
     * @param slots Describes how many cars the CarTransporter can carry
     */
    public CarTransporter(int slots){
        super(300, Color.CYAN, "DAF",
                true, 20, 2);

        LoaderHelper = new LoaderHelper<>(slots, Flatbed.LoadingMethod.FirstOnLastOff);
    }

    @Override
    public void move(){
        if(LoaderHelper.getPlatform().getAngle() == 0)
            super.move();
        else System.out.printf("The platform needs to be raised before moving, current angle: %d", LoaderHelper.getPlatform().getAngle());
    }

    /**
     * Starts carrying a car
     * @param car the Car to be carried
     */
    public void loadCar(Car car){
        LoaderHelper.loadCar(car, this);
    }

    /**
     * Loads off the car that was last loaded onto the flatbed
     */
    public void loadOffCar(){
        LoaderHelper.loadOffCar();
    }

    /**
     * Returns an array displaying the cars being carried
     * @return
     */
    public Car[] getLoad(){
        return LoaderHelper.getLoad();
    }
}
