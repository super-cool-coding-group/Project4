package src;

public interface ArrayInterface<T> {

    public void add(int index, T entry);

    public void add(T entry);

    public T remove(int index);

    public T remove();

    public T set(int index, T entry);

    public T get(int index);

    public void swap(int firstIndex, int secondIndex);

    public int getFreqOf(T entry);

    public boolean contains(T entry);

    public int getIndexOf(T entry);

    public int getCapacity();

    public int getNumEntries();

    public boolean isEmpty();

    public boolean isFull();

    public void clear();

    public T[] getArray();

}
