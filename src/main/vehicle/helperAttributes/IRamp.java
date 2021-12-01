package vehicle.helperAttributes;

public interface IRamp {

    /**
     * Raises the ramp
     */
    void raise();

    /**
     * Lowers the ramp
     */
    void lower();

    /**
     * Decides if the vehicle the ramp is mounted on can move
     * @return a boolean that describes if it's allowed to move
     */
    boolean getAllowMotion();
}
