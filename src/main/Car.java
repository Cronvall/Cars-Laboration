import java.awt.*;

public abstract class Car implements Vehicle, Movable{

    //Variables. I.e fields
    private final int nrDoors;
    private final String modelName;
    private double enginePower;
    private Color color;
    private Point position = new Point();
    private double currentSpeed;
    private int currentDirectionInteger = 1; //Start value 1 = Forward positive Y-axis.
                                            // Directions are integers: Y= 1, X = 2, -Y = 3, -X = 4

    public Car(int nrDoors, double enginePower, Color col, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = col;
        this.modelName = modelName;
        stopEngine();
    }

    //Get methods
    public double getEnginePower(){return enginePower;}
    public double getCurrentSpeed(){return currentSpeed;}
    public double getDirection(){return currentDirectionInteger;}
    public Point getPosition(){
        return position;
    }


    // Set method
    protected void setCurrentSpeed(double newSpeed){
        if(newSpeed >= 0 && newSpeed <= getEnginePower())  //Accepted interval
            this.currentSpeed = newSpeed;
        else{
            this.changeSpeedIfOutsideInterval(newSpeed);
        }
    }

    protected void changeSpeedIfOutsideInterval(double speed){
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

    public abstract double speedFactor();

    // "Actions methods" for cars
    @Override
    public void gas(double amount){
        // TODO is the engine running? Should it run to be able to gas?
        if(amount > 0 && amount <= 1){
            incrementSpeed(amount);
        }
        else
            System.out.println("The amount of gas exceeds allowed interval of [0,1].");
    }

    @Override
    public  void incrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() + speedFactor() * amount;
        setCurrentSpeed(Math.min(newSpeed,getEnginePower()));
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

    @Override
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
            case 1 -> this.position.y += getCurrentSpeed();

            //Right
            case 2 -> this.position.x += getCurrentSpeed();

            //Reverse
            case 3 -> this.position.y -= getCurrentSpeed();

            //Left
            case 4 -> this.position.x -= getCurrentSpeed();

            //In case of Invalid direction input.
            default -> System.out.println("Invalid direction: " + currentDirectionInteger + " (1-4 are valid).");
        }
    }
}
