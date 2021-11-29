package vehicle.helperAttributes;

/**
 * A ComplexPlatform can be raised, lowered and change its angle to the ground
 */
public class ComplexPlatform {

    private int angle;
    private boolean allowMotion;
    private boolean allowLoading;

    /**
     * Initiates a new object of the class ComplexPlatform
     */
    public ComplexPlatform(){
        this.angle = 0;
        this.allowMotion = true;
        this.allowLoading = false;
    }

    /**
     * Returns the ComplexPlatform's current angle to the ground
     * @return
     */
    public int getAngle(){
        return angle;
    }

    /**
     * Returns if vehicles is allowed to move
     * @return returns the boolean if allowed
     */
    public boolean getAllowMotion(){
        return allowMotion;
    }

    public boolean getAllowLoading(){
        return allowLoading;
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
     * Allows the Truck to move if the ComplexPlatform''s angle to the ground is 0
     * @param AllowMotion True(the angle is 0) or False(the angle is not 0)
     */
    private void setAllowMotion(boolean AllowMotion){
        allowMotion = AllowMotion;
    }

    private void setAllowLoading(boolean allowLoading){ this.allowLoading = allowLoading;}

    /**
     * Lowers the ComplexPlatform by a given amount of degrees
     * @param LoweringAngle The amount of degrees the ComplexPlatform will be lowered
     */
    public void lower(int LoweringAngle){
        if(LoweringAngle < 0){
            System.out.println("Only positive integers are valid!!");
        }
        else{
            int newAngle = angle - LoweringAngle;
            setAngle(Math.max(newAngle, 0));
        }
    }

    /**
     * Raises the ComplexPlatform by a given amount of degrees
     * @param raiseAngle The amount of degrees the ComplexPlatform will be raised
     */
    public void raise(int raiseAngle){
        if(raiseAngle < 0){
            System.out.println("Only positive integers are valid!!");
        }
        else{
            int newAngle = angle + raiseAngle;
            setAngle(Math.min(newAngle, 70));
        }
    }
}
