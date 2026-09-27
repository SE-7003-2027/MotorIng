package src.World;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Reads static maps from external text files.
 *
 * <p>Each line of the input file represents a row of the map,
 * and each character in a line represents a tile. The resulting
 * map is stored as a two-dimensional character array.</p>
 *
 * <p>This class separates the process of reading a map from the
 * representation of the map itself, allowing maps to be stored
 * externally and loaded when needed.</p>
 *
 * @author fabriziocasillas
 * @version 0.1
 */
public class MapReader {

    /**
     * Reads a map from the specified text file.
     *
     * <p>Each line is converted into a character array and stored
     * as a row of the map. After all lines have been read, a
     * {@link Map} object is created using the resulting array.</p>
     *
     * @param filename the path to the text file containing the map
     * @return a {@link Map} containing the tiles read from the file
     * @throws IOException if the file cannot be opened or an error
     *                     occurs while reading it
     */
    public static Map read(String filename) throws IOException {

        ArrayList<char[]> rows = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
            new FileReader(filename)
        );

        String line;

        while ((line = reader.readLine()) != null) {
            rows.add(line.toCharArray());
        }

        reader.close();

        char[][] tiles = new char[rows.size()][];

        for (int i = 0; i < rows.size(); i++) {
            tiles[i] = rows.get(i);
        }

        return new Map(tiles);
    }
}
