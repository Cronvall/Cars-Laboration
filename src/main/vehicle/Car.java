package vehicle;
import vehicle.helperAttributes.Engine;

import java.awt.*;

/**
 * A Car is a vehicle with a certain amount of doors
 */
public abstract class Car  extends MotorVehicle {

    private int nrDoors;

    /**
     * Initiates a new MotorVehicle of the Class Car
     * @param nrDoors Describes the car's number of doors
     * @param engine Describes the engine
     * @param color Describes the color of the Car
     * @param modelName Displays the name of the model(Volvo240, Saab95 etc.)
     */
    protected Car(int nrDoors, Engine engine, Color color, String modelName){
        super(engine, color, modelName);
        this.nrDoors = nrDoors;
    }

    /**
     * Returns the car's number of doors
     * @return an integer of the amount of doors
     */
    public int getNrOfDoors(){return this.nrDoors;}

    /**
     * Describes the specified characteristics of a car with a string
     * @return a string with the cars characteristics
     */
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
