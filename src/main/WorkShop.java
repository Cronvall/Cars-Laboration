import java.awt.*;
import java.util.ArrayList;

public class WorkShop<T extends Vehicle> implements IWorkShop {

    private ArrayList<Vehicle> vehiclesInWorkshop;
    private Point gpsLocations;

    public WorkShop(Point gpsLocations, int capacity){
        this.gpsLocations = gpsLocations;
        this.vehiclesInWorkshop = new ArrayList<>(capacity);
    }

    public void addVehicle(T vehicle){
        controlIfInWorkShop(vehicle);
    }

    private void controlIfInWorkShop(T vehicle){
        if (!vehicleInWorkShop(vehicle)){
            System.out.println("Vehicle is already admitted");
        }
        else {
            vehiclesInWorkshop.add(vehicle);
        }
    }

    private boolean vehicleInWorkShop(T vehicle){
        if (vehiclesInWorkshop.contains(vehicle)){
            return false;
        }
        return true;
    }
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
