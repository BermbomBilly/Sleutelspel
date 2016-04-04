package sleutelspel;

import java.awt.*;

public class Tile {
    
    private int width, height;
    private Color color;
    private ImageReader imageReader;

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
    
    public void paintTile(Graphics g, int x, int y){
        
        g.setColor(this.color);
        g.fillRect(x, y, this.width, this.height);
    }
}