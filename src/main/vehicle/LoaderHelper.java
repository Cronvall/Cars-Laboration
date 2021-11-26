package vehicle;
import vehicle.helperAttributes.Flatbed;
import vehicle.helperAttributes.Platform;

import java.awt.geom.Point2D;

/**
 * A LoaderHelper refers to a Vehicle that carries cars on a flatbed
 * @param <T>
 */
public class LoaderHelper<T extends Vehicle> {

    private final Flatbed flatbed;
    private final Platform platform;
    private int slots;

    /**
     * Initiates a new Vehicle of the class LoaderHelper
     * @param slots Describes the amount of cars the LoaderHelper can carry
     * @param loadingMethod Describes what order the LoaderHelper offloads cars
     */
    public LoaderHelper(int slots, Flatbed.LoadingMethod loadingMethod){
        this.platform = new Platform();
        this.flatbed = new Flatbed(slots, loadingMethod);
        this.slots = slots;
    }

    public Platform getPlatform(){
        return platform;
    }

    /**
     * Loads a car onto the LoaderHelper
     * @param carToLoad Describes the car to be loaded
     * @param vehicleToLoadOn Refers to the LoaderHelper
     */
    public void loadCar(Car carToLoad, T vehicleToLoadOn) {
        boolean allowedToLoad = isCarAllowedToLoad(carToLoad.getPosition(), vehicleToLoadOn.getPosition());

        if (allowedToLoad) {
            loadCarAndUpdateCoordinate(carToLoad, vehicleToLoadOn);
        }
    }

    private boolean isCarAllowedToLoad(Point2D.Double carPosition, Point2D.Double loadVehicle){
        boolean withinLoadingRangeX = controlIfInLoadingRange(carPosition.getX(), loadVehicle.getY());
        boolean withinLoadingRangeY = controlIfInLoadingRange(carPosition.getY(), loadVehicle.getY());
        boolean allowedToLoad = withinLoadingRangeY && withinLoadingRangeX;
        return allowedToLoad;
    }

    private boolean controlIfInLoadingRange(double carCoordinate, double loaderCoordinate){
        double allowedLoadingDistance = 5.0;
        boolean insideCoordinate = Math.abs(carCoordinate - loaderCoordinate) < allowedLoadingDistance;
        return insideCoordinate;
    }

    private void loadCarAndUpdateCoordinate(Car carToLoad, T vehicleToLoadOn){
        flatbed.loadCar(carToLoad);
        updateLoadPosition(vehicleToLoadOn, carToLoad);
    }

    private void updateLoadPosition(T vehicleToLoadOn, Car car){
        double loadOffX = vehicleToLoadOn.getPosition().getX();
        double loadOffY = vehicleToLoadOn.getPosition().getY();
        Point2D.Double newPosition = new Point2D.Double(loadOffX, loadOffY);

        car.setPosition(newPosition);
    }

    /**
     * Offloads a car from the LoaderHelper
     */
    public void loadOffCar(){
        flatbed.removeCar();

    }

    /**
     * Returns an array displaying what cars are on the LoaderHelper
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
