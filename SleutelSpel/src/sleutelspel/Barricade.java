package sleutelspel;

import java.awt.*;

public class Barricade extends Tile{    

    public Barricade(){
        
        super.getImageReader().loadImage("barricade.png");
    }

    @Override
    public void paintTile(Graphics g, int x, int y){

        g.drawImage(super.getImageReader().getImage(), x, y, super.getWidth(), super.getHeight(), null);
    }
}