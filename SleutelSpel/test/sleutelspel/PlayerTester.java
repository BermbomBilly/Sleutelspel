package sleutelspel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTester {
    
    private Player player;
    private int xPos, yPos, width, height;
    
    public PlayerTester(){
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
        
        this.player = new Player();
        this.xPos = 0;
        this.yPos = 0;
        this.width = 50;
        this.height = 50;
    }
    
    @After
    public void tearDown(){
        
    }
    
    @Test
    public void setxPosTest(){
        
       this.player.setxPos(50);
       
       int xPos = this.player.getxPos();
       int expectedxPos = 50;
       
       assertEquals("xPos test", expectedxPos, xPos);
    }
    
    @Test
    public void setyPosTest(){
        
        this.player.setyPos(50);
        
        int yPos = this.player.getyPos();
        int expectedyPos = 50;
        
        assertEquals("yPos test", expectedyPos, yPos);
    }
    
    @Test
    public void upMovementTest(){
        
        this.player.setyPos(300);
        
        this.player.moveUp();
        
        int yPos = this.player.getyPos();
        int expectedyPos = 300 - 50;
        
        assertEquals("yPos check after up movement", expectedyPos, yPos);        
    }
    
    @Test
    public void downMovementTest(){
        
        this.player.setyPos(300);
        
        this.player.moveDown();
        
        int yPos = this.player.getyPos();
        int expectedyPos = 300 + 50;
        
        assertEquals("yPos check after down movement", expectedyPos, yPos);
    }
    
    @Test
    public void leftMovementTest(){
        
        this.player.setxPos(300);
        
        this.player.moveLeft();
        
        int xPos = this.player.getxPos();
        int expectedxPos = 300 - 50;
        
        assertEquals("xPos check after left movement", expectedxPos, xPos);
    }
    
    @Test
    public void rightMovementTest(){
        
        this.player.setxPos(300);
        
        this.player.moveRight();
        
        int xPos = this.player.getxPos();
        int expectedxPos = 300 + 50;
        
        assertEquals("xPos check after right movement", expectedxPos, xPos);
    }
    
    @Test
    public void resetPlayerPositionTest(){
        
        this.player.setxPos(100);
        this.player.setyPos(100);
        
        this.player.resetPlayerPosition(0, 0);
        
        int xPos = this.player.getxPos();
        int expectedxPos = 0;
        
        assertEquals("xPos check after player reset", expectedxPos, xPos);

        int yPos = this.player.getyPos();
        int expectedyPos = 0;
        
        assertEquals("yPos check after player reset", expectedyPos, yPos);
    }
}