package vehicle.helperAttributes;

public class EasyPlatform{

    boolean platformUp;

    public EasyPlatform(){
        this.platformUp = true;
    }

    public boolean motionAllowed(){
        return platformUp;
    }
    public boolean loadingAllowed(){return !platformUp;}

    public void lower(){
        platformUp = false;
    }

    public void raise(){
        platformUp = true;
    }
}
