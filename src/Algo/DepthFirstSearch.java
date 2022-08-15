package Algo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
public class DepthFirstSearch { // not sure
	
	private final int V;
	private final List<List<Integer>> adj;
	
	public DepthFirstSearch(int V) {
		this.V = V;
		adj = new ArrayList(V);
		 for(int i = 0; i<V;i++) {
			 adj.add(new LinkedList<>());
		 }	
		
	}
	private void addEdge(int source, int dest) {
		adj.get(source).add(dest); //[[1, 2], [2], [0, 3], [3]]
	}
	
	public void DFS(int i, boolean[] visited) {
//						
//		Stack<Integer> s = new Stack<>(); // LIFO
//		s.push(i);
//		
//		while(!s.isEmpty()) {
//			i = s.pop();
//			  if (!visited[i]) {
//				  visited[i] = true;
//					System.out.println(i);	
//	            }
//			List<Integer> children = adj.get(i);			
//			for(int j : children) {
//				if(!visited[j]) {					
//					s.push(j);
//				}					
//			}			
//		}
//		
		 visited[i] = true;
	        System.out.print(i + " ");
	 
	        // Recur for all the vertices adjacent to this
	        // vertex
	        List<Integer> children = adj.get(i);	
	        for(int j : children) {
				if(!visited[j]) {
					  DFS(j, visited);
				}
				}	
	}
	
	public static void main(String[] args) {
		DepthFirstSearch g = new DepthFirstSearch(5);
		 
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);
		
		 g.addEdge(1, 0); //0 3 2 1 4
	        g.addEdge(0, 2);
	        g.addEdge(2, 1);
	        g.addEdge(0, 3);
	        g.addEdge(1, 4);
		 
        
        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");
        boolean[] visited = new boolean[5];
        for (int i = 0; i < 5; ++i)
            if (visited[i] == false)
               g.DFS(i, visited);
//        g.DFS(0,visited);

	}

}


