package src.Inputs;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Handles keyboard input from the console.
 *
 * <p>Input is read asynchronously so the game loop does not have to
 * wait for the user to press a key.</p>
 *
 * @author thrinkler
 * @version 0.1
 */
public class ConsoleInput implements Input {

    private final BlockingQueue<String> inputs;
    private volatile boolean running;

    public ConsoleInput() {
        inputs = new LinkedBlockingQueue<>();
        running = true;
        enableRawMode();
        Thread inputThread = new Thread(() -> {
            try {
                while (running) {
                    int value = System.in.read();
                    if (value != -1) {
                        inputs.offer(String.valueOf((char) value));
                    }
                }

            } catch (IOException e) {
                if (running) {
                    e.printStackTrace();
                }
            }
        });
        inputThread.setDaemon(true);
        inputThread.start();
    }

    /**
     * Returns the next available input.
     * @return the next command, or null if there is no input
     */
    public String getInput() {
        return inputs.poll();
    }

    /**
     * Enables raw terminal input so characters are received
     * immediately without pressing Enter.
     *
     * <p>This implementation requires a Unix-like terminal,
     * such as macOS or Linux.</p>
     */
    private void enableRawMode() {

        try {
            new ProcessBuilder(
                    "sh",
                    "-c",
                    "stty -icanon min 1 -echo"
            ).inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Could not enable raw console mode", e);
        }
    }

    /**
     * Restores the terminal to its normal configuration.
     */
    public void close() {
        running = false;
        try {
            new ProcessBuilder(
                    "sh",
                    "-c",
                    "stty sane"
            ).inheritIO().start().waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
