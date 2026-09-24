package src.World;

import src.Physicals.Physical;

/**
 * Represents a game world containing the map and physical objects.
 *
 * <p>A {@code World} defines the environment in which the game objects
 * exist. Its map and behavior can be expanded as the game engine develops.</p>
 *
 * @author fabriziocasillas, thrinkler
 * @version 0.1
 */
public class World {

    private int[][] map;
    private Physical[] physicals;

    private Physical player; // After first Demo, this will point to a controller. Also it has to be 1+ player

    /**
     * Creates a new world using the given physical objects.
     *
     * @param physicals the physical objects contained in the world
     * @param mapLength the length of the whole map
     * @param mapWidth the width of the whole map
     */
    public World(Physical[] physicals, int mapLength, int mapWidth) {
        this.physicals = physicals;
        map = new int[mapLength][mapWidth];
    }

    /**
     * Updates the world state by refreshing the map based on the positions
     * of the physical objects.
     *
     * <p>This method clears the current map and places each physical object
     * at its corresponding position.</p>
     */
    public void update(){ // Maybe for optimization, just update the pos of the physicals that have changed
        map = new int[map.length][map[0].length];
        for(int i = 0; i < physicals.length; i++){
            map[physicals[i].getY()][physicals[i].getX()] = i+1;
        }
    }

    /**
     * Returns the current map of the world.
     * @return the 2D array representing the world map
     */
    public int[][] getMap(){
        return map;
    }

    /**
     * Returns the array of physical objects in the world.
     * @return the array of physical objects
     */
    public Physical[] getPhysicals(){
        return physicals;
    }

    /**
     * Returns the physical object at the specified index.
     *
     * @param index the index of the physical object
     * @return the physical object at the given index
     */
    public Physical getPhysical(int index){
        return physicals[index];
    }

    public Physical getPlayer(){
        return player;
    }

    public void addController(Physical player){
        this.player = player;
    }
}