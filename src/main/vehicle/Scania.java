package vehicle;
import vehicle.helperAttributes.Engine;
import vehicle.helperAttributes.Platform;

import java.awt.*;

/**
 * A Scania is a Truck with a platform
 */
public class Scania extends Truck {

    private final Platform platform;

    /**
     * Initiates a new Truck of the class Scania
     * @param engine Describes the engine
     * @param color Describes the color of the Truck
     * @param grossWeightInTons Describes the Truck's gross weight in tons
     * @param platform Describes the object of the Truck's platform
     */
    public Scania(Engine engine, Color color, double grossWeightInTons,
                  Platform platform) {
        super(engine, color, "vehicle.Scania",
                true, grossWeightInTons, 2);
        this.platform = platform;
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
    }

    /**
     * Lowers platform
     * @param angle decides how much to lower the platform
     */
    public void lowerPlatform(int angle){
        platform.lower(angle);
    }

    /**
     * Moves the vehicle one of four directions in a 2d plane
     */
    @Override
    public void move(){
        if (platform.getAllowMotion()){
            super.move();}
        else{
            throw new IllegalArgumentException("platform is down!");}
    }
}
