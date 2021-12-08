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
        System.out.println("Turbo is off!");
    }

    public void turboOn(){
        this.turboOn = true;
        System.out.println("Turbo is now on!");
    }
}
