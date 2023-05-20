
package tarea2;
/**
*clase de excepcion en caso de que no haya productos
*/
public class NoHayProductoException extends Exception{
	/**
	*Metodo constructor de la NoHayProductoException
	*@param texto Es un texto que entrega para notificar la devolución de moneda.
	*/
    public NoHayProductoException(String texto){
        super(texto);
    }
} 
