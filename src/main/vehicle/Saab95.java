package vehicle;

import vehicle.Car;

import java.awt.*;

/**
 * A Saab95 is a Car with turbo deciding its speed factor
 */
public class Saab95 extends Car {

    private boolean turboOn;

    /**
     * Initiates a new Car of the class Saab95
     * @param nrDoors Describes the Car's number of doors
     * @param enginePower Describes the engine's power
     * @param col Describes the color of the Car
     */
    public Saab95(int nrDoors, int enginePower, Color col){
        super(nrDoors,enginePower,col,"Saab-95");
	    turboOn = false;
    }

    /**
     * Returns true(Turbo is on) or false(Turbo is off)
     * @return
     */
    public boolean getTurbo(){ return  turboOn;}

    /**
     * Turns on Turbo
     */
    public void setTurboOn(){
	    turboOn = true;
    }
    /**
     * Turns off Turbo
     */
    public void setTurboOff(){
	    turboOn = false;
    }

     @Override
     public double speedFactor(){
        double turbo = 1;
        if(turboOn) {turbo = 1.3;}
        return getEnginePower() * 0.01 * turbo;
    }
    @Override
    public void stopEngine(){
        setCurrentSpeed(0);
        setTurboOff();
    }
}
