import java.util.Scanner;


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
        
    //private String movement;

    /**Obtain the instruction
     * 
     * @return String with movement
     */


        /**Update de position of the character in the direction
         * 
         * @param direction Order to move
         * @param character Position of the characater
         * @return
         */

        public static void forward(String direction, Physical character){

            Physical pos = new Physical(0, 0, '0');

            if(direction.equals("up")){
                character.updatePos(character.getX()-1, character.getY());
            }

            else if(direction.equals("down")){
                character.updatePos(character.getX()+1, character.getY());
            }

            else if(direction.equals("left")){
                character.updatePos(character.getX(), character.getY()-1);
            }
            
            else if(direction.equals("right")){
                character.updatePos(character.getX(), character.getY()+1);
            }
            
            System.out.println("Ejecucion del nuevo pos que contiene los datos:");
            System.out.println(pos.getX());
            System.out.println(pos.getY());
            System.out.println("//////////////////////////////////////////0");
            //return pos;
        }


     /**Idetify instruction passed
     * 
     * @param instruction Order by person
     * @param actual Actual Scenary
    */
        public static void order(String instruction, Scenery actual){
            World current = actual.getWorld();

            if(instruction.equals("Move")){
                Scanner is = new Scanner(System.in);
                System.out.println("Move of the character");
                String direction = is.nextLine();

                //maybe save the character position to optimazate
                //exception if i not the character
                for(Physical object: current.getPhysicals()){
                    if(object.getSprite() == '0'){
                        forward(direction, object);
                        break;
                    }
                 }             
                
            }


            else{
                System.out.println("The Instruction is not identified");

            }
        }
}