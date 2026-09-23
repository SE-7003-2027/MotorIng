/**
 * Controls the main state and execution of the game.
 *
 * <p>{@code Scenery} Renders and sends inputs to the current game world,
 *  physical objects, sprites, input, updating, and displaying the game state.</p>
 *
 * <p>The {@code start()} method is responsible for starting the main
 * game loop, while {@code update(Input)} and {@code show()} handle
 * updating and displaying the current state.</p>
 *
 * @author fabrtiziocasillas, thrinkler
 * @version 0.1
 */
public class Scenery {

    private World world;

    /**
     * Creates a new {@code Scenery} instance with the specified world,
     * physical objects, and sprites.
     *
     * @param world the game world
     */
    public Scenery(World world) {
        this.world = world;
    }

    /**
     * Displays the current state of the game.
     */
    public void show() {

        for (int[] mapSide : world.getMap()) {
            for (int j = 0; j < mapSide.length; j++) {
                int index = mapSide[j];
                if(index > 0){
                    System.out.print(world.getPhysical(index-1).getSprite());
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Updates the game state using the given input.
     *
     * @param input the input received from the user
     */
    public void update(Input input) {
        
    }

    /**
     * Changes the current game world.
     *
     * @param world the new game world
     */
    public void changeWorld(World world) {
        this.world = world;
    }

    /**
     * Starts the main game loop.
     *
     * <p>The game loop repeatedly processes input, updates the game
     * state, and displays the current state.</p>
     */
    public void start() {
        
    }


    /**Get the actual world
     * 
     * @return Actual world
     */
    public World getWorld(){
        return this.world;
    }

}