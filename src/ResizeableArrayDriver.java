package src;

public class ResizeableArrayDriver{

    public static void main(String[] args){

        // ResizeableArray<String> negArr = new ResizeableArray<>(-1);

        // ResizeableArray<String> emptArr = new ResizeableArray<>(0);

        ResizeableArray<String> oneArr = new ResizeableArray<>(1);
        System.out.println(oneArr);

        // ResizeableArray<String> defArr = new ResizeableArray<>();
        // System.out.println(defArr);

        ResizeableArray<String> maxArr = new ResizeableArray<>(10_000);
        System.out.println(maxArr);

        //ResizeableArray<String> moreMaxArr = new ResizeableArray<>(10_001);

        oneArr.add("1");
        System.out.println(oneArr);
        oneArr.add("2");
        System.out.println(oneArr);
        // System.out.println(oneArr.get(0));
        System.out.println(oneArr.get(1));
        System.out.println(oneArr.get(2));
        oneArr.add("3");
        System.out.println(oneArr);
        System.out.println(oneArr.get(1));
        System.out.println(oneArr.get(3));
        oneArr.add(4, "4");
        System.out.println(oneArr);
        oneArr.add(6, "5");
        System.out.println(oneArr);
        oneArr.add(9, "6");
        System.out.println(oneArr);
        oneArr.set(1, "10");
        System.out.println(oneArr);
        oneArr.set(9, "9");
        oneArr.set(5, "5");

        System.out.println(oneArr);
        System.out.println(oneArr.getFreqOf("5"));

        oneArr.remove();
        System.out.println(oneArr);

        oneArr.remove(5);
        System.out.println(oneArr);

        oneArr.remove(2);
        System.out.println(oneArr);

        System.out.println(oneArr.get(2));

        // oneArr.remove(5);

        oneArr.swap(1, 2);
        System.out.println(oneArr);

        // oneArr.swap(1, 10);
        oneArr.swap(1, 4);
        System.out.println(oneArr);

        maxArr.add(5, "hey");
        System.out.println(maxArr);

        // maxArr.add(10_000, "he");
        // System.out.println(maxArr);
    }
}
