package src;

/**
 * The MaxHeap class that implements the BinaryHeapInterface interface.
 *
 * This class implements all the methods from the interface while also adding
 * functionality for creating a max heap from an array.
 *
 * Under the hood, the MaxHeap class is represented as a ResizeableList.
 *
 * Each method is documented separately.
 *
 * @author George Matta
 * @author Pierlorenzo Peruzzo
 * @version 2
 */
public class MaxHeap<T extends Comparable<? super T>> implements BinaryHeapInterface<T> {

    /**
     * The default/minimum capacity of any MaxHeap. For this implementation, the default capacity is 25.
     */
    private static final int DEFAULT_CAPACITY = 25;

    /**
     * The ResizeableList of the heap we will be populating.
     */
    private ResizeableList<T> heap;

    /**
     * The number of swaps it took to create this heap.
     */
    private int numSwaps;

    /**
     * A boolean that keeps track of whether or not the constructor was properly called
     */
    private boolean initialized = false;

    /**
     * Default Constructor.
     */
    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Initialize the Heap with a specific capacity.
     *
     * @param initialCapacity the initial capacity for the Heap.
     */
    public MaxHeap(int initialCapacity) {
        if (initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = DEFAULT_CAPACITY;

        heap = new ResizeableList<T>(initialCapacity);
        initialized = true;
        numSwaps = 0;
    }

    /**
     * Constructor that creates a heap from an array.
     *
     * @param items the array used to create the heap.
     */
    public MaxHeap(T[] items) {
        // Default to the non-optimal method
        this(items, false);
    }

    /**
     * Constructor that creates an heap from an array using the optimal method or
     * not.
     *
     * @param items   the array used to create the heap.
     * @param optimal if the constructor should use the optimal method to create the
     *                heap.
     */
    public MaxHeap(T[] items, boolean optimal) {
        this();

        // If we want the non-optimal method. O(nlog(n))
        if (!optimal) {
            for (int i = 0; i < items.length; i++) {
                this.add(items[i]);
            }
            return;
        }

        // Optimal method O(n)

        // Copy items to the ResizableList
        for (int i = 0; i < items.length; i++) {
            heap.add(items[i]);
        }

        // Begin heapifying at the center item
        for (int i = (items.length / 2) - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    /**
     * Checks if the heap is initialized.
     */
    private void checkInitialization() {
        if (!initialized) {
            throw new SecurityException("MaxHeap object is corrupt or was not initialized properly.");
        }
    }

    /**
     * Checks if we can add an entry to a given index.
     *
     * @param index The index we want to place the entry at.
     * @param entry The entry we want to add
     * @return true if we can add the entry, false if we cannot
     */
    @Override
    public boolean canAdd(int index, T entry) {
        checkInitialization();

        // Check if the entry we want to add is larger than the item at the index we want to place the entry at
        return entry.compareTo(heap.get(index)) > 0;
    }

    /**
     * Gets the index of a parent given the index of the child.
     *
     * @param childIndex The index of a child node.
     * @return The index of the child's parent, -1 if there is no parent.
     */
    @Override
    public int getParentIndex(int childIndex) {
        checkInitialization();

        // If the index is not an even number, we decrement it
        if (childIndex % 2 != 0) {
            childIndex--;
        }

        // If the index doesn't have a parent (because it's at the start of the heap) return -1
        if (childIndex <= 1) {
            return -1;
        }

        // Return half the childIndex (which is the parentIndex)
        return childIndex / 2;
    }

    /**
     * Gets the index of a child given the index of the parent.
     *
     * @param parentIndex The index of a parent node.
     * @return The index of the first child of the parent (add 1 for the second
     *         child), -1 if there is no child.
     */
    @Override
    public int getChildIndex(int parentIndex) {
        checkInitialization();

        // Multiply the parentIndex by 2
        int childIndex = parentIndex * 2;

        // if we're larger than the number of entries, then there's no child
        if (childIndex >= heap.getNumEntries()) {
            return -1;
        }

        // Return the index
        return childIndex;
    }

    /**
     * Adds an entry to the Heap
     *
     * @param entry The entry we want to add to the Heap
     */
    @Override
    public void add(T entry) {
        checkInitialization();

        // Add the entry to the last index
        heap.add(entry);

        // Set up indices for the current entry and the parent entry
        int entryIndex = heap.getNumEntries();
        int parentIndex = getParentIndex(entryIndex);

        // If the parent is less than the entry
        while (parentIndex > 0 && canAdd(parentIndex, entry)) {
            // Swap the entries
            heap.swap(entryIndex, parentIndex);
            this.numSwaps++;

            // Recalculate the indices
            entryIndex = parentIndex;
            parentIndex = getParentIndex(entryIndex);
        }

    }

    /**
     * Checks if the Heap is empty
     *
     * @return true if the heap is empty, false if it isn't
     */
    @Override
    public boolean isEmpty() {
        checkInitialization();
        return heap.isEmpty();
    }

    /**
     * Gets the size of the heap (how many entries are in the heap)
     *
     * @return The size of the heap
     */
    @Override
    public int getSize() {
        checkInitialization();
        return heap.getNumEntries();
    }

    /**
     * Clears a heap of all its entries
     */
    @Override
    public void clear() {
        checkInitialization();
        heap.clear();
    }

    /**
     * Represents the heap as a string.
     * @return The string representation of the heap
     */
    @Override
    public String toString() {
        checkInitialization();
        return heap.toString();
    }

    /**
     * Returns a preview of the first 10 items of the heap
     *
     * @return The string preview of the heap
     */
    public String preview(){
        checkInitialization();
        return heap.preview();
    }

    /**
     * Get the number of swaps it took to create the heap.
     *
     * @return the number of swaps.
     */
    public int getNumSwaps() {
        checkInitialization();
        return numSwaps;
    }

    /**
     * Get the max item in the heap.
     *
     * @return the heap's largest item.
     */
    public T getMax() {
        checkInitialization();

        // Check if we have a heap
        if(isEmpty()){
            return null;
        }

        // Return the first item in he heap
        return heap.get(1);
    }

    /**
     * Removes and returns the heap's largest item.
     *
     * @return the heap's largest item.
     */
    public T remove() {
        checkInitialization();

        if(isEmpty()){
            return null;
        }

        // Get the max item of the heap
        T max = heap.get(1);

        // Reset the first index of the heap to be the max item of the heap
        heap.set(1, heap.get(heap.getNumEntries()));

        // Remove the last item of the heap
        heap.remove(heap.getNumEntries());

        // Reheap the heap to make sure we maintain its heap-ness
        reheap(1);

        // Return the previously max item of the heap
        return max;
    }

    /**
     * Removes n items from the heap
     *
     * @param n the number of times to call `remove` on this heap
     */
    public void remove(int n){
        // Loop through until n
        for(int i = 0; i < n; i++){
            // Run the remove method
            this.remove();
        }
    }

    /**
     * Turns a semiheap into a heap.
     *
     * @param rootIndex the index of the root.
     */
    private void reheap(int rootIndex) {
        // Set conditions for while loop
        boolean done = false;
        T orphan = heap.get(rootIndex);
        int leftChildIndex = this.getChildIndex(1);

        // Compare left and right children and find the larger child
        while (!done && (leftChildIndex <= heap.getNumEntries())) {
            // Initialize larger and right child index
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;

            // Check if right child is larger than left child, if yes set right index as larger
            if ((rightChildIndex <= heap.getNumEntries()) &&
                    heap.get(rightChildIndex).compareTo(heap.get(largerChildIndex)) > 0) {
                largerChildIndex = rightChildIndex;
            }

            // Check if root is less than larger child, if yes set root as larger
            if (orphan.compareTo(heap.get(largerChildIndex)) < 0) {
                heap.set(rootIndex, heap.get(largerChildIndex));
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            }

            // If root is greater than larger child, end loop
            else
                done = true;
        }

        // Set current root index to original orphan
        heap.set(rootIndex, orphan);
    }

    /**
     * Heapify a heap represented as an array
     *
     * @param i the initial node.
     */
    private void heapify(int i) {
        // We set the largest item as the root
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if the left child is larger than the root, if yes swap
        if (left < heap.count() && heap.get(left + 1).compareTo(heap.get(largest + 1)) > 0)
            largest = left;

        // Check if the right child is larger than largest, if yes swap
        if (right < heap.count() && heap.get(right + 1).compareTo(heap.get(largest + 1)) > 0)
            largest = right;

        // If the largest is not the root, we swap it
        if (largest != i) {
            T temp = heap.get(i + 1);
            heap.set(i + 1, heap.get(largest + 1));
            heap.set(largest + 1, temp);
            numSwaps++;

            // Now we recursively call heapify to change the affected sub-tree
            heapify(largest);
        }
    }

}
