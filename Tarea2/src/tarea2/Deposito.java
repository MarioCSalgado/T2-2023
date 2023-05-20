
package tarea2;

import java.util.ArrayList;
/**
*Clase deposito, simula un deposito donde se guardan las bebidas,dulces y monedas
*@field deposito Es el es el deposito generico
*/

class Deposito<T>{
    private ArrayList<T> deposito;
     /**
    *Constructor de la clase Deposito, crea las respectivas instancias del deposito generico
    */
     public Deposito() {
       this.deposito = new ArrayList<T>();
    }
    /**
    *Metodo que agrega productos
    *@param producto Es el producto agregado
    */
     public void addDeposito(T producto){
        deposito.add(producto);
    }
   /**
    *retorna el tamaño del deposito generico
    */
    public int sizeDeposito(){
        return deposito.size();
    }
    /**
    *Metodo que obtiene un producto del deposito generico
    */
    public T getDeposito(){
       int tam= deposito.size();
       if(tam!=0){ 
       T producto= deposito.remove(0);
       return producto;
       }else{
           return null;
       }
    }    
}

