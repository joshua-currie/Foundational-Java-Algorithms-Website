// Joshua Currie
// Bubble, Insertion, Selection, Bucket, Merge, and Quick Sort Program

import java.util.*;

public class AllSorts
{
    public static void bubbleSortAlgorithm(int [] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j] > array[j+1])
                {
                    // swap 
                    swapValues(array ,j, j+1);
                }
            }
        }
    }

    public static void bucketSortAlgorithm(int [] array)
    {
        int largestValue = 0;

        for (int num : array)
        {
            if (num > largestValue)
            {
                largestValue = num;
            }
        }

        int [] bucketsArray = new int [largestValue + 1];

        for (int num : array)
        {
            bucketsArray[num]++;
        }

        int arrayIndexTracker = 0;

        for (int i = 0; i < bucketsArray.length; i++)
        {
            if (bucketsArray[i] != 0)
            {
                for (int j = 0; j < bucketsArray[i]; j++)
                {
                    array[arrayIndexTracker] = i;
                    arrayIndexTracker++;
                }
            }
        }
    }

    public static void insertionSortAlgorithm(int [] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key)
            {
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = key;
        }
    }

    public static void selectionSortAlgorithm(int [] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j] < array[minIndex])
                {
                    minIndex = j;
                }
            }

            swapValues(array, i, minIndex);
        }
    }


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
    
    public static void quickSortAlgorithm(int[] array) 
    {
        quickSortHelper(array, 0, array.length - 1);
    }
    
    private static void quickSortHelper(int[] array, int low, int high) 
    {
        if (low < high) 
        {
            int pivotIndex = partition(array, low, high);
    
            quickSortHelper(array, low, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, high);
        }
    }
    
    private static int partition(int[] array, int low, int high) 
    {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) 
        {
            if (array[j] <= pivot) 
            {
                i++;
                swapValues(array, i, j);
            }
        }

        swapValues(array, i + 1, high);
        return i + 1;
    }

    // swapValues: given an array and two integers representing indexes
    // of that array, will swap the values at those two indexes
    private static void swapValues(int [] array, int num1, int num2)
    {
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
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
        int sortSelection = Integer.parseInt(args[0]); // command line 1
        String commandLineInput = args[1]; // command line 2
        String [] myArrayBuffer = commandLineInput.split(","); 

        // convert command line String input to integer array
        int [] myArray = new int [myArrayBuffer.length];

        for (int i = 0; i < myArray.length; i++)
        {
            myArray[i] = Integer.parseInt(myArrayBuffer[i]);
        }

        switch (sortSelection)
        {
            case 1:
                System.out.println("Array before bubble sort:");
                printArray(myArray);
                
                bubbleSortAlgorithm(myArray);
        
                System.out.println("Array after bubble sort:");
                printArray(myArray);
                break;

            case 2:
                System.out.println("Array before bucket sort:");
                printArray(myArray);
                
                bucketSortAlgorithm(myArray);
        
                System.out.println("Array after bucket sort:");
                printArray(myArray);
                break;

            case 3:
                System.out.println("Array before insertion sort:");
                printArray(myArray);
                
                insertionSortAlgorithm(myArray);
        
                System.out.println("Array after insertion sort:");
                printArray(myArray);
                break;

            case 4:
                System.out.println("Array before selection sort:");
                printArray(myArray);
                
                selectionSortAlgorithm(myArray);
        
                System.out.println("Array after selection sort:");
                printArray(myArray);
                break;

            case 5:
                System.out.println("Array before merge sort:");
                printArray(myArray);
                
                mergeSortAlgorithm(myArray);
        
                System.out.println("Array after merge sort:");
                printArray(myArray);
                break;

            case 6:
                System.out.println("Array before quicksort:");
                printArray(myArray);
                
                quickSortAlgorithm(myArray);
        
                System.out.println("Array after quicksort:");
                printArray(myArray);
                break;
        }
    }
}