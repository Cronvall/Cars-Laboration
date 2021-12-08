package vehicle.helperAttributes;

public class TurboEngine extends Engine{

    private boolean turboOn;

    public TurboEngine(double enginePower){
        super(enginePower);
        this.turboOn = false;
    }

    @Override
    public void stopEngine(){
        super.stopEngine();
        this.turboOn = false;
    }


    public boolean getTurboOn(){
        return this.turboOn;
    }

    public void turboOff(){
        this.turboOn = false;
        throw new IllegalArgumentException("Turbo is off!");
    }

    public void turboOn(){
        this.turboOn = true;
        throw new IllegalArgumentException("Turbo is now on!");
    }
}
