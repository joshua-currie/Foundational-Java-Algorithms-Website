// Joshua Currie
// Bubble Sort Program

public class BubbleSort
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

        System.out.println("Array before bubble sort:");
        printArray(myArray);
        
        bubbleSortAlgorithm(myArray);

        System.out.println("Array after bubble sort:");
        printArray(myArray);
    }
}