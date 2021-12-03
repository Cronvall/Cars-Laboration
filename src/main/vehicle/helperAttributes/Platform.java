package vehicle.helperAttributes;

/**
 * A platform can be raised, lowered and change its angle to the ground
 */
public class Platform implements IPlatform{

    /**
     * The angle of the platform
     */
    private int angle;
    private boolean allowLoading;
    private boolean allowMotion;

    /**
     * Initiates a new object of the class ComplexPlatform
     * Ramp initiates as up, thereby movement is allowed and loading is not possible
     */
    public Platform(){
        this.allowMotion = true;
        this.angle = 0;
        this.allowLoading = false;
    }

    /**
     * Returns the ComplexPlatform's current angle to the ground
     * @return integer of angle
     */
    public int getAngle(){
        return angle;
    }

    /**
     * if vehicles is allowed to load
     * @return the boolean that decides if allowed to laod
     */
    public boolean getAllowLoading(){
        return allowLoading;
    }

    /**
     * Returns if vehicles is allowed to move
     * @return returns the boolean if allowed
     */
    @Override
    public boolean getAllowMotion(){return allowMotion;}

    /**
     * Allows the Truck to move if the ComplexPlatform''s angle to the ground is 0
     * @param allowMotion True(the angle is 0) or False(the angle is not 0)
     */
    private void setAllowMotion(boolean allowMotion){
        this.allowMotion = allowMotion;
    }


    /**
     * Changes the platform's angle to the ground
     * @param newAngle The desired angle
     */
    private void setAngle(int newAngle){
        if(newAngle >= 0 && newAngle <= 70)
            angle = newAngle;
        setAllowLoading(angle == 70);
        setAllowMotion(angle == 0);
    }

    /**
     * Decides if the vehicle is able to load
     * @param allowLoading boolean that is either true or false
     */
    private void setAllowLoading(boolean allowLoading){ this.allowLoading = allowLoading;}

    /**
     * Lowers the ComplexPlatform by a given amount of degrees
     * @param loweringAngle The amount of degrees the ComplexPlatform will be lowered
     */
    @Override
    public void lower(int loweringAngle){
        if(loweringAngle < 0){
            System.out.println("Only positive integers are valid!!");
        }
        else{
            int newAngle = angle + loweringAngle;
            setAngle(Math.min(newAngle, 70));
        }
    }

    /**
     * Raises the ComplexPlatform by a given amount of degrees
     * @param raiseAngle The amount of degrees the ComplexPlatform will be raised
     */
    @Override
    public void raise(int raiseAngle){
        if(raiseAngle < 0){
            System.out.println("Only positive integers are valid!!");
        }
        else{
            int newAngle = angle - raiseAngle;
            setAngle(Math.max(newAngle, 0));
        }
    }


}
