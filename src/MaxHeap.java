package src;

import org.junit.platform.engine.support.hierarchical.DefaultParallelExecutionConfigurationStrategy;

public class MaxHeap<T extends Comparable<? super T>> implements BinaryHeapInterface<T> {

    //#region Const

    private static final int DEFAULT_CAPACITY = 25;

    //#endregion

    //#region Private Fields

    private ResizeableArray<T> heap;
    private int lastIndex;
    private boolean initialized;

    //#endregion

    //#region Constructors

    public MaxHeap(){
        this(DEFAULT_CAPACITY);
    }

    public MaxHeap(int initialCapacity){
        if (initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = DEFAULT_CAPACITY;

        heap = new ResizeableArray(initialCapacity);
        lastIndex = 0;
        initialized = true;
    }

    //#endregion

    //#region Implement BinaryHeapInterface

    @Override
    public boolean canAdd() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getParentIndex(int index) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getChildIndex(int index) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void add(T newEntry) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public T removeRoot() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T getRoot() {
        // TODO Auto-generated method stub
        return null;
    }

    //#endregion
}
