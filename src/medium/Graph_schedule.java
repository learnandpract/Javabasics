package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph_schedule {
	
	public boolean canFinish(int numCourses, int[][] prerequisites){
	    int[] incomingEdges = new int[numCourses];
	    List<Integer>[] adj = new List[numCourses];
	    for(int i=0;i<adj.length;i++){
	    	adj[i] = new LinkedList<Integer>();
	    }
	    for(int[] pair: prerequisites){
	        incomingEdges[pair[0]]++;
	        adj[pair[1]].add(pair[0]);
	    }
	    //adj = [[1, 2], [3], [3], []] // adjacency list , incomingEdges= [0, 1, 1, 2]
	    //ADJ = [[1, 2], [2], [0, 3], [3]] FOR THE SECOND ONE
	    Queue<Integer> queue = new LinkedList<Integer>();
	    for(int i=0;i<incomingEdges.length;i++){
	        if(incomingEdges[i]==0){
	            queue.add(i); // 0 is the only node which does not have incoming edges
	        }
	    }
	    int edgeCnt = prerequisites.length;//4
	    while(!queue.isEmpty()){
	        int cur = queue.poll();
	        for(int i =0; i<adj[cur].size(); i++) {//[[1, 2], [2], [3], [3]]
	        	
	        	edgeCnt--; //3 // remove edge from graph
	        	incomingEdges[adj[cur].get(i)]--;//adj[0].get(0) ==1, 1-- =0 , [[0, 0, 1, 2]]//adj[0].get(1):[0, 0, 0, 2]//[0, 0, 0, 1]//[0, 0, 0, 0]
	        	
	        	if(incomingEdges[adj[cur].get(i)]==0) {//if no incoming edges , insert into queue
	        		queue.add(adj[cur].get(i)); //1 //1, 2//[3]
	        	}
	        }
//	        for(int goCrs: adj[cur]){
//	             edgeCnt--;
//	             if(--incomingEdges[goCrs]==0) //if no incoming edges
//	                queue.add(goCrs);
//	        }
	    }
	    return edgeCnt==0;// if there are edges which are remaining, it means that topological sorting isn't possible since the graph has a cycle. Only Directed Acyclic Graph (DAG) is guaranteed to have a topological sort.
	}
	
	public static void main(String[] args) {
		 Graph_schedule gs = new Graph_schedule();
//		 [[1,0],[2,0],[3,1],[3,2]]
		 System.out.println(gs.canFinish(4,new int[][] {{1,0},{2,0},{3,1},{3,2}}));
//		System.out.println(gs.canFinish(4,new int[][] {{1,0},{2,0},{2,1},{3,2},{3,3}}));

		
	}
	
	

}
