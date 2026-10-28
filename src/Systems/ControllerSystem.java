
package src.Systems;

import src.Controller.Action;
import src.Controller.Controller;
import src.Controller.Translation;
import src.Physical.Physical;
import src.World.World;

import java.util.Vector;

/**
 * Executes controller actions and applies them to the world.
 * @author fabriziocasillas
 * @version 0.1
 */
public class ControllerSystem implements GameSystem {

    private final Vector<Controller> controllers;

    public ControllerSystem(Vector<Controller> controllers) {
        this.controllers = controllers;
    }

    @Override
    public void update(World world) {
        for (Controller controller : controllers) {
            Action action = controller.action();

            if (action instanceof Translation translation) {
                Physical physical = controller.getPhysical();

                world.move(
                        physical,
                        translation.getDx(),
                        translation.getDy()
                );
            }
        }
    }
}
