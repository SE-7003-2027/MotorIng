package src.Systems;

import src.Physical.Physical;
import src.World.Map;
import src.World.World;

import java.util.Random;

/**
 * Generates random items within the map area
 * @author 1IsaacJR
 * @version 0.1
 */
public class EntitySpawner {
    private static final Random random = new Random();

    /**
     * Places or moves a physical object to a random cell that is neither a wall nor occupied. 
     * @param world The object that will be generated. 
     * @param entity The generation of the map from which objects will be randomly assigned.
     */
    public static void spawnInFreeCell(World world, Physical entity){
        Map map = world.getMap();
        int x, y;
        do{
            x = 1 + random.nextInt(map.getWidth() - 2);
            y = 1 + random.nextInt(map.getHeight() - 2);
        }while (world.isWall(x, y) || world.getPhysicalAt(x, y) != null);

        entity.updatePos(x, y);
    }
}