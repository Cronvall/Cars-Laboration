import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import vehicle.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to (20 hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());

                if (x < 200) {
                    frame.drawPanel.moveit(x, y);
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
                }
                else{
                    System.out.println("Outside");
                }

            }
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

    void startEngines(){
        for(Car car : cars){
            car.startEngine();
        }
    }
    void stopEngines(){
        for(Car car : cars){
            car.stopEngine();
        }
    }

    //Getters
    public Timer getTimer(){
        return timer;
    }
}