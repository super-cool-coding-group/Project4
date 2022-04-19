package deprecated;

/**
 * This is the MaxHeap class that implements the BinaryHeapInterface interface.
 *
 * A MaxHeap is composed of BinaryHeapNodes (which are recursive in nature)
 */
public class MaxHeap<T> implements BinaryHeapInterface<T>{

    /**
     * A MaxHeap object of the root node of the current Binary Tree
     */
    BinaryHeapNode<T> root;

    /**
     * The default constructor which creates a Heap node with null data
     */
    public MaxHeap(){
        this(null);
    }

    /**
     * A constructor that creates a leaf for the Heap given a piece of data
     * @param data The data we want the leaf to have
     */
    public MaxHeap(T data){
        this(data, null, null);
    }

    /**
     * A constructor that creates a Heap with data, a left heap, and a right heap
     * @param data The data we want the node to have
     * @param leftHeap The left heap we are linking to the root
     * @param rightHeap The right heap we are linking to the root
     */
    public MaxHeap(T data, MaxHeap<T> leftHeap, MaxHeap<T> rightHeap){
        initializeHeap(data, leftHeap, rightHeap);
    }

    /**
     * A private method to initialize a heap, full with root data and left/right subtrees, and set the root node to
     * the MaxHeap object we construct.
     *
     * This method fully sanitizes all user input to make sure we can add the right tree and to make sure we can have
     * a left tree. We make sure that the rightTree is not the same as the leftTree.
     *
     * This method doesn't return anything because it simply sets "this" root to the node at which the BinaryTree is rooted
     *
     * @param rootData The data we want our root node to hold
     * @param leftTree The left subtree of the root node
     * @param rightTree The right subtree of the root node
     */
    private void initializeHeap(T rootData, MaxHeap<T> leftTree, MaxHeap<T> rightTree) {
        root = new BinaryHeapNode<T>(rootData);

        // Check if we were given a left subtree
        if ((leftTree != null) && !leftTree.isEmpty()){
            root.setLeft(leftTree.root);
        }

        // Check if we were given a right subtree
        if ((rightTree != null) && !rightTree.isEmpty()) {
            // Check that the right subtree is different from the left subtree
            if (rightTree != leftTree) {
                root.setRight(rightTree.root);
            }
            else {
                root.setRight(rightTree.root.copy());
            }
        }

        // If the left subtree was not null, we clear it (to save memory)
        if ((leftTree != null) && (leftTree != this)){
            leftTree.clear();
        }

        // If the right subtree was not null, we clear it (to save memory)
        if ((rightTree != null) && (rightTree != this)){
            rightTree.clear();
        }
    }

    /**
     * A method to set the data of our root BinaryHeapNode
     */
    @Override
    public void setRootData(T rootData) {
        root.setData(rootData);
    }

    /**
     * A public method we use to set the root HeapNode to a tree we create in the initializeTree method
     *
     * @param rootData The root data we want the HeapNode to hold
     * @param leftTree The left subtree of the root node
     * @param rightTree The right subtree of the left node
     */
    @Override
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
        initializeHeap(rootData, (MaxHeap<T>) leftTree, (MaxHeap<T>) rightTree);
    }

    /**
     * A getter method to get the data held by the root node
     * @return The data held by the root node
     */
    @Override
    public T getRootData() {
        return root.getData();
    }

    /**
     * A method to check if the MaxHeap is empty
     * @return A boolean denoting whether or not the heap is empty
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * A method to clear the MaxHeap by setting the root to null
     */
    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean add(T data) {
        return false;
    }

    @Override
    public boolean add(BinaryHeapInterface<T> node) {
        return false;
    }

    /**
     * A method which returns whether or not the node we are adding to has data that's greater than or equal to
     * the data we are adding
     * @return A boolean denoting if we can add the node to the heap
     */
    @Override
    public boolean canAdd(int dataToCheck, int dataToAdd) {
        return dataToCheck >= dataToAdd;
    }

    @Override
    public BinaryHeapInterface<T> remove() {
        return null;
    }

    @Override
    public void swap(BinaryHeapInterface<T> primaryNode, BinaryHeapInterface<T> secondaryNode) {
    }

}
