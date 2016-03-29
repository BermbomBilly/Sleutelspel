package sleutelspel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Finish extends Tile{
    
    private BufferedImage finish;
    
    public Finish(){
               
        try {
            
            this.finish = ImageIO.read(getClass().getResourceAsStream("finish.png"));
        } 
        
        catch (IOException ex) {

            ex.printStackTrace();
        }
        
    }
    
    @Override
    public void paintTile(Graphics g, int x, int y){
        
        g.drawImage(this.finish, x, y, super.getWidth(), super.getHeight(), null);
    }
}