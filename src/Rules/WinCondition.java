
package src.Rules;

import src.World.World;

/**
 * Defines a condition that determines whether the player has won.
 */
public interface WinCondition {

    /**
     * Evaluates whether the win condition has been met.
     *
     * @param world current state of the game world
     * @return true if the player has won, false otherwise
     */
    boolean isMet(World world);
}
