package src;
import javax.swing.JFrame;

import src.Inputs.JframeInput;
import src.World.World;


/** 
 * Class used by Scenary for drawn a window that represents 
 * and updates the current map using JavaSwing
 * 
 */

public class Draw extends Scenery{

    private MapPanel panel;
    private JframeInput input;

/**
 * Constructor of the map 
 * @param world World
 * 
 */

    public Draw(World world, JframeInput input) {
        super(world);
        this.input = input;
        panel = new MapPanel(world);
    }

/**
 * Draw the map using a panel, in a window that opens to call this function
 * 
 */

    public void drawMap(){
        JFrame window = new JFrame();
        window.setSize(1000,1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setFocusable(true);
        panel.addKeyListener(input);
        window.add(panel);

        window.setVisible(true);

        panel.requestFocusInWindow();
    }

    @Override
    public void show(){
        panel.repaint();
    }

/**
 * Asign the new world in the current panel and repaint it. 
 * @param world
 */
    @Override
    public void changeWorld(World world){
        super.changeWorld(world);
        panel.setWorld(world);
        panel.repaint();
    }




}
