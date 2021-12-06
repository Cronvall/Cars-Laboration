package vehicle;
import vehicle.helperAttributes.Engine;
import vehicle.helperAttributes.Platform;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A Scania is a Truck with a complexPlatform
 */
public class Scania extends Truck {

    private final Platform complexPlatform;
    private  static BufferedImage image;
    /**
     * Initiates a new Truck of the class Scania
     * @param engine Describes the engine
     * @param color Describes the color of the Truck
     * @param grossWeightInTons Describes the Truck's gross weight in tons
     * @param complexPlatform Describes the object of the Truck's complexPlatform
     */
    public Scania(Engine engine, Color color, double grossWeightInTons,
                  Platform complexPlatform) {
        super(engine, color, "vehicle.Scania",
                true, grossWeightInTons, 2);
        this.complexPlatform = complexPlatform;
        try{
            image = ImageIO.read(new File("src/main/pics/scania.jpg"));
        }
        catch (IOException e){
            System.out.println("Faulty read of image in Scania!");
        }
    }

    /**
     * gets the platform that scania has mounted
     * @return the object platform mounted on scania
     */
    public Platform getRamp() {
        return complexPlatform;
    }


    /**
     * Raises complexPlatform
     * @param angle decides how much to raise the complexPlatform
     */
    public void raisePlatform(int angle){
        complexPlatform.raise(angle);
    }

    /**
     * Lowers complexPlatform
     * @param angle decides how much to lower the complexPlatform
     */
    public void lowerPlatform(int angle){
        if(getCurrentSpeed() == 0)
        complexPlatform.lower(angle);
        else System.out.println("You need to stop before lowering platform");
    }

    /**
     * Moves the vehicle one of four directions in a 2d plane
     */
    @Override
    public void move(){
        if (complexPlatform.getAllowMotion()){
            super.move();
        }
        else{
            System.out.println("ComplexPlatform is down");
            stopEngine();
        }
    }
}
