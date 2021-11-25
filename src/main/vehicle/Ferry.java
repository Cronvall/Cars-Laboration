package vehicle;
import attributes.*;
import java.awt.*;

/**
 * A Ferry is a Vehicle that can Carry a certain amount of Cars on its flatbed
 */
public class Ferry extends Vehicle  {

    private final carLoader<Ferry> carLoader;

    /**
     * Initiates a new Vehicle of the class Ferry
     * @param weight Describes the Ferry's weight
     */
    public Ferry(double weight){
        super(500, Color.white,"vehicle.Ferry");
        carLoader = new carLoader<>(20, Flatbed.LoadingMethod.FirstOnFirstOff);
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * (0.1 / 500);
    }

    @Override
    public void move(){
        if(carLoader.getPlatform().getAngle() == 0){
            super.move();
           if(!carLoader.isEmpty()){
               carLoader.moveLoad(this);
           }
        }
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
