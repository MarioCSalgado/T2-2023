
package tarea2;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class PanelExpendedor extends JPanel {
    Image expendedora;

    public PanelExpendedor() {
        expendedora = new ImageIcon("vending4.jpg").getImage();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(expendedora, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}