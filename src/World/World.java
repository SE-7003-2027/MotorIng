package src.World;

import src.Controller.Action;
import src.Controller.Controller;
import src.Controller.Translation;
import src.Physical.Physical;

import java.util.Vector;

/**
 * Represents a game world containing a static map and physical objects.
 *
 * <p>A {@code World} defines the environment in which the game objects
 * exist. The static map represents the environment and does not need to
 * be recreated when physical objects change their positions.</p>
 *
 * <p>Physical objects are stored separately from the map because they
 * can change their position during the execution of the game.</p>
 *
 * @author fabriziocasillas, thrinkler
 * @version 0.1
 */
public class World {

    private Map map;

    private Vector<Physical> physicals;

    /**
     * Creates a new world using the specified map and physical objects.
     *
     * @param map the static map representing the environment
     * @param physicals the physical objects contained in the world
     */
    public World(Map map, Vector<Physical> physicals) {
        this.map = map;
        this.physicals = physicals;
    }

    /**
     * Returns the static map of the world.
     *
     * @return the {@link Map} representing the environment
     */
    public Map getMap() {
        return map;
    }


    public void update(Vector<Controller> controllers) {
        for (Controller controller : controllers) {
            Action action = controller.action();
            if(action instanceof Translation){
                controller.getPhysical().updatePos(
                        ((Translation) action).getDx(),((Translation) action).getDy()
                );
            }
        }
    }
    /**
     * Returns the physical objects contained in the world.
     *
     * @return a {@link Vector} containing the physical objects
     */
    public Vector<Physical> getPhysicals() {
        return physicals;
    }

    /**
     * Returns the physical object at the specified index.
     *
     * @param index the index of the physical object
     * @return the physical object at the given index
     */
    public Physical getPhysical(int index) {
        return physicals.get(index);
    }
}
