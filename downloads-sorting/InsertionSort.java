// Joshua Currie
// Insertion Sort Program

public class InsertionSort
{
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

        System.out.println("Array before insertion sort:");
        printArray(myArray);
        
        insertionSortAlgorithm(myArray);

        System.out.println("Array after insertion sort:");
        printArray(myArray);
    }
}