package SleutelSpel;



import java.awt.*;

public class Player {

    private ImageReader imageReader;
    private int xPos, yPos, width, height;
    private final int MAX_Y = 450;
    private final int MAX_X = 450;
    private final int MIN_Y = 0;
    private final int MIN_X = 0;    
    
    /**
     * Constructor that sets the position of the player and loads an image
     */
    public Player() {
        
        this.xPos = 0;
        this.yPos = 0;
        
        this.width = 50;
        this.height = 50;
        
        this.imageReader = new ImageReader();
        this.imageReader.loadImage("pepe.png");        
    }

    /**
     * Method that makes the player move up if within bounds
     */
    public void moveUp(){
        
        if (this.yPos != MIN_Y){
            this.yPos -= 50;
        }        
    }

    /**
     * Mehtod that makes the player move down if within bounds
     */
    public void moveDown(){
        
        if (this.yPos != MAX_Y){
            this.yPos += 50;
        }
    }

    /**
     * Method that makes the player move left if within bounds
     */
    public void moveLeft(){
        
        if (this.xPos != MIN_X){
            this.xPos -= 50;
        }        
    }

    /**
     * Method that makes the player move right if within bounds
     */
    public void moveRight(){
        
        if (this.xPos != MAX_X){
            this.xPos += 50;
        }
    }
    
    /**
     * Method that resets the player position
     * @param x x-position in map
     * @param y y-position in map
     */
    public void resetPlayerPosition(int x, int y){
        this.setxPos(x);
        this.setyPos(y);
    }    

    /**
     * Paints an instance of 'Player'
     * @param g 
     */
    public void paintTile(Graphics g) {
        
        g.drawImage(this.imageReader.getImage(), this.xPos, this.yPos, this.width, this.height, null);
    }

    public int getxPos() {
        
        return xPos;
    }

    public int getyPos() {
        
        return yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}