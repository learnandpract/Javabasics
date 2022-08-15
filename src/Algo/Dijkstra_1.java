package Algo;

import java.util.*;
//https://www.techiedelight.com/single-source-shortest-paths-dijkstras-algorithm/
//http://www.cse.unt.edu/~tarau/teaching/AnAlgo/Dijkstra's%20algorithm.pdf
//A class to store a graph edge
class Edge1
{
 int source, dest, weight;

 public Edge1(int source, int dest, int weight)
 {
     this.source = source;
     this.dest = dest;
     this.weight = weight;
 }
}

//A class to store a heap node
class Node
{
 int vertex, weight;

 public Node(int vertex, int weight)
 {
     this.vertex = vertex;
     this.weight = weight;
 }
}

//A class to represent a graph object
class Graph
{
 // A list of lists to represent an adjacency list
 List<List<Edge1>> adjList = null;

 // Constructor
 Graph(List<Edge1> edges, int n)
 {
     adjList = new ArrayList<>();

     for (int i = 0; i < n; i++) {
         adjList.add(new ArrayList<>());
     }

     // add edges to the directed graph
     for (Edge1 edge: edges) {
         adjList.get(edge.source).add(edge);
     }
 }
}

class Dijsktra_1
{
	 public void getRoute(int[] prev, int i, List<Integer> route)
	 {
	     if (i >= 0)
	     {
	         getRoute(prev, prev[i], route);
	         route.add(i);
	     }
	 }

	 // Run Dijkstra’s algorithm on a given graph
	 public void findShortestPaths(Graph graph, int source, int n)
	 {
	  
	     // set initial distance from the source to `v` as infinity
	     List<Integer> dist;
	     dist = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));

	     // distance from the source to itself is zero
	     dist.set(source, 0); //[0, 2147483647, 2147483647, 2147483647, 2147483647]

	     // boolean array to track vertices for which minimum
	     // cost is already found
	     boolean[] done = new boolean[n];
	     done[source] = true;

	     // stores predecessor of a vertex (to a print path)
	     int[] prev = new int[n];
	     prev[source] = -1;
	     
	     // create a min-heap and push source node having distance 0
	     PriorityQueue<Node> minHeap;
	     minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
	     minHeap.add(new Node(source, 0));

	     // run till min-heap is empty
	     while (!minHeap.isEmpty())
	     {
	         // Remove and return the best vertex
	         Node node = minHeap.poll();

	         // get the vertex number
	         int u = node.vertex;

	         // do for each neighbor `v` of `u`
	         for (Edge1 edge: graph.adjList.get(u))
	         {
	             int v = edge.dest;
	             int weight = edge.weight;

	             // Relaxation step
	             if (!done[v] && (dist.get(u) + weight) < dist.get(v))
	             {
	                 dist.set(v, dist.get(u) + weight);
	                 prev[v] = u;
	                 minHeap.add(new Node(v, dist.get(v)));
	             }
	         }

	         // mark vertex `u` as done so it will not get picked up again
	         done[u] = true;
	     }

	     List<Integer> route = new ArrayList<>();

	     for (int i = 0; i < n; i++)
	     {
	         if (i != source && dist.get(i) != Integer.MAX_VALUE)
	         {
	             getRoute(prev, i, route);
	             System.out.printf("Path (%d —> %d): Minimum cost = %d, Route = %s\n",
	                             source, i, dist.get(i), route);
	             route.clear();
	         }
	     }
	 }

 public static void main(String[] args)
 {
     // initialize edges as per the above diagram
     // (u, v, w) represent edge from vertex `u` to vertex `v` having weight `w`
     List<Edge1> edges = Arrays.asList(
             new Edge1(0, 1, 10), new Edge1(0, 4, 3), new Edge1(1, 2, 2),
             new Edge1(1, 4, 4), new Edge1(2, 3, 9), new Edge1(3, 2, 7),
             new Edge1(4, 1, 1), new Edge1(4, 2, 8), new Edge1(4, 3, 2)
     );

     // total number of nodes in the graph (labelled from 0 to 4)
     int n = 5;

     // construct graph
     Graph graph = new Graph(edges, n);
     Dijsktra_1 dj = new Dijsktra_1();
     

     // run the Dijkstra’s algorithm from every node
     for (int source = 0; source < n; source++) {
         dj.findShortestPaths(graph, source, n);
     }
 }
}

