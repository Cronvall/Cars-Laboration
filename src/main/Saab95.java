import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(int nrDoors, double enginePower, Color col){
        super(nrDoors,enginePower,col,"Saab-95");
	    turboOn = false;
        stopEngine();
    }

    public void setTurboOn(){
	    turboOn = true;
    }
    public void setTurboOff(){
	    turboOn = false;
    }

     @Override
     public double speedFactor(){
        double turbo = 1;
        if(turboOn) {turbo = 1.3;}
        return getEnginePower() * 0.01 * turbo;
    }


    @Override
    public void stopEngine(){
        setCurrentSpeed(0);
        setTurboOff();
    }
}
