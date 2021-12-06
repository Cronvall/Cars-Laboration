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
    public Saab95(int nrDoors, TurboEngine engine, Color col){
        super(nrDoors,engine,col,"Saab-95");
        this.engine = engine;
        try{
            image = ImageIO.read(new File("src/main/vehicle.pics/Saab95.jpg"));
        }
        catch (IOException e){
            System.out.println("Faulty read of image in Saab!");
        }
    }

     @Override
     public double speedFactor(){
        double turbo = 1;
        if(this.engine.getTurboOn()) {turbo = 1.3;}
        return getEnginePower() * 0.01 * turbo;
    }
    @Override
    public void stopEngine(){
        setCurrentSpeed(0);
        this.getEngine().stopEngine();;
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
