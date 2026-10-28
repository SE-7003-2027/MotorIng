
package src;

import src.World.World;
import src.Physical.Physical;


import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
<<<<<<< HEAD
import java.util.Vector;
=======
import java.awt.Graphics2D;
import java.awt.AlphaComposite;
import java.awt.RenderingHints;
import java.awt.Dimension;
>>>>>>> origin/main

/**
 * Swing panel responsible for rendering the game world
 * and displaying interface messages over the map.
 *
 * @version 0.2
 */
public class MapPanel extends JPanel {

    private World world;
<<<<<<< HEAD
    static final int tile = 20;
=======
    private String message;

    static final int tile = 64;
>>>>>>> origin/main

    /**
     * Creates a panel associated with a world.
     *
     * @param world world to render
     */
    public MapPanel(World world) {
        this.world = world;
        this.message = null;

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(
                world.getMap().getWidth() * tile,
                world.getMap().getHeight() * tile
        ));
        setFocusable(true);
    }

    /**
     * Changes the world rendered by this panel.
     *
     * @param world new world
     */
    public void setWorld(World world) {
        this.world = world;
        revalidate();
        repaint();
    }

    /**
     * Returns the world rendered by this panel.
     *
     * @return current world
     */
    public World getWorld() {
        return world;
    }

    /**
     * Changes the message displayed over the map.
     *
     * @param message message to display, or null to hide it
     */
    public void setMessage(String message) {
        this.message = message;
        repaint();
    }

    /**
     * Returns the current interface message.
     *
     * @return current message, or null if no message is displayed
     */
    public String getMessage() {
        return message;
    }

    /**
     * Renders the map, physical objects, and optional message overlay.
     *
     * @param g graphics context used for rendering
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
<<<<<<< HEAD
       
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
=======
>>>>>>> origin/main

        if (world == null) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g.create();

        try {
            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            char[][] map = world.getMap().getTiles();

            g2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 32));
            FontMetrics metrics = g2.getFontMetrics();

            // Draw the static map.
            for (int y = 0; y < map.length; y++) {
                for (int x = 0; x < map[y].length; x++) {
                    drawCharacter(
                            g2,
                            map[y][x],
                            x,
                            y,
                            metrics
                    );
                }
            }

            // Draw physical objects over the map.
            for (Physical physical : world.getPhysicals()) {
                drawCharacter(
                        g2,
                        physical.getSprite(),
                        physical.getX(),
                        physical.getY(),
                        metrics
                );
            }

            // Draw the interface message above everything else.
            if (message != null && !message.isBlank()) {
                drawMessage(g2, message);
            }
        } finally {
            g2.dispose();
        }
    }

    /**
     * Draws a character centered inside a map tile.
     *
     * @param g graphics context
     * @param character character to draw
     * @param x horizontal tile coordinate
     * @param y vertical tile coordinate
     * @param metrics font metrics used for alignment
     */
    private void drawCharacter(
            Graphics2D g,
            char character,
            int x,
            int y,
            FontMetrics metrics) {

        int pixelX = x * tile
                + (tile - metrics.charWidth(character)) / 2;
        int pixelY = y * tile
                + (tile - metrics.getHeight()) / 2
                + metrics.getAscent();

        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(character), pixelX, pixelY);
    }

    /**
     * Draws a centered message over a translucent dark background.
     *
     * @param g graphics context
     * @param text message to display
     */
    private void drawMessage(Graphics2D g, String text) {
        Font previousFont = g.getFont();

        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 36));
        FontMetrics metrics = g.getFontMetrics();

        int padding = 32;
        int boxWidth = Math.min(
                getWidth() - 40,
                metrics.stringWidth(text) + padding * 2
        );
        int boxHeight = metrics.getHeight() + padding;

        int boxX = (getWidth() - boxWidth) / 2;
        int boxY = (getHeight() - boxHeight) / 2;

        // Translucent background.
        g.setComposite(
                AlphaComposite.getInstance(
                        AlphaComposite.SRC_OVER,
                        0.85f
                )
        );
        g.setColor(Color.BLACK);
        g.fillRoundRect(boxX, boxY, boxWidth, boxHeight, 24, 24);

        // Message text.
        g.setComposite(AlphaComposite.SrcOver);
        g.setColor(new Color(100, 255, 140));

        int textX = (getWidth() - metrics.stringWidth(text)) / 2;
        int textY = boxY + (boxHeight - metrics.getHeight()) / 2
                + metrics.getAscent();

        g.drawString(text, textX, textY);
        g.setFont(previousFont);
    }
}
