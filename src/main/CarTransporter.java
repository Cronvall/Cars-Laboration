import java.awt.*;

public class CarTransporter extends Truck {

    private Flatbed flatbed;

    public CarTransporter(Flatbed flatbed){
        super(300, Color.CYAN, "DAF", true, 20);
        this.flatbed = flatbed;
    }
}
