// Joshua Currie
// Selection Sort Program

public class SelectionSort
{
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

        System.out.println("Array before selection sort:");
        printArray(myArray);
        
        selectionSortAlgorithm(myArray);

        System.out.println("Array after selection sort:");
        printArray(myArray);
    }
}