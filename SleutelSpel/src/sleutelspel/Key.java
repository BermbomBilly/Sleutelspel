package SleutelSpel;



import java.awt.Graphics;

public class Key extends Tile{
    
    private boolean isPickedUp;
   
    /**
     * Constructor with a switchcase that determines the image to load
     * @param x id
     */
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
    
    /**
     * Paints an instance of 'Key'
     * @param g graphics
     * @param x x-position in map
     * @param y y-position in map
     */
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