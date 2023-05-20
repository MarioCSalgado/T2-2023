
package tarea2;
/**
*clase de excepcion en caso de e quiere comprar un producto por un valor inferior al precio
*/
public class PagoIncorrectoException extends Exception {
	/**
	*Metodo constructor de PagoIncorrectoException, devuelve un texto indicando la devolucion de la moneda como vuelto
	*/
    public PagoIncorrectoException(String texto) {
        super(texto);
    }
}
 
 