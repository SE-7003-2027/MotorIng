
package src.Systems;

import src.Scenery;
import src.World.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Coordinates the execution of the systems that make up a game.
 * @author fabriziocasillas
 * @version 0.1
 */
public class GameLoop {

    private final World world;
    private final Scenery scenery;
    private final List<GameSystem> systems;

    public GameLoop(World world, Scenery scenery) {
        this.world = world;
        this.scenery = scenery;
        this.systems = new ArrayList<>();
    }

    /**
     * Registers a system to be executed on each game tick.
     */
    public void addSystem(GameSystem system) {
        systems.add(system);
    }

    /**
     * Executes one game tick and refreshes the scenery.
     */
    public void update() {
        for (GameSystem system : systems) {
            system.update(world);
        }

        scenery.show();
    }

    /**
     * Runs the game loop with an approximately 60 FPS update rate.
     */
    public void start() {
        while (true) {
            update();

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
