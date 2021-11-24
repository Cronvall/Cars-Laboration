package vehicle;
import attributes.*;
import java.awt.*;


public class Ferry extends Vehicle {

    Flatbed deck;
    private double weight; //Weight in tons

    public Ferry(double weight){
        super(500, Color.white,"vehicle.Ferry");
        deck = new Flatbed(20, Flatbed.LoadingMethod.FirstOnFirstOff);
        this.weight = weight;
    }

    @Override
    public double speedFactor(){
         final double factor = getEnginePower() * 0.005;
        return getEnginePower() * (0.1 / weight);
    }

    public void loadCar(Car car){
        deck.loadCar(car);
        weight += 2;
    }

    public void loadOffCar(){
        deck.removeCar();
        weight -=2;
    }

    public Car[] getLoad(){
        return deck.getCarLoad();
    }
}
