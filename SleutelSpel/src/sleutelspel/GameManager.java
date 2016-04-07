package SleutelSpel;



import javax.swing.JOptionPane;

public class GameManager {
    
    private String map1;
    private String map2;
    private String map3;
    private String map4;
    private int currentMap;
    private TextReader textReader;
    private int [][] tiles;

    /**
     * Constructor that sets an int for the current map so that the right map will be loaded
     */
    public GameManager(){
        
        this.currentMap = 1;              
        this.map1 = "Map1.txt";
        this.map2 = "Map2.txt";
        this.map3 = "Map3.txt";
        this.map4 = "Map4.txt";
       
        this.textReader = new TextReader();        
    }
        
    /**
     * Method that loads the right map by using a switchcase
     */
    public void loadMap(){
        switch (this.currentMap){
            case 1: 
                this.tiles = this.textReader.readFile(this.map1);
                this.currentMap++;
                break;
            case 2: 
                this.tiles = this.textReader.readFile(this.map2);
                this.currentMap++;
                break;
            case 3: 
                this.tiles = this.textReader.readFile(this.map3);
                this.currentMap++;
                break;
            case 4: 
                this.tiles = this.textReader.readFile(this.map4);
                this.currentMap++;
                break;
        }
    }
    
    /**
     * Method for showing a message used in the game
     * @param message message you want to show
     * @param title title you want the message to have
     */
    public void showMessage(String message, String title){
        
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
        
    }
        
    public int getCurrentMap() {
        return currentMap;
    }
    
    public void setCurrentMap(int x) {
        this.currentMap = x;
    }

    public int[][] getTiles() {
        return tiles;
    }
}