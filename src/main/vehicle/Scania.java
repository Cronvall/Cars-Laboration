package vehicle;

import attributes.Platform;

import java.awt.*;

public class Scania extends Truck {

    private Platform platform;

    public Scania(int enginePower, Color color, double grossWeightInTons,
                  Platform platform, int nrDoors) {

        super(enginePower, color, "vehicle.Scania",
                true, grossWeightInTons, nrDoors);

        this.platform = platform;
    }

    public Platform getRamp() {
        return platform;
    }
}
