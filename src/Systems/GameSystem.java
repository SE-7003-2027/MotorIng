
package src.Systems;

import src.World.World;

/**
 * Represents an optional behavior executed during a game tick.
 * @author fabriziocasillas
 * @version 0.1
 */
public interface GameSystem {

    /**
     * Executes this system's behavior for the current game tick.
     *
     * @param world the world in which the behavior is executed
     */
    void update(World world);
}
