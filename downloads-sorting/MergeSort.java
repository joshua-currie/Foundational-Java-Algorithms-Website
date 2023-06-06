// Joshua Currie
// Merge Sort Program

import java.util.*;

public class MergeSort
{
    public static void mergeSortAlgorithm(int [] array)
    {
        // base case
        if (array.length <= 1)
        {
            return;
        }

        int midpoint = array.length / 2;
        int[] leftArray = Arrays.copyOfRange(array, 0, midpoint);
        int[] rightArray = Arrays.copyOfRange(array, midpoint, array.length);

        mergeSortAlgorithm(leftArray);
        mergeSortAlgorithm(rightArray);

        merge(leftArray, rightArray, array);
    }

    private static void merge(int [] leftArray, int [] rightArray, int [] array)
    {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftArray.length && j < rightArray.length)
         {
            if (leftArray[i] <= rightArray[j])
            {
                array[k] = leftArray[i];
                i++;
            } 

            else 
            {
                array[k] = rightArray[j];
                j++;
            }

            k++;
        }

        while (i < leftArray.length) 
        {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArray.length) 
        {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // printArray: given a 1-D array, will print the contents of
    // the array from smallest index to largest index
    public static void printArray(int [] array)
    {
        for (int num : array)
        {
            System.out.print(num +  "   ");
        }
        System.out.println("\n");
    }

    public static void main(String [] args)
    {
        String commandLineInput = args[0]; // command line 1
        String [] myArrayBuffer = commandLineInput.split(","); 

        int [] myArray = new int [myArrayBuffer.length];

        // convert command line String input to integer array
        for (int i = 0; i < myArray.length; i++)
        {
            myArray[i] = Integer.parseInt(myArrayBuffer[i]);
        }

        System.out.println("Array before merge sort:");
        printArray(myArray);
        
        mergeSortAlgorithm(myArray);

        System.out.println("Array after merge sort:");
        printArray(myArray);
    }
}