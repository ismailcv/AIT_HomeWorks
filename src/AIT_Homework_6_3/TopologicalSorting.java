//Topolojik sıralama ile grafların muhtemel sıralamalarını
//ekrana yazdıran program.

package AIT_Homework_6_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSorting {

    public static void main(String args[]){
	int choice = 0;
        Scanner scanner = new Scanner(System.in);
                
        System.out.println("A matrisi için 1'i: \n"
                + "B matrisi için 2'yi seçiniz.");
        
        choice = scanner.nextInt();
    
        if(choice == 1){
            Graph graf = new Graph(5);
	    graf.addEdge(0,2);
	    graf.addEdge(2,4);
	    graf.addEdge(1,2);
	    graf.addEdge(2,3);
	    graf.addEdge(3,4);
            graf.topologicalSort();
        }else if(choice == 2){
            Graph graf = new Graph(7);
            graf.addEdge(0,1);
	    graf.addEdge(0,2);
	    graf.addEdge(1,4);
	    graf.addEdge(1,6);
	    graf.addEdge(2,5);
            graf.addEdge(2,5);
            graf.addEdge(3,0);
            graf.addEdge(3,1);
            graf.addEdge(3,2);
            graf.addEdge(3,5);
            graf.addEdge(3,6);
            graf.addEdge(6,4);
            graf.addEdge(6,5);
            graf.topologicalSort();
        } 
    }
}

class Graph {
	
	private int V;

	private ArrayList<ArrayList<Integer> > adj;

	Graph(int v)
	{
		V = v;
		adj = new ArrayList<ArrayList<Integer> >(v);
		for (int i = 0; i < v; ++i)
			adj.add(new ArrayList<Integer>());
	}

	void addEdge(int v, int w) { adj.get(v).add(w); }

	void topologicalSortUtil(int v, boolean visited[],
							Stack<Integer> stack)
	{
		visited[v] = true;
		Integer i;


		Iterator<Integer> it = adj.get(v).iterator();
		while (it.hasNext()) {
			i = it.next();
			if (!visited[i])
				topologicalSortUtil(i, visited, stack);
		}

		stack.push(new Integer(v));
	}

	void topologicalSort()
	{
		Stack<Integer> stack = new Stack<Integer>();

		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				topologicalSortUtil(i, visited, stack);
		while (stack.empty() == false)
			System.out.print(stack.pop() + " ");
	}
}