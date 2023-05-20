
package tarea2;

/**
*Clase main, se usara para instanciar las otras clases respectivas y darle funcionalidad al codigo en conjunto
*/
public class Main {
    public static void main(String[] args) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        Expendedor exp = new Expendedor(4);
        Moneda m = null;
        Comprador c = null;
        System.out.println("Precios productos: ");
        System.out.println("Cocacola: " + Expendedor.precioCoca);
        System.out.println("Sprite: " + Expendedor.precioSprite);
        System.out.println("Super8: " + Expendedor.precioSuper8);
        System.out.println("Trencito: " + Expendedor.precioTrencito + "\n");

//-----Producto que NO vende, lanza una exception y con try-catch lanzamos un msg en este, caso y devolvemos la moenda*/
        try {
            m = new Moneda100();
            c = new Comprador(m, 657, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto()); //Si le sacamos los comentarios lanza NoHayProducotException
        } catch (NoHayProductoException e) {
            System.out.println(e.getMessage() + ", se le devolvera su moneda: " + exp.getVuelto().getValor());
        }
//-----trata de comprar SIN Moneda, lanza una exception y con try-catch devuelve el msg-------
        try {
            m = null;
            c = new Comprador(m, Expendedor.SPRITE, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// Si le sacamos los comentarios lanza PagoIncorrectoException
        } catch (PagoIncorrectoException e) {
            System.out.println(e.getMessage());
        }

//-----con dinero JUSTO para el precio y y si esta vacio retorna una exception, usamos try-catch para imprimir un msg-----
        try {
            m = new Moneda1000();
            c = new Comprador(m, Expendedor.COCA, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// cocacola $100
            m = new Moneda1000();
            c = new Comprador(m, Expendedor.COCA, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// cocacola $100
            m = new Moneda1000();
            c = new Comprador(m, Expendedor.COCA, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// cocacola $100
            m = new Moneda1000();
            c = new Comprador(m, Expendedor.COCA, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// cocacola $100
            m = new Moneda1000();
            c = new Comprador(m, Expendedor.COCA, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// cocacola $100
        } catch (NoHayProductoException e) {
            System.out.println(e.getMessage() + ", se le devolvera su moneda: " + exp.getVuelto().getValor());
        }
        
//-----con MENOS dinero que el precio, lanza una exception y usamos try-catch para devolver un msg y la moneda-----
        try {
            m = new Moneda500();
            c = new Comprador(m, Expendedor.SPRITE, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());//si le sacamos los comentarios lanza PagoInsuficienteException
        } catch (PagoInsuficienteException e) {
            System.out.println(e.getMessage() + ", se le devolvera su moneda: " + exp.getVuelto().getValor());
        }

//-----con MAS dinero que el precio y si esta vacio retorna una exception, usamos try-catch para imprimir un msg-----
        try {
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.SPRITE, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// sprite $600
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.SPRITE, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// sprite $600
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.SPRITE, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// sprite $600
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.SPRITE, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// sprite $600
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.SPRITE, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// sprite $600
        } catch (NoHayProductoException e) {
            System.out.println(e.getMessage() + ", se le devolvera su moneda: " + exp.getVuelto().getValor());
        }

//-----Con Mas dinero para comprar Super8 y si esta vacio retorna una exception, usamos try-catch para imprimir un msg-----
        try {
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.SUPER8, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// super8 $1200
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.SUPER8, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// super8 $120
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.SUPER8, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// super8 $1200
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.SUPER8, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// super8 $1200
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.SUPER8, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());
        } catch (NoHayProductoException e) {
            System.out.println(e.getMessage() + ", se le devolvera su moneda: " + exp.getVuelto().getValor());
        }
        
//-----Con Mas dinero para comprar Trencito y si esta vacio retorna una exception, usamos try-catch para imprimir un msg-----
        try {
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.TRENCITO, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// trencito $300
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.TRENCITO, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// trencito 300
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.TRENCITO, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// trencito $300
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.TRENCITO, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// trencito $300
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.TRENCITO, exp);
            System.out.println(c.queDegustaste() + ", " + c.cuantoVuelto());// trencito $300

        } catch (NoHayProductoException e) {
            System.out.println(e.getMessage() + ", se le devolvera su moneda: " + exp.getVuelto().getValor());
        }    
    }
} 
