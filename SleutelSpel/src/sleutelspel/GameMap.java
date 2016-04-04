package sleutelspel;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class GameMap {
        
    private Wall wall;
    private Barricade keylock;
    private Barricade fire;
    private Tile tile;
    private Key key;
    private Key bucket;
    private Finish finish;
    private GameManager gameManager;
    private Player player;
        
    public GameMap(){
        
        this.wall = new Wall();
        this.keylock = new Barricade(1);
        this.fire = new Barricade(2);
        this.tile = new Tile();
        this.key = new Key(1);
        this.bucket = new Key(2);
        this.finish = new Finish();
        this.gameManager = new GameManager();
        this.player = new Player();
        this.gameManager.loadMap(this.gameManager.getCurrentMap());
    }
    
    public boolean checkUpMovement(){
        
        boolean upMovement = true;
        
        if (this.player.getyPos() / 50 != 0){
            
            switch (this.gameManager.getTiles()[this.player.getyPos() / 50 - 1][this.player.getxPos() / 50]){
                
                case 1: 
                    upMovement = false;
                    break;
                
                case 2: 
                    if (!this.key.isIsPickedUp()){
                        upMovement = false;
                        this.gameManager.showMessage("You cannot go here.", "Barricade");
                        break;
                    }
                
                    else if (this.key.isIsPickedUp()){
                        upMovement = true;
                        break;
                    }
                    
                case 6:
                    if (!this.bucket.isIsPickedUp()){
                        upMovement = false;
                        this.gameManager.showMessage("You cannot go here.", "Barricade");
                        break;
                    }
                
                    else {
                        upMovement = true; 
                        break;
                    }                    
            }
        } 
        
        return upMovement;
    }
    
    public boolean checkDownMovement(){
        
        boolean downMovement = true;
        
        if (player.getyPos() / 50 != 9){
            
            switch (this.gameManager.getTiles()[this.player.getyPos() / 50 + 1][this.player.getxPos() / 50]){
                
                case 1: 
                    downMovement = false;
                    break;
                
                case 2: 
                    if (!this.key.isIsPickedUp()){
                        downMovement = false;
                        this.gameManager.showMessage("You cannot go here.", "Barricade");
                        break;
                    }
                
                    else if (this.key.isIsPickedUp()){
                        downMovement = true;   
                        break;
                    }
                
                case 6:
                    if (!this.bucket.isIsPickedUp()){
                        downMovement = false;
                        this.gameManager.showMessage("You cannot go here.", "Barricade");
                        break;
                    }
                
                    else {
                        downMovement = true; 
                        break;
                    }                
            }
        } 
        
        return downMovement;
    }
    
    public boolean checkRightMovement(){
       
        boolean rightMovement = true;
        
        if (this.player.getxPos() / 50 != 9){
            
            switch (this.gameManager.getTiles()[this.player.getyPos() / 50][this.player.getxPos() / 50 + 1]){
                
                case 1: 
                    rightMovement = false;
                    break;
                
                case 2: 
                    if (!this.key.isIsPickedUp()){
                        rightMovement = false;
                        this.gameManager.showMessage("You cannot go here.", "Barricade");
                        break;
                    }
                
                    else {
                        rightMovement = true;   
                        break;
                    }
                    
                case 6:
                    if (!this.bucket.isIsPickedUp()){
                        rightMovement = false;
                        this.gameManager.showMessage("You cannot go here.", "Barricade");
                        break;
                    }
                
                    else {
                        rightMovement = true; 
                        break;
                    }                    
            }
        }
        
        return rightMovement;
    }
    
    public boolean checkLeftMovement(){
        
        boolean leftMovement = true;
        
        if (this.player.getxPos() / 50 != 0){
            
            switch (this.gameManager.getTiles()[this.player.getyPos() / 50][this.player.getxPos() / 50 - 1]){
                
                case 1: 
                    leftMovement = false;
                    break;
                
                case 2: 
                    if (!this.key.isIsPickedUp()){
                        leftMovement = false;
                        this.gameManager.showMessage("You cannot go here.", "Barricade");
                        break;
                    }
                
                    else {
                        leftMovement = true; 
                        break;
                    }
                    
                case 6:
                    if (!this.bucket.isIsPickedUp()){
                        leftMovement = false;
                        this.gameManager.showMessage("You cannot go here.", "Barricade");
                        break;
                    }
                
                    else {
                        leftMovement = true; 
                        break;
                    }
            }
        }
        
        return leftMovement;
    }
    
    public void checkAction(){
        
        
        switch(this.gameManager.getTiles()[this.player.getyPos() / 50][this.player.getxPos() / 50]){
            
            case 2:
                this.gameManager.getTiles()[this.player.getyPos() / 50][this.player.getxPos() / 50] = 0;
                break;
                
            case 3:
                this.gameManager.getTiles()[this.player.getyPos() / 50][this.player.getxPos() / 50] = 0;
                this.key.setIsPickedUp(true);
                break;
                

            case 4:
                if (gameManager.getCurrentMap() != 5){
                        this.gameManager.loadMap(this.gameManager.getCurrentMap());
                        this.player.resetPlayerPosition(0, 0);
                        this.key.setIsPickedUp(false);                           
                    }
                    
                    else {
                        this.gameManager.showMessage("You win!", "Congratulations");
                    }
                
            case 5:
                this.gameManager.getTiles()[this.player.getyPos() / 50][this.player.getxPos() / 50] = 0;
                this.bucket.setIsPickedUp(true);
                break;
                
            case 6:
                this.gameManager.getTiles()[this.player.getyPos() / 50][this.player.getxPos() / 50] = 0;
                break;
        }
    }
    
    public void drawMap(Graphics g){
        
        
        for (int i = 0; i < 500; i += 50) {
            for (int j = 0; j < 500; j += 50) {
                
                
                switch (this.gameManager.getTiles()[j / 50][i / 50]){
                    
                    default: this.tile.paintTile(g, i, j);
                        break;
                    
                    case 1: this.wall.paintTile(g, i, j);
                        break;
                    
                    case 2: this.keylock.paintTile(g, i, j);
                        break;
                    
                    case 3: this.key.paintTile(g, i, j);
                        break;
                    
                    case 4: this.finish.paintTile(g, i, j);
                        break;
                        
                    case 5: this.bucket.paintTile(g, i, j);
                        break;
                        
                    case 6: this.fire.paintTile(g, i, j);
                        break;
                }
            }                        
        }
        
        this.player.paintTile(g);
    }    

    public Player getPlayer() {
        return this.player;
    }
    
    public Key getKey(){
        return this.key;
    }
}