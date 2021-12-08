import vehicle.MotorVehicle;
import vehicle.Saab95;
import vehicle.Scania;
import java.util.ArrayList;
public class CarModel {

    ArrayList<MotorVehicle> vehicles;
    ArrayList<Observer> observers;
    int ticker;

    public CarModel() {
        ticker = 0;
        vehicles = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public ArrayList<MotorVehicle> getVehicles() {
        return vehicles;
    }

    public void addMotorvehicle(MotorVehicle vehicle) {
        vehicles.add(vehicle);
    }


    // Calls the gas method for each car once
    void gas ( int amt){
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
        int direction = 1;
        for (MotorVehicle vehicle : vehicles) {
            vehicle.move();
            int x = (int) Math.round(vehicle.getPosition().getX());
            int y = (int) Math.round(vehicle.getPosition().getY());

            //view.drawPanel.moveit(x, y * direction, vehicle);

            if (vehicle.getPosition().getY() >= 500 || vehicle.getPosition().getY() <= 0 && vehicle.isRunning()) {
                vehicle.turnLeft(); // Turns 180 degrees
                vehicle.turnLeft();
                vehicle.move(); //Move so that we don't get stuck in a position of 500 or 0
                vehicle.stopEngine();
                vehicle.startEngine();
            }
            if (vehicle.getDirection() == 1) {
                direction = 1;
            } else if (vehicle.getDirection() == 4) {
                direction = -1;
            }
        }
    }


    private void update() {
        movementUpdate();
        for (Observer observer: observers){
            observer.update();
        }
    }

    public void start(){
        try {
            while (true) {
                Thread.sleep(16);
                System.out.println("Model Updated!");
                update();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}