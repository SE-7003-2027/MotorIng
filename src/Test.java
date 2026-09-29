package src;

import src.Controller.Controller;
import src.Controller.UserController;
import src.Inputs.ConsoleInput;
import src.Physical.Physical;
import src.World.Map;
import src.World.MapReader;
import src.World.World;

import java.io.IOException;
import java.util.Vector;

import static java.lang.Thread.sleep;

/**
 * Tests the Map, MapReader, Physical, Scenery, and World classes
 * by loading and displaying a simple map.
 *
 * @author fabriziocasillas, thrinkler
 * @version 0.1
 */
public class Test {

    /**
     * Loads a map from a text file, creates physical objects,
     * constructs a world, and displays the resulting map.
     *
     * @param args command-line arguments
     * @throws IOException if the map file cannot be read
     */
    public static void main(String args[]) throws IOException, InterruptedException {

        /*
         * Load the static map from the text file.
         */
        Map map = MapReader.read("maps/map.txt");

        /*
         * Create the physical objects that exist in the world.
         * Walls are no longer represented as Physical objects
         * because they belong to the static map.
         */
        Vector<Physical> physicals = new Vector<>();
        Vector<Controller> controllers = new Vector<>();

        Physical potion = new Physical(5, 1, '*');
        physicals.add(potion);

        Physical secondPotion = new Physical(2, 4, '*');
        physicals.add(secondPotion);

        Physical enemy = new Physical(7, 4, '@');
        physicals.add(enemy);

        Physical character = new Physical(2, 1, 'o');
        ConsoleInput input = new ConsoleInput();
        UserController userInput = new UserController(character, input);
        physicals.add(character);
        controllers.add(userInput);

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

        for(int i = 0; i < 100; i++){
            scenery.show();
            while(userInput.action()== null){
                world.update(controllers);
            }
        }



        System.out.println("\nYOU EXIT SUCCESFULLY");
    }
}
