package src;

import java.io.File;
import java.io.FileNotFoundException;
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

    /**
     * The name of the file containing the random data
     */
    private static final String RANDOM_DATA_FILE = "src/data_random.txt";

    /**
     * The name of the file containing the sorted data
     */
    private static final String SORTED_DATA_FILE = "src/data_sorted.txt";

    /**
     * The name of the file in which we will output our final data
     */
    private static final String OUTPUT_DATA_FILE = "src/output_file.txt";

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

        System.out.println("*** TESTING READ FROM FILE ***\n");

        // Initialize Integer arrays for our random and sorted data files
        Integer[] randomData = null;
        Integer[] sortedData = null;

        // Try to read our random data file
        try {
            randomData = readFile(RANDOM_DATA_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("File " + RANDOM_DATA_FILE + " not found.");
        }

        // Try to read our sorted data file
        try {
            sortedData = readFile(SORTED_DATA_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("File " + SORTED_DATA_FILE + " not found.");
        }

        // Try to write to our output data file
        try{
            writeFile(randomData, sortedData, OUTPUT_DATA_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("File " + OUTPUT_DATA_FILE + " not found.");
        }
    }

    /**
     * Reads a file given a filename in this path and creates/returns an Integer[] of the numbers in that file.
     *
     * The file passed through must contain all integers, one on each line.
     *
     * @param file The name of the file we want to read
     * @return An Integer[] of the ints in the file
     * @throws FileNotFoundException If the file passed is not found in the path
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
     * Writes to our output file the heaps created by random and sorted data, the number of swaps for various creation methods,
     * and the heap after 10 removals
     *
     * @param randomData An Integer[] of random ints
     * @param sortedData An Integer[] of sorted ints
     * @param outputFile The name of the file we will output to
     * @throws FileNotFoundException If the file passed is not found in the path
     */
    private static void writeFile(Integer[] randomData, Integer[] sortedData, String outputFileName) throws FileNotFoundException {

        String outputString = "";

        if(randomData != null){
            MaxHeap<Integer> nonOptRand = new MaxHeap<>(randomData);
            MaxHeap<Integer> optRand = new MaxHeap<>(randomData, true);

            outputString += "*** Heap built using RANDOM data ***\n";

            outputString += "Heap built using Sequential Insertions: " + nonOptRand.preview() + "\n";
            outputString += "Number of Swaps in the heap creation: " + nonOptRand.getNumSwaps() + "\n";
            nonOptRand.remove(10);
            outputString += "Heap after 10 removals: " + nonOptRand.preview() + "\n";

            outputString += "\n";

            outputString += "Heap built using Optimal Method: " + optRand.preview() + "\n";
            outputString += "Number of Swaps in the heap creation: " + optRand.getNumSwaps() + "\n";
            optRand.remove(10);
            outputString += "Heap after 10 removals: " + optRand.preview() + "\n";
        }

        outputString += "\n";

        if(sortedData != null){
            MaxHeap<Integer> nonOptSorted = new MaxHeap<>(sortedData);
            MaxHeap<Integer> optSorted = new MaxHeap<>(sortedData, true);

            outputString += "*** Heap built using SORTED data ***\n";

            outputString += "Heap built using Sequential Insertions: " + nonOptSorted.preview() + "\n";
            outputString += "Number of Swaps in the heap creation: " + nonOptSorted.getNumSwaps() + "\n";
            nonOptSorted.remove(10);
            outputString += "Heap after 10 removals: " + nonOptSorted.preview() + "\n";

            outputString += "\n";

            outputString += "Heap built using Optimal Method: " + optSorted.preview() + "\n";
            outputString += "Number of Swaps in the heap creation: " + optSorted.getNumSwaps() + "\n";
            optSorted.remove(10);
            outputString += "Heap after 10 removals: " + optSorted.preview() + "\n";
        }

        System.out.println(outputString);

        // PrintWriter outputFile = new PrintWriter(outputFileName);

        // for (int i = 0; i < 10; i++) {
        //     outputFile.println("");
        // }

        // outputFile.close();
    }
}
