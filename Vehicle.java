public interface Vehicle extends Movable {
     void startEngine();
     void stopEngine();

     void incrementSpeed(double amount);
     void decrementSpeed(double amount);

}
