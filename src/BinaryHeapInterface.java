package src;

/**
 * This is the BinaryHeapInterface. It hosts definitions for methods integral for the creation of any heap.
 *
 * Heaps that implement this interface can be a Max Heap, Min Heap, or any other special type of tree that places
 * a restriction on where entries can be added.
 *
 * We achieve this by using the canAdd(int, T) method which returns a boolean denoting whether or not an entry can be
 * added at that position. So, for a maxHeap, we would check if the entry is less than its parent.
 *
 * We also define that the generic type T is comparable.
 *
 * Each method is documented separately.
 *
 * @author Pierlorenzo Peruzzo
 * @author George Matta
 * @version 2.0
 */
public interface BinaryHeapInterface<T extends Comparable<? super T>> {

    /**
     * Adds an entry to the Heap
     *
     * @param entry The entry we want to add to the Heap
     */
    public void add(T entry);

    /**
     * Checks if we can add an entry to a given index.

     * @param index The index we want to place the entry at.
     * @param entry The entry we want to add
     * @return true if we can add the entry, false if we cannot
     */
    public boolean canAdd(int index, T entry);

    /**
     * Gets the index of a parent given the index of the child.
     *
     * @param childIndex The index of a child node.
     * @return THe index of the child's parent.
     */
    public int getParentIndex(int childIndex);

    /**
     * Gets the index of a child given the index of the parent.
     *
     * @param parentIndex The index of a parent node.
     * @return The index of the first child of the parent (add 1 for the second child).
     */
    public int getChildIndex(int parentIndex);

    /**
     * Checks if the Heap is empty
     *
     * @return true if the heap is empty, false if it isn't
     */
    public boolean isEmpty();

    /**
     * Gets the size of the heap (how many entries are in the heap)
     * @return The size of the heap
     */
    public int getSize();

    /**
     * Clears a heap of all its entries
     */
    public void clear();

    // public T removeRoot();

    // public T getRoot();

}
