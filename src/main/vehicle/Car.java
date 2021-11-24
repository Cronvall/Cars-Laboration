package vehicle;

import java.awt.*;

public abstract class Car  extends Vehicle {

    private final int nrDoors;

    public Car(int nrDoors, int enginePower, Color color, String modelName){
        super(enginePower, color, modelName);
        this.nrDoors = nrDoors;
    }

    public int getNrOfDoors(){return this.nrDoors;}

    @Override
    public String toString(){
        return(
                this.getClass().toString() +
                        ": {" +
                        "modelName "+ getModelName() +
                        "nrOfDoors "+ getNrOfDoors() +
                        ", enginePower: " + getEnginePower() +
                        ", Color: " + getColor() +
                        ", Position: " + getPosition() +
                        ", Speed: " + getCurrentSpeed() +
                        ", DirectionInteger: " + getDirection() +
                        " }"
        );
    }

}
