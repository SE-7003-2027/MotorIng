/**
 * Represents a game world containing the map and physical objects.
 *
 * <p>A {@code World} defines the environment in which the game objects
 * exist. Its map and behavior can be expanded as the game engine develops.</p>
 *
 * @author fabriziocasillas
 * @version 0.1
 */
public class World {

    private int[][] map;
    private Physical[] physicals;

    /**
     * Creates a new world using the given physical objects.
     *
     * @param physicals the physical objects contained in the world
     * @param mapSize the size of a side of the whole map
     */
    public World(Physical[] physicals, int mapSize) {
        this.physicals = physicals;
        map = new int[mapSize][mapSize];
    }

    /**
     * Updates the world state by refreshing the map based on the positions
     * of the physical objects.
     *
     * <p>This method clears the current map and places each physical object
     * at its corresponding position.</p>
     */
    public void update(){ // Maybe for optimization, just update the pos of the physicals that have changed
        map = new int[map.length][map.length];
        for(int i = 0; i < physicals.length; i++){
            map[physicals[i].getX()][physicals[i].getY()] = i;
        }
    }

    /**
     * Returns the current map of the world.
     * @return the 2D array representing the world map
     */
    public int[][] getMap(){
        return map;
    }

}