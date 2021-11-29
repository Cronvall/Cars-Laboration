package workshops;

import vehicle.MotorVehicle;

public interface IWorkShop<T extends MotorVehicle> {

    /**
     * Changes the tires of the vehicle
     * @param vehicle
     */
    void changeTires(T vehicle);

    /**
     * Changes the oil-filter of the vehicle
     * @param vehicle
     */
    void changeOilFilter(T vehicle);

    /**
     * Repairs the windshield of the vehicle
     * @param vehicle
     */
    void repairWindShield(T vehicle);


}
