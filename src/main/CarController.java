import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    CarModel model;

    // The frame that represents this instance View of the MVC pattern
    CarView view;


    int gasAmount = 0;

    // The delay (ms) corresponds to (20 hz)
    private final int delay = 10;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());


    public CarController(CarModel model, CarView view){
        this.model = model;
        this.view = view;

        setListeners();
    }

    private void setListeners(){
        //The gas & brake spinner
        SpinnerModel PaceKoefficentSpinnerModel =new SpinnerNumberModel(
                0, 0, 100,1);
        view.gasSpinner = new JSpinner(PaceKoefficentSpinnerModel);
        view.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }});

        //Engine management
        view.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.startEngines();
            }});


        //Pace management
        view.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas(gasAmount);
            }
        });

        view.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brake(gasAmount);
            }
        });

        //Turbo management
        view.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.turboOn();
            }
        });

        view.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.turboOff();
            }
        });

        view.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.stopEngines();
            }
        });

        //Platform management
        view.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.liftRamp();
            }
        });
        view.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.lowerRamp();
            }
        });

    }



    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int direction = 1;

            for (MotorVehicle car : model.getVehicles()) {
                car.move();
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());

                view.drawPanel.moveit(x, y * direction, car);

                if(car.getPosition().getY() >= 500 || car.getPosition().getY() <= 0 && car.isRunning()){
                    car.turnLeft(); // Turns 180 degrees
                    car.turnLeft();
                    car.move(); //Move so that we don't get stuck in a position of 500 or 0
                    car.stopEngine();
                    car.startEngine();
                }
                if(car.getDirection() == 1){
                    direction = 1;
                }
                else if(car.getDirection() == 4) {
                    direction = -1;
                }

                // repaint() calls the paintComponent method of the panel
                view.drawPanel.repaint();
                //frame.drawPanel.drawCars(frame.getGraphics(), car);
            }
        }
    }




    //Getters
    public Timer getTimer(){
        return timer;
    }

    public ArrayList<MotorVehicle> getCars(){
        return model.getVehicles();
    }








}
