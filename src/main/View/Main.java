package View;

public class Main {

    public static void main(String[] args){
        CarModel model = CarModelFactory.makeDefaultModel();
        CarView view = new CarView("Cars-laboration", model);
        model.observerSubscribe(view);
        CarController controller = new CarController(model, view);
        model.start();
    }
}
