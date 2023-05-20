
package tarea2;
/**
*Clase Producto,guarda el numero de serie  y lo retorna con otro metodo,además de servir como prototipo
*@field serie Guarda el numero de serie retornado por sus subclases
*/ 
abstract class Producto{//no se puede instanciar directamente
    private int serie;
   /**
  	*Metodo constructor de Producto, guarda el numero de serie
  	*@param prueba Recibe un numero para almacenarlo como numero de serie
  	*/ 
    public Producto(int prueba){
       this.serie=prueba;
    }
    /**
    *retorna el numero de serie a su instancia
    *@return serie El numero de serie 
    */ 
    public int getSerie(){
       return serie;
    }
        /**
    *Metodo abstracto para que las subclases lo utilicen
    */
    public abstract String degustar();   
}