package vehicle;

import vehicle.helperAttributes.ComplexPlatform;

import java.awt.*;

/**
 * A Scania is a Truck with a complexPlatform
 */
public class Scania extends Truck {

    private ComplexPlatform complexPlatform;

    /**
     * Initiates a new Truck of the class Scania
     * @param enginePower Describes the engine's power
     * @param color Describes the color of the Truck
     * @param grossWeightInTons Describes the Truck's gross weight in tons
     * @param complexPlatform Describes the object of the Truck's complexPlatform
     * @param nrDoors Describes the Truck's number of doors
     */
    public Scania(int enginePower, Color color, double grossWeightInTons,
                  ComplexPlatform complexPlatform, int nrDoors) {
        super(enginePower, color, "vehicle.Scania",
                true, grossWeightInTons, nrDoors);
        this.complexPlatform = complexPlatform;
    }

 //   /**
 //    * OSÄKER: Defines our complexPlatform as an object of the class ComplexPlatform
 //    * @return
 //    */
    public ComplexPlatform getRamp() {
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
