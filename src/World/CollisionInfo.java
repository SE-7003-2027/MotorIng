package src.World;

import src.Physical.Physical;
import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates collision and touch information detected by the World.
 *
 * <p>Stores references to static map tiles and other physical objects
 * that a {@link Physical} object is touching or colliding with.</p>
 *
 * @author 1IsaacJR
 * @version 0.1
 */
public class CollisionInfo {

    private final List<Character> touchedTiles;
    private final List<Physical> touchedPhysicals;

    public CollisionInfo() {
        this.touchedTiles = new ArrayList<>();
        this.touchedPhysicals = new ArrayList<>();
    }

    public void addTile(char tile) {
        if (!touchedTiles.contains(tile)) {
            touchedTiles.add(tile);
        }
    }

    public void addPhysical(Physical physical) {
        if (!touchedPhysicals.contains(physical)) {
            touchedPhysicals.add(physical);
        }
    }

    public List<Character> getTouchedTiles() {
        return touchedTiles;
    }

    public List<Physical> getTouchedPhysicals() {
        return touchedPhysicals;
    }

    public boolean hasCollisions() {
        return !touchedTiles.isEmpty() || !touchedPhysicals.isEmpty();
    }
}