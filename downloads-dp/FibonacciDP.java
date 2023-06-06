// Joshua Currie
// Fibonacci Dynamic Programming approach

public class FibonacciDP
{
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

    // takes in one command line argument which an integer representing which term of Fibonacci to compute
    public static void main(String [] args)
    {
        int fibTerm = Integer.parseInt(args[0]);

        int answer = fibonacciDP(fibTerm);
        System.out.println("The "+ fibTerm + "term of Fibonacci using standing Dynamic Programming is " + answer);
    }
}