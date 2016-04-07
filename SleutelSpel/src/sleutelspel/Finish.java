package SleutelSpel;



import java.awt.Graphics;

public class Finish extends Tile{
    
    /**
     * Constructor that loads the image
     */
    public Finish(){
               
        super.getImageReader().loadImage("finish.png");
    }
    
    /**
     * Paints an instance of 'Finish'
     * @param g graphics
     * @param x x-position in map
     * @param y y-position in map
     */
    @Override
    public void paintTile(Graphics g, int x, int y){
        
        g.drawImage(super.getImageReader().getImage(), x, y, super.getWidth(), super.getHeight(), null);
    }
}