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

    //Methods
    public int getNrDoors() { return nrDoors;}
    public double getEnginePower(){return enginePower;}

    public Color getColor(){return color;}
    public void setColor(Color clr){color = clr;}
    public double getCurrentSpeed(){return currentSpeed;}

    private int currentDirectionInteger = 1; //Start value 1 = Forward positive Y-axis

    private int getDirection(){
        return currentDirectionInteger;
    }

    public double[] getPosition(){
        return position;
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
        switch (currentDirectionInteger){
            //position[0] acts as X-axis and position[1] acts as Y-axis.
            //Foward
            case 1: position[1] += getCurrentSpeed();
                break;
            //Right
            case 2: position[0] += getCurrentSpeed();
                break;
            //Reverse
            case 3: position[1] -= getCurrentSpeed();
                break;
            //Left
            case 4: position[0] -= getCurrentSpeed();
                break;
            //In case of Invalid direction input.
            default: print("Invalid direction: " + currentDirectionInteger + " (1-4 are valid).");
        }
    }

}
