package src;
import java.util.Scanner;
import src.Physicals.Physical;


/**
 * Represents input received from the user.
 *
 * <p>This class is currently a placeholder for the input system of the
 * game engine. It will be extended to handle user input and interact
 * with the game loop.</p>
 *
 * @author fabriziocasillas
 * @version 0.1
 */
public class Input {
        

    private char lastKey;

    public void readInput(Scanner scanner) {
        String input = scanner.nextLine().trim().toUpperCase();
        if (!input.isEmpty()) {
            lastKey = input.charAt(0);
        } else {
            lastKey = ' ';
        }
    }

    public char getLastKey() {
        return lastKey;
    }

    /**Update de position of the character in the direction
     * 
     * @param direction Order to move
     * @param character Position of the characater
     * @return
     */
    public static void movePhys(String direction, Physical character){

        Physical pos = new Physical(0, 0, '0');

        switch (direction.toUpperCase().charAt(0)) {
            case 'W':
                character.updatePos(character.getX(), character.getY()-1);
                break;
            case 'S':
                character.updatePos(character.getX(), character.getY()+1);
                break;
            case 'A':
                character.updatePos(character.getX()-1, character.getY());
                break;
            case 'D':
                character.updatePos(character.getX()+1, character.getY());
                break;
            default:
                break;
        }
    }


}