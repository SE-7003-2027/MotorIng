package src.Physical;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a physical object made of a group of cells (a cluster).
 *
 * <p>The shape of the cluster is defined by a two-dimensional array of
 * characters. The character {@link #EMPTY} marks cells that do not belong
 * to the object, which allows non-rectangular shapes such as an L or a T.
 * The position {@code (x, y)} of the object corresponds to the top-left
 * corner of the shape.</p>
 *
 * <p>Since a {@code ClusterPhysical} is a {@link Physical}, it can be stored
 * in the same collections as any other physical object, and the
 * {@code World} can treat it polymorphically.</p>
 *
 * @author fabriziocasillas, thrinkler
 * @version 0.1
 */
public class ClusterPhysical extends Physical {

    /**
     * Character used in a shape to mark a cell that is not part
     * of the object.
     */
    public static final char EMPTY = ' ';

    private final char[][] shape;

    /**
     * Creates a new cluster with the specified position and shape.
     *
     * @param x the horizontal position of the top-left corner of the shape
     * @param y the vertical position of the top-left corner of the shape
     * @param shape the two-dimensional array of characters describing
     *              the cluster; {@link #EMPTY} cells are not occupied
     */
    public ClusterPhysical(int x, int y, char[][] shape) {
        super(x, y, firstSprite(shape));
        this.shape = shape;
    }

    /**
     * Creates a new rectangular cluster completely filled with the
     * same sprite.
     *
     * @param x the horizontal position of the top-left corner
     * @param y the vertical position of the top-left corner
     * @param width the number of columns of the cluster
     * @param height the number of rows of the cluster
     * @param sprite the character used to fill every cell
     */
    public ClusterPhysical(int x, int y, int width, int height, char sprite) {
        this(x, y, filled(width, height, sprite));
    }

    /**
     * Creates a new cluster from lines of text, where each line is a row
     * of the shape.
     *
     * @param x the horizontal position of the top-left corner
     * @param y the vertical position of the top-left corner
     * @param rows the rows of the shape; spaces represent empty cells
     */
    public ClusterPhysical(int x, int y, String... rows) {
        this(x, y, toMatrix(rows));
    }

    /**
     * Returns the width of the cluster in cells.
     *
     * <p>The width is the length of the longest row of the shape.</p>
     *
     * @return the number of columns of the shape
     */
    @Override
    public int getWidth() {
        int width = 0;

        for (char[] row : shape) {
            width = Math.max(width, row.length);
        }

        return width;
    }

    /**
     * Returns the height of the cluster in cells.
     *
     * @return the number of rows of the shape
     */
    @Override
    public int getHeight() {
        return shape.length;
    }

    /**
     * Checks whether the cluster occupies the specified cell of the world.
     *
     * <p>The world coordinates are converted to local coordinates of the
     * shape by subtracting the position of the cluster. The cell is
     * occupied if it lies inside the shape and is not {@link #EMPTY}.</p>
     *
     * @param px the horizontal position of the cell in world coordinates
     * @param py the vertical position of the cell in world coordinates
     * @return {@code true} if the cluster occupies the cell,
     *         {@code false} otherwise
     */
    @Override
    public boolean occupies(int px, int py) {

        int localX = px - getX();
        int localY = py - getY();

        if (localY < 0 || localY >= shape.length) {
            return false;
        }

        if (localX < 0 || localX >= shape[localY].length) {
            return false;
        }

        return shape[localY][localX] != EMPTY;
    }

    /**
     * Returns the sprite that the cluster draws at the specified cell
     * of the world.
     *
     * <p>The result is only meaningful if
     * {@link #occupies(int, int)} returns {@code true} for the same cell.</p>
     *
     * @param px the horizontal position of the cell in world coordinates
     * @param py the vertical position of the cell in world coordinates
     * @return the sprite character of that cell of the shape
     */
    @Override
    public char getSpriteAt(int px, int py) {
        return shape[py - getY()][px - getX()];
    }

    /**
     * Returns the absolute coordinates of every cell occupied by the
     * cluster.
     *
     * <p>Cells marked as {@link #EMPTY} are not included.</p>
     *
     * @return an array of {@code {x, y}} pairs, one for each occupied cell
     */
    @Override
    public int[][] getCells() {

        ArrayList<int[]> cells = new ArrayList<>();

        for (int localY = 0; localY < shape.length; localY++) {
            for (int localX = 0; localX < shape[localY].length; localX++) {

                if (shape[localY][localX] != EMPTY) {
                    cells.add(new int[]{getX() + localX, getY() + localY});
                }
            }
        }

        return cells.toArray(new int[0][]);
    }

    /**
     * Returns the first non-empty character of a shape, used as the
     * default sprite of the cluster.
     *
     * @param shape the shape to inspect
     * @return the first occupied sprite, or {@link #EMPTY} if there is none
     */
    private static char firstSprite(char[][] shape) {

        for (char[] row : shape) {
            for (char c : row) {
                if (c != EMPTY) {
                    return c;
                }
            }
        }

        return EMPTY;
    }

    /**
     * Builds a rectangular shape completely filled with one character.
     *
     * @param width the number of columns
     * @param height the number of rows
     * @param sprite the character used to fill the shape
     * @return the resulting two-dimensional array
     */
    private static char[][] filled(int width, int height, char sprite) {

        char[][] matrix = new char[height][width];

        for (char[] row : matrix) {
            Arrays.fill(row, sprite);
        }

        return matrix;
    }

    /**
     * Converts an array of text lines into a two-dimensional character array.
     *
     * @param rows the lines of text, one for each row of the shape
     * @return the resulting two-dimensional array
     */
    private static char[][] toMatrix(String[] rows) {

        char[][] matrix = new char[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            matrix[i] = rows[i].toCharArray();
        }

        return matrix;
    }
}