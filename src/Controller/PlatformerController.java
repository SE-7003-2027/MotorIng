
package src.Controller;

import src.Inputs.Input;
import src.Inputs.JframeInput;
import src.Physical.Physical;

/**
 * Controller for a platformer.
 * A and D move horizontally; SPACE requests a jump.
 * @author fabriziocasillas
 * @version 0.1
 */
public class PlatformerController extends Controller {

    private int pendingDx = 0;
    private boolean jumpRequested = false;

    public PlatformerController(Physical physical, Input input) {
        super(physical, input);
    }

    @Override
    public Action action(String command) {
        if (command == null || command.isEmpty()) {
            return null;
        }

        switch (command.toUpperCase()) {
            case "A" -> pendingDx = -1;
            case "D" -> pendingDx = 1;
            case "SPACE" -> jumpRequested = true;
        }

        return null;
    }

    @Override
    public Action action() {
        String command;

        if (input instanceof JframeInput keyboard) {
            command = keyboard.getNextCommand();
        } else {
            command = input.getInput();
        }

        action(command);

        if (pendingDx != 0) {
            int dx = pendingDx;
            pendingDx = 0;
            return new Translation(dx, 0);
        }

        return null;
    }

    public boolean consumeJumpRequest() {
        boolean requested = jumpRequested;
        jumpRequested = false;
        return requested;
    }
}
