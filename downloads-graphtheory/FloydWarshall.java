// Joshua Currie
// Floyd-Warshall's Algorithm Program

import java.util.*;

public class FloydWarshall
{
    // initialized distance for undiscovered path between two nodes
    private static final int INFINITY = 1000000;

    // floydWarshallAlgorithm: given an adjacency matrix and the number of nodes in the graph, 
    // will calculate the shortest path distance between every two nodes in the graph using the
    // Floyd-Warshall dynamic programming apporach
    public static void floydWarshallAlgorithm(int [][] matrix, int numNodes)
    {
        // declare and initialize necessary fields
        int [][] distanceArray = new int [numNodes][numNodes];

        // initialize distance array with the values in the matrix
        for (int i = 0; i < numNodes; i++)
        {
            for (int j = 0; j < numNodes; j++)
            {
                distanceArray[i][j] = matrix[i][j];
            }
        }

        // perform Floyd-Warshall
        for (int k = 0; k < numNodes; k++)
        {
            for (int i = 0; i < numNodes; i++)
            {
                for (int j = 0; j < numNodes; j++)
                {
                    // if the distance between node i and j is decreased when passing through node k
                    if (distanceArray[i][k] + distanceArray[k][j] < distanceArray[i][j])
                    {
                        // update new distance between node i and node j
                        distanceArray[i][j] = distanceArray[i][k] + distanceArray[k][j];
                    }
                }
            }
        }

        // after algorithm is concluded, print results
        printDistances(distanceArray);
    }

    // printDistances: helper method to print final distances given 2-D distance array
    private static void printDistances(int [][] distanceArray)
    {
        System.out.println("Shortest path between every pair of nodes using Floyd-Warshall:");

        for (int i = 0; i < distanceArray.length; i++)
        {
            for (int j = 0; j < distanceArray.length; j++)
            {
                if (distanceArray[i][j] != INFINITY)
                {
                    System.out.println("Distance from node " + (i+1) + " to node " + (j+1) + ": " + distanceArray[i][j]);
                }

                else
                {
                    System.out.println("NOT FOUND\t");
                }
            }
        }
    }

    public static void main(String [] args)
    {
        int numNodes = Integer.parseInt(args[0]); // command line 1
        String edges = args[1]; // command line 2

        // create adjacency matrix and initialize all values to -1
        int [][] adjacencyMatrix= new int [numNodes][numNodes];
        
        for (int i = 0; i < numNodes; i++)
        {
            Arrays.fill(adjacencyMatrix[i], INFINITY);
        }

        // manipulate command line String argument representing edges to fill matrix
        String [] edgeArray = edges.split(",");

        for (String edge : edgeArray)
        {
            String [] edgeParts = edge.split("/");

            adjacencyMatrix[Integer.parseInt(edgeParts[0]) - 1][Integer.parseInt(edgeParts[1]) - 1] = Integer.parseInt(edgeParts[2]);
            adjacencyMatrix[Integer.parseInt(edgeParts[1]) - 1][Integer.parseInt(edgeParts[0]) - 1] = Integer.parseInt(edgeParts[2]);
        }

        // fill all node edges that point to itself as distance of 0
        for (int i = 0; i < numNodes; i++)
        {
            adjacencyMatrix[i][i] = 0;
        }

        // call algorithm method
        floydWarshallAlgorithm(adjacencyMatrix, numNodes);
    }
}