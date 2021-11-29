package vehicle.helperAttributes;

/**
 * A ComplexPlatform can be raised, lowered and change its angle to the ground
 */
<<<<<<< Updated upstream:src/main/vehicle/helperAttributes/Platform.java
public class Platform{
=======
public class ComplexPlatform {
>>>>>>> Stashed changes:src/main/vehicle/helperAttributes/ComplexPlatform.java

    private int angle;
    private boolean allowMotion;
    private boolean allowLoading;

    /**
     * Initiates a new object of the class ComplexPlatform
     */
    public ComplexPlatform(){
        angle = 0;
        allowMotion = true;
        allowLoading = false;
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

    /**
     * Returns if you are allowed to (un)load a car
     * @return returns the boolean with above condition
     */
    public boolean getAllowLoading(){return allowLoading;}

    /**
     * Changes the platform's angle to the ground
     * @param newAngle The desired angle
     */
    private void setAngle(int newAngle){
        if(newAngle >= 0 && newAngle <= 70)
            angle = newAngle;

        setAllowMotion(angle == 0);
        setAllowLoading(angle == 70);
    }

    /**
     * Allows the Truck to move if the ComplexPlatform''s angle to the ground is 0
     * @param AllowMotion True(the angle is 0) or False(the angle is not 0)
     */
    private void setAllowMotion(boolean AllowMotion){
        allowMotion = AllowMotion;
    }

    /**
<<<<<<< Updated upstream:src/main/vehicle/helperAttributes/Platform.java
     * Allows the Truck to (un)load if the Platform''s angle to the ground is 70
     * @param AllowLoading True(the angle is 70) or False(the angle is not 70)
     */
    private void setAllowLoading(boolean AllowLoading){allowLoading = AllowLoading;}

    /**
     * Lowers the Platform by a given amount of degrees
     * @param LoweringAngle The amount of degrees the Platform will be lowered
=======
     * Lowers the ComplexPlatform by a given amount of degrees
     * @param LoweringAngle The amount of degrees the ComplexPlatform will be lowered
>>>>>>> Stashed changes:src/main/vehicle/helperAttributes/ComplexPlatform.java
     */
    public void lower(int LoweringAngle){
        if(LoweringAngle < 0){
            System.out.println("Only positive integers are valid!!");
        }
        else{
            int newAngle = angle + LoweringAngle;
            setAngle(Math.min(newAngle, 70));
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
            int newAngle = angle - raiseAngle;
            setAngle(Math.max(newAngle, 0));
        }
    }
}
