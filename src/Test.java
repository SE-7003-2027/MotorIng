package src;

import src.Controller.Controller;
import src.Controller.UserController;
import src.Inputs.Input;
import src.Inputs.JframeInput;
import src.Physical.Physical;
import src.Physical.Potion;
import src.World.Map;
import src.World.MapReader;
import src.World.World;
import src.Audio.AudioPlayer;
import src.Systems.ControllerSystem;
import src.Systems.GameLoop;
import src.Systems.GameSystem;

import java.io.IOException;
import java.util.Vector;

/**
 * Tests movement, collectible interactions, and win logic via GameSystems.
 *
 * @author fabriziocasillas, thrinkler
 * @version 0.3
 */
public class Test {

    /**
     * Loads a map from a text file, creates physical objects,
     * constructs a world, and displays the resulting map.
     *
     * @param args command-line arguments
     * @throws IOException if the map file cannot be read
     * @throws InterruptedException if the thread is interrupted
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

        // Create the world.
        World world = new World(map, physicals);

        // Create and display the game window.
        Draw draw = new Draw(world, (JframeInput) input);
        draw.drawMap();

        System.out.println("Collect all the potions (*) to win!");

        // 1. Instanciar el motor (sin el while(true) alrededor)
        GameLoop game = new GameLoop(world, draw);

        // 2. Sistema de controles (en este Test usamos UserController clásico)
        game.addSystem(new ControllerSystem(controllers));

        // 3. Sistema de Victoria (Reemplazo directo de WinCondition)
        game.addSystem(new GameSystem() {
            private boolean won = false;

            @Override
            public void update(World world) {
                if (won) return; // Si ya ganó, salir rápido

                // Lógica para revisar si el jugador ya recolectó todas las pociones
                boolean hasPotions = false;
                for (Physical p : world.getPhysicals()) {
                    if (p instanceof Potion) {
                        hasPotions = true;
                        break; 
                    }
                }

                // Si recorrió todo el mundo y no encontró pociones, el jugador gana
                if (!hasPotions) {
                    won = true;
                    draw.showMessage("¡Ganaste!");
                }
            }
        });

        // 4. Iniciar el motor
        game.start();
    }
}