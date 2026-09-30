package src;


import src.World.World;
import src.Physical.*;

import javax.swing.JPanel;
import java.awt.Graphics;


public class MapPanel extends JPanel{

    private World world;
    static final int tile = 64;

    /**
     * Contructor of MapPanel
     * @param world
     */ 

    public MapPanel(World world){
        this.world = world;
    }

    /** 
     * Change the World attribute from the actual object
     * @param World world
     * 
     */

    public void setWorld(World world){
        this.world = world;
    }

    /** 
     * Obtain the World attribute from the Panel
     * @return World attribute 
     * 
     */

    public World getWorld(){
        return this.world;
    }

    /** 
     * Draw the actual attribute of the panel using the world using the graphics of JPanel
     * @param Graphics g
     * 
     */

    @Override 
    public void paintComponent(Graphics g){
        char[][] map = this.getWorld().getMap().getTiles();

        super.paintComponent(g);
       
        for(int i = 0 ; i < map.length; i++){
            for (int j = 0 ; j < map[i].length; j++){
                String lopo = String.valueOf(map[i][j]);
                g.drawString(lopo, j*tile, i*tile+tile);
            }
        }
        
        for(int i = 0; i< world.getPhysicals().size(); i++){
            Physical actual = world.getPhysicals().get(i);
            g.drawString(String.valueOf(actual.getSprite()),
             actual.getX() *tile,
            actual.getY()*tile+tile);
        }  

    }

    
}
