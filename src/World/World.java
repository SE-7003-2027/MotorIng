package src.World;

import src.Controller.Action;
import src.Controller.Controller;
import src.Controller.Translation;
import src.Physical.Physical;

import java.util.Vector;

/**
 * Represents a game world containing a static map and physical objects.
 *
 * <p>A {@code World} defines the environment in which the game objects
 * exist. The static map represents the environment and does not need to
 * be recreated when physical objects change their positions.</p>
 *
 * <p>Physical objects are stored separately from the map because they
 * can change their position during the execution of the game.</p>
 *
 * @author fabriziocasillas, thrinkler
 * @version 0.1
 */
public class World {

    public static final char WALL = '#';

    private Map map;

    private Vector<Physical> physicals;

    /**
     * Creates a new world using the specified map and physical objects.
     *
     * @param map the static map representing the environment
     * @param physicals the physical objects contained in the world
     */
    public World(Map map, Vector<Physical> physicals) {
        this.map = map;
        this.physicals = physicals;
    }

    /**
     * Returns the static map of the world.
     *
     * @return the {@link Map} representing the environment
     */
    public Map getMap() {
        return map;
    }


    public void update(Vector<Controller> controllers) {
        for (Controller controller : controllers) {
            Action action = controller.action();
            if (action instanceof Translation translation) {
                Physical physical = controller.getPhysical();
                move(physical,translation.getDx(),translation.getDy()
                );
            }
        }
    }
    /**
     * Returns the physical objects contained in the world.
     *
     * @return a {@link Vector} containing the physical objects
     */
    public Vector<Physical> getPhysicals() {
        return physicals;
    }

    /**
     * Returns the physical object at the specified index.
     *
     * @param index the index of the physical object
     * @return the physical object at the given index
     */
    public Physical getPhysical(int index) {
        return physicals.get(index);
    }

    /**
     * Returns the physical object that occupies the specified cell.
     *
     * <p>This method works for objects of any size. If several objects
     * occupy the same cell, the first one stored in the vector is returned.</p>
     *
     * @param x the horizontal position of the cell
     * @param y the vertical position of the cell
     * @return the physical object occupying the cell, or {@code null}
     *         if the cell is free
     */
    public Physical getPhysicalAt(int x, int y) {

        for (Physical physical : physicals) {
            if (physical.occupies(x, y)) {
                return physical;
            }
        }

        return null;
    }

    /**
     * Checks whether the specified cell is inside the limits of the map.
     *
     * <p>The length of each row is checked individually, since the rows
     * of the map file may have different lengths.</p>
     *
     * @param x the horizontal position of the cell
     * @param y the vertical position of the cell
     * @return {@code true} if the cell is inside the map,
     *         {@code false} otherwise
     */
    public boolean inBounds(int x, int y) {

        if (y < 0 || y >= map.getHeight()) {
            return false;
        }

        return x >= 0 && x < map.getTiles()[y].length;
    }

    /**
     * Checks whether the specified cell is a wall of the static map.
     *
     * <p>The cell must be inside the map, see {@link #inBounds(int, int)}.</p>
     *
     * @param x the horizontal position of the cell
     * @param y the vertical position of the cell
     * @return {@code true} if the cell is a wall, {@code false} otherwise
     */
    public boolean isWall(int x, int y) {
        return map.getTile(x, y) == WALL;
    }

    /**
     * Checks whether a physical object can move by the specified offset.
     *
     * <p>Every cell occupied by the object is translated by
     * {@code (dx, dy)}. The movement is valid only if all the resulting
     * cells are inside the map, are not walls, and are not occupied by
     * another physical object. The object itself is ignored, since it
     * can overlap its own previous position.</p>
     *
     * @param physical the object to move
     * @param dx the change in the x-coordinate
     * @param dy the change in the y-coordinate
     * @return {@code true} if the movement is possible,
     *         {@code false} otherwise
     */
    public boolean canMove(Physical physical, int dx, int dy) {

        for (int[] cell : physical.getCells()) {

            int newX = cell[0] + dx;
            int newY = cell[1] + dy;

            if (!inBounds(newX, newY) || isWall(newX, newY)) {
                return false;
            }

            Physical other = getPhysicalAt(newX, newY);

            if (other != null && other != physical) {
                return false;
            }
        }

        return true;
    }

    /**
     * Moves a physical object by the specified offset if the movement
     * is possible.
     *
     * <p>If any of the cells of the object would collide, the object
     * does not move at all.</p>
     *
     * @param physical the object to move
     * @param dx the change in the x-coordinate
     * @param dy the change in the y-coordinate
     * @return {@code true} if the object was moved, {@code false} otherwise
     */
    public boolean move(Physical physical, int dx, int dy) {

        if (!canMove(physical, dx, dy)) {
            return false;
        }

        physical.updatePos(physical.getX() + dx, physical.getY() + dy);
        return true;
    }
}
