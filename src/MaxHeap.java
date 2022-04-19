package src;

/**
 * This is the MaxHeap class that implements the BinaryHeapInterface interface.
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

    // #region Const

    private static final int DEFAULT_CAPACITY = 25;

    // #endregion

    // #region Private Fields

    private ResizeableList<T> heap;
    private boolean initialized = false;
    private int numSwaps;

    // #endregion

    // #region Constructors

    /**
     * Default Constructor.
     */
    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Initialize the ReordableList with a specific capacity.
     *
     * @param initialCapacity the initial capacity for the ReordableList.
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

        // If we want the non-optimal method
        if (!optimal) {
            for (int i = 0; i < items.length; i++) {
                this.add(items[i]);
            }
            return;
        }

        // Optimize method

        // Copy items to the ResizableList
        for (int i = 0; i < items.length; i++) {
            heap.add(items[i]);
        }

        for (int i = (items.length / 2) - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    // #endregion

    // #region Security Check

    /**
     * Checks if the heap is initialized.
     */
    private void checkInitialization() {
        if (!initialized) {
            throw new SecurityException("MaxHeap object is corrupt or was not initialized properly.");
        }
    }

    // #endregion

    // #region Implement BinaryHeapInterface

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

        return entry.compareTo(heap.get(index)) > 0;
    }

    /**
     * Gets the index of a parent given the index of the child.
     *
     * @param childIndex The index of a child node.
     * @return THe index of the child's parent.
     */
    @Override
    public int getParentIndex(int childIndex) {
        checkInitialization();

        if (childIndex % 2 != 0) {
            childIndex--;
        }

        if (childIndex <= 1) {
            return -1;
        }

        return childIndex / 2;
    }

    /**
     * Gets the index of a child given the index of the parent.
     *
     * @param parentIndex The index of a parent node.
     * @return The index of the first child of the parent (add 1 for the second
     *         child).
     */
    @Override
    public int getChildIndex(int parentIndex) {
        checkInitialization();

        int childIndex = parentIndex * 2;

        if (childIndex >= heap.getNumEntries()) {
            return -1;
        }

        return childIndex;
    }

    /**
     * Adds an entry to the Heap
     *
     * @param entry The entry we want to add to the Heap
     */
    @Override
    public void add(T newEntry) {
        checkInitialization();

        // Add the entry to the last index
        heap.add(newEntry);

        // Set up indices for the current entry and the parent entry
        int entryIndex = heap.getNumEntries();
        int parentIndex = getParentIndex(entryIndex);

        // If the parent is less than the entry
        while (parentIndex > 0 && canAdd(parentIndex, newEntry)) {
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
     */
    @Override
    public String toString() {
        return heap.toString();
    }

    /**
     * Get the root item in the heap.
     *
     * @return the root item.
     */
    public T getRoot() {
        checkInitialization();
        T root = null;
        if (!isEmpty())
            root = heap.get(1);
        return root;
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
     * @return the max item.
     */
    public T getMax() {
        checkInitialization();
        T root = null;
        if (!isEmpty())
            root = heap.get(1);
        return root;
    }

    /**
     * Removes and returns the heap's largest item.
     *
     * @return the heap's largest item.
     */
    public T removeMax() {
        checkInitialization();
        T root = null;
        if (!isEmpty()) {
            root = heap.get(1);
            heap.set(1, heap.get(heap.getNumEntries()));
            heap.remove(heap.getNumEntries());
            reheap(1);
        }
        return root;
    }

    /**
     * Turns a semiheap into a heap.
     *
     * @param rootIndex the index of the root.
     */
    private void reheap(int rootIndex) {
        boolean done = false;
        T orphan = heap.get(rootIndex);
        int leftChildIndex = this.getChildIndex(1);
        while (!done && (leftChildIndex <= heap.getNumEntries())) {
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            if ((rightChildIndex <= heap.getNumEntries()) &&
                    heap.get(rightChildIndex).compareTo(heap.get(largerChildIndex)) > 0) {
                largerChildIndex = rightChildIndex;
            }

            if (orphan.compareTo(heap.get(largerChildIndex)) < 0) {
                heap.set(rootIndex, heap.get(largerChildIndex));
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            }

            else
                done = true;
        }
        heap.set(rootIndex, orphan);
    }

    // #endregion

    // #region Other methods

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

            // Now we recursively call heapify to change the affected sub-tree
            heapify(largest);
        }
    }

    // #endregion
}
