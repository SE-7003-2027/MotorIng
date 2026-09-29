package src.Controller;

/**
 * Represents a translation action that can be performed on a physical object.
 *
 * <p>This class defines the change in position (dx, dy) that will be applied
 * to the physical object when the action is executed.</p>
 *
 * @author thrinkler
 * @version 0.1
 */
public class Translation extends Action{
    private final int dx;
    private final int dy;

    /**
     * Creates a new {@code Translation} action with the specified change in position.
     *
     * @param dx the change in the x-coordinate
     * @param dy the change in the y-coordinate
     */
    public Translation(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
