package vehicle;

import java.awt.*;

public abstract class Truck extends Car {

    private boolean requiresDriverLicenseC;
    private double grossWeightInTons;

    protected Truck(int enginePower, Color color, String modelName,
                    boolean requiresDriverLicenseC, double grossWeightInTons, int nrDoors){
        super(nrDoors, enginePower, color, modelName);

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
