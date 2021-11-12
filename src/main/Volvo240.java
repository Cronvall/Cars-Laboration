import java.awt.*;

public class Volvo240 extends Car{

    //TODO We shouldn't use text as parameters. Use variables that are final. Maybe even static?
    // private static final int DEFAULT_NR_DOORS = 4;
    // private  final String DEFAULT_MODEL_NAME = "Volvo-240";
    private final int DEFAULT_NR_DOORS = 4;
    private final static double trimFactor = 1.25;
    
    public Volvo240(int _nrDoors, double _enginePower, Color col){
        super(_nrDoors,_enginePower,col,"Volvo-240");
        stopEngine();
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
