package vehicle;
import attributes.*;
import java.awt.geom.Point2D;

public class carLoader<T extends Vehicle> {

    private final Flatbed flatbed;
    private final Platform platform;
    int slots;

    public carLoader(int slots, Flatbed.LoadingMethod loadingMethod){
        platform = new Platform();
        flatbed = new Flatbed(slots, loadingMethod);
        this.slots = slots;
    }

    public Platform getPlatform(){
        return platform;
    }

    //Functionality
    public void loadCar(Car car, T self){
        Point2D.Double carPosition = car.getPosition();

        //Översikt för konstanten 10 då den eventuellt kan vara för stor / liten.
        boolean statementX = self.getPosition().getX() - 10 < carPosition.getX() && carPosition.getX()< self.getPosition().getX() + 10;
        boolean statementY = self.getPosition().getY() - 10 < carPosition.getY() && carPosition.getY()< self.getPosition().getY() + 10;
        if(statementX && statementY){
            car.setPosition(self.getPosition());
            flatbed.loadCar(car);
        }
    }

    public void loadOffCar(){
        flatbed.removeCar();
    }

    public Car[] getLoad(){
        return flatbed.getCarLoad();
    }

    //Used to move the cars that are stored in the transporter
    void moveLoad(T self){
        for(int i  = 0; i < this.getLoad().length; i++){
            if(this.getLoad()[i] != null)
                this.getLoad()[i].setPosition(self.getPosition());
        }
    }

    public boolean isEmpty(){
        boolean result = true;
        for(int i = 0; i < this.getLoad().length; i++){
            if(this.getLoad()[i] != null)
                result = false;
        }
        return result;
    }
}
