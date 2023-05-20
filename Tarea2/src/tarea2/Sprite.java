
package tarea2;
/**
*Subclase de Bebida Sprite, la cual retorna un numero de serie recibido como parametro a su superclase y tambien retorna un String en caso de ser instanciada
*/
class Sprite extends Bebida{
	 /**
    *Metodo constructor de Sprite, retorna el numero de serie a su superclase
    *@param serie Numero de serie recibido como parametro, lo retorna a su superclase 
    */
    public Sprite(int serie){
        super(serie);
    }
    /**
    *Metodo que devuelve una string en caso de sar instanciada
    *@return String devuelve la string
    */  
    @Override
    public String degustar(){
        return "sprite";
    }
} 