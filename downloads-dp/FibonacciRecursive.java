// Joshua Currie
// Fibonacci recurisve approach

public class FibonacciRecursive
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

    // takes in one command line argument which an integer representing which term of Fibonacci to compute
    public static void main(String [] args)
    {
        int fibTerm = Integer.parseInt(args[0]);

        int answer = fibonacciRecursive(fibTerm);
        System.out.println("The "+ fibTerm + "term of Fibonacci using brute force recursion is " + answer);
    }
}