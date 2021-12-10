package vehicle;
import vehicle.helperAttributes.Flatbed;
import java.awt.geom.Point2D;

/**
 * A LoaderHelper refers to a MotorVehicle that carries cars on a flatbed
 */
public class LoaderHelper{
    private MotorVehicle[] cargo;
    /**
     * Loads a car onto the LoaderHelper
     * @param car Describes the vehicle to be loaded
     * @param carTransporter Refers to the LoaderHelper
     */
     public void loadCar(Car car, MotorVehicle carTransporter) {
        validateIfSameVehicle(car, carTransporter);

        if (vehiclesWithinLoadingRange(car, carTransporter) && !vehicleLoadedOnTransporter(car)) {
            updateVehicleStatus(car, carTransporter);}
    }

    /**
     * If vehicle tries to load itself, throws an exception
     */
    private void validateIfSameVehicle(Car car, MotorVehicle carTransporter){
        boolean sameVehicle = car == carTransporter;
        if (sameVehicle) {throw new IllegalArgumentException("Can't load the vehicle on itself!");}
    }

    /**
     * Controls if the vehicle is already loaded on a flatbed
     * @return boolean
     */
    private boolean vehicleLoadedOnTransporter(Car car){
       return car.getLoadedOnTransporter();
    }

    /**
     * Controls if the vehicles is within the required range to each other
     * @return If within loading range returns true, otherwise false if you cannot load
     */
    private boolean vehiclesWithinLoadingRange(Car car, MotorVehicle carTransporter){
        boolean xRange = rangeAllowed(car.getPosition().getX(), carTransporter.getPosition().getX());
        boolean yRange = rangeAllowed(car.getPosition().getY(), carTransporter.getPosition().getY());
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
    private void updateVehicleStatus(Car car, MotorVehicle carTransporter){
        car.setLoadedOnTransporter(true);
        newLoadPosition(car, carTransporter);
        loadTheCar((ILoadCar) carTransporter, car);


    }
    private void loadTheCar(ILoadCar carTransporter, Car car){
        carTransporter.getFlatbed().loadCar(car);
    }

    /**
     * Updates the position of the current vehicle to be the same as the vehicle loaded on top on
     */
    private void newLoadPosition(Car car, MotorVehicle carTransporter){
        double loadOffX = carTransporter.getX();
        double loadOffY = carTransporter.getY();
        Point2D.Double newPosition = new Point2D.Double(loadOffX, loadOffY);

        car.setPosition(newPosition);
    }

    /**
     * Offloads a car from the LoaderHelper
     */
    public void loadOffCar(Flatbed ownerFlatbed){
        ownerFlatbed.removeCar();
    }

    /**
     * Returns an array displaying what cars are on the LoaderHelper
     * @return array of cars
     */
    public Car[] getLoad(Flatbed ownerFlatbed){
        return (Car[]) ownerFlatbed.getCarLoad();
    }

    /**
     * Changes the position of the cars being carried
     */
    public  void moveLoad(Car[] cargo, MotorVehicle transporter ){

        for(int i  = 0; i < cargo.length; i++){
            if(cargo[i] != null)
                cargo[i].setPosition(transporter.getPosition()); //Since the ferry hasn't moved it won't give the right update of position
        }
    }



    /**
     * Checks whether any cars are currently being carried
     * @return a boolean 
     */
    public  boolean isEmpty(Car[] cargo){
        Car[] flatbedLoad = cargo;
        boolean result = true;
        for(int loadIndex = 0; loadIndex < flatbedLoad.length; loadIndex++){
            if(flatbedLoad[loadIndex] != null){
                result = false;
                break;
            }
        }
        return result;
    }


}
