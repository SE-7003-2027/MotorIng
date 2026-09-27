package src.Controller;

import src.Physical.Physical;


/**
 * Represents input received from the user. 
 *
 * <p>This class is currently an example of how to implement 
 * a controller for user input. It defines the actions that can
 *  be performed on a physical object based on user commands.
 *  The actions are defined as translations in different directions
 *  (up, down, left, right) and are associated with specific
 *  commands (W, S, A, D).</p>
 *
 * @author thrinkler
 * @version 0.1
 */
public class UserInput extends Controller{

    public UserInput(Physical physical) {
        super(physical);
        
        actions = new Action[]{
                new Translation(0, -1), // Up
                new Translation(0, 1),  // Down
                new Translation(-1, 0), // Left
                new Translation(1, 0)   // Right
        };
    }


    @Override
    public Action action(String command) {
        return switch (command.toUpperCase().charAt(0)) {
            case 'W' -> actions[0];
            case 'S' -> actions[1];
            case 'A' -> actions[2];
            case 'D' -> actions[3];
            default -> null;
        };
    }
}