package main;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
class PanelExpendedor extends JPanel {
    Image expendedora;
    private ImageIcon Coquita, Sprite, Super8, Trencito;
    private JButton CokeBoton, SpriteBoton, Super8boton, TrencitoBoton,VueltoBoton;

    public PanelExpendedor() {
        setLayout(null);
        expendedora = new ImageIcon("vending4.jpg").getImage();
        Coquita = new ImageIcon("cocafinal.png");
        Sprite = new ImageIcon("Sprite.png");
        Super8 = new ImageIcon("Super8.png");
        Trencito = new ImageIcon("Trencito.png");
        Botones();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(expendedora, 0, 0, this.getWidth(), this.getHeight(), this);
        int largo1 = 10; // define cuánto a la izquierda quieres empezar
        int space1 = 50;  // define la separación entre imágenes
        for (int i = 0; i < 4; i++) {
            int x = largo1 + i * space1; // calcula la coordenada x para cada imagen
            g.drawImage(Coquita.getImage(), x, 160, null);
            g.drawImage(Coquita.getImage(), x, 190, null);
        }
        int largo2 = 24;
        int space2 = 50;
        for (int i = 0; i < 4; i++) {
            int x = largo2 + i * space2; // calcula la coordenada x para cada imagen
            g.drawImage(Sprite.getImage(), x, 210, null);
            g.drawImage(Sprite.getImage(), x, 230, null);
        }
        int offsetX = 10;
        int spaceX = 40;
        for (int i = 0; i < 4; i++) {
            int x = offsetX + i * spaceX; // calcula la coordenada x para cada imagen
            g.drawImage(Super8.getImage(), x, 280, null);
            g.drawImage(Trencito.getImage(), x, 350, null);
            g.drawImage(Super8.getImage(), x, 320, null);
            g.drawImage(Trencito.getImage(), x, 390, null);
        }
    }

    private void Botones() {
        CokeBoton = new JButton();
        CokeBoton.setBounds(240, 344, 67, 46);
        ImageIcon CoKebotonImage = new ImageIcon("cokebutton.png");
        CokeBoton.setIcon(new ImageIcon(CoKebotonImage.getImage().getScaledInstance(CokeBoton.getWidth(), CokeBoton.getHeight(), Image.SCALE_SMOOTH)));
        this.add(CokeBoton);
        SpriteBoton = new JButton();
        SpriteBoton.setBounds(238, 296, 67, 46);
        ImageIcon SpriteBotonImage = new ImageIcon("Spritebutton.jpg");
        SpriteBoton.setIcon(new ImageIcon(SpriteBotonImage.getImage().getScaledInstance(SpriteBoton.getWidth(), SpriteBoton.getHeight(), Image.SCALE_SMOOTH)));
        this.add(SpriteBoton);
        Super8boton = new JButton();
        Super8boton.setBounds(240, 248, 67, 46);
        ImageIcon Super8botonimage = new ImageIcon("Super8button.png");
        Super8boton.setIcon(new ImageIcon(Super8botonimage.getImage().getScaledInstance(Super8boton.getWidth(), Super8boton.getHeight(), Image.SCALE_SMOOTH)));
        this.add(Super8boton);
        TrencitoBoton = new JButton();
        TrencitoBoton.setBounds(240, 200, 67, 46);
        ImageIcon TrencitoBotonImage = new ImageIcon("Trencitobutton.png");
        TrencitoBoton.setIcon(new ImageIcon(TrencitoBotonImage.getImage().getScaledInstance(TrencitoBoton.getWidth(), TrencitoBoton.getHeight(), Image.SCALE_SMOOTH)));
        this.add(TrencitoBoton);
        VueltoBoton= new JButton();
        VueltoBoton.setBounds(240, 500, 67, 46);
        ImageIcon VueltoBotonImage = new ImageIcon("vuelto.jpg");
        VueltoBoton.setIcon(new ImageIcon(VueltoBotonImage.getImage().getScaledInstance(VueltoBoton.getWidth(), VueltoBoton.getHeight(), Image.SCALE_SMOOTH)));
        this.add(VueltoBoton);
    }
}
