/**
 * Represents a physical object within the game world.
 *
 * <p>A physical object has a position represented by its {@code x} and
 * {@code y} coordinates and a character used as its sprite.</p>
 *
 * @author fabriziocasillas, thrinkler
 * @version 0.1
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
}