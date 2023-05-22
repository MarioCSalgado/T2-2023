package tarea2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class PanelComprador extends JPanel {
    Moneda m;
    int resumen=0;
    Deposito<Moneda> monedero;
    Image Persona;
    JLabel vuelto;
    JButton boton100;
    JButton boton500;
    JButton boton1000;
    JButton boton2000;
    JButton total;
    JButton mandarDinero;
    
    public PanelComprador() {
        setLayout(null);
        Persona = new ImageIcon("Persona.jpg").getImage();
        monedero = new Deposito<>();
        Botones();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Persona, 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
    private void Botones() {
        boton100 = new JButton();
        boton100.setBounds(300, 50, 60, 60);
        ImageIcon moneda100 = new ImageIcon("moneda100.png");
        boton100.setIcon(new ImageIcon(moneda100.getImage().getScaledInstance(boton100.getWidth(), boton100.getHeight(), Image.SCALE_SMOOTH)));
        this.add(boton100);

        boton500 = new JButton();
        boton500.setBounds(300, 125, 60, 60);
        boton500.setOpaque(true);
        boton500.setBackground(Color.WHITE);
        ImageIcon moneda500 = new ImageIcon("moneda500.png");
        boton500.setIcon(new ImageIcon(moneda500.getImage().getScaledInstance(boton500.getWidth(), boton500.getHeight(), Image.SCALE_SMOOTH)));
        this.add(boton500);

        boton1000 = new JButton();
        boton1000.setBounds(280, 200, 90, 60);
        ImageIcon moneda1000 = new ImageIcon("moneda1000.png");
        boton1000.setIcon(new ImageIcon(moneda1000.getImage().getScaledInstance(boton1000.getWidth(), boton1000.getHeight(), Image.SCALE_SMOOTH)));
        this.add(boton1000);

        boton2000 = new JButton();
        boton2000.setBounds(280, 275, 90, 60);
        ImageIcon moneda2000 = new ImageIcon("moneda2000.png");
        boton2000.setIcon(new ImageIcon(moneda2000.getImage().getScaledInstance(boton2000.getWidth(), boton2000.getHeight(), Image.SCALE_SMOOTH)));
        this.add(boton2000);
        
        mandarDinero = new JButton("Enviar $");
        mandarDinero.setBounds(280,475, 80,60);
        mandarDinero.setBackground(Color.GREEN);
        this.add(mandarDinero);
        
        total = new JButton("Dinero");
        total.setBounds(285,350,80,60);
        total.setBackground(Color.LIGHT_GRAY);
        this.add(total);

        oyentesDeMouse();
    }

    private void oyentesDeMouse() {
        oyenteDeMouse100();
        oyenteDeMouse500();
        oyenteDeMouse1000();
        oyenteDeMouse2000();
        oyenteDeTotal();
        oyenteDeEnvio();
    }

    private void oyenteDeMouse100() {
        MouseListener mouse100 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                m = new Moneda100();
                monedero.addDeposito(m);
                System.out.println("Se agrego 100 pesos");
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        boton100.addMouseListener(mouse100);
    }

    private void oyenteDeMouse500() {
        MouseListener mouse500 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                m = new Moneda500();
                monedero.addDeposito(m);
                System.out.println("Se agrego 500 pesos");
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        boton500.addMouseListener(mouse500);
    }

    private void oyenteDeMouse1000() {
        MouseListener mouse1000 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                m = new Moneda1000();
                monedero.addDeposito(m);
                System.out.println("Se agrego 1000 pesos");
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        boton1000.addMouseListener(mouse1000);
    }

    private void oyenteDeMouse2000() {
        MouseListener mouse2000 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                m = new Moneda2000();
                monedero.addDeposito(m);
                System.out.println("Se agrego 2000 pesos");
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        boton2000.addMouseListener(mouse2000);
    }
    
        private void oyenteDeTotal() {
        MouseListener mouseTotal = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                
                calcularTotal();
                System.out.println("Dinero Disponible: "+resumen+" pesos");
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        total.addMouseListener(mouseTotal);
    }
        
    private PanelExpendedor panelExpendedor;

    public void setPanelExpendedor(PanelExpendedor panelExpendedor) {
        this.panelExpendedor = panelExpendedor;
    }  
    private void oyenteDeEnvio(){
        MouseListener mouseEnvio = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                if (panelExpendedor != null) {
                    panelExpendedor.actualizarDineroDisponible(resumen);
                    resumen=0;
                    vuelto.setText("Dinero: " + resumen);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        mandarDinero.addMouseListener(mouseEnvio);
    }
    
    
        
    private void calcularTotal() {
        Moneda monedaOut = monedero.getDeposito();
        while (monedaOut != null) {
            resumen += monedaOut.getValor();
            monedaOut = monedero.getDeposito();
        }

        if (vuelto == null) {
            vuelto = new JLabel();
            vuelto.setBounds(285, 425, 150, 30);
            this.add(vuelto);
        }
        vuelto.setText("Dinero: " + resumen);
        this.repaint();
    }
}
