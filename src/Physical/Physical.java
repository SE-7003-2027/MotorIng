package src.Physical;
/**
 * Represents a physical object within the game world.
 *
 * <p>A physical object has a position represented by its {@code x} and
 * {@code y} coordinates and a character used as its sprite. By default,
 * a physical object occupies a single cell of the world.</p>
 *
 * @author fabriziocasillas, thrinkler, memolokote
 * @version 0.2
 */
public class Physical {

    private int x;
    private int y;
    private char sprite;


    /**
     * Creates a new physical object with the specified position and sprite.
     *
     * @param x the horizontal position of the object
     * @param y the vertical position of the object
     * @param sprite the character representing the object's sprite
     */
    public Physical(int x, int y, char sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }

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
    /**
     * Returns the horizontal position of the physical object.
     * @return the x coordinate
     */
    public int getX(){
        return x;
    }

    /**
     * Returns the vertical position of the physical object.
     * @return the y coordinate
     */
    public int getY(){
        return y;
    }

    /**
     * Returns the sprite character representing the physical object.
     * @return the sprite character
     */
    public char getSprite(){
        return sprite;
    }

    /**
     * Returns the width of the physical object in cells.
     *
     * @return the number of columns occupied by the object
     */
    public int getWidth() {
        return 1;
    }

    /**
     * Returns the height of the physical object in cells.
     *
     * @return the number of rows occupied by the object
     */
    public int getHeight() {
        return 1;
    }

    /**
     * Checks whether the physical object occupies the specified cell
     * of the world.
     *
     * <p>Subclasses that occupy more than one cell must override this
     * method to describe their shape.</p>
     *
     * @param px the horizontal position of the cell in world coordinates
     * @param py the vertical position of the cell in world coordinates
     * @return {@code true} if the object occupies the cell,
     *         {@code false} otherwise
     */
    public boolean occupies(int px, int py) {
        return px == x && py == y;
    }

    /**
     * Returns the sprite that the object draws at the specified cell
     * of the world.
     *
     * <p>The result is only meaningful if
     * {@link #occupies(int, int)} returns {@code true} for the same cell.</p>
     *
     * @param px the horizontal position of the cell in world coordinates
     * @param py the vertical position of the cell in world coordinates
     * @return the sprite character to draw at that cell
     */
    public char getSpriteAt(int px, int py) {
        return sprite;
    }

    /**
     * Returns the absolute coordinates of every cell occupied by the
     * physical object.
     *
     * <p>Each element of the returned array is a pair {@code {x, y}}
     * expressed in world coordinates.</p>
     *
     * @return an array of {@code {x, y}} pairs, one for each occupied cell
     */
    public int[][] getCells() {
        return new int[][]{{x, y}};
    }

}