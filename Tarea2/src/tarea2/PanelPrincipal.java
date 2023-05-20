package tarea2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal() {
        this.setLayout(new GridLayout(1, 2)); 
        com = new PanelComprador();
        exp = new PanelExpendedor();
        this.setSize(600,400);
        this.setBackground(Color.CYAN);
        this.add(com); // añade al primer panel
        this.add(exp); // añade al segundo panel
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}


