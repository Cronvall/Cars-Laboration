import java.awt.*;

public class Volvo240 extends Car {

    private double trimFactor = 1.25;

    public Volvo240(int nrDoors, int enginePower, Color col){
        super(nrDoors,enginePower,col,"Volvo-240");
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
