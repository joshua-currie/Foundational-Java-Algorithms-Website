// Joshua Currie
// Fibonacci recurisve approach

public class FibonacciDPOptimized
{
    // fibonacciDPOptimized: similar to the other DP solution by using an 1-D array instead of recurion
    // but the array size now only being the size of 2 as the DP approach for Fibonacci only relys on the 
    // previous two sub-problem solutions
    public static int fibonacciDPOptimized(int fibTerm)
    {
        // create optimized data structure to perform Dynamic Programming
        int [] dpArrayOpt = new int [2];

        // base cases
        dpArrayOpt[0] = 0;
        dpArrayOpt[1] = 1;

        for (int i = 2; i <= fibTerm; i++)
        {
            dpArrayOpt[i%2] = dpArrayOpt[(i-1)%2] + dpArrayOpt[i%2];
        }

        return dpArrayOpt[fibTerm%2];
    }

    // takes in one command line argument which an integer representing which term of Fibonacci to compute
    public static void main(String [] args)
    {
        int fibTerm = Integer.parseInt(args[0]);

        int answer = fibonacciDPOptimized(fibTerm);
        System.out.println("The "+ fibTerm + "term of Fibonacci using optimized Dynamic Programming is " + answer);
    }
}