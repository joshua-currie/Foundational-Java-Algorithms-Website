// Joshua Currie
// Fibonacci Program 4 ways

import java.util.*;

public class Fibonacci
{
    // fibonacciRecursive: brute force approach using recusion
    public static int fibonacciRecursive(int fibTerm)
    {
        // base cases
        if (fibTerm == 0 || fibTerm == 1)
        {
            return fibTerm;
        }

        else
        {
            return fibonacciRecursive(fibTerm - 1) + fibonacciRecursive(fibTerm - 2);
        }
    }

    // fibonacciMemoized: recursive solution using an array data structure to avoid 
    // repeated computation
    public static int fibonacciMemoized(int fibTerm)
    {
        // create data structure to hold repeated computation
        int [] memo = new int [fibTerm + 1];
        Arrays.fill(memo, -1);

        return fibonacciMemoizedHelper(memo, fibTerm);
    }

    private static int fibonacciMemoizedHelper(int [] memo, int fibTerm)
    {
        // base cases
        if (fibTerm == 0 || fibTerm == 1)
        {
            return fibTerm;
        }

        // check if term has already been calculated before
        else if (memo[fibTerm] != -1)
        {
            return memo[fibTerm];
        }

        // calculate answer recurively and store answer in memoizing array
        else
        {
            memo[fibTerm] = fibonacciMemoizedHelper(memo, fibTerm - 1) + fibonacciMemoizedHelper(memo, fibTerm - 2);
            return memo[fibTerm];
        }
    }

    // fibonacciDP: remove recursion entirely and uses a 1-D array to solve the problem by filling in sub-problem
    // solutions in our array to work out to our final answer. 
    // Dynamic programming solution has high fidelity to the recursive apporach.
    public static int fibonacciDP(int fibTerm)
    {
        // create data structure to perform Dynamic Programming
        int [] dpArray = new int [fibTerm + 1];
        
        // base cases
        dpArray[0] = 0;
        dpArray[1] = 1;

        for (int i = 2; i <= fibTerm; i++)
        {
            dpArray[i] = dpArray[i-1] + dpArray[i-2];
        }

        return dpArray[fibTerm];
    }

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

    // EX: to find the 9th term of Fibonnaci using Memoization
    // java Fibonacci 9 2
    public static void main(String [] args)
    {
        int fibTerm = Integer.parseInt(args[0]); // command line 1
        int approachSelection = Integer.parseInt(args[1]); // command line 2
        int answer;

        switch(approachSelection)
        {
            case 1:
                answer = fibonacciRecursive(fibTerm);
                System.out.println("The "+ fibTerm + "term of Fibonacci using brute force recursion is " + answer);
                break;

            case 2:
                answer = fibonacciMemoized(fibTerm);
                System.out.println("The "+ fibTerm + "term of Fibonacci using memoization is " + answer);
                break;

            case 3:
                answer = fibonacciDP(fibTerm);
                System.out.println("The "+ fibTerm + "term of Fibonacci using standing Dynamic Programming is " + answer);
                break;

            case 4:
                answer = fibonacciDPOptimized(fibTerm);
                System.out.println("The "+ fibTerm + "term of Fibonacci using optimized Dynamic Programming is " + answer);
                break;
        }
    }
}