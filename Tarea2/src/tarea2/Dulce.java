
package tarea2;
/**
*Clase Dulce,funciona de base para sus subclases super8 y trencito,ademas devuelve su numero de serie a su superclase producto
*/
abstract class Dulce extends Producto{//no se puede instanciar directamente
    /**
    *Metodo constructor de dulce el cual devuelve el numero de serie a su superclase Producto
    *@param serie Es el numero de serie del dulce, recibido de sus subclases
    */
    public Dulce(int serie){
        super(serie);
    }  
}
 