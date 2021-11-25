package vehicle;

import java.awt.*;

/**
 * A Volvo240 is a Car with a constant trim factor as its speed factor
 */
public class Volvo240 extends Car {

    private double trimFactor = 1.25;

    /**
     * Initiates a new Car of the class Volvo240
     * @param nrDoors
     * @param enginePower
     * @param col
     */
    public Volvo240(int nrDoors, int enginePower, Color col){
        super(nrDoors,enginePower,col,"Volvo-240");
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
