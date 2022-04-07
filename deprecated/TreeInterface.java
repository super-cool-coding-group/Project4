package deprecated;

/**
 * This is the most abstract interface for trees - the TreeInterface.
 *
 * This interface only has methods for getting and setting the root data, checking if a tree is empty, and clearing a tree.
 *
 * The interface will later be used to create a heap, so all the extra features (like getting height and number of nodes).
 *
 * Each method is documented separately.
 *
 * @author George Matta
 * @version 1.0
 */
public interface TreeInterface<T>{

    /**
     * A method to get the root data of the TreeInterface object
     * @return A generic T-type object of the data.
     */
    public T getRootData();

    /**
     * A method to set the root data of the TreeInterface object
     * @param data The data to set the root node to hold
     */
    public void setRootData(T data);

    /**
     * A method to check if the tree is empty
     * @return A boolean denoting whether or not the tree is empty.
     */
    public boolean isEmpty();

    /**
     * A method to clear the tree. If this method is run, calling isEmpty() will return "true".
     */
    public void clear();
}
