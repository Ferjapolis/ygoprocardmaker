package ygoprocardmaker.exception;

/**
 *
 * @author Simão Reis <dracostriker@hotmail.com>
 */
public class InvalidFieldException extends Exception {

    /**
     * Creates a new instance of <code>InvalidFieldException</code> without
     * detail message.
     */
    public InvalidFieldException() {
    }

    /**
     * Constructs an instance of <code>InvalidFieldException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidFieldException(String msg) {
        super(msg);
    }
}
