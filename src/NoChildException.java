package src;

/**
 * This is the NoChildException class which extends the RuntimeExtension class to create a new exception.
 *
 * This exception is thrown when a parent node in a heap does not have a child.
 *
 * @author George Matta
 * @version 1.0
 */
public class NoChildException extends RuntimeException{

    /**
     * A default constructor for the exception which calls the NoChildException(String) constructor but passes null for
     * the message string
     */
	public NoChildException(){
		this(null);
	} // end default constructor

    /**
     * A constructor which takes a message string and calls the super constructor to create the exception with the message.
     * @param message The message we want to be displayed when creating this NoChildException
     */
	public NoChildException(String message){
		super(message);
	} // end constructor

} // end NoChildException