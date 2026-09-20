/**
 * Represents a physical object within the game world.
 *
 * <p>A physical object has a position represented by its {@code x} and
 * {@code y} coordinates and a character used as its sprite.</p>
 *
 * @author fabriziocasillas
 * @version 0.1
 */
public class Physical {

    private int x;
    private int y;
    private char sprite;

    /**
     * Updates the position of the physical object.
     *
     * @param x the new horizontal position
     * @param y the new vertical position
     */
    public void updatePos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}