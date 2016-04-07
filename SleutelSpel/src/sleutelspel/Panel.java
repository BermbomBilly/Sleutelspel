package SleutelSpel;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel {

    private GameMap map;
    private KeyPressed keypressed;
    private JButton startButton;
    private JButton selectLevelButton;
    private JButton quitButton;
    private ClickListener listener;
    private boolean drawGame;
    private JButton level1;
    private JButton level2;
    private JButton level3;
    private JButton level4;
    
    /**
     * Constructor that creates the panel on which the game is drawn
     */
    public Panel(){
        
        this.drawGame = false;
        setLayout(null);
        this.listener = new ClickListener();
        createMenuButtons();
        createLevelSelectButtons();
        this.map = new GameMap();
        this.keypressed = new KeyPressed();                
        setFocusable(true);
        addKeyListener(this.keypressed);
        requestFocusInWindow(); 
        setBackground(Color.GRAY.brighter());
    }
    
    /**
     * Method that creates the buttons used in the main menu
     */
    private void createMenuButtons(){
                       
        this.startButton = new JButton("Start");
        this.selectLevelButton = new JButton("Select Level");
        this.quitButton = new JButton("Quit");
        this.startButton.addActionListener(listener);
        this.selectLevelButton.addActionListener(listener);
        this.quitButton.addActionListener(listener);
        this.startButton.setBounds(160, 100, 200, 100);
        this.selectLevelButton.setBounds(160, 200, 200, 100);
        this.quitButton.setBounds(160, 300, 200, 100);
        add(startButton);
        add(selectLevelButton);
        add(quitButton);
    }        
    
    /**
     * Method that creates the buttons used in the sub menu of the main menu
     */
    private void createLevelSelectButtons(){
        
        this.level1 = new JButton("Level 1");
        this.level2 = new JButton("Level 2");
        this.level3 = new JButton("Level 3");
        this.level4 = new JButton("Level 4");        
        this.level1.addActionListener(listener);
        this.level2.addActionListener(listener);
        this.level3.addActionListener(listener);
        this.level4.addActionListener(listener);
        this.level1.setBounds(160, 65, 200, 100);
        this.level2.setBounds(160, 165, 200, 100);
        this.level3.setBounds(160, 265, 200, 100);
        this.level4.setBounds(160, 365, 200, 100);
    }
    
    /**
     * Method that draws the map if the boolean is true, this happens when the 'Start Game' button is clicked or a level is selected
     * @param g graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
                 
        if(drawGame){
            this.map.drawMap(g);
        }        
    }

    /**
     * Key listener for keys used in game
     */
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
                
                map.getGameManager().setCurrentMap(map.getGameManager().getCurrentMap() - 1);
                map.getGameManager().loadMap();
                map.resetAll();
                repaint();
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {

        }                
    }
    
    /**
     * Action listener for the buttons used in the game's menus
     */
    public class ClickListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource() == startButton){
                
                removeAll();
                map.resetAll();
                drawGame = true;
                map.getGameManager().setCurrentMap(1);
                map.getGameManager().loadMap();
                repaint();
                
            }
            
            if(e.getSource() == selectLevelButton){
                
                removeAll();
                add(level1);
                add(level2);
                add(level3);
                add(level4);
                repaint();
            }
            
            if(e.getSource() == quitButton){
                
                System.exit(0);
            }
            
            if(e.getSource() == level1){
                
                removeAll();
                map.resetAll();                
                drawGame = true;
                map.getGameManager().setCurrentMap(1);                
                map.getGameManager().loadMap();
                repaint();
            }
            
            if(e.getSource() == level2){
                
                removeAll();
                map.resetAll();                
                drawGame = true;
                map.getGameManager().setCurrentMap(2);
                map.getGameManager().loadMap();
                repaint();                
            }
            
            if(e.getSource() == level3){
                
                removeAll();
                map.resetAll();                
                drawGame = true;
                map.getGameManager().setCurrentMap(3);
                map.getGameManager().loadMap();
                repaint();                
            }
            
            if(e.getSource() == level4){
                
                removeAll();
                map.resetAll();                
                drawGame = true;
                map.getGameManager().setCurrentMap(4);
                map.getGameManager().loadMap();
                repaint();                
            }
        }                
    }    
}