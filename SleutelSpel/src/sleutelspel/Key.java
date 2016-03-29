package sleutelspel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Key extends Tile{
    
    private BufferedImage key;
    private boolean isPickedUp;

    
    public Key(){
        
        this.isPickedUp = false;
        
        try {
            
            this.key = ImageIO.read(getClass().getResourceAsStream("key.png"));
        } 
        
        catch (IOException ex) {

            ex.printStackTrace();
        }
    }
    
    @Override
    public void paintTile(Graphics g, int x, int y){
        
        g.drawImage(this.key, x, y, super.getWidth(), super.getHeight(), null);
    }

    public boolean isIsPickedUp() {
        
        return isPickedUp;
    }

    public void setIsPickedUp(boolean isPickedUp) {
        
        this.isPickedUp = isPickedUp;
    }
}