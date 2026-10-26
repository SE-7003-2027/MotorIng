
package src.Rules;

import src.Physical.Physical;
import src.World.World;

public class CollectPotionCondition implements WinCondition {

    @Override
    public boolean isMet(World world) {
        for (Physical physical : world.getPhysicals()) {
            if (physical.getSprite() == '*') {
                return false;
            }
        }

        return true;
    }
}
