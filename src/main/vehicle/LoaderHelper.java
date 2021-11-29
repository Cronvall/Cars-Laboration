package vehicle;
import vehicle.helperAttributes.Flatbed;
import java.awt.geom.Point2D;

/**
 * A LoaderHelper refers to a Vehicle that carries cars on a flatbed
 * @param <T>
 */
public class LoaderHelper<T extends Vehicle> {

    private Flatbed ownerFlatbed;
    private Car currentVehicle;
    private Vehicle vehicleLoadingOn;
    /**
     * Initiates a new Vehicle of the class LoaderHelper
     * @param ownerFlatbed the flatbed to load on
     */
    public LoaderHelper(Flatbed ownerFlatbed){
        this.ownerFlatbed = ownerFlatbed;
    }

    /**
     * Loads a car onto the LoaderHelper
     * @param vehicleLoading Describes the vehicle to be loaded
     * @param vehicleToLoadOn Refers to the LoaderHelper
     */
    public void loadCar(Car vehicleLoading, T vehicleToLoadOn) {
        this.currentVehicle = vehicleLoading;
        this.vehicleLoadingOn = vehicleToLoadOn;

        validateIfSameVehicle();

    }

    /**
     * If vehicle tries to load itself, throws an exception
     */
    private void validateIfSameVehicle(){
        if (vehicleLoadingOn == currentVehicle){
            throw new IllegalArgumentException("Can't load the vehicle on itself!");
        }
        else{if (vehicleWithinLoadingRange()) {loadCarAndUpdateCoordinate();}}
    }

    /**
     * Controls if the vehicles is within the required range to each other
     * @return If within loading range returns true, otherwise false if you cannot load
     */
    private boolean vehicleWithinLoadingRange(){
        boolean xRange = rangeAllowed(currentVehicle.getPosition().getX(), vehicleLoadingOn.getPosition().getX());
        boolean yRange = rangeAllowed(currentVehicle.getPosition().getY(), vehicleLoadingOn.getPosition().getY());
        return (xRange && yRange);
    }

    /**
     * Utilizes the specified loading distance to control if loading is possible
     * @param vehicleCoordinate   Coordinate of the vehicle to load
     * @param loaderCoordinate    Coordinate of the vehicle loading on
     * @return Returns true if loading is possible, otherwise false
     */
    private boolean rangeAllowed(double vehicleCoordinate, double loaderCoordinate){
        double allowedLoadingDistance = 5.0;
        boolean insideCoordinate = Math.abs(vehicleCoordinate - loaderCoordinate) < allowedLoadingDistance;
        return insideCoordinate;
    }

    /**
     * Car gets added to flatbeds array of cargo
     */
    private void loadCarAndUpdateCoordinate(){
        ownerFlatbed.loadCar(currentVehicle);
        updateLoadPosition();
    }

    /**
     * Updates the position of the current vehicle to be the same as the vehicle loaded on top on
     */
    private void updateLoadPosition(){
        double loadOffX = vehicleLoadingOn.getPosition().getX();
        double loadOffY = vehicleLoadingOn.getPosition().getY();
        Point2D.Double newPosition = new Point2D.Double(loadOffX, loadOffY);

        currentVehicle.setPosition(newPosition);
    }

    /**
     * Offloads a car from the LoaderHelper
     */
    public void loadOffCar(){
        ownerFlatbed.removeCar();
    }

    /**
     * Returns an array displaying what cars are on the LoaderHelper
     * @return array of cars
     */
    public Vehicle[] getLoad(){
        return ownerFlatbed.getCarLoad();
    }

    //Used to move the cars that are stored in the transporter

    /**
     * Changes the position of the cars being carried
     * @param self is the owner object  used with syntax "this"
     */
    public void moveLoad(T self){
        for(int i  = 0; i < this.getLoad().length; i++){
            if(this.getLoad()[i] != null)
                this.getLoad()[i].setPosition(self.getPosition()); //Since the ferry hasn't moved it won't give the right update of position
        }
    }

    /**
     * Checks whether any cars are currently being carried
     * @return a boolean 
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
