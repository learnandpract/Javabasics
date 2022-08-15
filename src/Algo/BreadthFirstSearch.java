package Algo;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
	
	private final int V ;
	
	private final List<List<Integer>> adj ;
	
	public BreadthFirstSearch(int V) {
		this.V = V;
		adj = new ArrayList<>(V);	
		for(int i =0 ; i< V; i++) {
			adj.add(new LinkedList<>());
		}		
	}
	private void addEdge(int source, int dest) {
		adj.get(source).add(dest);//[[1, 2], [2], [0, 3], [3]]
//		adj.get(dest).add(source);// no need [[1, 2, 2], [0, 2], [0, 1, 0, 3], [2, 3, 3]]
	}
	
   public void BFS(int i , boolean[] visited) {
	   visited[i]=true;
	
	   Queue<Integer> q = new ArrayDeque<>();	   
	   q.add(i);
	   
	   while(!q.isEmpty()) {
		   i = q.poll();
		   System.out.println(i+" ");
		   
		   List<Integer> children = adj.get(i);
		  
	   for(Integer j : children) {
 		   if(!visited[j]) {
			   visited[j] = true;
			   q.add(j);		   
			   
		   }		   
	   }
	   }
	   
   }
	
	public static void main(String[] args) {
		BreadthFirstSearch g = new BreadthFirstSearch(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        //2  0  3  1 

        
        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        boolean[] visited = new boolean[4];
        g.BFS(2,visited);

	}

}
//class BreadthFirstSearch
//{
//    private int V;   // No. of vertices
//    private LinkedList<Integer> adj[]; //Adjacency Lists
// 
//    // Constructor
//     BreadthFirstSearch(int v)
//    {
//        V = v;
//        adj = new LinkedList[v];
//        for (int i=0; i<v; ++i)
//            adj[i] = new LinkedList();
//    }
// 
//    // Function to add an edge into the graph
//    void addEdge(int v,int w)
//    {
//        adj[v].add(w);//adj = [[1, 2], [2], [0, 3], [3]]
//    }
// 
//    // prints BFS traversal from a given source s
//    void BFS(int s)
//    {
//        // Mark all the vertices as not visited(By default
//        // set as false)
//        boolean visited[] = new boolean[V];
// 
//        // Create a queue for BFS
//        LinkedList<Integer> queue = new LinkedList<Integer>();
// 
//        // Mark the current node as visited and enqueue it
//        visited[s]=true;
//        queue.add(s);
// 
//        while (queue.size() != 0)
//        {
//            // Dequeue a vertex from queue and print it
//            s = queue.poll();
//            System.out.print(s+" ");
// 
//            // Get all adjacent vertices of the dequeued vertex s
//            // If a adjacent has not been visited, then mark it
//            // visited and enqueue it
//            Iterator<Integer> i = adj[s].listIterator();
//            while (i.hasNext())
//            {
//                int n = i.next();
//                if (!visited[n])
//                {
//                    visited[n] = true;
//                    queue.add(n);
//                }
//            }
//        }
//    }
// 
//    // Driver method to
//    public static void main(String args[])
//    {
//    	BreadthFirstSearch g = new BreadthFirstSearch(4);
// 
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);
// 
//        System.out.println("Following is Breadth First Traversal "+
//                           "(starting from vertex 2)");
// 
//        g.BFS(2);
//    }
//}
