package vehicle.helperAttributes;

public interface IPlatform {

    /**
     * Lowers the ComplexPlatform by a given amount of degrees
     * @param angle The amount of degrees the ComplexPlatform will be lowered
     */
    void lower(int angle);

    /**
     * Raises the ComplexPlatform by a given amount of degrees
     * @param angle The amount of degrees the ComplexPlatform will be raised
     */
    void raise(int angle);

    /**
     * Returns if vehicles is allowed to move
     * @return returns the boolean if allowed
     */
    boolean getAllowMotion();

}
