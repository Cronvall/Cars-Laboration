package vehicle;
import vehicle.helperAttributes.TurboEngine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A Saab95 is a Car with turbo deciding its speed factor
 */
public class Saab95 extends Car {

    private final TurboEngine engine;
    private BufferedImage image;
    /**
     * Initiates a new Car of the class Saab95
     * @param nrDoors Describes the Car's number of doors
     * @param col Describes the color of the Car
     */
    public Saab95(int nrDoors, double enginePower, Color col){
        super(nrDoors,enginePower ,col,"Saab-95");
        this.engine = new TurboEngine(enginePower);
        try{
            image = ImageIO.read(new File("src/main/pics/Volvo240.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     @Override
     public double speedFactor(){
        double turbo = 1;
        if(this.engine.getTurboOn()) {turbo = 10;}
        return getEnginePower() * 0.01 * turbo;
    }
    @Override
    public void stopEngine(){
        setCurrentSpeed(0);
        this.engine.stopEngine();;
    }

    public void turboOff(){
        this.engine.turboOff();
    }

    public void turboOn(){
        this.engine.turboOn();
    }

    public boolean getTurbo(){
        return this.engine.getTurboOn();
    }
}
