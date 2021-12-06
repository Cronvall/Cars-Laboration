
import vehicle.Car;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoIMG;
    BufferedImage saabIMG;
    BufferedImage scaniaIMG;

    // To keep track of a singel cars position
    Point displayPoint = new Point();

    // TODO: Make this genereal for all cars
    void moveit(int x, int y){
        displayPoint.x = x;
        displayPoint.y = y;
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
        g.drawImage(volvoIMG, displayPoint.x,displayPoint.y,null);
    }

    public void drawCars(Graphics g, ArrayList<Car> cars){
        for(Car car : cars){
            g.drawImage(car.getImage(), displayPoint.x, displayPoint.y,null);
        }
    }
}
