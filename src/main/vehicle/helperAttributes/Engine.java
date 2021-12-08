package vehicle.helperAttributes;

public class Engine implements IEngine{

    private boolean engineRunning;
    private double trimFactor;
    private double enginePower;

    public Engine(double enginePower, double trimFactor){
        this.enginePower = enginePower;
        this.engineRunning = false;
        this.trimFactor = trimFactor;
    }

    public Engine(double enginePower){
        this.enginePower = enginePower;
        this.engineRunning = false;
        this.trimFactor = 1;
    }

    public boolean getEngineRunning(){
        return engineRunning;
    }
    public double getTrimFactor() {
        return trimFactor;
    }


    public double getEnginePower(){
        return enginePower;
    }

    @Override
    public void startEngine(){
        this.engineRunning = true;
    }

    @Override
    public void stopEngine(){
        this.engineRunning = false;
    }

    public boolean isRunning(){return this.engineRunning;}


}
