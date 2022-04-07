package src;

public interface BinaryHeapInterface<T extends Comparable<? super T>> {

    public void add(T newEntry);

    public boolean canAdd();

    public int getParentIndex(int index);

    public int getChildIndex(int index);

    public boolean isEmpty();

    public int getSize();

    public void clear();

    public T removeRoot();

    public T getRoot();
    
}
