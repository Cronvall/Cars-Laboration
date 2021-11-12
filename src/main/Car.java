import java.awt.*;

public abstract class Car implements Vehicle{

    //Variables. I.e fields
    private final int nrDoors; // Number of doors on the car
    private final String modelName; // The car model name
    private double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private Point position = new Point();
    private double currentSpeed;
    private int currentDirectionInteger = 1; //Start value 1 = Forward positive Y-axis.
                                            // Directions are integers: Y= 1, X = 2, -Y = 3, -X = 4


    //TODO should the constructor be protected? Case against/for
    //Constructor
    public Car(int _nrDoors, double _enginePower, Color col, String _mName){
        nrDoors = _nrDoors;
        enginePower = _enginePower;
        color = col;
        modelName = _mName;
        // TODO use stopEngine() here instead of in previous constructor?
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


    //TODO Another question! Should we rather use "throw new" as handling errors instead of system.out?

    // Set methods
    protected void setCurrentSpeed(double speed){
        if(speed >= 0 && speed < getEnginePower())  //Accepted interval
            currentSpeed = speed;
        else{
            System.out.print("Speed was not within required intervall [0, 1].");
            if(speed < 0){
                System.out.println("Speed defaulted to 0");
                setCurrentSpeed(0);
            }

            else if(speed > getEnginePower()){
                System.out.println("Speed defaulted to engine power");
                setCurrentSpeed(getEnginePower());
            }
        }
    }

    //Defines that there is a speedFactor.
    public abstract double speedFactor();

    // "Actions methods" for cars
    @Override
    public void gas(double amount){
        // TODO is the engine running? Should it run to be able to gas?
        if(amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
        else
            System.out.println("The amount of gas exceeds allowed interval of [0,1].");
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


    public  void incrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() + speedFactor() * amount;
        setCurrentSpeed(Math.min(newSpeed,getEnginePower()));
    }


    public void decrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        setCurrentSpeed(Math.max(newSpeed,0));
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
}
