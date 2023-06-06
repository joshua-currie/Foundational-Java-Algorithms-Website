// Joshua Currie
// Bellman-Ford Algorithm Program

import java.util.*;

public class BellmanFord
{
    // initialized distance for undiscovered path between two nodes
    private static final int INFINITY = 1000000;


    // bellmanFordAlgorithm: given an adjacency matrix, the starting node, and the number of nodes in the graph,
    // will calculate the shortest path distance between the specified starting node and every other node.
    public static void bellmanFordAlgorithm(int [][] matrix, int startingNode, int numNodes)
    {
        // declare and initialize necessary fields
        int [] distanceArray = new int [numNodes];
        Arrays.fill(distanceArray, INFINITY);
        distanceArray[startingNode] = 0;

        // bellmanFord should complete the algorithm for a valid graph in numNodes - 1 iterations
        for (int i = 0; i < numNodes - 1; i++)
        {
            for (int u = 0; u < numNodes; u++)
            {
                for (int v = 0; v < numNodes; v++)
                {
                    // if edge exists. the starting node current distance is not unknown, 
                    // and the newly calculated distance is less than the previous distance
                    if (matrix[u][v] != 0 && distanceArray[u] != INFINITY
                        && distanceArray[u] + matrix[u][v] < distanceArray[v])
                        {
                            distanceArray[v] = distanceArray[u] + matrix[u][v];
                        }
                }
            }
        }

        // checking for negative cycles
        // if the algorithm finds short distances for any of the nodes at this point
        // there must be a negative cycle
        for (int u = 0; u < numNodes; u++) 
        {
            for (int v = 0; v < numNodes; v++) 
            {
                if (matrix[u][v] != 0 && distanceArray[u] != INFINITY
                    && distanceArray[u] + matrix[u][v] < distanceArray[v]) 
                    {
                        System.out.println("Negative cycle has been detected. Bellman-Ford is invalid.");
                        return;
                    }
            }
        }

        // after algorithm is concluded, print results
        printDistances(distanceArray, startingNode);
    }

    // printDistances: helper method to print final distances given distance array
    private static void printDistances(int [] distanceArray, int startingNode) 
    {
        System.out.println("Shortest path between node " + (startingNode+1) + " and every other node using Bellman-Ford:");

        for (int i = 0; i < distanceArray.length; i++) 
        {
            System.out.println("Node " + (i+1) + "\t Distance: " + distanceArray[i]);
        }
    }

    public static void main(String [] args)
    {
        int numNodes = Integer.parseInt(args[0]); // command line 1
        int startingNode = Integer.parseInt(args[1]); // command line 2
        String edges = args[2]; // command line 3

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
        bellmanFordAlgorithm(adjacencyMatrix, startingNode - 1, numNodes);
    }
}