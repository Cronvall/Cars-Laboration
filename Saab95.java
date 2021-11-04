import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(int _nrDoors, double _enginePower, Color col){
        super(_nrDoors,_enginePower,col,"Saab-95");
	    turboOn = false;
        stopEngine();
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    @Override
    public void stopEngine(){
        currentSpeed = 0;
        turboOn = false;
    }
}
