
package src.Physical;

import src.World.World;

/**
 * Represents a physical object that reacts to contact
 * with another physical object.
 */
public abstract class Interactuable extends Physical {

    public Interactuable(int x, int y, char sprite) {
        super(x, y, sprite);
    }

    /**
     * Defines what happens when another physical object
     * touches this interactable object.
     *
     * @param other the physical object that touched this object
     * @param world the world containing both objects
     */
    public abstract void interact(Physical other, World world);
}

