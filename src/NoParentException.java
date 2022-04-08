package src;

/**
 * This is the NoParentException class which extends the RuntimeExtension class to create a new exception.
 *
 * This exception is thrown when a parent node in a heap does not have a parent.
 *
 * @author George Matta
 * @version 1.0
 */
public class NoParentException extends RuntimeException{

    /**
     * A default constructor for the exception which calls the NoParentException(String) constructor but passes null for
     * the message string
     */
	public NoParentException(){
		this(null);
	} // end default constructor

    /**
     * A constructor which takes a message string and calls the super constructor to create the exception with the message.
     * @param message The message we want to be displayed when creating this NoParentException
     */
	public NoParentException(String message){
		super(message);
	} // end constructor

} // end NoParentException