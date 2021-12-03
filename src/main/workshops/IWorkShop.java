package workshops;

import vehicle.Car;
import vehicle.MotorVehicle;

public interface IWorkShop<T extends MotorVehicle> {

    // TODO fix that if can have this method
    //void addVehicle(Car vehicle);

    /**
     * Changes the tires of the vehicle
     * @param vehicle vehicle to change tires of
     */
    void changeTires(T vehicle);

    /**
     * Changes the oil-filter of the vehicle
     * @param vehicle to change oil-filter of
     */
    void changeOilFilter(T vehicle);

    /**
     * Repairs the windshield of the vehicle
     * @param vehicle to repair windshield
     */
    void repairWindShield(T vehicle);


}
