package vehicle;
import attributes.*;
import java.awt.geom.Point2D;

/**
 * A carLoader refers to a Vehicle that carries cars on a flatbed
 * @param <T>
 */
public class carLoader<T extends Vehicle> {

    private final Flatbed flatbed;
    private final Platform platform;
    int slots;

    /**
     * Initiates a new Vehicle of the class carLoader
     * @param slots Describes the amount of cars the carLoader can carry
     * @param loadingMethod Describes what order the carLoader offloads cars
     */
    public carLoader(int slots, Flatbed.LoadingMethod loadingMethod){
        platform = new Platform();
        flatbed = new Flatbed(slots, loadingMethod);
        this.slots = slots;
    }

    public Platform getPlatform(){
        return platform;
    }

    //Functionality

    /**
     * Loads a car onto the carLoader
     * @param car Describes the car to be loaded
     * @param self Refers to the carLoader
     */
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

    /**
     * Offloads a car from the carLoader
     */
    public void loadOffCar(){
        flatbed.removeCar();
    }

    /**
     * Returns an array displaying what cars are on the carLoader
     * @return
     */
    public Car[] getLoad(){
        return flatbed.getCarLoad();
    }

    //Used to move the cars that are stored in the transporter

    /**
     * Changes the position of the cars being carried
     * @param self
     */
    void moveLoad(T self){
        for(int i  = 0; i < this.getLoad().length; i++){
            if(this.getLoad()[i] != null)
                this.getLoad()[i].setPosition(self.getPosition()); //Since the ferry hasn't moved it won't give the right update of position
        }
    }

    /**
     * Checks whether any cars are currently being carried
     * @return
     */
    public boolean isEmpty(){
        boolean result = true;
        for(int i = 0; i < this.getLoad().length; i++){
            if(this.getLoad()[i] != null){
                result = false;
                break;
            }
        }
        return result;
    }
}
