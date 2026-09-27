package src.Controller;

import src.Physical.Physical;

/**
 * Represents a controller of a physical object in the game.
 * Stores the physical object and defines the actions that can be performed on it.
 *
 * <p>This abstract class serves as a base for specific controller implementations,
 * such as user input controllers or npc movement. It defines the structure for
 *  handling actions based on commands.</p>
 *
 * @author thrinkler
 * @version 0.1
 */
public abstract class Controller {

    protected Physical physical;
    protected Action[] actions;

    public Controller(Physical physical) {
        this.physical = physical;
    }

    /**
     * Returns the action corresponding to the given command.
     *
     * @param command the command input
     * @return the action associated with the command, or null if no action is found
     */
    public abstract Action action(String command);
}

