package SleutelSpel;



import java.awt.Graphics;

public class Key extends Tile{
    
    private boolean isPickedUp;
   
    public Key(int x){
        
        this.isPickedUp = false;
        int id = x;
        
        switch(id){
            
            case 1:
                super.getImageReader().loadImage("key.png");
                break;
                
            case 2:
                super.getImageReader().loadImage("bucket.png");
                break;
                
            case 3:
                super.getImageReader().loadImage("saw.png");
                break;
        }

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