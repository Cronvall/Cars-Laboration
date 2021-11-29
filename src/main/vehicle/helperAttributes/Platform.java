package vehicle.helperAttributes;


public abstract class Platform {

    private boolean allowMotion;

    /**
     * Platform constructor that is raised by default
     */
    protected Platform(){
        this.allowMotion = false;
    }

    /**
     * Returns if vehicles is allowed to move
     * @return returns the boolean if allowed
     */
    public boolean getAllowMotion(){return allowMotion;}

    /**
     * returns a boolean that says if the vehicle can load
     * @return boolean if loading is allowed
     */
    public boolean getAllowLoading(){return !allowMotion;}

    /**
     * Allows the Truck to move if the ComplexPlatform''s angle to the ground is 0
     * @param allowMotion True(the angle is 0) or False(the angle is not 0)
     */
    protected void setAllowMotion(boolean allowMotion){
        this.allowMotion = allowMotion;
    }

    /**
     * Raises the platform
     */
    public void raise(){
        this.allowMotion = true;
    }

    /**
     * Lowers the platform
     */
    public void lower(){
        this.allowMotion = false;
    }

}
