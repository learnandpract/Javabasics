package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dijkstra_Algo {
	 Map<Integer, Integer> dist;
public int networkDelayTime(int[][] times, int N, int K) {// 743 - network delay time medium
//	Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, K = 2
//	output: 2 , check the leetcode picure

	Map<Integer, List<int[]>> graph = new HashMap<Integer, List<int []>>();
	for(int[] edge : times ) {
		if(!graph.containsKey(edge[0]))
		graph.put(edge[0], new ArrayList<int[]>());
	 graph.get(edge[0]).add(new int[]{edge[1], edge[2]}); 
	}//graph:{2:(1,1)(3,1) 3:(4,1)}	
	dist = new HashMap<Integer, Integer>();
	  for (int node = 1; node <= N; ++node)
          dist.put(node, Integer.MAX_VALUE);
	
	  dist.put(K,0); //dist ={1=2147483647, 2=0, 3=2147483647, 4=2147483647}
	  boolean[] seen = new boolean[N+1];
	  
	  while (true) {
          int candNode = -1;
          int candDist = Integer.MAX_VALUE;
          for (int i = 1; i <= N; ++i) {
              if (!seen[i] && dist.get(i) < candDist) { 
                  candDist = dist.get(i); // shortest path
                  candNode = i;
              }
          }

          if (candNode < 0) break; // keeps running until candNode has all seen 
          seen[candNode] = true;
          if (graph.containsKey(candNode))
              for (int[] info: graph.get(candNode))
                  dist.put(info[0], //4:  dist.get(candNode=3)=1 it is 1+1(info[1]=1 ),  with 2 and connected it would have been - {2,4,1} just info[1]=1 : 
                           Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
      }

      int ans = 0;
      for (int cand: dist.values()) { // dist : {1=1, 2=0, 3=1, 4=2}
          if (cand == Integer.MAX_VALUE) return -1;
          ans = Math.max(ans, cand);
      }
      return ans;  

    }


//A Java program for Dijkstra's single source shortest path algorithm.
//The program is for adjacency matrix representation of the graph



	// A utility function to find the vertex with minimum distance value,
	// from the set of vertices not yet included in shortest path tree
	static final int V = 9;
	int minDistance(int dist[], Boolean sptSet[])
	{
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

	// A utility function to print the constructed distance array
	void printSolution(int dist[])
	{
		System.out.println("Vertex \t\t Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}

	// Function that implements Dijkstra's single source shortest path
	// algorithm for a graph represented using adjacency matrix
	// representation
	void dijkstra(int graph[][], int src)
	{
		int dist[] = new int[V]; // The output array. dist[i] will hold
		// the shortest distance from src to i

		// sptSet[i] will true if vertex i is included in shortest
		// path tree or shortest distance from src to i is finalized
		Boolean sptSet[] = new Boolean[V];

		// Initialize all distances as INFINITE and stpSet[] as false
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		// Distance of source vertex from itself is always 0
		dist[src] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < V - 1; count++) {
			// Pick the minimum distance vertex from the set of vertices
			// not yet processed. u is always equal to src in first
			// iteration.
			int u = minDistance(dist, sptSet);

			// Mark the picked vertex as processed
			sptSet[u] = true;

			// Update dist value of the adjacent vertices of the
			// picked vertex.
			for (int v = 0; v < V; v++)

				// Update dist[v] only if is not in sptSet, there is an
				// edge from u to v, and total weight of path from src to
				// v through u is smaller than current value of dist[v]
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

		// print the constructed distance array
		printSolution(dist);
	}

	// Driver method
//	public static void main(String[] args)
//	{
//		/* Let us create the example graph discussed above */
//		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
//									{ 4, 0, 8, 0, 0, 0, 0, 11, 0 },
//									{ 0, 8, 0, 7, 0, 4, 0, 0, 2 },
//									{ 0, 0, 7, 0, 9, 14, 0, 0, 0 },
//									{ 0, 0, 0, 9, 0, 10, 0, 0, 0 },
//									{ 0, 0, 4, 14, 10, 0, 2, 0, 0 },
//									{ 0, 0, 0, 0, 0, 2, 0, 1, 6 },
//									{ 8, 11, 0, 0, 0, 0, 1, 0, 7 },
//									{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
//		ShortestPath t = new ShortestPath();
//		t.dijkstra(graph, 0);
//	}




	public static void main(String[] args) {
		Dijkstra_Algo alg = new Dijkstra_Algo();
		int[][] points = new int[][] {{2,1,1},{2,3,1},{3,4,1},{2,4,1}};
		int res = alg.networkDelayTime(points,4,2);
		System.out.println(res+" : result");
		

	}

}
