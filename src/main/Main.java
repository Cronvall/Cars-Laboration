import vehicle.*;
import vehicle.Factory.MotorVehicleFactory;
import vehicle.helperAttributes.Engine;
import vehicle.helperAttributes.Platform;
import vehicle.helperAttributes.TurboEngine;
import java.awt.*;

public class Main {

    public static void main(String[] args){
        CarController controller = new CarController();
        controller.cars.add(MotorVehicleFactory.buildVolvo240(4,100, Color.red));
        controller.cars.add(MotorVehicleFactory.buildSaab95(2, 100, Color.CYAN));
        controller.cars.add(MotorVehicleFactory.buildScania(100, Color.green, 10));

        controller.frame = new CarView("Cars-laboration",controller);
        controller.getTimer().start();

    }

}
