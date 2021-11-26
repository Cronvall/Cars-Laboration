package vehicle.helperAttributes;

public class EasyPlatform {

    boolean platformUp;

    public EasyPlatform(){
        this.platformUp = true;
    }

    public boolean motionAllowed(){
        return platformUp;
    }

    public void rampDown(){
        platformUp = false;
    }

    public void rampUp(){
        platformUp = true;
    }
}
