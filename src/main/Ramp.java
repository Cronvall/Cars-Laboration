public class Ramp {

    int angle;
    boolean allowMotion;

    public Ramp(){
        angle = 0;
        allowMotion = true;
    }

    public int getAngle(){
        return angle;
    }

    private void setAngle(int newAngle){
        if(newAngle >= 0 && newAngle <= 70)
            angle = newAngle;

        setAllowMotion(angle == 0);
    }

    private void setAllowMotion(boolean AllowMotion){
        allowMotion = AllowMotion;
    }

    protected void lower(int LoweringAngle){
        if(LoweringAngle < 0){
            System.out.println("Only positive integers are valid!!");
        }
        else{
            int newAngle = angle - LoweringAngle;
            setAngle(Math.max(newAngle, 0));
        }
    }

    protected void raise(int RaiseAngle){
        if(RaiseAngle < 0){
            System.out.println("Only positive integers are valid!!");
        }
        else{
            int newAngle = angle + RaiseAngle;
            setAngle(Math.min(newAngle, 70));
        }
    }
}
