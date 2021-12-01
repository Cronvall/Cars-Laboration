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
    
    /**
     * Returns if vehicles is allowed to load
     * @return returns the boolean if allowed loading
     */
    @Override
    public boolean getAllowLoading(){ return !rampUp;}

    /**
     * Returns if vehicles is allowed to move
     * @return  the boolean if moving is allowed
     */
    @Override
    public boolean getAllowMotion(){
        return rampUp;
    }

    /**
     * Raises the ramp
     */
    @Override
    public void raise(){
        this.rampUp = true;
    }

    /**
     * Lowers the ramp
     */
    @Override
    public void lower(){
        this.rampUp = false;
    }
}
