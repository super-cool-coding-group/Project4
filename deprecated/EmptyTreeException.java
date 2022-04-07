package deprecated;

/**
 * This is the EmptyTreeException class which extends the RuntimeExtension class to create a new exception.
 *
 * This exception is thrown when a BinaryTree is found to be empty.
 *
 * @author George Matta
 * @author Matt Dong
 *
 * @version 1.0
 */
public class EmptyTreeException extends RuntimeException{

    /**
     * A default constructor for the exception which calls the EmptyTreeException(String) constructor but passes null for
     * the message string
     */
	public EmptyTreeException(){
		this(null);
	} // end default constructor

    /**
     * A constructor which takes a message string and calls the super constructor to create the exception with the message.
     * @param message The message we want to be displayed when creating this EmptyTreeException
     */
	public EmptyTreeException(String message){
		super(message);
	} // end constructor

} // end EmptyTreeException
