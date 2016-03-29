package sleutelspel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Barricade extends Tile{
    
    private BufferedImage barricade;

    public Barricade(){
        
        try {
            
            this.barricade = ImageIO.read(getClass().getResourceAsStream("barricade.png"));
        } 
        
        catch (IOException ex) {
            
            ex.printStackTrace();
        }
    }

    @Override
    public void paintTile(Graphics g, int x, int y){

        g.drawImage(this.barricade, x, y, super.getWidth(), super.getHeight(), null);
    }
}