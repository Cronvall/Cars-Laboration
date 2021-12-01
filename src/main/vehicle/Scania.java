package vehicle;

import vehicle.helperAttributes.Platform;

import java.awt.*;

/**
 * A Scania is a Truck with a complexPlatform
 */
public class Scania extends Truck {

    private Platform complexPlatform;

    /**
     * Initiates a new Truck of the class Scania
     * @param enginePower Describes the engine's power
     * @param color Describes the color of the Truck
     * @param grossWeightInTons Describes the Truck's gross weight in tons
     * @param complexPlatform Describes the object of the Truck's complexPlatform
     * @param nrDoors Describes the Truck's number of doors
     */
    public Scania(int enginePower, Color color, double grossWeightInTons,
                  Platform complexPlatform, int nrDoors) {
        super(enginePower, color, "vehicle.Scania",
                true, grossWeightInTons, nrDoors);
        this.complexPlatform = complexPlatform;
    }

    /**
     * gets the platform that scania has mounted
     * @return the object platform mounted on scania
     */
    public Platform getRamp() {
        return complexPlatform;
    }


    /**
     * Raises complexPlatform
     * @param angle decides how much to raise the complexPlatform
     */
    public void raisePlatform(int angle){
        complexPlatform.raise(angle);
    }

    /**
     * Lowers complexPlatform
     * @param angle decides how much to lower the complexPlatform
     */
    public void lowerPlatform(int angle){
        complexPlatform.lower(angle);
    }

    /**
     * Moves the vehicle one of four directions in a 2d plane
     */
    @Override
    public void move(){
        if (complexPlatform.getAllowMotion()){
            super.move();
        }
        else{
            System.out.println("ComplexPlatform is down");
        }
    }
}
