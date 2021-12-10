import java.awt.*;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    DrawVehicles vehicleDrawer;

    public static void main(String[] args){
        CarModel model = CarModelFactory.makeDefaultModel();
        CarView view = new CarView("Forza Horizon 5 - Green World DLC", model);
        model.addObserver(view);
        CarController controller = new CarController(model, view);
        model.start();
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, DrawVehicles vehicleDrawer){
        this.vehicleDrawer = vehicleDrawer;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        vehicleDrawer.paintComponent(g);
    }
}
