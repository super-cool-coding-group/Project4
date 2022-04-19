package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HeapDriver {
    public static void main(String[] args) throws FileNotFoundException{


        int[] items = {10, 20, 30, 40, 50, 60, 70, 80, 90};

        MaxHeap<Integer> h = new MaxHeap<>(items);

        System.out.println(h);

        h.add(85);
        System.out.println(h);

        

    }

    private static int[] readFile(String file) throws FileNotFoundException{
        File thisFile = new File(file);
        Scanner inputFile = new Scanner(thisFile);

        // Inputs file data into array
        int[] fileArray = new int[100];
        for(int i = 1; i <= 100; i++){
            fileArray[i] = inputFile.nextInt();
        }
        inputFile.close();

        return fileArray;
    }
}
