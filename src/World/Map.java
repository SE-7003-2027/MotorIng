package src.World;

/**
 * Represents a static map within the game world.
 *
 * <p>The map is represented as a two-dimensional array of characters,
 * where each character represents a tile of the environment. Unlike
 * physical objects, the map does not change when game objects move.</p>
 *
 * <p>Maps can be loaded from external files and stored in memory,
 * allowing large static environments to be represented without
 * recreating the map during each update.</p>
 *
 * @author fabriziocasillas, thrinkler
 * @version 0.1
 */
public class Map {

    private char[][] tiles;

    /**
     * Creates a new map using the specified tiles.
     *
     * @param tiles the two-dimensional array containing the map tiles
     */
    public Map(char[][] tiles) {
        this.tiles = tiles;
    }

    /**
     * Returns the character stored at the specified position.
     *
     * @param x the horizontal position of the tile
     * @param y the vertical position of the tile
     * @return the character representing the tile at the specified position
     */
    public char getTile(int x, int y) {
        return tiles[y][x];
    }

    /**
     * Returns the width of the map.
     *
     * @return the number of columns in the map
     */
    public int getWidth() {
        return tiles[0].length;
    }

    /**
     * Returns the height of the map.
     *
     * @return the number of rows in the map
     */
    public int getHeight() {
        return tiles.length;
    }

    /**
     * Returns the complete array of tiles that represents the map.
     *
     * @return the two-dimensional array containing all map tiles
     */
    public char[][] getTiles() {
        return tiles;
    }
}
