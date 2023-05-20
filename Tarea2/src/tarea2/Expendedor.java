
package tarea2;
/**
*Clase Expendedor, simula un expendedor creando sus depositos respectivos para cada bebida y producto en general, además de a sus monedas
*@field coca Es el deposito de las cocacolas
*@field sprite El deposito de las sprite
*@field super8 El deposito de los super8
*@field trencito El deposito de los trencitos
*@field monVu El deposito de las monedas
*@field COCA Constante para obtener la cocacola
*@field SPRITE Constante para obtener la sprite 
*@field SUPER8 Constante para tener un super8
*@field TRENCITO Constante para tener un trencito
*@field precios Son los precios de los productos
*@field vuelto Corresponde al vuelto
*/
class Expendedor{
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Dulce> super8;
    private Deposito<Dulce> trencito;
    private Deposito<Moneda> monVu;
    
    public static final int COCA=1; 
    public static final int SPRITE=2;
    public static final int SUPER8=3; 
    public static final int TRENCITO=4;
    public static final int precioCoca=900;
    public static final int precioSprite=900;
    public static final int precioSuper8=300;
    public static final int precioTrencito=1200;
    public int vuelto=0;
    /**
    *Metodo constructor de Expendedor, instancia los depositos  y además agrega sus productos dado un numero entragado como parametro, tambien guarda los precios
    *@param productos Es el numero de productos que se desea
    */
   public Expendedor(int productos) {
        coca = new Deposito<>();
        sprite = new Deposito<>();
        super8 = new Deposito<>();
        trencito = new Deposito<>();
        monVu = new Deposito<>();

        for (int i = 0; i < productos; i++) {//si el numero de bebidas es 0, no se agregan bebidas
            coca.addDeposito(new CocaCola(100 + i));
            sprite.addDeposito(new Sprite(200 + i));
            super8.addDeposito(new Super8(300+i));
            trencito.addDeposito(new Trencito(400+i));
        }
    }
    
    /**
    *Metodo que sirve para escoger un producto dado sus parametros y obtenerlo en caso de estar, ademas devolver el vuelto en monedas de 100 que son creadas en el mismo metodo
    *@param m Moneda con la cual se compra el producto
    *@param codigo Numero asociado al producto que se desea
    *@return Retorna el producto en si requerido, ya sea Bebida,Dulce,etc
    */
    public Producto comprarProducto(Moneda m, int codigo) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException{
      if (m == null) {//si la moneda no es valida         
            throw new PagoIncorrectoException("Su Moneda no es valida");
        }
        
        if(codigo>4 || codigo<1){
            monVu.addDeposito(m);
            throw new NoHayProductoException("El numero ingresado para el codigo no es valido");
        }

        switch (codigo) {
            case COCA:
                if (coca.sizeDeposito() == 0) {
                    monVu.addDeposito(m);
                    throw new NoHayProductoException("No quedan CocaCola's, los depositos estan vacios");

                } else if (precioCoca > m.getSerie().getValor()) {
                    monVu.addDeposito(m);
                    throw new PagoInsuficienteException("Pago Insuficiente");

                } else {
                    vuelto = m.getSerie().getValor() - precioCoca;
                    int numLoops = vuelto / 100;
                    for (int i = 0; i < numLoops; i++) {
                        monVu.addDeposito(new Moneda100());
                    }
                    return (Producto) coca.getDeposito();
                }

            case SPRITE:
                if (sprite.sizeDeposito()== 0) {
                    monVu.addDeposito(m);
                    throw new NoHayProductoException("No quedan Sprite's, los depositos estan vacios");

                } else if (precioSprite > m.getSerie().getValor()) {
                    monVu.addDeposito(m);
                    throw new PagoInsuficienteException("Pago Insuficiente");

                } else {
                    vuelto = m.getSerie().getValor() - precioSprite;
                    int numLoops = vuelto / 100;
                    for (int i = 0; i < numLoops; i++) {
                        monVu.addDeposito(new Moneda100());
                    }

                    return (Producto) sprite.getDeposito();
                }
            case SUPER8:
                if (super8.sizeDeposito() == 0) {
                    monVu.addDeposito(m);
                    throw new NoHayProductoException("No quedan Super8's, los depositos estan vacios");

                } else if (precioSuper8 > m.getSerie().getValor()) {
                    monVu.addDeposito(m);
                    throw new PagoInsuficienteException("Pago Insuficiente");

                } else {
                    vuelto = m.getSerie().getValor() - precioSuper8;
                    int numLoops = vuelto / 100;
                    for (int i = 0; i < numLoops; i++) {
                        monVu.addDeposito(new Moneda100());
                    }

                    return (Producto) super8.getDeposito();

                }
            case TRENCITO:
                if (trencito.sizeDeposito() == 0) {
                    monVu.addDeposito(m);
                    throw new NoHayProductoException("No quedan Trencito's, los depositos estan vacios");

                } else if (precioTrencito > m.getSerie().getValor()) {
                    monVu.addDeposito(m);
                    throw new PagoInsuficienteException("Pago Insuficiente");

                } else {
                    vuelto = m.getSerie().getValor() - precioTrencito;
                    int numLoops = vuelto / 100;
                    for (int i = 0; i < numLoops; i++) {
                        monVu.addDeposito(new Moneda100());
                    }

                    return (Producto) trencito.getDeposito();
                }
        }

        throw new PagoInsuficienteException("Pago Insuficiente");// (PagoInsuficienteException)
    }
    /**
    *Metodo que retorna una moneda correspondiente al vuelto
    */
    public Moneda getVuelto(){
        Moneda mon1= (Moneda) monVu.getDeposito();
        if(mon1==null) return null;
        else return mon1;
    }
} 