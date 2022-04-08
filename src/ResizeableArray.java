package src;

public class ResizeableArray<T> implements ArrayInterface<T> {

    private T[] array;

    private int numOfEntries;

    private boolean integrityOk = false;

    private static final int MAX_CAPACITY = 10_000;

    private static final int DEFAULT_CAPACITY = 10;

    public ResizeableArray(){
        this(DEFAULT_CAPACITY);
    }

    public ResizeableArray(int capacity){
        checkCapacity(capacity);
        this.array = createArray(capacity);
        this.numOfEntries = 0;
        this.integrityOk = true;
    }

    /**
     * A private method to create a generic-type array
     * @param capacity The capacity of the array object
     * @return The array object of T generics
     */
    @SuppressWarnings("unchecked")
    private T[] createArray(int capacity){
        return (T[]) new Object[capacity];
    }

    /**
     * A method to throw an error if the capacity of the bag is too large or too small
     * @param capacity The capacity we are checking
     */
    private void checkCapacity(int capacity){
        String errorMessage = "Attempted to create a bag with a capacity (" + capacity + ") which is too ";
        if (capacity > MAX_CAPACITY){
            errorMessage += "large";
            throw new IllegalStateException(errorMessage);
        }
        if (capacity < 1){
            errorMessage += "small";
            throw new IllegalStateException(errorMessage);
        }
    }

    /**
     * A method to continuously double the capacity if a provided index is larger than capacity
     * @param index The index we are checking if it is too large
     */
    private void ensureCapacity(int index){
        while(index > array.length){
            doubleCapacity();
        }
    }

    /**
     * A method to double the capacity of the array
     */
    private void doubleCapacity(){
        int newCapacity = array.length * 2;
        checkCapacity(newCapacity);
        T[] newArray = createArray(newCapacity);
        array = copyEntries(newArray);
    }

    /**
     * A method to copy all the entries from this array into a new array
     * @param newArray The array to copy the entries into
     * @return The array with the copied entries
     */
    private T[] copyEntries(T[] newArray){
        for(int i = 0; i < numOfEntries; i++){
            newArray[i] = array[i];
        }
        return newArray;
    }

    /**
     * A method to check the integrity of the ResizeableArrayBag to make sure the constructor was called.
     */
    private void checkIntegrity(){
        if(!integrityOk){
            throw new SecurityException("ResizeableArray object is corrupt or was not initialized properly.");
        }
    }

    private void checkIndexInRange(int index){
        if(index < 1 || index > numOfEntries){
            throw new IndexOutOfBoundsException("The index provided (" +
                                                index + ") does not fall within " +
                                                "the range of the array (1-" +
                                                numOfEntries + ").");
        }
    }

    @Override
    public void add(int index, T entry) {
        checkIntegrity();
        ensureCapacity(index);

        if(index <= numOfEntries){
            moveEntriesForward(index + 1);
        }

        array[index - 1] = entry;

        numOfEntries += index - numOfEntries;
    }

    @Override
    public void add(T entry) {
        add(numOfEntries + 1, entry);
    }

    @Override
    public T remove(int index) {
        checkIntegrity();
        checkIndexInRange(index);

        T removed = moveEntriesBack(index);

        // We are definitely removing one entry
        numOfEntries--;
        // We also remove an entry for every trailing null
        for( ; array[numOfEntries - 1] == null; numOfEntries--);

        return removed;
    }

    @Override
    public T remove() {
        checkIntegrity();
        return remove(numOfEntries);
    }

    // basically removes an entry
    private T moveEntriesBack(int index){
        T removed = array[index];
        for(int i = index + 1; i <= numOfEntries; i++){
            array[i - 1] = array[i];
        }
        return removed;
    }

    // adds a null at index and moves everything forward
    private void moveEntriesForward(int index){
        ensureCapacity(index);
        for(int i = numOfEntries; i > index; i--){
            System.out.println(this);
            array[i + 1] = array[i];
        }
    }

    @Override
    public T set(int index, T entry) {
        checkIntegrity();
        checkIndexInRange(index);

        T removed = array[index - 1];
        array[index - 1] = entry;

        return removed;
    }

    @Override
    public T get(int index) {
        checkIntegrity();
        checkIndexInRange(index);

        return array[index - 1];
    }

    @Override
    public void swap(int firstIndex, int secondIndex) {
        checkIntegrity();
        checkIndexInRange(firstIndex);
        checkIndexInRange(secondIndex);

        T tempEntry = array[firstIndex - 1];
        array[firstIndex - 1] = array[secondIndex - 1];
        array[secondIndex - 1] = tempEntry;
    }

    @Override
    public int getFreqOf(T entry) {
        checkIntegrity();

        int count = 0;
        // Loop through the array
        for(int i = 0; i < numOfEntries; i++){
            // If we are at a null entry, skip it
            if(array[i] == null){
                continue;
            }
            // If we found the element
            if(array[i].equals(entry)){
                // Increase the count
                count++;
            }
        }

        // Return the final count
        return count;
    }


    @Override
    public boolean contains(T entry) {
        checkIntegrity();
        // If the entry is in the array, return true
        return getIndexOf(entry) > -1;
    }

    @Override
    public int getIndexOf(T entry) {

        // Loop through the array
        for(int i = 0; i < numOfEntries; i++){
            // If we find the element
            if(array[i].equals(entry)){
                // Return the indes
                return i;
            }
        }

        // Otherwise, return -1
        return -1;
    }

    @Override
    public int getCapacity() {
        checkIntegrity();
        return array.length;
    }

    @Override
    public int getNumEntries() {
        checkIntegrity();
        return numOfEntries;
    }

    @Override
    public boolean isEmpty() {
        checkIntegrity();
        return numOfEntries == 0;
    }

    @Override
    public boolean isFull() {
        return numOfEntries >= array.length - 1;
    }

    @Override
    public void clear() {
        checkIntegrity();
        while(!isEmpty()){
            remove();
        }
    }

    @Override
    public T[] getArray() {
        checkIntegrity();
        return array;
    }

    @Override
    public String toString(){
        checkIntegrity();

        String output = "[";
        for(int i = 0; i < numOfEntries - 1; i++){
            output += array[i] + ", ";
        }

        if(numOfEntries != 0){
            output += array[numOfEntries - 1];
        }
        output += "]";

        output += "\nCapacity: " + array.length;
        output += "\nNumEntries: " + numOfEntries;

        return output;
    }

}
