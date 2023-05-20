
package tarea2;
/**
*clase de excepcion en caso de que se quiera comprar Bebidas sin dinero (moneda null) 
*/
public class PagoInsuficienteException extends Exception {
	/**
	*Metodo constructor de PagoInsuficienteException retorna un texto que indica que no se devuelve vuelto ni producto
	*@param texto Es el texto que se devuelve que indica lo mencionado
	*/
    PagoInsuficienteException(String texto){
        super(texto);
    }
}
 