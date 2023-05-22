
package tarea2;
/**
*Clase Comprador,guarda los string de los sonidos de bebidas y los retorna, devuelve el vuelto de las monedas y los retorna
*@field sonido Guarda el string dado por las clases y subclases instanciadas y creadas en el expendedor
*@field vuelto Guarda el vuelto total, dada por las compras     
*/
class Comprador{
    private String sonido;
    private int vuelto=0;
    /**
    *Metodo constructor de Comprador,calcula el vuelto y lo asocia a su atributo,ademas de asignar tambien el sonido del producto
    *@param m Es la Moneda con la cual se compra
    *@param cualExpende Se refiere al cual expendedor sera recibido
    *@param exp Es el expendedor en si
    */
    public Comprador(int DineroDisp, int cualExpende, Expendedor exp) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {//1500,1400
        Producto pd= exp.comprarProducto(DineroDisp,cualExpende);
        
        if(pd != null){
            sonido=pd.degustar();
        }
        
        Moneda monedaOut= exp.getVuelto();
              
         while(monedaOut != null){
            this.vuelto= vuelto + monedaOut.getValor();
            monedaOut=exp.getVuelto();
        }
    }
    /**
    *retorna el vuelto a su instancia
    *@return vuelto El vuelto almacenado
    */
    public int cuantoVuelto(){
        return vuelto;
    }
    /**
    *retorna el sonido a su instancia
    *@return sonido El sonido almacenado
    */ 
    public String queDegustaste(){
        return sonido;
    }
 
}
