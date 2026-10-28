
package src;

import src.Controller.Controller;
import src.Controller.UserController;
import src.Inputs.Input;
import src.Inputs.JframeInput;
import src.Physical.Physical;
import src.Physical.Potion;
import src.Rules.CollectPotionCondition;
import src.Rules.WinCondition;
import src.World.Map;
import src.World.MapReader;
import src.World.World;
import src.Audio.AudioPlayer;
import src.Rules.CollectPotionCondition;
import src.Rules.WinCondition;



import java.io.IOException;
import java.util.Vector;

import static java.lang.Thread.sleep;

/**
 * Tests movement, collectible interactions, and the win condition.
 *
 * @author fabriziocasillas, thrinkler
 * @version 0.2
 */
public class Test {

    /**
     * Loads a map from a text file, creates physical objects,
     * constructs a world, and displays the resulting map.
     *
     * @param args command-line arguments
     * @throws IOException if the map file cannot be read
     */
    public static void main(String[] args)
            throws IOException, InterruptedException {

        // Load the map.
        Map map = MapReader.read("maps/map.txt");

        // Create physical objects and controllers.
        Vector<Physical> physicals = new Vector<>();
        Vector<Controller> controllers = new Vector<>();

        Potion potion = new Potion(5, 1);
        Potion secondPotion = new Potion(2, 4);

        Physical enemy = new Physical(7, 4, '@');
        Physical character = new Physical(2, 1, 'o');

        physicals.add(potion);
        physicals.add(secondPotion);
        physicals.add(enemy);
        physicals.add(character);

        // Configure keyboard input.
        Input input = new JframeInput();
        UserController userInput =
                new UserController(character, input);

        controllers.add(userInput);

        // Create the world and the win condition.
        World world = new World(map, physicals);
        WinCondition winCondition = new CollectPotionCondition();
        boolean won = false;


        // Create and display the game window.
        Draw draw = new Draw(world, (JframeInput) input);
        draw.drawMap();

        System.out.println("Collect all the potions (*) to win!");

        // Game loop.
        while (true) {
            if (!won) {
                world.update(controllers);

                if (winCondition.isMet(world)) {
                    won = true;

                    draw.showMessage("¡Ganaste!");
                    AudioPlayer.play("sounds/victory.wav");
                }
            }

            draw.show();
            sleep(16);
        }

    }
}
