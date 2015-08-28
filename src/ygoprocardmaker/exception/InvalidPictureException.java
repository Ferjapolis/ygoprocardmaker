package ygoprocardmaker.exception;

/**
 *
 * @author Simão Reis <dracostriker@hotmail.com>
 */
public class InvalidPictureException extends Exception {

    /**
     * Creates a new instance of <code>InvalidPictureException</code> without
     * detail message.
     */
    public InvalidPictureException() {
    }

    /**
     * Constructs an instance of <code>InvalidPictureException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidPictureException(String msg) {
        super(msg);
    }
}
