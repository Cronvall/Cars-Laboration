package vehicle.helperAttributes;

/**
 * Loading dock for vehicles that decides if motion is allowed
 */
public interface ILoadingDock {

    /**
     * Returns if vehicles is allowed to move
     * @return returns the boolean if allowed moving
     */
    boolean getAllowMotion();

    /**
     * Returns if vehicles is allowed to load
     * @return returns the boolean if allowed loading
     */
     boolean getAllowLoading();
}
