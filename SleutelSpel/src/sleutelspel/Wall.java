package SleutelSpel;



import java.awt.*;

public class Wall extends Tile{
    
    /**
     * Constructor that loads an image
     */
    public Wall(){
        
        super.getImageReader().loadImage("wall.png");
    }

    /**
     * Paints an instance of 'Wall'
     * @param g graphics
     * @param x x-position in map
     * @param y y-position i nmap
     */
    @Override
    public void paintTile(Graphics g, int x, int y){

        g.drawImage(super.getImageReader().getImage(), x, y, super.getWidth(), super.getHeight(), null);
    }
}