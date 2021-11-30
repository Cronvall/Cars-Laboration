package vehicle.helperAttributes;

/**
 * A ramp that can be either up or down
 */
public class Ramp {

    private boolean rampUp;

    /**
     * The ramp starts in a state where is it up
     */
    public Ramp(){
        this.rampUp = true;
    }

    /**
     * Decides if the vehicle the ramp is mounted on can move
     * @return a boolean that describes if it's allowed to move
     */
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

    /**
     * Raises the ramp
     */
    public void raise(){
        this.rampUp = true;
    }

    /**
     * Lowers the ramp
     */
    public void lower(){
        this.rampUp = false;
    }
}
