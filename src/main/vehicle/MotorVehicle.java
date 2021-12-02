package vehicle;
import java.awt.*;
import java.awt.geom.Point2D;

/**
 * A movable MotorVehicle with methods for movement
 */
public abstract class MotorVehicle implements Movable {


    private final String modelName;
    private final double enginePower;
    private final Color color;
    private Point2D.Double position = new Point2D.Double();
    private double currentSpeed;
    private int currentDirectionInteger = 1; //Start value 1 = Forward positive Y-axis.
                                                             // Directions are integers: Y= 1, X = 2, -Y = 3, -X = 4
    private boolean loadedOnTransporter;

    /**
     * Initiates a new object of the class MotorVehicle
     * @param enginePower Describes the engine's power
     * @param col Describes the color of the vehicle
     * @param modelName Displays the name of the model(Volvo240, Saab95 etc.)
     */
    public MotorVehicle(double enginePower, Color col, String modelName){
        this.enginePower = enginePower;
        this.color = col;
        this.loadedOnTransporter = false;
        this.modelName = modelName;
        stopEngine();
    }

    //Get methods

    /**
     * Returns a boolean if vehicle is allowed to load
     */
    public boolean getLoadedOnTransporter(){
        return loadedOnTransporter;
    }

    /**
     * Returns the engine's power as a double
     * @return the engineer of the motorbike
     */
    public double getEnginePower(){return enginePower;}

    /**
     * Returns the vehicle's current speed as a double
     * @return the motor-vehicles current speed
     */
    public double getCurrentSpeed(){return currentSpeed;}

    /**
     * Returns the vehicle's current direction as an int between 1-4
     * @return the current direction of the vehicle
     */
    public double getDirection(){return currentDirectionInteger;}

    /**
     * Returns the vehicle's current position as a double in a 2D environment
     * @return the current position of the vehicle
     */
    public Point2D.Double getPosition(){
        return position;
    }

    /**
     * Returns the vehicle's model name as a String
     * @return the name of the model
     */
    public String getModelName(){return modelName;}

    /**
     * Returns the vehicle's color, type Color
     * @return the color of the vehicle
     */
    public Color getColor(){return color;}

    // Set methods
    /**
     * Changes the vehicle's speed if given newSpeed is within the accepted interval
     * @param newSpeed Defines the speed the vehicle will have after the method
     */
    protected void setCurrentSpeed(double newSpeed){
        if(newSpeed >= 0 && newSpeed <= getEnginePower())  //Accepted interval
            this.currentSpeed = newSpeed;
        else{
            this.changeSpeedIfOutsideInterval(newSpeed);
        }
    }

    /**
     * Changes the vehicle's position
     * @param newPosition Defines the new position the vehicle will take
     */
    protected void setPosition(Point2D.Double newPosition){
        position = new Point2D.Double(newPosition.getX(), newPosition.getY());
    }

    public void setLoadedOnTransporter(boolean loadedOnTransporter)
    {
        this.loadedOnTransporter = loadedOnTransporter;
    }

    /**
     * Will stop the vehicle if given speed is less than,
     * and increase its speed to maximum if given speed is greater than, the accepter interval
     * @param speed the speed being checked
     */
    private void changeSpeedIfOutsideInterval(double speed){
        System.out.print("Speed was not within required interval [0, 1].");
        if(speed < 0){
            System.out.println("Speed defaulted to 0");
            this.setCurrentSpeed(0);
        }
        else if(speed > getEnginePower()){
            System.out.println("Speed defaulted to engine power");
            this.setCurrentSpeed(getEnginePower());
        }
    }

    /**
     * Returns the factor that will alter any increment or decrement to the vehicle's speed depending on its model
     * @return the speed-factor of the vehicle
     */
    public abstract double speedFactor();

    // "Actions methods" for cars

    /**
     * Will increase the vehicle's speed if the amount is within the accepted interval
     * @param amount Describes by how much (approx. 1-100%) the speed should increase
     */
    public void gas(double amount){
        boolean withinSpeed = amount > 0 && amount <= 1;

        if(withinSpeed && !loadedOnTransporter ){
            incrementSpeed(amount);
        }
        else
            System.out.println("The amount of gas exceeds allowed interval of [0,1].");
    }

    /**
     * Increases the vehicle's current speed
     * @param amount Describes by how much (approx. 1-100%) the speed will increase
     */
    public  void incrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() + speedFactor() * amount;
        setCurrentSpeed(Math.min(newSpeed,getEnginePower()));
    }

    /**
     * Will decrease the vehicle's speed if the amount is within the accepted interval
     * @param amount Describes by how much (approx. 1-100%) the speed should decrease
     */
    public void brake(double amount){
        boolean withInSpeed = amount >= 0 && amount <= 1;
        if (withInSpeed && !loadedOnTransporter){
            decrementSpeed(amount);
        }
        else{
            System.out.println("The amount of braking is not within the allowed interval [0, 1].");
        }
    }

    /**
     * Decreases the vehicle's current speed
     * @param amount Describes by how much (approx. 1-100%) the speed will decrease
     */
    public void decrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        setCurrentSpeed(Math.max(newSpeed,0));
    }

    /**
     * Starts the engine, setting a low speed
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Stops the engine, and the vehicle
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    @Override
    public void turnLeft(){
        if(getDirection() == 1)
            currentDirectionInteger = 4;
        else
            currentDirectionInteger--;
    }

    @Override
    public void turnRight(){
        if(getDirection() == 4)
            currentDirectionInteger = 1;
        else
            currentDirectionInteger++;
    }

    /**
     * Moves the vehicle one of four directions in a 2d plane
     */
    @Override
    public void move(){
        switch (currentDirectionInteger) {
            //position[0] acts as X-axis and position[1] acts as Y-axis.
            //Forward
            case 1 -> this.position.setLocation(this.position.getX(), this.position.getY() + getCurrentSpeed());

            //Right
            case 2 -> this.position.setLocation(this.position.getX() + getCurrentSpeed(), this.position.getY());

            //Reverse
            case 3 -> this.position.setLocation(this.position.getX(), this.position.getY() - getCurrentSpeed());

            //Left
            case 4 -> this.position.setLocation(this.position.getX() - getCurrentSpeed(), this.position.getY());

            //In case of Invalid direction input.
            default -> System.out.println("Invalid direction: " + currentDirectionInteger + " (1-4 are valid).");
        }
    }

    @Override
    public String toString(){
        return(
                this.getClass().toString() +
                        ": {" +
                        "modelName "+ modelName +
                        ", enginePower: " + getEnginePower() +
                        ", Color: " + color +
                        ", Position: " + getPosition() +
                        ", Speed: " + getCurrentSpeed() +
                        ", DirectionInteger: " + getDirection() +
                        " }"
                );
    }

}