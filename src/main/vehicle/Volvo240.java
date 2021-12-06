package vehicle;

import vehicle.helperAttributes.Engine;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * A Volvo240 is a Car with a constant trim factor as its speed factor
 */
public class Volvo240 extends Car {

    private static BufferedImage image;
    /**
     * Initiates a new Car of the class Volvo240
     * @param nrDoors Describes the Car's number of doors
     * @param engine Describes the engine
     * @param col Describes the color of the Car
     */
    public Volvo240(int nrDoors, Engine engine, Color col){
        super(nrDoors,engine,col,"Volvo-240");
    }

    @Override
    public double speedFactor(){
        double trimFactor = this.getEngine().getTrimFactor();
        return this.getEnginePower() * 0.01 * trimFactor;
    }
}
