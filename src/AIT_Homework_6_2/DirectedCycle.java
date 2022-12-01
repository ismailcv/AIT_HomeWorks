//Burada bir grafın çevrimsel olup olmadığını kontrol edişyoruz

package AIT_Homework_6_2;

import java.util.*;

class Solution {
    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[]) {
        vis[node] = 1; 
        pathVis[node] = 1; 
        
        // traverse for adjacent nodes 
        for(int it : adj.get(node)) {
            // when the node is not visited 
            if(vis[it] == 0) {
                if(dfsCheck(it, adj, vis, pathVis) == true) 
                    return true; 
            }
            // if the node has been previously visited
            // but it has to be visited on the same path 
            else if(pathVis[it] == 1) {
                return true; 
            }
        }
        
        pathVis[node] = 0; 
        return false; 
    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        
        for(int i = 0;i<V;i++) {
            if(vis[i] == 0) {
                if(dfsCheck(i, adj, vis, pathVis) == true) return true; 
            }
        }
        return false; 
    }
}

public class DirectedCycle {
    public static void main(String[] args) {
        int V = 11;
        int choice = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        System.out.println("A matrisi için 1'i: \n"
                + "B matrisi için 2'yi seçiniz.");
        
        choice = scanner.nextInt();
        
        if(choice == 1){
           adj.get(1).add(3);
           adj.get(2).add(3);
           adj.get(3).add(4);
           adj.get(3).add(5);
           adj.get(4).add(5); 
        } else if (choice == 2){
            adj.get(1).add(2);
            adj.get(1).add(3);
            adj.get(2).add(5);
            adj.get(2).add(7);
            adj.get(3).add(6);
            adj.get(4).add(1);
            adj.get(4).add(2);
            adj.get(4).add(3);
            adj.get(4).add(6);
            adj.get(4).add(7);
            adj.get(7).add(5);
            adj.get(7).add(6);
        }  
        
        

        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans){
            System.out.println("Bu graf çevrimli grafdır.");
        }else{
            System.out.println("Bu graf çevrimli graf değildir.");
        }
            

    }
}
