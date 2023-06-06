// Joshua Currie
// Quick Sort Program

public class QuickSort
{
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
        String commandLineInput = args[0]; // command line 1
        String [] myArrayBuffer = commandLineInput.split(","); 

        // convert command line String input to integer array
        int [] myArray = new int [myArrayBuffer.length];

        for (int i = 0; i < myArray.length; i++)
        {
            myArray[i] = Integer.parseInt(myArrayBuffer[i]);
        }

        System.out.println("Array before quicksort:");
        printArray(myArray);
        
        quickSortAlgorithm(myArray);

        System.out.println("Array after quicksort:");
        printArray(myArray);
    }
}