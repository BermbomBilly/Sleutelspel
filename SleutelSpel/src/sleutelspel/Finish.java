package SleutelSpel;



import java.awt.Graphics;

public class Finish extends Tile{
    
    public Finish(){
               
        super.getImageReader().loadImage("finish.png");
    }
    
    @Override
    public void paintTile(Graphics g, int x, int y){
        
        g.drawImage(super.getImageReader().getImage(), x, y, super.getWidth(), super.getHeight(), null);
    }
}