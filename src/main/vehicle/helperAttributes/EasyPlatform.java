package vehicle.helperAttributes;

/**
 * A platform that can be up or down
 */
public class EasyPlatform {

    private boolean platformUp;

    /**
     * The platform starts up
     */
    public EasyPlatform(){
        this.platformUp = true;
    }

    /**
     * If platform is up the vehicle may move, otherwise it can not move
     * @return boolean to decide if vehicle platform mounted on can move
     */
    public boolean motionAllowed(){
        return platformUp;
    }
    public boolean loadingAllowed(){return !platformUp;}

    /**
     * Lowers the platform
     */
    public void lower(){
        platformUp = false;
    }

    /**
     * Raises the platform
     */
    public void raise(){
        platformUp = true;
    }
}
