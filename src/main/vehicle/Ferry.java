package vehicle;
import attributes.*;
import java.awt.*;


public class Ferry extends Vehicle  {

    private final carLoader<Ferry> carLoader;

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
           if(!carLoader.isEmpty()){
               carLoader.moveLoad(this);
           }
            super.move();
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
