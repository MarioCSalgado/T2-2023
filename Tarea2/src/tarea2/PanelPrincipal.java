package tarea2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;
    public static int resumen=0;
    public PanelPrincipal() {
        this.setLayout(new GridLayout(1, 2)); 
        com = new PanelComprador();
        exp = new PanelExpendedor();
        this.setBackground(Color.CYAN);
        com.setPanelExpendedor(exp);
        this.add(com); 
        this.add(exp); 
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}