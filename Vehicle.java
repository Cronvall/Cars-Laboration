public interface Vehicle extends Moveable{
     void startEngine();
     void stopEngine();

     void incrementSpeed(double amount);
     void decrementSpeed(double amount);

}
