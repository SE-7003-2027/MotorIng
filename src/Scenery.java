
package src;

import src.World.World;

/**
 * Defines the common interface for game scenes.
 *
 * <p>A scene manages the current world and provides operations
 * for displaying the game and showing interface messages.</p>
 *
 * @author fabrtiziocasillas, thrinkler
 * @version 0.2
 */
public abstract class Scenery {

    private World world;
    private String message;

    /**
     * Creates a scene associated with a world.
     *
     * @param world world to display and manage
     */
    public Scenery(World world) {
        this.world = world;
        this.message = null;
    }

    /**
     * Displays or refreshes the current scene.
     */
    public abstract void show();

    /**
     * Displays a message in the current scene.
     *
     * @param message text to display
     */
    public void showMessage(String message) {
        this.message = message;
        show();
    }

    /**
     * Removes the currently displayed message.
     */
    public void clearMessage() {
        this.message = null;
        show();
    }

    /**
     * Returns the currently displayed message.
     *
     * @return active message, or null if there is none
     */
    public String getMessage() {
        return message;
    }

    /**
     * Changes the world associated with this scene.
     *
     * @param world new world
     */
    public void changeWorld(World world) {
        this.world = world;
    }

    /**
     * Returns the world associated with this scene.
     *
     * @return current world
     */
    public World getWorld() {
        return world;
    }
}
