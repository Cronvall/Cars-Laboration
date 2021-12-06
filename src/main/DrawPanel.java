
import vehicle.Car;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoIMG;

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
        //TODO FIX THE READING OF IMG FILE HERE
        /*try {
            volvoIMG = ImageIO.read(new File("pics/Volvo240.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
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
