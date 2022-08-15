package Algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PrioirtyQ {
//	https://leetcode.com/problems/top-k-frequent-words/discuss/431008/Summary-of-all-the-methods-you-can-imagine-of-this-problem
	//https://leetcode.com/problems/top-k-frequent-words/
//	https://leetcode.com/problems/top-k-frequent-elements/solution/
//	Building hashmap - O(N)
//	Building heap- O(k)- to addd first k elements in avg case
//	O(log1 +log2+logk)=O(logk!)=O(klogk) - worst
	//After the first k elements we start to push and pop at each step, N - k steps in total. TC of heap push pop is O(logk)
//	and we do it N - k times that means O(N-k.logk ) 
//	Adding both parts up, we get O(Nlogk) time complexity for the second step.
	//heap into an output array. - O(klog k)
	
	
	  public int furthestBuilding(int[] heights, int bricks, int ladders) {
		  
	        int totalBricksUsed = 0;
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
//	        priority_queue<int> bricksUsed;
	        int i = 0;
	        for (; i < heights.length-1; i++) {
	            
	            if (heights[i] < heights[i+1]) {
	      
	            int diff = heights[i+1] - heights[i];
	        
	            if (totalBricksUsed + diff <= bricks) {	                
	                totalBricksUsed += diff;
	                pq.add(diff);
	            } else if (ladders > 0) {
	                if (!pq.isEmpty() && pq.peek() > diff) { 
	                    totalBricksUsed = totalBricksUsed - pq.peek() + diff;
	                    pq.poll();
	                    pq.add(diff); 
	                }
	                ladders--;
	            } else {
	                break;
	            }
	        }
	    }
	        return i;
	    }
	
	 public List<String> topKFrequent(String[] words, int k) {
		 List<String> lst = new ArrayList();
//		 Input: words = ["i","love","leetcode","i","love","coding"], k = 2
//				 Output: ["i","love"]
		 
		 Map<String,Integer> mp = new HashMap();
		 
		 for(String wd : words) {
			mp.put(wd, mp.getOrDefault(wd,0)+1);
		 }
		 
//		 PriorityQueue<Integer> heap = new PriorityQueue<>(
//		            (n1, n2) -> count.get(n1) - count.get(n2));
//		   PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
//	            @Override
//	            public int compare(String s1, String s2) {
//	                if (map.get(s1) == map.get(s2)) {
//	                    return s1.compareTo(s2);
//	                }
//	                return map.get(s2) - map.get(s1);
//	            }
//	        });
		 PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
				 (a,b)->a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()): a.getValue()-b.getValue());
		 
		 for(Map.Entry<String, Integer> entry: mp.entrySet()) {
			 pq.offer(entry); // pq.add
			 if(pq.size()>k) {
				 pq.poll();				 
			 }			 
		 }
		 while(!pq.isEmpty()) {
			 lst.add(pq.poll().getKey());
		 }
		 
		 return lst;
		 
	 }

	public static void main(String[] args) {
		PrioirtyQ pqc = new PrioirtyQ();
		System.out.println(pqc.topKFrequent(new String[] {"i","love","leetcode","i","love","coding"}, 2));
		

	}

}
