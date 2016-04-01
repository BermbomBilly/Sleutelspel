package sleutelspel;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageReader {

    private BufferedImage image;
    
    public void loadImage(String image){
        
         try {
            
            this.image = ImageIO.read(getClass().getResourceAsStream(image));
        } 
        
        catch (IOException ex) {
            
            ex.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return image;
    }
}