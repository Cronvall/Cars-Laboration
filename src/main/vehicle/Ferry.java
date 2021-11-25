package vehicle;
import attributes.*;
import java.awt.*;
import java.awt.geom.Point2D;

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
            moveLoad();
            super.move();
        }
        else System.out.printf("The platform needs to be raised before moving, current angle: %d", carLoader.getPlatform().getAngle());
    }

    //Used to move the cars that are stored on the ferry
    private void moveLoad(){
        for(int i  = 0; i < this.getLoad().length; i++){
            if(this.getLoad()[i] != null)
                this.getLoad()[i].setPosition(this.getPosition());
        }
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
