public interface IVehicle extends Movable{

     // Not necessary at the moment, more of a speculative interface if more vehicles are wanted

     void startEngine();
     void stopEngine();

     void gas(double amount);
     void brake(double amount);

     void incrementSpeed(double amount);
     void decrementSpeed(double amount);

}
