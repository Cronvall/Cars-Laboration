import vehicle.*;
import vehicle.Factory.MotorVehicleFactory;

import java.awt.*;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    public static void main(String[] args){
        CarModel model = CarModelFactory.makeDefaultModel();
        CarView view = new CarView("Cars-laboration", model);
        model.addObserver(view);
        CarController controller = new CarController(model, view);
        model.start();
    }

    // TODO: Make this general for all cars
    void moveit(int x, int y, MotorVehicle car){
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y){
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


}
