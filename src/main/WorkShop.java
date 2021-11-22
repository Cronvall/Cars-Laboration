import java.util.ArrayList;

public class WorkShop<T extends Car> {


    private ArrayList<Car> carsInWorkshop = new ArrayList<>(7);

    public WorkShop(){

    }

    public void admitCar(T car){
        carsInWorkshop.add(car);
    }

    public void carFixed(T car){
        carsInWorkshop.remove(car);
    }
}
