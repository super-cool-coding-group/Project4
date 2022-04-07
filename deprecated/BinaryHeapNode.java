package deprecated;

/**
 * This is the BinaryHeapNode class which contains basic definitions to create a singular node in a heap.
 *
 * This class does not extend anything and is bare-bones to creating a heap.
 * A full BinaryHeap conists of many BinaryHeapNodes, but both are similar in construction (recursively)
 *
 * @author George Matta
 * @version 1.0
 */
public class BinaryHeapNode<T> {

    /**
     * The data we want the node to have
     */
    private T data;

    /**
     * The left heap node of the current node
     */
    private BinaryHeapNode<T> leftNode;

    /**
     * The right heap node of the current node
     */
    private BinaryHeapNode<T> rightNode;

    /**
     * A default constructor that creates a Heap node with null data and no children
     */
    public BinaryHeapNode(){
        this(null);
    }

    /**
     * A constructor which creates a leaf Heap node given a piece of data
     * @param data The data we want the heap node to hold
     */
    public BinaryHeapNode(T data){
        this(data, null, null);
    }

    /**
     * A constructor which creates a BinaryHeapNode given a piece of data and the two children
     * @param data The data we want the node to hold
     * @param leftNode The left child of this node
     * @param rightNode The right child of this node
     */
    public BinaryHeapNode(T data, BinaryHeapNode<T> leftNode, BinaryHeapNode<T> rightNode){
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    /**
     * A basic getter method to get the data of the node
     * @return The data of the node
     */
    public T getData(){
        return data;
    }

    /**
     * A basic getter method to get the left node
     * @return The left child of the node
     */
    public BinaryHeapNode<T> getLeft(){
        return leftNode;
    }

    /**
     * A basic getter method to get the right node
     * @return The right child of the node
     */
    public BinaryHeapNode<T> getRight(){
        return rightNode;
    }

    /**
     * A basic setter method to set the data of the node
     * @param data The data we want the node to hold
     */
    public void setData(T data){
        this.data = data;
    }

    /**
     * A basic setter method to set the left child of the node
     * @param node The node we want to set as a child of this node
     */
    public void setLeft(BinaryHeapNode<T> node){
        leftNode = node;
    }

    /**
     * A basic setter method to set the right child of the node
     * @param node The node we want to set as a child of this node
     */
    public void setRight(BinaryHeapNode<T> node){
        rightNode = node;
    }

    /**
     * A checker method to check if we have a left node
     * @return A boolean denoting whether or not this node has a left child
     */
    public boolean hasLeft(){
        return leftNode != null;
    }

    /**
     * A checker method to check if we have a right node
     * @return A boolean denoting whether or not this node has a right child
     */
    public boolean hasRight(){
        return rightNode != null;
    }

    /**
     * A checker method to check if this node is a leaf node
     * @return A boolean denoting whether or not this node is a leaf
     */
    public boolean isLeaf(){
        return (!hasLeft() && !hasRight());
    }

    /**
     * A method to copy the current node and return a new node
     * @return A new node which is copied from this node
     */
    public BinaryHeapNode<T> copy(){
        return null;
    }

}
