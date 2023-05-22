package tarea2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;
/**
*Clase que es el panel principal para sus subpaneles  correspondientes
*@field com,corresponde al panel comprador, es decir, su subpanel
*@field exp,corresponde al panel expendedor, es decir, otro subpanel
*/
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
/**
*Metodo que pinta las componentes respectivas mediante el metodo graphics a este panel
*/
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}