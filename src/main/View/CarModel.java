package View;
import vehicle.MotorVehicle;
import vehicle.Saab95;
import vehicle.Scania;
import java.util.ArrayList;

public class CarModel {

    private ArrayList<MotorVehicle> vehicles;
    private ArrayList<Observer> observerSubscriptions;

    CarModel() {

        vehicles = new ArrayList<>();
        observerSubscriptions = new ArrayList<>();
    }

    ArrayList<MotorVehicle> getVehicles() {
        return vehicles;
    }
    void observerSubscribe(Observer observer) {
        observerSubscriptions.add(observer);
    }
    void addMotorvehicle(MotorVehicle vehicle) {
        vehicles.add(vehicle);
    }



    // Calls the gas method for each car once
    void gas (int amt){
        double g = ((double) amt) / 100;
        for (MotorVehicle vehicle : vehicles) {
            vehicle.gas(g);
        }
    }

    //Calls the brake method for each car once
    void brake( int amt){
        double b = ((double) amt) / 100;
        for (MotorVehicle vehicle : vehicles) {
            vehicle.brake(b);
        }
    }

    //Turbo management for SAAB
    void turboOn () {
        for (MotorVehicle vehicle : vehicles) {
            if (vehicle.getClass() == Saab95.class) {
                ((Saab95) vehicle).turboOn();
            }
        }
    }

    void turboOff () {
        for (MotorVehicle vehicle : vehicles) {
            if (vehicle.getClass() == Saab95.class) {
                ((Saab95) vehicle).turboOff();
            }
        }
    }

    void liftRamp () {
        for (MotorVehicle vehicle : vehicles) {
            if (vehicle.getClass() == Scania.class) {
                ((Scania) vehicle).raisePlatform(70);
            }
        }
    }

    void lowerRamp () {
        for (MotorVehicle vehicle : vehicles) {
            if (vehicle.getClass() == Scania.class) {
                ((Scania) vehicle).lowerPlatform(70);
            }
        }
    }

    void startEngines () {
        for (MotorVehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    void stopEngines () {
        for (MotorVehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    private void movementUpdate(){
        for (MotorVehicle vehicle : vehicles) {
            vehicle.move();

            if (vehicle.getPosition().getY() >= 686 || vehicle.getPosition().getY() < 0 && vehicle.isRunning()) {
                makeUturn(vehicle);
            }



        }
    }

    private void makeUturn(MotorVehicle vehicle){
        vehicle.turnLeft();
        vehicle.turnLeft();
        vehicle.move(); //Move so that we don't get stuck in a position of 500 or 0
        vehicle.stopEngine();
        vehicle.startEngine();
    }


    private void update() {
        movementUpdate();
        for (Observer observer: observerSubscriptions){
            observer.update();
        }
    }

    public void start(){
        try {
            while (true) {
                Thread.sleep(25);
                update();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}