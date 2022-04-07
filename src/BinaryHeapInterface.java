package src;

public interface BinaryHeapInterface<T> {

    public boolean canAdd();

    public int getParentIndex(int index);

    public int getChildIndex(int index);
}
