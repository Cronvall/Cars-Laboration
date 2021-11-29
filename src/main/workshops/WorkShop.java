package workshops;
import java.awt.*;
import java.util.ArrayList;
import vehicle.*;

/**
 * Workshop holds vehicles and have methods to maintain them
 * @param <T>
 */
public class WorkShop<T extends MotorVehicle> implements IWorkShop {

    private ArrayList<MotorVehicle> vehiclesInWorkshop = new ArrayList<>();
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
     * @return returns a list of the current vehicles in the workshop
     */
    public ArrayList<MotorVehicle> getVehiclesInWorkshop() {
        return vehiclesInWorkshop;
    }

    /**
     * Inserts a vehicle to the end of the list
     * @param vehicle to be added to the workshop
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
     * @param vehicle controls if the vehicle already is inside the workshop
     */
    private void controlIfInWorkShop(T vehicle){
        if (vehicleInWorkShop(vehicle)){
            System.out.println("MotorVehicle is already admitted");
        }
        else {
            vehiclesInWorkshop.add(vehicle);
        }
    }

    /**
     * Returns true if the vehicle is in the workshop
     * @param vehicle vehicle to control if inside workshop
     * @return boolean if vehicle is inside vehicle
     */
    private boolean vehicleInWorkShop(T vehicle){
        return vehiclesInWorkshop.contains(vehicle);
    }

    /**
     * Removes the specified element from the workshop
     * @param vehicle to be removed from the workshop
     */
    public void removeVehicle(T vehicle){
        vehiclesInWorkshop.remove(vehicle);
    }

    @Override
    public void changeTires(MotorVehicle motorVehicle) {
        System.out.println("Tires changed!");
    }

    @Override
    public void changeOilFilter(MotorVehicle motorVehicle) {
        System.out.println("Oil filter changed!");
    }

    @Override
    public void repairWindShield(MotorVehicle motorVehicle) {
        System.out.println("Windshield repaired!");

    }

}
