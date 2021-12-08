import vehicle.*;
import vehicle.Factory.MotorVehicleFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoIMG;
    BufferedImage saabIMG;
    BufferedImage scaniaIMG;

    // To keep track of a single cars position
    //Point displayPoint = new Point();
    Point volvoPosition = new Point();
    Point saabPosition = new Point();
    Point scaniaPosition = new Point();

    // TODO: Make this general for all cars
    void moveit(int x, int y, MotorVehicle car){

        if(car instanceof Volvo240) {
            volvoPosition.x = x;
            volvoPosition.y = y;
        }
        else if (car instanceof Saab95){
            saabPosition.x = x;
            saabPosition.y = y;
        }
        else if(car instanceof Scania){
            scaniaPosition.x = x;
            scaniaPosition.y = y;
        }
        else{
            throw new IllegalArgumentException("this is terrible programming");
        }
    }

    public static void main(String[] args){

        CarModel model = new CarModel();

        CarView view = new CarView("Cars-laboration", model);

        model.addObserver(view);

        CarController controller = new CarController(model, view);


        model.vehicles.add(MotorVehicleFactory.buildVolvo240(4,100, Color.red));
        model.vehicles.add(MotorVehicleFactory.buildSaab95(2, 100, Color.CYAN));
        model.vehicles.add(MotorVehicleFactory.buildScania(1337, Color.green, 1));

        model.start();
    }


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y){
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoIMG = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabIMG = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaIMG = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoIMG, volvoPosition.x,volvoPosition.y,null);
        g.drawImage(saabIMG, saabPosition.x + 100, saabPosition.y, null);
        g.drawImage(scaniaIMG, scaniaPosition.x + 200, scaniaPosition.y, null);
    }


}
