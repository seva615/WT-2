package by.lab2.exception;

/**
 * ServiceException class.
 * @author Ilja Grigorchik
 */
public class ServiceException extends Exception {

    /**
     * ServiceException constructor with parameter
     *
     * @param message - message
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * ServiceException constructor with parameter
     *
     * @param e - exception
     */
    public ServiceException(Exception e) {
        super(e);
    }

}
