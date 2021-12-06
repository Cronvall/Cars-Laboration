package workshops;
import java.awt.*;
import java.util.ArrayList;
import vehicle.*;

/**
 * Workshop holds vehicles and have methods to maintain them
 * @param <T>
 */
public class WorkShop<T extends MotorVehicle> implements IWorkShop<T> {

    private final ArrayList<MotorVehicle> vehiclesInWorkshop = new ArrayList<>();
    private final Point gpsLocations;
    private final int workShopCapacity;

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
     * Inserts a vehicle to the workshop
     * @param vehicle to be added to the workshop
     */
    @Override
    public void addVehicle(T vehicle){
        checkCapacityExceed();
        addVehicleIfNotInWorkshop(vehicle);
    }

    /**
     * Control if workshop is within capacity, otherwise throw exception
     */
    private void checkCapacityExceed() {
        boolean exceedCapacity = vehiclesInWorkshop.size() < workShopCapacity;
        if (! exceedCapacity) {
            throw new IllegalArgumentException("Too many vehicles in the workshop");
        }
    }

    /**
     * Asserts that the vehicle is not already in the workshop
     * @param vehicle controls if the vehicle already is inside the workshop
     */
    private void addVehicleIfNotInWorkshop(T vehicle){
        if (vehicleInWorkShop(vehicle)){
            throw new IllegalArgumentException("MotorVehicle is already admitted");
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
    @Override
    public void removeVehicle(T vehicle){
        vehiclesInWorkshop.remove(vehicle);
    }

    /**
     * Changes the tires of the vehicle
     * @param motorVehicle vehicle to change tires of
     */
    @Override
    public void changeTires(T motorVehicle) {
        System.out.println("Tires changed!");
    }

    /**
     * Changes the oil-filter of the vehicle
     * @param motorVehicle to change oil-filter of
     */
    @Override
    public void changeOilFilter(T motorVehicle) {
        System.out.println("Oil filter changed!");
    }

    /**
     * Repairs the windshield of the vehicle
     * @param motorVehicle to repair windshield
     */
    @Override
    public void repairWindShield(T motorVehicle) {
        System.out.println("Windshield repaired!");
    }

}
