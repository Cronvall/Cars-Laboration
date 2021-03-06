package vehicle;
import vehicle.helperAttributes.Engine;
import vehicle.helperAttributes.Platform;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A Scania is a Truck with a platform
 */
public class Scania extends Truck {

    private final Platform platform;
    /**
     * Initiates a new Truck of the class Scania
     * @param enginePower Describes the engines power
     * @param color Describes the color of the Truck
     * @param grossWeightInTons Describes the Truck's gross weight in tons
     * @param platform Describes the object of the Truck's platform
     */
    public Scania(double enginePower, Color color, double grossWeightInTons,
                  Platform platform) {
        super(enginePower, color, "vehicle.Scania",
                true, grossWeightInTons, 2);
        this.platform = platform;
        try{
            image = ImageIO.read(new File("src/main/pics/Scania.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * gets the platform that scania has mounted
     * @return the object platform mounted on scania
     */
    public Platform getRamp() {
        return platform;
    }


    /**
     * Raises platform
     * @param angle decides how much to raise the platform
     */
    public void raisePlatform(int angle){
        platform.raise(angle);
        System.out.println("Platform raised");
    }

    /**
     * Lowers platform
     * @param angle decides how much to lower the platform
     */
    public void lowerPlatform(int angle){
        if(Math.round(getCurrentSpeed()) == 0){
            setCurrentSpeed(0);
            platform.lower(angle);
            System.out.println("Platform lowered");
        }
        else System.out.println("You need to stop before lowering platform");
    }

    /**
     * Moves the vehicle one of four directions in a 2d plane
     */
    @Override
    public void move(){
        if (platform.getAllowMotion()){
            super.move();}
        else{
            stopEngine();
            System.out.println("platform needs to be up before movement");
        }
    }
}
