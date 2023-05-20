
package tarea2;
/**
*Subclase super8, devuelve su numero de serie recibido como parametro a su superclase además de retornar un string en caso de ser instanciada
*/
class Super8 extends Dulce{
	/**
    *Metodo constructor de Super8, entrega el numero de serie a su clase super
    *@param serie El numero de serie
    */
    public Super8(int serie){
        super(serie);
    }
     /**
    *Metodo que retorna una string
    *@return La string respectiva
    */
    @Override
    public String degustar(){
        return "Super8";
    }
}