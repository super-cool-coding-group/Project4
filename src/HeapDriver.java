package src;

public class HeapDriver {
    public static void main(String[] args){

        MaxHeap<Integer> h = new MaxHeap<>();

        h.add(90);
        h.add(80);
        h.add(60);
        h.add(70);
        h.add(30);
        h.add(20);
        h.add(50);
        h.add(10);
        h.add(40);

        System.out.println(h);

        h.add(85);
        System.out.println(h);

    }
}
