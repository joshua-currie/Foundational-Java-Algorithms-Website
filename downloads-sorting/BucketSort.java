// Joshua Currie
// Bucket Sort Program

public class BucketSort
{
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

        System.out.println("Array before bucket sort:");
        printArray(myArray);
        
        bucketSortAlgorithm(myArray);

        System.out.println("Array after bucket sort:");
        printArray(myArray);
    }
}