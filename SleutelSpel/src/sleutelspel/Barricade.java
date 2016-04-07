package SleutelSpel;



import java.awt.*;

public class Barricade extends Tile{    
    
    /**
     * Constructor with a switchcase that determines the image to load
     * @param x id
     */
    public Barricade(int x){
        
        int id = x;
        
        switch (id){
            
            case 1:
                super.getImageReader().loadImage("keylock.png");
                break;
                
            case 2:
                super.getImageReader().loadImage("fire.png");
                break;
                
            case 3:
                super.getImageReader().loadImage("tree.png");
                break;
        }
            
    }
    
    /**
     * Paints an instance of 'Barricade'
     * @param g graphics
     * @param x x-position in map
     * @param y y-postition in map
     */
    @Override
    public void paintTile(Graphics g, int x, int y){

        g.drawImage(super.getImageReader().getImage(), x, y, super.getWidth(), super.getHeight(), null);
    }
}