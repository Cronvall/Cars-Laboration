package attributes;

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
     * Changes the platform's angle to the ground
     * @param newAngle The desired angle
     */
    private void setAngle(int newAngle){
        if(newAngle >= 0 && newAngle <= 70)
            angle = newAngle;

        setAllowMotion(angle == 0);
    }

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
     * @param RaiseAngle The amount of degrees the Platform will be raised
     */
    public void raise(int RaiseAngle){
        if(RaiseAngle < 0){
            System.out.println("Only positive integers are valid!!");
        }
        else{
            int newAngle = angle + RaiseAngle;
            setAngle(Math.min(newAngle, 70));
        }
    }
}
