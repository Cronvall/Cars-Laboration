package workshops;
import java.awt.*;
import java.util.ArrayList;
import vehicle.*;

/**
 * Workshop holds vehicles and have methods to maintain them
 * @param <T>
 */
public class WorkShop<T extends Car> implements IWorkShop {

    private ArrayList<Vehicle> vehiclesInWorkshop = new ArrayList<>();
    private Point gpsLocations;
    private int workShopCapacity;

    /**
     * Initiates a new object of the class WorkShop
     * @param gpsLocations Describes the location of the workshop
     * @param capacity Describes how many vehicles the workshop can hold
     */
    public WorkShop(Point gpsLocations, int capacity){
        this.gpsLocations = gpsLocations;
        this.workShopCapacity = capacity;
    }

    /**
     * Returns a list with the vehicles in the workshop
     * @return
     */
    public ArrayList<Vehicle> getVehiclesInWorkshop() {
        return vehiclesInWorkshop;
    }

    /**
     * Inserts a vehicle to the end of the list
     * @param vehicle
     */
    public void addVehicle(T vehicle){
        willCapacityExceed(vehicle);
    }


    /**
     * If within capacity add a vehicle otherwise throw exception
     * @param vehicle to add
     */
    private void willCapacityExceed(T vehicle) {
        boolean exceedCapacity = vehiclesInWorkshop.size() < workShopCapacity;
        if (exceedCapacity) {
            controlIfInWorkShop(vehicle);
        }
        else{
            throw new IllegalArgumentException("Too many vehicles in the workshop");
        }
    }

    /**
     * Asserts that the vehicle is not already in the workshop
     * @param vehicle
     */
    private void controlIfInWorkShop(T vehicle){
        if (vehicleInWorkShop(vehicle)){
            System.out.println("Vehicle is already admitted");
        }
        else {
            vehiclesInWorkshop.add(vehicle);
        }
    }

    /**
     * Returns true if the vehicle is in the workshop
     * @param vehicle
     * @return
     */
    private boolean vehicleInWorkShop(T vehicle){
        if (vehiclesInWorkshop.contains(vehicle)){
            return true;
        }
        return false;
    }

    /**
     * Removes the specified element from the workshop
     * @param vehicle
     */
    public void removeVehicle(T vehicle){
        vehiclesInWorkshop.remove(vehicle);
    }

    @Override
    public void changeTires(Vehicle vehicle) {
        System.out.println("Tires changed!");
    }

    @Override
    public void changeOilFilter(Vehicle vehicle) {
        System.out.println("Oil filter changed!");
    }

    @Override
    public void repairWindShield(Vehicle vehicle) {
        System.out.println("Windshield repaired!");

    }

    @Override
    public void loosenBolts(Vehicle vehicle) {
        System.out.println("I'm in danger");
    }
}
