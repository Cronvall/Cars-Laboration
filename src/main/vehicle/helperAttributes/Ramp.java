package vehicle.helperAttributes;

/**
 * A ramp that can be either up or down
 */
public class Ramp implements IRamp {

    private boolean rampUp;

    /**
     * The ramp starts in a state where is it up
     */
    public Ramp(){
        this.rampUp = true;
    }


    @Override
    public boolean getAllowMotion(){
        return rampUp;
    }

    /**
     * Decides if the vehicle the ramp is mounted on can load
     * @return a boolean if allowed to load
     */
    public boolean getAllowLoading(){
        return !rampUp;
    }


    @Override
    public void raise(){
        this.rampUp = true;
    }


    @Override
    public void lower(){
        this.rampUp = false;
    }
}
