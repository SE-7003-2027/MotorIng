package src;


import src.World.World;
import src.Physical.*;


import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Vector;


public class MapPanel extends JPanel{

    private World world;
    static final int tile = 20;

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
                String actual = String.valueOf(map[i][j]);
                
                if(actual.equals(" ")){
                    g.drawRect(j*tile, i*tile, tile, tile);
                }
                else if(actual.equals("#")){
                    g.fillRect(j*tile, i*tile, tile, tile);
                }            
                else{
                    g.drawString(actual, j*tile, i*tile+tile);
                }
            }
        }

        Vector <Physical> physicals = world.getPhysicals();
        for(int i = 0; i< physicals.size(); i++){
            if(physicals.get(i) instanceof ClusterPhysical){
                int x = physicals.get(i).getX();
                int y = physicals.get(i).getY();
                for(int j = 0; j < physicals.get(i).getHeight(); j++){
                    int ytrue = y + j;
                    for(int k = 0; k < physicals.get(i).getWidth(); k++){
                        int xtrue = x + k;
                        if (physicals.get(i).occupies(xtrue, ytrue) &&
                            physicals.get(i).getSpriteAt(xtrue, ytrue) == '#') {

                            g.fillRect(xtrue*tile, ytrue*tile, tile, tile);
                        }
                        else{
                            g.drawString(String.valueOf(physicals.get(i).getSpriteAt(xtrue, ytrue))
                            , xtrue *tile,
                             ytrue*tile+tile );
                            
                        }
                        
                    }

                }
            }
            else{
                Physical actual = world.getPhysicals().get(i);
                g.drawString(String.valueOf(actual.getSprite()),
                actual.getX() *tile,
                actual.getY()*tile+tile);
            }
        }  

    }

    
}
