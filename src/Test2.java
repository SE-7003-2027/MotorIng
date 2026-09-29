import src.Physical.ClusterPhysical;
import src.Physical.Physical;
import src.World.Map;
import src.World.MapReader;
import src.World.World;
import src.Scenery;

import java.io.IOException;
import java.util.Vector;

/**
 * Tests the Map, MapReader, Physical, ClusterPhysical, Scenery, and World
 * classes by loading a simple map, displaying it, and moving objects of
 * different sizes.
 *
 * @author Memolokote
 * @version 0.2
 */
public class Test2 {

    /**
     * Loads a map from a text file, creates physical objects of different
     * sizes, constructs a world, displays the resulting map, and tests
     * the movement of the objects.
     *
     * @param args command-line arguments
     * @throws IOException if the map file cannot be read
     */
    public static void main(String args[]) throws IOException {

        /*
         * Load the static map from the text file.
         */
        Map map = MapReader.read("maps/map.txt");

        /*
         * Create the physical objects that exist in the world.
         * Walls are not represented as Physical objects
         * because they belong to the static map.
         */
        Vector<Physical> physicals = new Vector<>();

        Physical potion = new Physical(5, 1, '*');
        physicals.add(potion);

        Physical secondPotion = new Physical(2, 4, '*');
        physicals.add(secondPotion);

        Physical enemy = new Physical(7, 4, '@');
        physicals.add(enemy);

        Physical character = new Physical(2, 1, 'o');
        physicals.add(character);

        /*
         * Create clusters, which are physical objects that occupy
         * several cells. Adjust their positions to free cells
         * of your map.
         */

        // Rectangular cluster of 2x2 cells
        ClusterPhysical box = new ClusterPhysical(4, 2, 2, 2, 'B');
        physicals.add(box);

        // L-shaped cluster; the spaces are cells that are not occupied
        ClusterPhysical lShape = new ClusterPhysical(8, 1,
                "X ",
                "X ",
                "XX");
        physicals.add(lShape);

        /*
         * Create the world using the static map and
         * the physical objects.
         */
        World world = new World(map, physicals);

        /*
         * Create the scenery and display the world.
         */
        Scenery scenery = new Scenery(world);

        System.out.println("Print a simple map\n");

        scenery.show();

        /*
         * Test the movement with collisions. The result depends on
         * the obstacles around each object.
         */
        System.out.println("\nMove character right: " + world.move(character, 1, 0));
        System.out.println("Move box right: " + world.move(box, 1, 0));
        System.out.println("Move L-shape down: " + world.move(lShape, 0, 1));

        System.out.println();

        scenery.show();

        System.out.println("\nYOU EXIT SUCCESFULLY");
    }
}