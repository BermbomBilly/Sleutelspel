package sleutelspel;

import java.awt.Color;
import java.awt.Graphics;

public class GameMap2 {
        
    private int[][] tiles;
    private Wall wall;
    private Barricade barricade;
    private Tile tile;
    private Key key;
    private Finish finish;
    private TextReader textReader;
    
    private String map1;
    private String map2;
    private String map3;
    private String map4;
    
    public GameMap2(){
        
        this.wall = new Wall();
        this.barricade = new Barricade();
        this.tile = new Tile();
        this.key = new Key();
        this.finish = new Finish();
        
        this.map1 = "Map1.txt";
        this.map2 = "Map2.txt";
        this.map3 = "Map3.txt";
        this.map4 = "Map4.txt";

        this.textReader = new TextReader();
        
        tiles = textReader.loadMap(this.map1);                        
    }
    
    public boolean checkUpMovement(int xPos, int yPos){
        
        boolean upMovement = true;
        
        if (yPos / 50 != 0){
            
            switch (this.tiles[yPos / 50 - 1][xPos / 50]){
                
                case 1: upMovement = false;
                    break;
                
                case 2: if (!this.key.isIsPickedUp()){
                    upMovement = false;
                    break;
                }
                
                else if (this.key.isIsPickedUp()){
                    upMovement = true;
                    this.tiles[yPos / 50 - 1][xPos / 50] = 0;  
                    break;
                }
                   
                case 3: this.key.setIsPickedUp(true);
                    this.tiles[yPos / 50 - 1][xPos / 50] = 0;
                    break;                
            }
        } 
        
        return upMovement;
    }
    
    public boolean checkDownMovement(int xPos, int yPos){
        
        boolean downMovement = true;
        
        if (yPos / 50 != 9){
            
            switch (this.tiles[yPos / 50 + 1][xPos / 50]){
                
                case 1: downMovement = false;
                    break;
                
                case 2: if (!this.key.isIsPickedUp()){
                    downMovement = false;
                    break;
                }
                
                else if (this.key.isIsPickedUp()){
                    downMovement = true;
                    this.tiles[yPos / 50 + 1][xPos / 50] = 0;   
                    break;
                }
                
                case 3: this.key.setIsPickedUp(true);
                    this.tiles[yPos / 50 + 1][xPos / 50] = 0;
                    break;
            }
        } 
        
        return downMovement;
    }
    
    public boolean checkRightMovement(int xPos, int yPos){
       
        boolean rightMovement = true;
        
        if (xPos / 50 != 9){
            
            switch (this.tiles[yPos / 50][xPos / 50 + 1]){
                
                case 1: rightMovement = false;
                    break;
                
                case 2: if (this.key.isIsPickedUp() == false){
                    rightMovement = false;
                    break;
                }
                
                else {
                    rightMovement = true;
                    this.tiles[yPos / 50][xPos / 50 + 1] = 0;   
                    break;
                }
                
                case 3: this.key.setIsPickedUp(true);
                    this.tiles[yPos / 50][xPos / 50 + 1] = 0;
                    break;
            }
        }
        
        return rightMovement;
    }
    
    public boolean checkLeftMovement(int xPos, int yPos){
        
        boolean leftMovement = true;
        
        if (xPos / 50 != 0){
            
            switch (this.tiles[yPos / 50][xPos / 50 - 1]){
                
                case 1: leftMovement = false;
                    break;
                
                case 2: if (this.key.isIsPickedUp() == false){
                    leftMovement = false;
                    break;
                }
                
                else {
                    leftMovement = true;
                    this.tiles[yPos / 50][xPos / 50 - 1] = 0; 
                    break;
                }
                
                case 3: this.key.setIsPickedUp(true);
                    this.tiles[yPos / 50][xPos / 50 - 1] = 0;
                    break;
            }
        }
        
        return leftMovement;
    }
    

    
    public void drawMap(Graphics g){
        
        
        for (int i = 0; i < 500; i += 50) {
            for (int j = 0; j < 500; j += 50) {
                
                
                switch (this.tiles[j / 50][i / 50]){
                    
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