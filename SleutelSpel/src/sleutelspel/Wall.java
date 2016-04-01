package sleutelspel;

import java.awt.*;

public class Wall extends Tile{
    
    public Wall(){
        
        super.getImageReader().loadImage("wall.png");
    }

    @Override
    public void paintTile(Graphics g, int x, int y){

        g.drawImage(super.getImageReader().getImage(), x, y, super.getWidth(), super.getHeight(), null);
    }
}