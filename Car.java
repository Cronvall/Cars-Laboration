import java.awt.*;
import java.util.Vector;

public abstract class Car implements Vehicle{
    //Variables
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Point position = new Point();
    private double currentSpeed;
    private int currentDirectionInteger = 1; //Start value 1 = Forward positive Y-axis


    //Constructor
    public Car(int _nrDoors, double _enginePower, Color col, String _mName){
        nrDoors = _nrDoors;
        enginePower = _enginePower;
        color = col;
        modelName = _mName;
    }

    //Methods
    public int getNrDoors() { return nrDoors;}
    public double getEnginePower(){return enginePower;}
    public Color getColor(){return color;}
    public double getCurrentSpeed(){return currentSpeed;}
    public double getDirection(){return currentDirectionInteger;}
    public Point getPosition(){
        return position;
    }

    // Set methods
    protected void setCurrentSpeed(double speed){
        if(speed >= 0 && speed < getEnginePower())
            currentSpeed = speed;
        else{
            System.out.print("Speed was not within required intervall [0, 1].");
        }
    }
    public void setColor(Color clr){color = clr;}


    // Speed-factor
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

    // "Actions methods" for cars
    @Override
    public void gas(double amount){
        if(amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
        else{
            System.out.println("The amount of gas exceeds allowed interval of [0,1].");
        }

    }
    @Override
    public void brake(double amount){
        if (amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        }
        else{
            System.out.println("The amount of braking is not within the allowed interval [0, 1].");
        }

    }

    //Overriding methods
    @Override
    public void incrementSpeed(double amount){
        double newSpeed = getEnginePower() * 0.01 + getCurrentSpeed();
        setCurrentSpeed(newSpeed);
    }
    public void decrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() - speedFactor();
        setCurrentSpeed(newSpeed);
    }
    @Override
    public void startEngine() {
        currentSpeed = 0.1;
    }
    @Override
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

    @Override
    public void move(){
        switch (currentDirectionInteger) {
            //position[0] acts as X-axis and position[1] acts as Y-axis.
            //Forward
            case 1 -> position.y += getCurrentSpeed();
            //Right
            case 2 -> position.x += getCurrentSpeed();
            //Reverse
            case 3 -> position.y -= getCurrentSpeed();
            //Left
            case 4 -> position.x -= getCurrentSpeed();
            //In case of Invalid direction input.
            default -> System.out.println("Invalid direction: " + currentDirectionInteger + " (1-4 are valid).");
        }
    }
    /* TODO fix this method according to lab pm
     *   Gas() and Break() should only accept values in the interval [0,1]
     *   No speed bellow 0 or greater then enginePower
     *   Gas should not decrease speed
     *   brake should not increase speed */
}
