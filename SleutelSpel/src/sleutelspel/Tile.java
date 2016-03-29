package sleutelspel;

import java.awt.*;

public class Tile {
    
    private int width, height;
    private Color color;

    public Tile(){
        
        this.color = Color.WHITE;
        this.width = 50;
        this.height = 50;
    }

    public int getWidth() {
        
        return width;
    }

    public int getHeight() {
        
        return height;
    }
    
    
    public void paintTile(Graphics g, int x, int y){
        
        g.setColor(this.color);
        g.fillRect(x, y, this.width, this.height);
    }
}