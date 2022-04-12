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

        int parentIndex = getParentIndex(index);
        int childIndex = getChildIndex(index);

        boolean parentCheck = true;
        boolean childCheck = true;
        if(parentIndex != -1){
            parentCheck = heap.get(parentIndex).compareTo(entry) >= 0;
        }

        if(childIndex != -1){
            if(childIndex < heap.getNumEntries())
                childCheck = heap.get(childIndex).compareTo(entry) <= 0;
            if (childIndex+1 < heap.getNumEntries())
                childCheck = childCheck && heap.get(childIndex + 1).compareTo(entry) <= 0;
        }

        return parentCheck && childCheck;
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
        add(heap.getNumEntries() + 1, newEntry);
    }

    @Override
    public void add(int index, T newEntry){
        checkInitialization();

        if(canAdd(index, newEntry)){
            heap.add(index, newEntry);
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
