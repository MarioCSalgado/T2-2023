
package tarea2;
/**
*Subclase de Bebida CocaCola, la cual retorna un numero de serie recibido como parametro a su superclase y tambien retorna un String en caso de ser instanciada
*/
class CocaCola extends Bebida{
     /**
    *Metodo constructor de CocaCola, retorna el numero de serie a su superclase
    *@param serie Numero de serie recibido como parametro, lo retorna a su superclase 
    */
    public CocaCola(int serie){
        super(serie);
    }
    /**
    *Metodo que devuelve una string en caso de sar instanciada
    *@return String devuelve la string
    */
    @Override
    public String degustar(){
        return "cocacola";
    }
} 