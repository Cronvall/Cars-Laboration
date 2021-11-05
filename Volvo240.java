import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;
    
    public Volvo240(int nrDoors, double enginePower, Color col, String mName){
        super(nrDoors,enginePower,col,mName);
        stopEngine();
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public void incrementSpeed(double amount){
        double minSpeed = getCurrentSpeed() + speedFactor() * amount;
        setCurrentSpeed(Math.min(minSpeed,getEnginePower()));
    }

    @Override
    public void decrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        setCurrentSpeed(Math.max(newSpeed,0));
    }

}
