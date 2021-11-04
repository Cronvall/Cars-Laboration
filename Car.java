import java.awt.*;
import java.util.Vector;

public abstract class Car implements Vehicle{
    //Variables
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double currentSpeed;
    protected double[] position = new double[2];

    private int currentDirectionInteger = 1; //Start value 1 = Forward positive Y-axis

    //Methods
    public int getNrDoors() { return nrDoors;}
    public double getEnginePower(){return enginePower;}

    public Color getColor(){return color;}
    public void setColor(Color clr){color = clr;}
    public double getCurrentSpeed(){return currentSpeed;}


    private int getDirection(){
        return currentDirectionInteger;
    }

    public double[] getPosition(){
        return position;
    }

    /* TODO fix this method according to lab pm
     *   Gas() and Break() should only accept values in the interval [0,1]
     *   No speed bellow 0 or greater then enginePower
     *   Gas should not decrease speed
     *   brake should not increase speed */
    public void gas(double amount){
        incrementSpeed(amount);
    }

    public void brake(double amount){
        decrementSpeed(amount);
    }

    //Overriding methods
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
        double x = position[0];
        double y = position[1];
        switch (currentDirectionInteger) {
            //position[0] acts as X-axis and position[1] acts as Y-axis.
            //Forward
            case 1 -> position[1] += getCurrentSpeed();
            //Right
            case 2 -> position[0] += getCurrentSpeed();
            //Reverse
            case 3 -> position[1] -= getCurrentSpeed();
            //Left
            case 4 -> position[0] -= getCurrentSpeed();
            //In case of Invalid direction input.
            default -> System.out.println("Invalid direction: " + currentDirectionInteger + " (1-4 are valid).");
        }
    }
}
