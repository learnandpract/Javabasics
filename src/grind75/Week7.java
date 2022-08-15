package grind75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Week7 {
	
	 public List<String> letterCombinations(String digits) {
	        Map<Character, String> mp = new HashMap();
	        mp.put('2', "abc");
	        mp.put('3', "def");
	        
	        List<String> result = new ArrayList();
	        
//	        char[] ch =digits.toCharArray();	        
//	        for(char dig: ch ) {
//	        	for(int i =0; i< mp.get(dig).length;i++) {}	   
//	        }
	        
	        backtrack(result,mp, digits, new StringBuilder(),0);
	        return result;
	    }
	 public void backtrack(List result,  Map<Character, String> mp,String digits, StringBuilder frmedStr,int index ) {
		 
		 if(frmedStr.length()==digits.length()) {
			 result.add(frmedStr.toString());
			 return ;
		 }
		 String comb = mp.get(digits.charAt(index));
		 
		 for(char ch: comb.toCharArray()) {
			 frmedStr.append(ch);
			 backtrack(result,mp, digits,frmedStr,index+1);
			 frmedStr.deleteCharAt(frmedStr.length()-1);
		 }
		 
		 
	 }
	 
	 
	  public boolean exist(char[][] board, String word) {
		  
		  boolean res = false;
		  for(int i = 0;i< board.length;i++) {
			  for(int j =0;j< board[0].length;j++) {
				  res = dfs(  board, word, i,j,0 );
			  }
		  }
		  return res;
	        
	    }
	  public boolean dfs(char[][] board, String word,  int i, int j, int index) {
		  if(index == word.length()) return true;
		  
		  if(i>board.length||j>board[0].length || i<0||j<0 || board[i][j]!=word.charAt(index)) return false;		  
	
		  board[i][j]='#';
		  
		 boolean exists = dfs(board,word, i-1,j,index+1)||
		  dfs(board,word, i,j-1,index+1)||
		  dfs(board,word, i+1,j,index+1)||
		  dfs(board,word, i,j+1,index+1); //condition1 || condition2 || condition3 || condition4
//		 will return true as soon as a condition returned true, and the rest conditions are not even calculated.
		 
		 board[i][j] = word.charAt(index);// remove the visited mark, so that it can be visited again in the future
		 return exists;
	  }
	  
	  public List<Integer> findAnagrams(String s, String p) { //check sliding window
//		  Input: s = "cbaebabacd", p = "abc"
//			  Output: [0,6]
		  List<Integer> result = new ArrayList();
		  
		  int ns = s.length();
		  int np = p.length();
		  
		  Map<Character,Integer> sMap = new HashMap();
		  Map<Character,Integer> pMap = new HashMap();
		  
		  for(char ch: p.toCharArray()) {
			  pMap.put(ch, pMap.getOrDefault(ch, 0)+1);		  
		  }
		 
		  for(int i =0; i< ns;i++) {
			  char ch = s.charAt(i);
			  sMap.put(ch, sMap.getOrDefault(ch,0)+1);
			  if(i>=np) {
				  ch = s.charAt(i-np);
				  if(sMap.get(ch)==1) {
					  sMap.remove(ch);
				  }else {
					  sMap.put(ch, sMap.get(ch)-1);					  
				  }				  
			  }
			  if(pMap.equals(sMap)) {
				  result.add(i-np+1);
			  }			  
		  }
		  return result;	
	    }	  
	  
	  public List canFinish(int n, int[][] edges){
		    int[] incomingEdges = new int[n];
		    List<Integer>[] adj = new List[n];
		    List<Integer> res = new ArrayList<>();
		    
		    for(int i=0;i<adj.length;i++){
		    	adj[i] = new LinkedList<Integer>();
		    }
		    
		    for (int[] edge : edges) {
		        adj[edge[0]].add(edge[1]);
		        adj[edge[1]].add(edge[0]);
		    }
		   
		    Queue<Integer> queue = new LinkedList<Integer>();
		    for(int i=0;i<incomingEdges.length;i++){
		        if(incomingEdges[i]==1){
		            queue.add(i); // 0 is the only node which does not have incoming edges
		        }
		    }
//		    int edgeCnt = prerequisites.length;//4
		    
		    while (n > 2) {
	            int size = queue.size();
	            n -= size;
	            for (int i = 0; i < size; i++) {
	                int cur = queue.poll();
	                for(int j =0; i<adj[cur].size(); i++) {
	                	incomingEdges[j]--;
	                    if (incomingEdges[j] == 1) {
	                    	queue.add(j);
	                    }
	                }
	            }
	        }
		    
		    return new ArrayList(queue);// if there are edges which are remaining, it means that topological sorting isn't possible since the graph has a cycle. Only Directed Acyclic Graph (DAG) is guaranteed to have a topological sort.
		}

	public static void main(String[] args) {
		Week7 wk7 = new Week7();
//		System.out.println(wk7.letterCombinations("23"));
		
//		System.out.println(wk7.findAnagrams("cbaebabacd", "abc"));
		System.out.println(wk7.canFinish(4, new int [][] {{1,0},{1,2},{1,3}}));

	}

}
