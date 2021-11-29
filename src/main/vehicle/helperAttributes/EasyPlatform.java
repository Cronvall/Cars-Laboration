package vehicle.helperAttributes;

<<<<<<< Updated upstream
public class EasyPlatform{
=======
/**
 * A platform that can be up or down
 */
public class EasyPlatform {
>>>>>>> Stashed changes

    boolean platformUp;

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

<<<<<<< Updated upstream
    public void lower(){
        platformUp = false;
    }

    public void raise(){
=======
    /**
     * Lowers the platform
     */
    public void platformDown(){
        platformUp = false;
    }

    /**
     * Raises the platform
     */
    public void platformUp(){
>>>>>>> Stashed changes
        platformUp = true;
    }
}
