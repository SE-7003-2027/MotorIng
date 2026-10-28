
package src.Physical;

import src.World.World;

public class Potion extends Interactuable {

    public Potion(int x, int y) {
        super(x, y, '*');
    }

    @Override
    public void interact(Physical other, World world) {
        world.removePhysical(this);
    }
}

