
package tarea2;
/**
*Subclase trencito, devuelve su numero de serie recibido como parametro a su superclase además de retornar un string en caso de ser instanciada
*/
class Trencito extends Dulce{
	 /**
    *Metodo constructor de trencito, entrega el numero de serie a su clase super
    *@param serie El numero de serie
    */
    public Trencito(int serie){
        super(serie);
    }
    /**
    *Metodo que retorna una string
    *@return La string respectiva
    */ 
    @Override
    public String degustar(){
        return "Trencito";
    }
} 