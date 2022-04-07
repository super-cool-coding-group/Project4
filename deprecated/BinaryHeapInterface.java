package deprecated;

/**
 * This is the BinaryHeapInterface class which is an inteface that extends the BinaryTreeInterface.
 *
 * This interface includes the definitions for what makes a heap a heap - which would be to add a node, check that
 * the item added follows a specific criteria (for a max-heap, we would check that the item is less than the root data, and for
 * a min-heap we would check that the item is greater than the root data), remove a node, swap two nodes.
 *
 * Each method is documented separately.
 */
public interface BinaryHeapInterface<T> extends BinaryTreeInterface<T>{

    /**
     * A public method to add a piece of data into the Binary Heap. We also create a node since we are only given data.
     *
     * @param data The data of generic type that we want to add
     * @return A boolean denoting if we were sucessful in adding the item (this would be false if canAdd returns false)
     */
    public boolean add(T data);

    /**
     * A public method to add a node to the BinaryHeap.
     *
     * @param node The node we are adding to the BinaryHeap
     * @return A boolean denoting if we were sucessful in adding the item (this would be false if canAdd returns false)
     */
    public boolean add(BinaryHeapInterface<T> node);

    /**
     * A public method to check if we can add an item. For a max-heap, it would return true if the data passed in is
     * less than the data of the node it would be attached to, and the opposite for a min-heap.
     *
     * Both the data values passed into this method must be ints.
     *
     * @param dataToCheck The 'root' data of the node to attach to
     * @param dataToAdd The data we are trying to add to the heap
     * @return A boolean denoting if we can add the item.
     */
    public boolean canAdd(int dataToCheck, int dataToAdd);

    /**
     * A public method that removes the last item from the Heap
     *
     * @return The item we removed from the Heap
     */
    public BinaryHeapInterface<T> remove();

    /**
     * A public method that swaps two nodes in a heap.
     *
     * @param primaryNode The first node we are swapping
     * @param secondaryNode The second node we are swapping
     */
    public void swap(BinaryHeapInterface<T> primaryNode, BinaryHeapInterface<T> secondaryNode);

}
