
package src.Systems;

import src.Physical.Physical;
import src.World.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Applies optional, discrete gravity to selected physical objects.

 */
public class GravitySystem implements GameSystem {

    private final List<Physical> affectedPhysicals;
    private final int ticksPerFall;
    private int tickCounter;

    /**
     * @param ticksPerFall number of game ticks between falling attempts
     * @param physicals objects affected by gravity
     */
    public GravitySystem(int ticksPerFall, Physical... physicals) {
        if (ticksPerFall < 1) {
            throw new IllegalArgumentException(
                    "ticksPerFall must be greater than zero"
            );
        }

        this.ticksPerFall = ticksPerFall;
        this.affectedPhysicals = new ArrayList<>(Arrays.asList(physicals));
        this.tickCounter = 0;
    }

    @Override
    public void update(World world) {
        tickCounter++;

        if (tickCounter < ticksPerFall) {
            return;
        }

        tickCounter = 0;

        // Iterate over a copy in case an interaction removes an object.
        for (Physical physical : new ArrayList<>(affectedPhysicals)) {
            // Ignore objects that are no longer part of the world.
            if (!world.getPhysicals().contains(physical)) {
                continue;
            }

            // Try to move the object one cell down.
            world.move(physical, 0, 1);
        }
    }
}
