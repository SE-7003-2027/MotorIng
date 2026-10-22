
package src;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import src.Inputs.JframeInput;
import src.World.World;

/**
 * Graphical scene implementation using Java Swing.
 *
 * <p>Manages the game window and delegates rendering to MapPanel.</p>
 *
 * @version 0.2
 */
public class Draw extends Scenery {

    private final MapPanel panel;
    private final JframeInput input;
    private JFrame window;

    /**
     * Creates a graphical scene.
     *
     * @param world world to display
     * @param input keyboard input handler
     */
    public Draw(World world, JframeInput input) {
        super(world);

        this.input = input;
        this.panel = new MapPanel(world);
        this.window = null;
    }

    /**
     * Creates and displays the game window if it is not already open.
     */
    public void drawMap() {
        if (window != null) {
            window.setVisible(true);
            panel.requestFocusInWindow();
            return;
        }

        window = new JFrame("MotorIng");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(panel);
        panel.addKeyListener(input);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        panel.requestFocusInWindow();
    }

    /**
     * Refreshes the graphical scene.
     */
    @Override
    public void show() {
        panel.setMessage(getMessage());
        panel.repaint();
    }

    /**
     * Changes the world rendered by the scene.
     *
     * @param world new world to display
     */
    @Override
    public void changeWorld(World world) {
        super.changeWorld(world);
        panel.setWorld(world);
        panel.setMessage(getMessage());
    }

    /**
     * Returns the panel used to render the game.
     *
     * @return graphical map panel
     */
    public MapPanel getPanel() {
        return panel;
    }
}
