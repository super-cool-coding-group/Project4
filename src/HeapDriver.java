package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This is the HeapDriver class that tests basic functionality of the MaxHeap
 * class.
 *
 * These functionalities include the creation of a heap with and without the
 * optimize method, adding an item, and creating a heap from a file.
 *
 *
 * @author George Matta
 * @author Pierlorenzo Peruzzo
 * @version 2.0
 */
public class HeapDriver {

    private static final String RANDOM_DATA_FILE = "src/data_random.txt";
    private static final String SORTED_DATA_FILE = "src/data_sorted.txt";

    /**
     * Demos typical usage of a MaxHeap object.
     *
     * We test different constructors with different creation methods, adding items,
     * and reading data into a heap from a file.
     *
     * @param args The basic String[] args for any main method in Java.
     */
    public static void main(String[] args) {

        // Testing non-optimize method
        System.out.println("*** TESTING NON-OPTIMAL METHOD ***");
        Integer[] items = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };

        MaxHeap<Integer> h = new MaxHeap<>(items);
        System.out.println(h);

        System.out.println();

        System.out.println("*** TESTING ADD AN ITEM ***");

        h.add(85);
        System.out.println(h);

        System.out.println();

        System.out.println("*** TESTING OPTIMAL METHOD ***");
        MaxHeap<Integer> h1 = new MaxHeap<>(items, true);
        System.out.println(h1);

        System.out.println();

        System.out.println("*** TESTING READ FROM FILE ***");

        Integer[] randomData = null;
        Integer[] sortedData = null;
        try {
            randomData = readFile(RANDOM_DATA_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("File " + RANDOM_DATA_FILE + " not found.");
        }
        try {
            sortedData = readFile(SORTED_DATA_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("File " + SORTED_DATA_FILE + " not found.");
        }

        if(randomData != null){
            System.out.println();

            System.out.println("*** TESTING NON-OPTIMAL METHOD ON RANDOM DATA ***");

            MaxHeap<Integer> nonOptRand = new MaxHeap<>(randomData);
            System.out.println(nonOptRand);
            System.out.println("NumSwaps: " + nonOptRand.getNumSwaps());

            System.out.println();

            System.out.println("*** TESTING OPTIMAL METHOD ON RANDOM DATA ***");

            MaxHeap<Integer> optRand = new MaxHeap<>(randomData, true);
            System.out.println(optRand);
            System.out.println("NumSwaps: " + optRand.getNumSwaps());
        }

        if(sortedData != null){
            System.out.println();

            System.out.println("*** TESTING NON-OPTIMAL METHOD ON SORTED DATA ***");

            MaxHeap<Integer> nonOptSorted = new MaxHeap<>(sortedData);
            System.out.println(nonOptSorted);
            System.out.println("NumSwaps: " + nonOptSorted.getNumSwaps());


            System.out.println();

            System.out.println("*** TESTING OPTIMAL METHOD ON SORTED DATA ***");

            MaxHeap<Integer> optSorted = new MaxHeap<>(sortedData, true);
            System.out.println(optSorted);
            System.out.println("NumSwaps: " + optSorted.getNumSwaps());
        }

    }

    /**
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    private static Integer[] readFile(String file) throws FileNotFoundException {
        File thisFile = new File(file);
        Scanner inputFile = new Scanner(thisFile);

        // Inputs file data into array
        Integer[] fileArray = new Integer[100];
        for (int i = 0; i < 100; i++) {
            fileArray[i] = inputFile.nextInt();
        }
        inputFile.close();

        return fileArray;
    }

    /**
     *
     * @param fileArray
     * @throws FileNotFoundException
     */
    public void writeFile(Integer[] fileArray) throws FileNotFoundException {
        PrintWriter outputFile = new PrintWriter("output_file.txt");

        for (int i = 0; i < 10; i++) {
            outputFile.println(fileArray);
        }

        outputFile.close();
    }
}
