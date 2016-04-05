package SleutelSpel;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextReader {
    
    private Scanner scanner;
    private File file;
    private URL url;
    private int tiles[][];       
    
    public TextReader(){
        
        this.tiles = new int[10][10];        
    }
 
    public int[][] readFile(String map){
        
        this.url = getClass().getResource(map);
        this.file = new File(this.url.getPath());
        
        try {
            
            this.scanner = new Scanner(this.file);
        } 
        
        catch (FileNotFoundException ex) {
            
            Logger.getLogger(TextReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles.length; j++) {
                
                this.tiles[i][j] = this.scanner.nextInt();               
            }            
        }
        
        return this.tiles;
    }

}