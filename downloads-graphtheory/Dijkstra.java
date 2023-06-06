// Joshua Currie
// Dijkstra's Algorithm Program

import java.util.*;

public class Dijkstra
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
        printDistances(distanceArray, startingNode);
    }

    // findShortestNode: helper method that will find the next node with the shortest distance
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

    // printDistances: helper method to print final distances given distance array
    private static void printDistances(int [] distanceArray, int startingNode) 
    {
        System.out.println("Shortest path between node " + (startingNode) + " and every other node using Dijkstra:");

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
        dijkstraAlgorithm(adjacencyMatrix, startingNode, numNodes);
    }
}