package src;

public interface ArrayInterface<T> {

    public boolean add(T entry);

    public T remove(int index);

    public T remove();

    public void swap(int firstIndex, int secondIndex);

    public int getFreqOf(T entry);

    public boolean contains(T entry);

    public int getCapacity();

    public int getNumEntries();

    public boolean isEmpty();

    public void clear();

    public T[] toArray();

}
