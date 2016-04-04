package sleutelspel;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameMapTester{
    
    private GameMap map;
    private Wall wall;
    private Barricade barricade;
    private Tile tile;
    private Player player;
    private Key key;
    private Finish finish;
    private GameManager gameManager;   
    private TextReader textReader;
    private int tiles[][];
    
    public GameMapTester(){
        
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
        this.textReader = new TextReader();
        this.gameManager.loadMap(this.gameManager.getCurrentMap());
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
    
    //Test to see if the original boolean becomes false whilst engaging a wall
    @Test
    public void CheckUpMovementCase1Test(){        
        
        map.getPlayer().setyPos(100);
        int test1 = this.gameManager.getTiles()[map.getPlayer().getyPos() / 50 - 1][map.getPlayer().getxPos() / 50];
        int expectedTest1 = 1;
        
        assertEquals("Array waarde", expectedTest1, test1);
        
        boolean test2 = map.checkUpMovement();         
        
        assertFalse(test2);
    }
    
    //Test to see if the original boolean becomes false whilst engaging a barricade without key
    @Test
    public void CheckUpMovementCase2IfTest(){
        
        map.getPlayer().setyPos(400);
        map.getPlayer().setxPos(250);
        int test1 = this.gameManager.getTiles()[map.getPlayer().getyPos() / 50 - 1][map.getPlayer().getxPos() / 50];
        int expectedTest1 = 2;
        
        assertEquals("Array waarde", expectedTest1, test1);
        
        boolean test2 = map.checkUpMovement();
        
        assertFalse(test2);
    }
    
    //Test to see if the original boolean becomes true whilst engaging a barricade with key
    @Test
    public void CheckUpMovementCase2ElseTest(){
        
        map.getPlayer().setyPos(400);
        map.getPlayer().setxPos(250);
        map.getKey().setIsPickedUp(true);
        
        int test1 = this.gameManager.getTiles()[map.getPlayer().getyPos() / 50 - 1][map.getPlayer().getxPos() / 50];
        int expectedTest1 = 2;
        
        assertEquals("Array waarde", expectedTest1, test1);
        
        boolean test2 = map.checkUpMovement();
        
        assertTrue(test2);
    }
    
    //Kapot
//    @Test
//    public void CheckActionTestCase2(){
//        
//        map.getPlayer().setyPos(350);
//        map.getPlayer().setxPos(250);
//        int test1 = this.gameManager.getTiles()[map.getPlayer().getyPos() / 50][map.getPlayer().getxPos() / 50];
//        int expectedTest1 = 2;
//        
//        assertEquals("Array waarde", expectedTest1, test1);
//        
//        map.checkAction();
//        int test2 = this.gameManager.getTiles()[map.getPlayer().getyPos() / 50][map.getPlayer().getxPos() / 50];
//        int expectedTest2 = 0;
//        
//        assertEquals(expectedTest2, test2);
//    }
    
    @Test
    public void CurrentMapTest(){
        
        int test = this.gameManager.getCurrentMap();
        int expectedTest = 2;
        
        assertEquals(expectedTest, test);
    }
}