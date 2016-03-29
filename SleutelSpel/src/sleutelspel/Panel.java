package sleutelspel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel {

    private GameMap map;
    private Player player;
    private KeyPressed keypressed;

    public Panel(){
        
        this.map = new GameMap();
        this.player = new Player();
        this.keypressed = new KeyPressed();
                
        setFocusable(true);
        addKeyListener(this.keypressed);
        requestFocusInWindow();   
        
    }

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
                 
        this.map.drawMap(g);
        player.paintTile(g);
        
    }

    public class KeyPressed implements KeyListener {
        
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {

            int key = ke.getKeyCode();
            
            if (key == KeyEvent.VK_LEFT && map.checkLeftMovement(player.getxPos(), player.getyPos())) {
                
                player.moveLeft();
                repaint();                
            }
            
            if (key == KeyEvent.VK_RIGHT && map.checkRightMovement(player.getxPos(), player.getyPos())) {
                
                player.moveRight();
                repaint();
            }
            
            if (key == KeyEvent.VK_UP && map.checkUpMovement(player.getxPos(), player.getyPos())) {
                
                player.moveUp();
                repaint();      
            }
            
            if (key == KeyEvent.VK_DOWN && map.checkDownMovement(player.getxPos(), player.getyPos())) {
                
                player.moveDown();
                repaint();               
            }
            
            if (key == KeyEvent.VK_ESCAPE){
                
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {

        }                
    }
}