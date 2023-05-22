package tarea2;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

class PanelExpendedor extends JPanel {
    Image expendedora;
    private ImageIcon Coquita, Sprite, Super8, Trencito;
    private JButton CokeBoton, SpriteBoton, Super8boton, TrencitoBoton,VueltoBoton;
    Expendedor exp;
    Comprador nuevo= null;
    JLabel dineroDisponible;
    JLabel compra;
    JLabel entregaProducto;   
    JLabel entregaVuelto;
    int dineroActual=0;
    

    public PanelExpendedor() {
        setLayout(null);
        exp= new Expendedor(12);
        expendedora = new ImageIcon("vending4.jpg").getImage();
        Coquita = new ImageIcon("cocafinal.png");
        Sprite = new ImageIcon("Sprite.png");
        Super8 = new ImageIcon("Super8.png");
        Trencito = new ImageIcon("Trencito.png");
        BotonesExpendedor();     
        labelsActualizables();
    }
    
    public void actualizarDineroDisponible(int nuevoDinero) {
        dineroActual = nuevoDinero + dineroActual;
        dineroDisponible();
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
    
    
    private void BotonesExpendedor() {
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
        
        oyentesDeMouseExpendedor();
    }
    
    private void labelsActualizables(){
        dineroDisponibleInicial();
        resultadoCompra();
        entregaProductoExp();
    }
    
    private void oyentesDeMouseExpendedor(){
        oyenteDeMouseBCoke();
        oyenteDeMouseBSprite();
        oyenteDeMouseBTrencito();
        oyenteDeMouseBSuper8();
        oyenteDeMouseBVuelto();
    }
    
    private void oyenteDeMouseBCoke(){
        MouseListener mouseCoke = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    nuevo = new Comprador(dineroActual, Expendedor.COCA, exp);
                    System.out.println(nuevo.queDegustaste() + ", " + nuevo.cuantoVuelto());
                    dineroActual = nuevo.cuantoVuelto();
                    correcto();
                    dineroDisponible();
                    entregaCoca();
                    
                } catch (PagoIncorrectoException ex) {
                    incorrecto();
                } catch (PagoInsuficienteException ex) {
                    incorrecto();
                } catch (NoHayProductoException ex) {
                    incorrecto();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        CokeBoton.addMouseListener(mouseCoke);
    }
    private void oyenteDeMouseBSprite(){
        MouseListener mouseSprite = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    nuevo = new Comprador(dineroActual, Expendedor.SPRITE, exp);
                    System.out.println(nuevo.queDegustaste() + ", " + nuevo.cuantoVuelto());
                    dineroActual = nuevo.cuantoVuelto();
                    correcto();
                    dineroDisponible();
                    entregaSprite();
                    
                } catch (PagoIncorrectoException ex) {
                    incorrecto();
                } catch (PagoInsuficienteException ex) {
                    incorrecto();
                } catch (NoHayProductoException ex) {
                    incorrecto();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        SpriteBoton.addMouseListener(mouseSprite);
    }
    
    private void oyenteDeMouseBTrencito(){
        MouseListener mouseTrencito = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    nuevo = new Comprador(dineroActual, Expendedor.TRENCITO, exp);
                    System.out.println(nuevo.queDegustaste() + ", " + nuevo.cuantoVuelto());
                    dineroActual = nuevo.cuantoVuelto();
                    correcto();
                    dineroDisponible();
                    entregaTrencito();
                    
                } catch (PagoIncorrectoException ex) {
                    incorrecto();
                } catch (PagoInsuficienteException ex) {
                    incorrecto();
                } catch (NoHayProductoException ex) {
                    incorrecto();
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        TrencitoBoton.addMouseListener(mouseTrencito);
    }
    
    private void oyenteDeMouseBSuper8(){
        MouseListener mouseSuper8 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    nuevo = new Comprador(dineroActual, Expendedor.SUPER8, exp);
                    System.out.println(nuevo.queDegustaste() + ", " + nuevo.cuantoVuelto());
                    dineroActual = nuevo.cuantoVuelto();
                    correcto();
                    dineroDisponible();
                    entregaSuper8();
                    
                } catch (PagoIncorrectoException ex) {
                    incorrecto();
                } catch (PagoInsuficienteException ex) {
                    incorrecto();
                } catch (NoHayProductoException ex) {
                    incorrecto();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        Super8boton.addMouseListener(mouseSuper8);
    }
    
    private void oyenteDeMouseBVuelto(){
        MouseListener mouseVuelto = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                if (dineroActual > 0) {
                    System.out.println("vuelto");

                    pintarMonedas();
                    dineroActual = 0;
                    espera();
                    dineroDisponible();
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        VueltoBoton.addMouseListener(mouseVuelto);
    }
    
    private void dineroDisponibleInicial(){
        dineroDisponible = new JLabel();
        String dinero = String.valueOf(dineroActual);
        dineroDisponible.setText("$ "+dinero);
        dineroDisponible.setHorizontalAlignment(SwingConstants.CENTER);
        dineroDisponible.setOpaque(true);
        dineroDisponible.setBackground(Color.WHITE);
        dineroDisponible.setBounds(245,160,50,17);
        this.add(dineroDisponible);
    }
    
    private void dineroDisponible(){
        String dineroMom = String.valueOf(dineroActual);
        dineroDisponible.setText("$ "+dineroMom);
    }
    /**********Metodos de Resultado de la Compra***************/
    private void resultadoCompra(){
        compra= new JLabel();
        compra.setBounds(246, 435, 50, 40);
        ImageIcon espera= new ImageIcon("espera.jpg");
        compra.setIcon(new ImageIcon(espera.getImage().getScaledInstance(compra.getWidth(), compra.getHeight(), Image.SCALE_SMOOTH)));
        this.add(compra); 
    }
    private void espera(){
        ImageIcon espera= new ImageIcon("espera.jpg");
        compra.setIcon(new ImageIcon(espera.getImage().getScaledInstance(compra.getWidth(), compra.getHeight(), Image.SCALE_SMOOTH)));
    }
    private void correcto(){
        ImageIcon imagenCorrecto=new ImageIcon("correcto.jpg");
        compra.setIcon(new ImageIcon(imagenCorrecto.getImage().getScaledInstance(compra.getWidth(), compra.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    private void incorrecto(){
        ImageIcon imagenIncorrecto=new ImageIcon("incorrecto.jpg");
        compra.setIcon(new ImageIcon(imagenIncorrecto.getImage().getScaledInstance(compra.getWidth(), compra.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    /********************************************************/
    
    /*********Metodos de EntregaProducto********/
    private void entregaProductoExp(){
        entregaProducto= new JLabel();
        entregaProducto.setLocation(60,520);
        this.add(entregaProducto);
    }
    
    private void entregaCoca() {
        ImageIcon imCoca = new ImageIcon("cocafinal.png");
        entregaProducto.setLocation(90,506);
        int anchoImagen = imCoca.getIconWidth();
        int altoImagen = imCoca.getIconHeight();
        
        int nuevoAncho = anchoImagen;
        int nuevoAlto = altoImagen;

        Image nuevaImagen = imCoca.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        ImageIcon nuevaImagenIcono = new ImageIcon(nuevaImagen);

        entregaProducto.setIcon(nuevaImagenIcono);
        entregaProducto.setSize(nuevoAncho, nuevoAlto);
    }

    private void entregaSprite() {
        ImageIcon imSprite = new ImageIcon("Sprite.png");
        entregaProducto.setLocation(80,506);
        int anchoImagen = imSprite.getIconWidth();
        int altoImagen = imSprite.getIconHeight();

        int nuevoAncho = anchoImagen;
        int nuevoAlto = altoImagen;

        Image nuevaImagen = imSprite.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        ImageIcon nuevaImagenIcono = new ImageIcon(nuevaImagen);

        entregaProducto.setIcon(nuevaImagenIcono);
        entregaProducto.setSize(nuevoAncho, nuevoAlto);
    }

    private void entregaTrencito() {
        ImageIcon imTrencito = new ImageIcon("Trencito.png");
        entregaProducto.setLocation(70,514);
        int anchoImagen = imTrencito.getIconWidth();
        int altoImagen = imTrencito.getIconHeight();
        
        int nuevoAncho = anchoImagen;
        int nuevoAlto = altoImagen;

        Image nuevaImagen = imTrencito.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        ImageIcon nuevaImagenIcono = new ImageIcon(nuevaImagen);

        entregaProducto.setIcon(nuevaImagenIcono);
        entregaProducto.setSize(nuevoAncho, nuevoAlto);
    }

    private void entregaSuper8() {
        ImageIcon imSuper8 = new ImageIcon("Super8.png");
        entregaProducto.setLocation(60,514);
        int anchoImagen = imSuper8.getIconWidth();
        int altoImagen = imSuper8.getIconHeight();

        int nuevoAncho = anchoImagen;
        int nuevoAlto = altoImagen;

        Image nuevaImagen = imSuper8.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        ImageIcon nuevaImagenIcono = new ImageIcon(nuevaImagen);
        
        entregaProducto.setIcon(nuevaImagenIcono);
        entregaProducto.setSize(nuevoAncho, nuevoAlto);

    }
   /***********************************************************************/ 
    private void pintarMonedas(){
        entregaProducto.setBounds(80,500,60,50);//en este caso el Producto es el vuelto
        ImageIcon entVuelto = new ImageIcon("vueltoEntrega.jpg");
        entregaProducto.setIcon(new ImageIcon(entVuelto.getImage().getScaledInstance(entregaProducto.getWidth(), entregaProducto.getHeight(), Image.SCALE_SMOOTH)));
    }
}
