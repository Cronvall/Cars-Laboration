import java.awt.*;
import java.util.Vector;

public abstract class Car implements Vehicle{
    //Variables
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double currentSpeed;
    protected double x_coordinate = 0;
    protected double y_coordinate = 0;
    protected int currentDirectionInteger = 1; // 1 = Y, 2 = X, 3 = -Y, 4 = -X

    //Get methods
    public int getNrDoors() { return nrDoors;}
    public double getEnginePower(){return enginePower;}
    public Color getColor(){return color;}
    public double getCurrentSpeed(){return currentSpeed;}
    public double getX_coordinate(){return x_coordinate;}
    public double getY_coordinate(){return y_coordinate;}
    public double getDirection(){return currentDirectionInteger;}


    public void positions(){
        System.out.printf("Current positions of %a is X = %b and Y = %c", modelName, x_coordinate, y_coordinate);
    }



    public void setColor(Color clr){color = clr;}
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
        double x = getX_coordinate();
        double y = getY_coordinate();
        switch (currentDirectionInteger) {
            //position[0] acts as X-axis and position[1] acts as Y-axis.
            //Forward
            case 1 -> y_coordinate += getCurrentSpeed();
            //Right
            case 2 -> x_coordinate += getCurrentSpeed();
            //Reverse
            case 3 -> y_coordinate -= getCurrentSpeed();
            //Left
            case 4 -> x_coordinate -= getCurrentSpeed();
            //In case of Invalid direction input.
            default -> System.out.println("Invalid direction: " + currentDirectionInteger + " (1-4 are valid).");
        }
    }
}
