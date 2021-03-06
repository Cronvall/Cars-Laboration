package vehicle;

import vehicle.helperAttributes.Flatbed;

public interface ILoadCar {

    /**
     * Loads a car on a vehicle
     * @param car that will be loaded on vehicle
     */
    void loadCar(Car car);

    /**
     * Removes a car from a vehicle
     */
    void loadOffCar();

    Car[] getCargo();

    Flatbed getFlatbed();

}
