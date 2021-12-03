package vehicle;
import vehicle.helperAttributes.Engine;
import java.awt.*;

/**
 * A Truck is a Car that may require a type C driver's license and has a defined weight
 */
public abstract class Truck extends Car {

    private boolean requiresDriverLicenseC;
    private double grossWeightInTons;

    /**
     * Initiates a new Car of the class Truck
     * @param engine Describes the engine
     * @param color Describes the color of the Truck
     * @param modelName Displays the name of the model(Scania etc.)
     * @param requiresDriverLicenseC Describes whether the Truck requires a type C driver's license
     * @param grossWeightInTons Describes the Truck's gross weight in tons
     * @param nrDoors Describes the Truck's number of doors
     */
    protected Truck(Engine engine, Color color, String modelName,
                    boolean requiresDriverLicenseC, double grossWeightInTons, int nrDoors){
        super(nrDoors, engine, color, modelName);
        this.requiresDriverLicenseC = requiresDriverLicenseC;
        this.grossWeightInTons = grossWeightInTons;
    }

    /**
     * Returns the Truck's gross weight in tons
     * @return weight in tons
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
