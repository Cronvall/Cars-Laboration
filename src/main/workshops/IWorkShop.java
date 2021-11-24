package workshops;

import vehicle.Vehicle;

public interface IWorkShop<T extends Vehicle> {

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

    /**
     * Loosens the tires bolts
     * @param vehicle
     */
    void loosenBolts(T vehicle);
}
