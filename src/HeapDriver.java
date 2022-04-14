package src;

public class HeapDriver {
    public static void main(String[] args){


        int[] items = {10, 20, 30, 40, 50, 60, 70, 80, 90};

        MaxHeap<Integer> h = new MaxHeap<>(items);

        System.out.println(h);

        h.add(85);
        System.out.println(h);

    }
}
