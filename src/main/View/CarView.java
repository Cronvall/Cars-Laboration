package View;

import vehicle.MotorVehicle;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame implements Observer {

    private static final int X = 800;
    private static final int Y = 800;

    private int gasAmount = 0;

    // The controller member
    private CarModel model;
    private RepaintPanel vehicleDrawer;

    private DrawPanel drawPanel;

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();

    JLabel gasBrakeLabel = new JLabel("Amount of gas/brake");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");


    // Constructor
    public CarView(String framename,  CarModel model ){
        this.model = model;
        this.vehicleDrawer = new RepaintPanel(this.model);
        drawPanel = new DrawPanel(X, Y - 240, new RepaintPanel(model));
        initComponents(framename);
    }


    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        //The gas & brake spinner
        SpinnerModel PaceKoefficentSpinnerModel =new SpinnerNumberModel(
                0, 0, 100,1);
        gasSpinner = new JSpinner(PaceKoefficentSpinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }});

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasBrakeLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void update(){
        drawPanel.repaint();
    }

    public int getGasAmount(){
        return gasAmount;
    }


    private static final class DrawPanel extends JPanel{

        RepaintPanel vehicleDrawer;

        // Initializes the panel and reads the images
        public DrawPanel(int x, int y, RepaintPanel vehicleDrawer){
            this.vehicleDrawer = vehicleDrawer;
            this.setDoubleBuffered(true);
            this.setPreferredSize(new Dimension(x, y));
            this.setBackground(Color.green);
        }

        // This method is called each time the panel updates/refreshes/repaints itself

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            vehicleDrawer.paintComponent(g);
        }
    }


    private static final class RepaintPanel extends JPanel {
        CarModel model;
        public RepaintPanel(CarModel model){
            this.model = model;
        }

        @Override
        protected void paintComponent(Graphics g){
            for(int i = 0; i < model.getVehicles().size(); i++){
                MotorVehicle vehicle = model.getVehicles().get(i);
                g.drawImage(vehicle.getImage(),(int)vehicle.getY(),150 * i, null);
            }
        }
    }


}