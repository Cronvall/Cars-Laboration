package vehicle;

import java.awt.*;

/**
 * A Truck is a Car that may require a type C driver's license and has a defined weight
 */
public abstract class Truck extends Car {

    private boolean requiresDriverLicenseC;
    private double grossWeightInTons;

    /**
     * Initiates a new Car of the class Truck
     * @param enginePower Describes the engine's power and defines the speed of the vehicle
     * @param color Describes the color of the vehicle
     * @param modelName Displays the name of the model(Volvo240, Saab95 etc.)
     * @param requiresDriverLicenseC Describes whether the Truck requires a type C driver's license
     * @param grossWeightInTons Describes the Truck's gross weight in tons
     * @param nrDoors Describes the car's number of door
     */
    protected Truck(int enginePower, Color color, String modelName,
                    boolean requiresDriverLicenseC, double grossWeightInTons, int nrDoors){
        super(nrDoors, enginePower, color, modelName);

        this.requiresDriverLicenseC = requiresDriverLicenseC;
        this.grossWeightInTons = grossWeightInTons;
    }

    /**
     * Returns the Truck's gross weight in tons
     * @return
     */
    public double getGrossWeightInTons() {
        return grossWeightInTons;
    }

    @Override
    public double speedFactor() {
        double weightFactor = 0.01 * grossWeightInTons;
        double newSpeedFactor = getCurrentSpeed() - weightFactor;
        return newSpeedFactor;
    }


}
