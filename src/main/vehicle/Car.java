package vehicle;
import java.awt.*;

/**
 * A Car is a vehicle with a certain amount of doors
 */
public abstract class Car  extends MotorVehicle {

    private int nrDoors;

    /**
     * Initiates a new MotorVehicle of the Class Car
     * @param nrDoors Describes the car's number of doors
     * @param enginePower Describes the engine's power
     * @param color Describes the color of the Car
     * @param modelName Displays the name of the model(Volvo240, Saab95 etc.)
     */
    protected Car(int nrDoors, int enginePower, Color color, String modelName){
        super(enginePower, color, modelName);
        this.nrDoors = nrDoors;
    }

    /**
     * Returns the car's number of doors
     * @return
     */
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
