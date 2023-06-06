// Joshua Currie
// Fibonacci Memoized approach

import java.util.*;

public class FibonacciMemoized
{
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

    // takes in one command line argument which an integer representing which term of Fibonacci to compute
    public static void main(String [] args)
    {
        int fibTerm = Integer.parseInt(args[0]);

        int answer = fibonacciMemoized(fibTerm);
        System.out.println("The "+ fibTerm + "term of Fibonacci using memoization is " + answer);
    }
}