package sleutelspel;

import javax.swing.*;

public class Frame extends JFrame {

    private final int WIDTH = 500;
    private final int HEIGHT = 522;
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