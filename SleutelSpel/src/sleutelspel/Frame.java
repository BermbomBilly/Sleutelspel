package SleutelSpel;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Frame extends JFrame {

    private final int WIDTH = 507;
    private final int HEIGHT = 536;
    private Panel panel;

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