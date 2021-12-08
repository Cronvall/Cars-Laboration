import vehicle.Car;
import vehicle.Saab95;
import vehicle.Scania;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CarModel {

    ArrayList<BufferedImage> vehiclePictures = new ArrayList<>();
    ArrayList<Car> cars = new ArrayList<>();

    public CarModel(){
    }

    void startEngines() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars ) {
            car.gas(gas);
        }
    }

    //Calls the brake method for each car once
    void brake(int amount){
        double brake = ((double) amount) / 100;
        for(Car car: cars){
            car.brake(brake);
        }
    }

    //Turbo management for SAAB
    void turboOn(){
        for(Car car: cars){
            if (car.getClass() == Saab95.class){
                ((Saab95) car).turboOn();
            }
        }
    }
    void turboOff(){
        for(Car car: cars){
            if (car.getClass() == Saab95.class){
                ((Saab95) car).turboOff();
            }
        }
    }

    void liftRamp(){
        for(Car car: cars){
            if(car.getClass() == Scania.class){
                ((Scania)car).raisePlatform(70);
            }
        }
    }
    void lowerRamp(){
        for(Car car: cars){
            if(car.getClass() == Scania.class){
                ((Scania)car).lowerPlatform(70);
            }
        }
    }

    void stopEngines(){
        for(Car car : cars){
            car.stopEngine();
        }
    }



}
