import vehicle.MotorVehicle;
import javax.swing.*;
import java.awt.*;

public class DrawVehicles extends JPanel {
    CarModel model;
    public DrawVehicles(CarModel model){
        this.model = model;
    }

    @Override
    protected void paintComponent(Graphics g){
        for(int i = 0; i < model.getVehicles().size(); i++){
            MotorVehicle vehicle = model.getVehicles().get(i);
            g.drawImage(vehicle.getImage(),150 * i,(int)vehicle.getY(),null);
        }
    }
}
