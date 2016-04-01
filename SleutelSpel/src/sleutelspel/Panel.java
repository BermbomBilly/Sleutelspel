package sleutelspel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel {

    private GameMap map;
    private KeyPressed keypressed;

    public Panel(){
        
        this.map = new GameMap();
        this.keypressed = new KeyPressed();                
        setFocusable(true);
        addKeyListener(this.keypressed);
        requestFocusInWindow();   
        
    }

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
                 
        this.map.drawMap(g);

        
    }

    public class KeyPressed implements KeyListener {
        
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {

            int key = ke.getKeyCode();
            
            if (key == KeyEvent.VK_LEFT && map.checkLeftMovement()) {
                
                map.getPlayer().moveLeft();
                repaint(); 
                map.checkAction();               
            }
            
            if (key == KeyEvent.VK_RIGHT && map.checkRightMovement()) {
                
                map.getPlayer().moveRight();
                repaint(); 
                map.checkAction();
            }
            
            if (key == KeyEvent.VK_UP && map.checkUpMovement()) {
                
                map.getPlayer().moveUp();
                repaint();                 
                map.checkAction();      
            }
            
            if (key == KeyEvent.VK_DOWN && map.checkDownMovement()) {
                
                map.getPlayer().moveDown();
                repaint();                 
                map.checkAction();            
            }
            
            if (key == KeyEvent.VK_ESCAPE){
                
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {

        }                
    }
}