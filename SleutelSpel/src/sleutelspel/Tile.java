package SleutelSpel;



import java.awt.*;

public class Tile {
    
    private int width, height;
    private Color color;
    private ImageReader imageReader;

    /**
     * Constructor that creates a basic tile and creates a new image reader used for inheritance 
     */
    public Tile(){
        
        this.color = Color.GRAY.brighter();
        this.width = 50;
        this.height = 50;
        this.imageReader = new ImageReader();
    }
    
    public int getWidth() {
        
        return width;
    }

    public int getHeight() {
        
        return height;
    }

    public ImageReader getImageReader() {
        return imageReader;
    }
    
    /**
     * Paints an instance of 'Tile'
     * @param g graphics
     * @param x x-position in map
     * @param y y-position in map
     */
    public void paintTile(Graphics g, int x, int y){
        
        g.setColor(this.color);
        g.fillRect(x, y, this.width, this.height);
    }
}