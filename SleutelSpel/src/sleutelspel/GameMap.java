package sleutelspel;

import java.awt.Color;
import java.awt.Graphics;

public class GameMap {
        
    private Wall wall;
    private Barricade barricade;
    private Tile tile;
    private Key key;
    private Finish finish;
    private GameManager gameManager;
    
    
    public GameMap(){
        
        this.wall = new Wall();
        this.barricade = new Barricade();
        this.tile = new Tile();
        this.key = new Key();
        this.finish = new Finish();
        this.gameManager = new GameManager();
        
        
        gameManager.loadMap(gameManager.getCurrentMap());
    }
    
    public boolean checkUpMovement(int xPos, int yPos){
        
        boolean upMovement = true;
        
        if (yPos / 50 != 0){
            
            switch (gameManager.getTiles()[yPos / 50 - 1][xPos / 50]){
                
                case 1: upMovement = false;
                    break;
                
                case 2: if (!this.key.isIsPickedUp()){
                    upMovement = false;
                    break;
                }
                
                else if (this.key.isIsPickedUp()){
                    upMovement = true;
                    gameManager.getTiles()[yPos / 50 - 1][xPos / 50] = 0;  
                    break;
                }
                   
                case 3: this.key.setIsPickedUp(true);
                    gameManager.getTiles()[yPos / 50 - 1][xPos / 50] = 0;
                    break;      
                case 4: if (gameManager.getCurrentMap() != 4){
                    gameManager.loadMap(gameManager.getCurrentMap());
                    
                }
            }
        } 
        
        return upMovement;
    }
    
    public boolean checkDownMovement(int xPos, int yPos){
        
        boolean downMovement = true;
        
        if (yPos / 50 != 9){
            
            switch (gameManager.getTiles()[yPos / 50 + 1][xPos / 50]){
                
                case 1: downMovement = false;
                    break;
                
                case 2: if (!this.key.isIsPickedUp()){
                    downMovement = false;
                    break;
                }
                
                else if (this.key.isIsPickedUp()){
                    downMovement = true;
                    gameManager.getTiles()[yPos / 50 + 1][xPos / 50] = 0;   
                    break;
                }
                
                case 3: this.key.setIsPickedUp(true);
                    gameManager.getTiles()[yPos / 50 + 1][xPos / 50] = 0;
                    break;
                    
                case 4: if (gameManager.getCurrentMap() != 4){
                    gameManager.loadMap(gameManager.getCurrentMap());
                }
            }
        } 
        
        return downMovement;
    }
    
    public boolean checkRightMovement(int xPos, int yPos){
       
        boolean rightMovement = true;
        
        if (xPos / 50 != 9){
            
            switch (gameManager.getTiles()[yPos / 50][xPos / 50 + 1]){
                
                case 1: rightMovement = false;
                    break;
                
                case 2: if (this.key.isIsPickedUp() == false){
                    rightMovement = false;
                    break;
                }
                
                else {
                    rightMovement = true;
                    gameManager.getTiles()[yPos / 50][xPos / 50 + 1] = 0;   
                    break;
                }
                
                case 3: this.key.setIsPickedUp(true);
                    gameManager.getTiles()[yPos / 50][xPos / 50 + 1] = 0;
                    break;
                    
                case 4: if (gameManager.getCurrentMap() != 4){
                    gameManager.loadMap(gameManager.getCurrentMap());
                }
            }
        }
        
        return rightMovement;
    }
    
    public boolean checkLeftMovement(int xPos, int yPos){
        
        boolean leftMovement = true;
        
        if (xPos / 50 != 0){
            
            switch (gameManager.getTiles()[yPos / 50][xPos / 50 - 1]){
                
                case 1: leftMovement = false;
                    break;
                
                case 2: if (this.key.isIsPickedUp() == false){
                    leftMovement = false;
                    break;
                }
                
                else {
                    leftMovement = true;
                    gameManager.getTiles()[yPos / 50][xPos / 50 - 1] = 0; 
                    break;
                }
                
                case 3: this.key.setIsPickedUp(true);
                    gameManager.getTiles()[yPos / 50][xPos / 50 - 1] = 0;
                    break;
                    
                case 4: if (gameManager.getCurrentMap() != 4){
                    gameManager.loadMap(gameManager.getCurrentMap());
                }
            }
        }
        
        return leftMovement;
    }
    

    
    public void drawMap(Graphics g){
        
        
        for (int i = 0; i < 500; i += 50) {
            for (int j = 0; j < 500; j += 50) {
                
                
                switch (gameManager.getTiles()[j / 50][i / 50]){
                    
                    default: this.tile.paintTile(g, i, j);
                        break;
                    
                    case 1: this.wall.paintTile(g, i, j);
                        break;
                    
                    case 2: this.barricade.paintTile(g, i, j);
                        break;
                    
                    case 3: this.key.paintTile(g, i, j);
                        break;
                    
                    case 4: this.finish.paintTile(g, i, j);
                }

                g.setColor(Color.BLACK);
                g.drawRect(i, j, 50, 50);
            }                        
        }                
    }            
}