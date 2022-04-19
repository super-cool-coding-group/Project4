package src;

public class MaxHeap<T extends Comparable<? super T>> implements BinaryHeapInterface<T> {

    //#region Const

    private static final int DEFAULT_CAPACITY = 25;
    //private static final int MAX_CAPACITY = 10000;

    //#endregion

    //#region Private Fields

    private ResizeableList<T> heap;
    private boolean initialized = false;

    //#endregion

    //#region Constructors

    public MaxHeap(){
        this(DEFAULT_CAPACITY);
    }

    public MaxHeap(int initialCapacity){
        if (initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = DEFAULT_CAPACITY;

        heap = new ResizeableList<T>(initialCapacity);
        initialized = true;
    }

    //#endregion

    //#region Building Heap (Project 4)
    public MaxHeap(int[] items){
        // Default to the non-optimal method
        this(items, false);
    }

    @SuppressWarnings("unchecked")
    public MaxHeap(int[] items, boolean optimal){
        this();

        // If we want the non-optimal method
        if(!optimal){
            for(Integer item : items){
                this.add((T) item);
            }

            return;
        }

        // If we want the optimal method:

    }

    //#endregion

    //#region Security Check

    private void checkInitialization(){
        if(!initialized){
            throw new SecurityException("MaxHeap object is corrupt or was not initialized properly.");
        }
    }

    //#endregion


    //#region Implement BinaryHeapInterface

    @Override
    public boolean canAdd(int index, T entry){
        checkInitialization();

        return entry.compareTo(heap.get(index)) > 0;
    }

    @Override
    public int getParentIndex(int childIndex){
        checkInitialization();

        if(childIndex % 2 != 0){
            childIndex--;
        }

        if (childIndex <= 1){
            return -1;
        }

        return childIndex/2;
    }

    @Override
    public int getChildIndex(int parentIndex){
        checkInitialization();

        int childIndex = parentIndex * 2;

        if(childIndex >= heap.getNumEntries()){
            return -1;
        }

        return childIndex;
    }

    @Override
    public void add(T newEntry){
        checkInitialization();

        // Add the entry to the last index
        heap.add(newEntry);

        // Set up indices for the current entry and the parent entry
        int entryIndex = heap.getNumEntries();
        int parentIndex = getParentIndex(entryIndex);

        // If the parent is less than the entry
        while(parentIndex > 0 && canAdd(parentIndex, newEntry)){
            // Swap the entries
            heap.swap(entryIndex, parentIndex);
            // Recalculate the indices
            entryIndex = parentIndex;
            parentIndex = getParentIndex(entryIndex);
        }

    }

    @Override
    public boolean isEmpty(){
        checkInitialization();
        return heap.isEmpty();
    }

    @Override
    public int getSize(){
        checkInitialization();
        return heap.getNumEntries();
    }

    @Override
    public void clear(){
        checkInitialization();
        heap.clear();
    }

    @Override
    public String toString(){
        return heap.toString();
    }

    public T getRoot(){
        checkInitialization();
        T root = null;
        if(!isEmpty())
            root = heap.get(1);
        return root;
    }

    public T getMax(){
        checkInitialization();
        T root = null;
        if(!isEmpty())
            root = heap.get(1);
        return root;
    }

    // Removes and returns the heap's largest object
    public T removeMax(){
        checkInitialization();
        T root = null;
        if(!isEmpty()){
            root = heap.get(1);
            heap.set(1, heap.get(heap.getNumEntries()));
            heap.remove(heap.getNumEntries());
            reheap(1);
        }
        return root;
    }

    // Turns a semiheap into a heap
    private void reheap(int rootIndex){
        boolean done = false;
        T orphan = heap.get(rootIndex);
        int leftChildIndex = this.getChildIndex(1);
        while(!done && (leftChildIndex <= heap.getNumEntries())){
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            if( (rightChildIndex <= heap.getNumEntries()) && 
                heap.get(rightChildIndex).compareTo(heap.get(largerChildIndex)) > 0){
                largerChildIndex = rightChildIndex;
            }

            if(orphan.compareTo(heap.get(largerChildIndex)) < 0){
                heap.set(rootIndex, heap.get(largerChildIndex));
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            }

            else
                done = true;
        }
        heap.set(rootIndex, orphan);
    }

    //#endregion

}
