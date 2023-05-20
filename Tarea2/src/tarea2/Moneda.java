
package tarea2;
import java.util.ArrayList;
/**
*Clase Moneda que sirve como prototipo para las otras clases, retorna la refencia respectiva de la moneda, de su subclase de por si, además de dar la estructura de un metodo e implementar la interfaz Comparable
*/
abstract class Moneda implements Comparable<Moneda>{
     /**
    *Metodo constructor de moneda, inicializa
    */
    public Moneda() {
       
    }  
    /**
    *Metodo para retornar el valor de referencia respectivo a la moneda
    *@return El valor de referencia
    */ 
    public Moneda getSerie(){
        return this;
    }
    /**
    *Metodo comparTo, el cual compara una moneda actual con otra, en este caso basandose en sus valores
    */
    @Override
    public int compareTo(Moneda monedaprueba){
        return (this.getSerie().getValor()-monedaprueba.getSerie().getValor());
    }
    /**
    *Metodo para darle estructura a los override que retornaran el valor de las monedas respectivas
    */
    public abstract int getValor();
}
/**
*Subclase Moneda1500, entrega su valor de referencia a su superclase, ademas de retornar su valor   
*/
class Moneda1500 extends Moneda{
   /**
    *Metodo constructor, entrega su valor de referencia
    */ 
    public Moneda1500() {
       super();
    }  
    /**
    *Metodo que retorna el valor de la moneda
    *@return el valor de la moneda
    */ 
    @Override
    public int getValor(){
        return 1500;
    }
}
/**
*Subclase Moneda1000, entrega su valor de referencia a su superclase, ademas de retornar su valor   
*/
class Moneda1000 extends Moneda{
    /**
    *Metodo constructor, entrega su valor de referencia
    */ 
    public Moneda1000() {
       super();
    }
     /**
    *Metodo que retorna el valor de la moneda
    *@return el valor de la moneda
    */ 
    @Override
    public int getValor(){
        return 1000;
    }
}
class Moneda500 extends Moneda{
    /**
    *Metodo constructor, entrega su valor de referencia
    */ 
    public Moneda500() {
       super();
    } 
     /**
    *Metodo que retorna el valor de la moneda
    *@return el valor de la moneda
    */ 
    @Override
    public int getValor(){
        return 500;
    }
}
class Moneda100 extends Moneda{
    /**
    *Metodo constructor, entrega su valor de referencia
    */ 
    public Moneda100() {
       super();
    }
    /**
    *Metodo que retorna el valor de la moneda
    *@return el valor de la moneda
    */  
    @Override
    public int getValor(){
        return 100;
    }
} 