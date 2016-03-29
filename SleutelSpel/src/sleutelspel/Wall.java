package sleutelspel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Wall extends Tile{
    
    private BufferedImage wall;
    
    public Wall(){
        
        try {
            
            this.wall = ImageIO.read(getClass().getResourceAsStream("wall.png"));
        } 
        
        catch (IOException ex) {
            
            ex.printStackTrace();
        }
    }

    @Override
    public void paintTile(Graphics g, int x, int y){

        g.drawImage(this.wall, x, y, super.getWidth(), super.getHeight(), null);
    }
}