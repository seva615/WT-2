package by.lab2.exception;

/**
 * ResourceException class.
 * @author Ilja Grigorchik
 */
public class ResourceException extends Exception {

    /**
     * ResourceException constructor with parameter
     *
     * @param e - exception
     */
    public ResourceException(Exception e) {
        super(e);
    }

}
