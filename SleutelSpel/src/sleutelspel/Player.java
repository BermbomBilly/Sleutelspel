package sleutelspel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player  {

    private BufferedImage pepe;
    private int xPos, yPos, width, height;
    private final int MAX_Y = 450;
    private final int MAX_X = 450;
    private final int MIN_Y = 0;
    private final int MIN_X = 0;    

    public Player() {
        
        this.xPos = 0;
        this.yPos = 0;
        
        this.width = 50;
        this.height = 50;
        
        try {
            
            this.pepe = ImageIO.read(getClass().getResourceAsStream("pepe.png"));
        } 
        
        catch (IOException ex) {
            
            ex.printStackTrace();
        }
        
    }

    public void moveUp(){
        
        if (this.yPos != MIN_Y){
            this.yPos -= 50;
        }        
    }

    public void moveDown(){
        
        if (this.yPos != MAX_Y){
            this.yPos += 50;
        }
    }

    public void moveLeft(){
        
        if (this.xPos != MIN_X){
            this.xPos -= 50;
        }        
    }

    public void moveRight(){
        
        if (this.xPos != MAX_X){
            this.xPos += 50;
        }
    }


    public void paintTile(Graphics g) {
        
        g.drawImage(this.pepe, this.xPos, this.yPos, this.width, this.height, null);
    }

    public int getxPos() {
        
        return xPos;
    }

    public int getyPos() {
        
        return yPos;
    }
}