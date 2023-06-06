// Joshua Currie
// Dijkstra, Bellman-Ford, and Floyd-Warshall Algorithms

import java.util.*;

public class AllGraphAlgorithms
{
    // initialized distance for undiscovered path between two nodes
    private static final int INFINITY = 1000000;

    // dijkstraAlgorithm: given an adjacency matrix, the starting node, and the number of nodes in the graph,
    // will calculate the shortest path distance between the specified starting node and every other node.
    public static void dijkstraAlgorithm(int [][] matrix, int startingNode, int numNodes)
    {
        // declare and initialize necessary fields
        int [] distanceArray = new int [numNodes];
        boolean [] visitedArray = new boolean [numNodes];

        Arrays.fill(distanceArray, INFINITY);
        distanceArray[startingNode - 1] = 0;

        int shortestNode;

        for (int i = 0; i < numNodes - 1; i++)
        {
            // find the next node with the shortest distance from the current node
            shortestNode = findShortestNode(distanceArray, visitedArray, numNodes);
            visitedArray[shortestNode] = true;

            // having found the shortest node, calculate the path to get to that node
            // and finalize that distance in the distance array
            for (int j = 0 ; j < numNodes; j++)
            {
                int newDistance = distanceArray[shortestNode] + matrix[shortestNode][j];

                if (newDistance < distanceArray[j]) 
                {
                    distanceArray[j] = newDistance;
                }
            }
        }

        // after algorithm is concluded, print results
        printDistances1D(distanceArray, startingNode, 1);
    }

    // findShortestNode: helper method for Dijkstra that will find the next node with the shortest distance
    // relative to the current node
    private static int findShortestNode(int [] distanceArray, boolean [] visitedArray, int numNodes)
    {
        int shortestNode = -1;

        // loop through each node
        for (int i = 0; i < numNodes; i++)
        {
            // if the node is not visited and this is the first node being compared or the current node distance
            // is less than the shortest node distnace, make that the new shorestNode
            if (!visitedArray[i] && (shortestNode == -1 || distanceArray[i] < distanceArray[shortestNode])) 
            {
                shortestNode = i;
            }
        }
            
        return shortestNode;
    }

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
        printDistances1D(distanceArray, startingNode, 2);
    }

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
        printDistances2D(distanceArray);
    }

    // printDistances1D: helper method to print final distances given 1-D distance array and which algorithm was used
    private static void printDistances1D(int [] distanceArray, int startingNode, int algorithmSelection) 
    {
        switch (algorithmSelection)
        {
            // Print Dijkstra
            case 1:
              System.out.println("Shortest path between node " + (startingNode) + " and every other node using Dijkstra:");

              for (int i = 0; i < distanceArray.length; i++) 
              {
                  System.out.println("Node " + (i+1) + "\t Distance: " + distanceArray[i]);
              }  
              break;

            // Print Bellman-Ford
            case 2:
              System.out.println("Shortest path between node " + (startingNode+1) + " and every other node using Bellman-Ford:");

              for (int i = 0; i < distanceArray.length; i++) 
              {
                  System.out.println("Node " + (i+1) + "\t Distance: " + distanceArray[i]);
              }
              break;
        }
    }

    // printDistances2D: helper method to print final distances given 2-D distance array
    private static void printDistances2D(int [][] distanceArray)
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
        int algorithmSelection = Integer.parseInt(args[0]); // command line 1
        int numNodes = Integer.parseInt(args[1]); // command line 2
        int startingNode = Integer.parseInt(args[2]); // command line 3
        String edges = args[3]; // command line 4

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

        switch (algorithmSelection)
        {
            // Perform Dijkstra
            case 1:
                dijkstraAlgorithm(adjacencyMatrix, startingNode, numNodes);
                break;

            // Perform Bellman-Ford
            case 2:
                bellmanFordAlgorithm(adjacencyMatrix, startingNode - 1, numNodes);
                break;

            // Perform Floyd-Warshall
            case 3:
                floydWarshallAlgorithm(adjacencyMatrix, numNodes);
                break;
        }
    }
}