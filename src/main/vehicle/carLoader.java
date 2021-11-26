package vehicle;
import attributes.*;

import java.awt.geom.Point2D;

public class carLoader<T extends Vehicle> {

    private final Flatbed flatbed;
    private final Platform platform;
    private int slots;

    public carLoader(int slots, Flatbed.LoadingMethod loadingMethod){
        this.platform = new Platform();
        this.flatbed = new Flatbed(slots, loadingMethod);
        this.slots = slots;
    }

    public Platform getPlatform(){
        return platform;
    }

    public void loadCar(Car carToLoad, T vehicleToLoadOn){
        boolean allowedToLoad = isCarAllowedToLoad(carToLoad.getPosition(), vehicleToLoadOn.getPosition());

        if(allowedToLoad){
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
