package SleutelSpel;



import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageReader {

    private BufferedImage image;
    
    /**
     * Method that loads an image
     * @param image image you want to load
     */
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