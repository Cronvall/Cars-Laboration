package vehicle.helperAttributes;

/**
 * Ramps can be either raised or lowered and decides if a vehicle may move
 */
public interface IRamp extends ILoadingDock {

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
    @Override
    boolean getAllowMotion();

    /**
     * Returns if vehicles is allowed to load
     * @return returns the boolean if allowed loading
     */
    @Override
    boolean getAllowLoading();
}
