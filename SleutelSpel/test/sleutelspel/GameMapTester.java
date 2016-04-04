package sleutelspel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameMapTester{
    
    private GameMap map;
    private Wall wall;
    private Barricade barricade;
    private Tile tile;
    private Key key;
    private Finish finish;
    private GameManager gameManager;
    private Player player;    
    
    public GameMapTester(){
        
    }
    
    @BeforeClass
    public static void setUpClass(){
        
    }
    
    @AfterClass
    public static void tearDownClass(){
        
    }
    
    @Before
    public void setUp(){
        
        this.map = new GameMap();
        this.wall = new Wall();
        this.barricade = new Barricade();
        this.tile = new Tile();
        this.key = new Key();
        this.finish = new Finish();
        this.gameManager = new GameManager();
        this.player = new Player();
    }
    
    @After
    public void tearDown(){
        
    }
    
    //Test to see if the original boolean is set to true when the method is called upon
    @Test
    public void initialCheckUpMovementTest(){
        
        boolean test = map.checkUpMovement();
        
        assertTrue(test);
    }
    
    //Test to see if the original boolean stays true whilst not engaging in the if statement of the method
    @Test
    public void noIfCheckUpMovementTest(){
        
        boolean test = map.checkUpMovement();
        
        this.player.setyPos(0);
        
        assertTrue(test);
    }
    
    
    @Test
    public void CheckUpMovementCase1Test(){        
        
        
        this.player.setyPos(100);
        this.player.setxPos(0);
        boolean test = map.checkUpMovement();
        boolean expectedTest = false;        
        
        assertFalse(test);
    }
}
