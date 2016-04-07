package SleutelSpel;



import javax.swing.*;

public class Frame extends JFrame {

    private final int WIDTH = 507;
    private final int HEIGHT = 536;
    private Panel panel;
    
    /**
     * Constructor that creates the frame in which the game will run
     */
    public Frame(){
        
        this.panel = new Panel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Super Pepe: Op zoek naar wiet");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        add(panel);
    }
}