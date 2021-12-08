package vehicle;

import java.awt.geom.Point2D;

/**
 * A Movable vehicle can move four directions in a 2d plane and turn 90 degrees at a time
 */
public interface Movable {

    /**
     * Moves the vehicle one of four directions in a 2d plane
     */
    void move();

    /**
     * Changes direction(if currently going East, starts going North)
     */
    void turnLeft();

    /**
     * Changes direction(if currently going East, starts going South)
     */
    void turnRight();

    double getX();
    double getY();
    Point2D.Double getPosition();
}
