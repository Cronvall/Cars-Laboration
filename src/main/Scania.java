import java.awt.*;

public class Scania extends Truck{

    private Ramp ramp;

    public Scania(int enginePower, Color color, double grossWeightInTons,  Ramp ramp) {

        super(enginePower, color, "Scania", true, grossWeightInTons);

        this.ramp = ramp;
    }

    public Ramp getRamp() {
        return ramp;
    }
}
