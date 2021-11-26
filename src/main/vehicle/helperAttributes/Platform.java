package vehicle.helperAttributes;

/**
 * A Platform can be raised, lowered and change its angle to the ground
 */
public class Platform {

    private int angle;
    private boolean allowMotion;

    /**
     * Initiates a new object of the class Platform
     */
    public Platform(){
        angle = 0;
        allowMotion = true;
    }

    /**
     * Returns the Platform's current angle to the ground
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

    /**
     * Changes the platform's angle to the ground
     * @param newAngle The desired angle
     */
    private void setAngle(int newAngle){
        if(newAngle >= 0 && newAngle <= 70)
            angle = newAngle;

        setAllowMotion(angle == 0);
    }

    /**
     * Allows the Truck to move if the Platform''s angle to the ground is 0
     * @param AllowMotion True(the angle is 0) or False(the angle is not 0)
     */
    private void setAllowMotion(boolean AllowMotion){
        allowMotion = AllowMotion;
    }

    /**
     * Lowers the Platform by a given amount of degrees
     * @param LoweringAngle The amount of degrees the Platform will be lowered
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
     * Raises the Platform by a given amount of degrees
     * @param raiseAngle The amount of degrees the Platform will be raised
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
