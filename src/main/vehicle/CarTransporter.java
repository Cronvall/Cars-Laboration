package vehicle;

import attributes.Flatbed;
import vehicle.Truck;

import java.awt.*;

public class CarTransporter extends Truck {

    private Flatbed flatbed;

    public CarTransporter(Flatbed flatbed){
        super(300, Color.CYAN, "DAF",
                true, 20, 2);
        this.flatbed =  new Flatbed(3, Flatbed.LoadingMethod.FirstOnFirstOff);
    }
}
