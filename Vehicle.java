public interface Vehicle extends Movable {

     // Not necessary at the moment, more of a speculative interface if more vehicles are wanted

     void startEngine();
     void stopEngine();

     void incrementSpeed(double amount);
     void decrementSpeed(double amount);

}
