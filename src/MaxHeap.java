package src;

public class MaxHeap<T extends Comparable<? super T>> implements BinaryHeapInterface<T> {

    //#region Const

    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10_000;

    //#endregion

    //#region Private Fields

    private ResizeableList<T> heap;
    private int lastIndex;
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
        lastIndex = 0;
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
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getParentIndex(int childIndex){
        checkInitialization();

        if(childIndex % 2 != 0){
            childIndex--;
        }

        if (childIndex == 1){
            throw new NoParentException("The node at index " + childIndex + " does not have a parent.");
        }

        return childIndex/2;
    }

    @Override
    public int getChildIndex(int parentIndex){
        checkInitialization();

        int childIndex = parentIndex * 2;

        if(childIndex > lastIndex){
            throw new NoParentException("The node at index " + parentIndex + " does not have a child.");
        }

        return childIndex;
    }

    @Override
    public void add(T newEntry){
        checkInitialization();
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isEmpty(){
        checkInitialization();
        return heap.isEmpty();
    }

    @Override
    public int getSize(){
        checkInitialization();
        return lastIndex;
    }

    @Override
    public void clear(){
        checkInitialization();
        heap.clear();
    }

    // @Override
    // public T removeRoot() {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    // @Override
    // public T getRoot() {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    //#endregion
}
