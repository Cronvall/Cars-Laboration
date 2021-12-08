import vehicle.Factory.MotorVehicleFactory;
import java.awt.*;

public class CarModelFactory {

    public static CarModel makeDefaultModel(){
        CarModel model = new CarModel();
        model.addMotorvehicle(MotorVehicleFactory.buildSaab95(2,100, Color.red));
        model.addMotorvehicle(MotorVehicleFactory.buildVolvo240(2,100, Color.red));
        model.addMotorvehicle(MotorVehicleFactory.buildScania(250,Color.red,5));

        return model;
    }
}
