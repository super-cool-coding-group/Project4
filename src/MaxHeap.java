package src;

public class MaxHeap<T extends Comparable<? super T>> implements BinaryHeapInterface<T> {

    //#region Const

    private static final int DEFAULT_CAPACITY = 25;

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

    //#endregion
}
