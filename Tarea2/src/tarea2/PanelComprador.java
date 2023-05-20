
package tarea2;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class PanelComprador extends JPanel {
    Image persona;

    public PanelComprador() {
        persona = new ImageIcon("Persona.jpg").getImage();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(persona, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

