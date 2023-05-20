
package tarea2;
/**
*Subclase abstracta Bebida,lleva el numero de serie de la bebida a la super clase Producto
*/
abstract class Bebida extends Producto{//no se puede instanciar directamente
    /**
    *Metodo constructor de Bebida, retorna el valor de serie recibido de sus subclases a su superclse Producto
    *@param serie El numero de serie de la bebida
    */ 
    public Bebida(int serie){
        super(serie);
    }  
} 

