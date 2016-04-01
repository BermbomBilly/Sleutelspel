package sleutelspel;

import java.awt.Graphics;

public class Key extends Tile{
    
    private boolean isPickedUp;
   
    public Key(){
        
        this.isPickedUp = false;
        
        super.getImageReader().loadImage("key.png");
    }
    
    @Override
    public void paintTile(Graphics g, int x, int y){
        
        g.drawImage(super.getImageReader().getImage(), x, y, super.getWidth(), super.getHeight(), null);
    }

    public boolean isIsPickedUp() {
        
        return isPickedUp;
    }

    public void setIsPickedUp(boolean isPickedUp) {
        
        this.isPickedUp = isPickedUp;
    }
}