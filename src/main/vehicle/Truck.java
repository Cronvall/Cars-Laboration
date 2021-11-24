package vehicle;

import java.awt.*;

public abstract class Truck extends Vehicle {

    private boolean requiresDriverLicenseC;
    private double grossWeightInTons;
    private int nrDoors = 2;

    protected Truck(int enginePower, Color color, String modelName,
                    boolean requiresDriverLicenseC, double grossWeightInTons){
        super(enginePower, color, modelName);

        this.requiresDriverLicenseC = requiresDriverLicenseC;
        this.grossWeightInTons = grossWeightInTons;
    }

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
