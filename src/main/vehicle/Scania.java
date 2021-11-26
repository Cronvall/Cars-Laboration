package vehicle;

import vehicle.helperAttributes.Platform;

import java.awt.*;

/**
 * A Scania is a Truck with a platform
 */
public class Scania extends Truck {

    private Platform platform;

    /**
     * Initiates a new Truck of the class Scania
     * @param enginePower Describes the engine's power
     * @param color Describes the color of the Truck
     * @param grossWeightInTons Describes the Truck's gross weight in tons
     * @param platform Describes the object of the Truck's platform
     * @param nrDoors Describes the Truck's number of doors
     */
    public Scania(int enginePower, Color color, double grossWeightInTons,
                  Platform platform, int nrDoors) {
        super(enginePower, color, "vehicle.Scania",
                true, grossWeightInTons, nrDoors);
        this.platform =  platform;
    }

 //   /**
 //    * OSÄKER: Defines our platform as an object of the class Platform
 //    * @return
 //    */
    public Platform getRamp() {
        return platform;
    }


    /**
     * Raises platform
     * @param angle decides how much to raise the platform
     */
    public void raisePlatform(int angle){
        platform.raise(angle);
    }

    /**
     * Lowers platform
     * @param angle decides how much to lower the platform
     */
    public void lowerPlatform(int angle){
        platform.lower(angle);
    }

    @Override
    public void move(){
        if (platform.getAllowMotion()){
            super.move();
        }
        else{
            System.out.println("Platform is down");
        }
    }
}
