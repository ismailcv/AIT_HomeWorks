package AIT_HomeWork_10_1;

import java.io.*;
import java.lang.*;
import java.util.*;
 
public class KruksalAlgo {
 
    // A class to represent a graph edge
    class Edge implements Comparable<Edge> {
        int src, dest, weight;
 
        // Comparator function used for
        // sorting edgesbased on their weight
        public int compareTo(Edge compareEdge)
        {
            return this.weight - compareEdge.weight;
        }
    };
 
    // A class to represent a subset for
    // union-find
    class subset {
        int parent, rank;
    };
 
    int V, E; // V-> no. of vertices & E->no.of edges
    Edge edge[]; // collection of all edges
 
    // Creates a graph with V vertices and E edges
    KruksalAlgo(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }
 
    // A utility function to find set of an
    // element i (uses path compression technique)
    int find(subset subsets[], int i)
    {
        // find root and make root as parent of i
        // (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent
                = find(subsets, subsets[i].parent);
 
        return subsets[i].parent;
    }
 
    // A function that does union of two sets
    // of x and y (uses union by rank)
    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
 
        // Attach smaller rank tree under root
        // of high rank tree (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
 
        // If ranks are same, then make one as
        // root and increment its rank by one
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
 
    // The main function to construct MST using Kruskal's
    // algorithm
    void KruskalMST()
    {
        // This will store the resultant MST
        Edge result[] = new Edge[V];
 
        // An index variable, used for result[]
        int e = 0;
 
        // An index variable, used for sorted edges
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge();
 
        // Step 1:  Sort all the edges in non-decreasing
        // order of their weight.  If we are not allowed to
        // change the given graph, we can create a copy of
        // array of edges
        Arrays.sort(edge);
 
        // Allocate memory for creating V subsets
        subset subsets[] = new subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new subset();
 
        // Create V subsets with single elements
        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
 
        i = 0; // Index used to pick next edge
 
        // Number of edges to be taken is equal to V-1
        while (e < V - 1) {
            // Step 2: Pick the smallest edge. And increment
            // the index for next iteration
            Edge next_edge = edge[i++];
 
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
 
            // If including this edge doesn't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }
 
        // print the contents of result[] to display
        // the built MST
        System.out.println("Following are the edges in "
                           + "the constructed MST");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -- "
                               + result[i].dest
                               + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree "
                           + minimumCost);
    }
 
    // Driver's Code
    public static void main(String[] args)
    {
        /*
        { 0, 4, 0, 0, 0, 0, 0, 8, 0},
        { 4, 0, 12, 0, 0, 0, 0, 11, 0},
        { 0, 12, 0, 7, 0, 4, 3, 0, 2},
        { 0, 0, 7, 0, 10, 14, 0, 0, 0},
        { 0, 0, 0, 10, 0, 9, 0, 0, 0},
        { 0, 0, 4, 14, 9, 0, 2, 0, 0},
        { 0, 0, 3, 0, 0, 2, 0, 1, 6},
        { 8, 11, 0, 0, 0, 0, 1, 0, 5},
        { 0, 0, 2, 0, 0, 0, 6, 5, 0}
        */
        
        int V = 9; // Number of vertices in graph
        int E = 15; // Number of edges in graph
        KruksalAlgo graph = new KruksalAlgo(V, E);
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 4;
 
        // add edge 0-7
        graph.edge[1].src = 0;
        graph.edge[1].dest = 7;
        graph.edge[1].weight = 8;
 
        // add edge 1-2
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 12;
 
        // add edge 1-7
        graph.edge[3].src = 1;
        graph.edge[3].dest = 7;
        graph.edge[3].weight = 11;
 
        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 7;
        
        // add edge 2-5
        graph.edge[5].src = 2;
        graph.edge[5].dest = 5;
        graph.edge[5].weight = 4;
        
        // add edge 2-6
        graph.edge[6].src = 2;
        graph.edge[6].dest = 6;
        graph.edge[6].weight = 3;
        
        // add edge 2-8
        graph.edge[7].src = 2;
        graph.edge[7].dest = 8;
        graph.edge[7].weight = 2;
        
        // add edge 3-4
        graph.edge[8].src = 3;
        graph.edge[8].dest = 4;
        graph.edge[8].weight = 10;
        
        // add edge 3-5
        graph.edge[9].src = 3;
        graph.edge[9].dest = 5;
        graph.edge[9].weight = 14;
        
        // add edge 4-5
        graph.edge[10].src = 4;
        graph.edge[10].dest = 5;
        graph.edge[10].weight = 9;
        
        // add edge 5-6
        graph.edge[11].src = 5;
        graph.edge[11].dest = 6;
        graph.edge[11].weight = 2;
        
        // add edge 6-7
        graph.edge[12].src = 6;
        graph.edge[12].dest = 7;
        graph.edge[12].weight = 1;
        
        // add edge 6-8
        graph.edge[13].src = 6;
        graph.edge[13].dest = 8;
        graph.edge[13].weight = 6;
        
        // add edge 7-8
        graph.edge[14].src = 7;
        graph.edge[14].dest = 8;
        graph.edge[14].weight = 5;
        
        // Function call
        graph.KruskalMST();
    }
}