
package tarea2;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *metodo main para llamar a la ventana y ocurran las acciones subsiguientes
 */
public class Ventana extends JFrame{
    PanelPrincipal panel;
    
    public Ventana(){
        this.setLayout(new BorderLayout());
        this.setSize(800, 650);
        panel = new PanelPrincipal();
        this.setTitle("Tarea2-Programacion2");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //cerrar aplicación
        this.add(panel,BorderLayout.CENTER); //se agrega al centro
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

