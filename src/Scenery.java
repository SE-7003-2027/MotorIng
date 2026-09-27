package src;

import src.World.World;
import src.World.Map;
import src.Physical.Physical;

/**
 * Controls the main state and execution of the game.
 *
 * <p>{@code Scenery} Renders and sends inputs to the current game world,
 * physical objects, sprites, input, updating, and displaying the game state.</p>
 *
 * <p>The {@code start()} method is responsible for starting the main
 * game loop, while {@code update(Input)} and {@code show()} handle
 * updating and displaying the current state.</p>
 *
 * @author fabrtiziocasillas, thrinkler
 * @version 0.1
 */
public class Scenery {

    private World world;

    /**
     * Creates a new {@code Scenery} instance with the specified world,
     * physical objects, and sprites.
     *
     * @param world the game world
     */
    public Scenery(World world) {
        this.world = world;
    }

    /**
     * Displays the current state of the game.
     *
     * <p>The static map is displayed first. Physical objects are then
     * displayed on top of the map according to their current positions.</p>
     */
    public void show() {

        Map map = world.getMap();

        for (int y = 0; y < map.getHeight(); y++) {

            for (int x = 0; x < map.getWidth(); x++) {

                char sprite = map.getTile(x, y);

                for (Physical object : world.getPhysicals()) {

                    if (object.getX() == x && object.getY() == y) {
                        sprite = object.getSprite();
                        break;
                    }
                }

                System.out.print(sprite);
            }

            System.out.println();
        }
    }

    /**
     * Updates the game state using the given input.
     *
     * @param input the input received from the user
     */
    public void update(Input input) {

    }

    /**
     * Changes the current game world.
     *
     * @param world the new game world
     */
    public void changeWorld(World world) {
        this.world = world;
    }

    /**
     * Starts the main game loop.
     *
     * <p>The game loop repeatedly processes input, updates the game
     * state, and displays the current state.</p>
     */
    public void start() {

    }

    /**
     * Gets the actual world.
     *
     * @return the current game world
     */
    public World getWorld() {
        return this.world;
    }
}
