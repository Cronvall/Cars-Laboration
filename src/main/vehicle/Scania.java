package vehicle;

import attributes.Platform;

import java.awt.*;

/**
 * A Scania is a Truck with a platform
 */
public class Scania extends Truck {

    private Platform platform;

    /**
     * Initiates a new Truck of the class Scania
     * @param enginePower
     * @param color
     * @param grossWeightInTons
     * @param platform
     * @param nrDoors
     */
    public Scania(int enginePower, Color color, double grossWeightInTons,
                  Platform platform, int nrDoors) {

        super(enginePower, color, "vehicle.Scania",
                true, grossWeightInTons, nrDoors);

        this.platform = platform;
    }

 //   /**
 //    * OSÄKER: Defines our platform as an object of the class Platform
 //    * @return
 //    */
    public Platform getRamp() {
        return platform;
    }
}
