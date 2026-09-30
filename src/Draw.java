package src;
import javax.swing.JFrame;
import src.World.World;


/** 
 * Class used by Scenary for drawn a window that represents 
 * and updates the current map using JavaSwing
 * 
 */

public class Draw extends Scenery{

    private MapPanel panel;

/**
 * Constructor of the map 
 * @param world World
 * 
 */

    public Draw(World world){
        super(world);  
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
        

        window.add(panel);
        window.setVisible(true);

    }

/**
 * Asign the new world in the current panel and repaint it. 
 * @param world
 */

    public void updatePanel(World world){
        changeWorld(world);
        panel.setWorld(world);
        panel.repaint();

    }




}
