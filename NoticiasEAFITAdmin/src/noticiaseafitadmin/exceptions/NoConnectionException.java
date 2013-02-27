package noticiaseafitadmin.exceptions;

/**
 *
 * @author Rodrigo Diaz
 */
public class NoConnectionException extends Exception {

    /**
     * Creates a new instance of
     * <code>NoConnectionException</code> without detail message.
     */
    public NoConnectionException() {
    }

    /**
     * Constructs an instance of
     * <code>NoConnectionException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public NoConnectionException(String msg) {
        super(msg);
    }
}
