package medium;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayIntervals {// 57
	//Trick is to collect before and after interval overlap and do the merge.
	  public int[][] insert(int[][] intervals, int[] newInterval) {
//		  Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//		  Output: [[1,5],[6,9]]		  
//		  Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//				  Output: [[1,2],[3,10],[12,16]]
		  ArrayList<int[]> as = new ArrayList();
		
		  int i = 0;
		  while(i< intervals.length && intervals[i][1]<newInterval[0]) {
			  as.add(intervals[i++]); //(1,2)
			  
		  }
		  while(i<intervals.length && intervals[i][0]<=newInterval[1] ) {
			  newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
			  newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
			  i++;			  
		  }
		  as.add(newInterval);
		  
		  while(i<intervals.length) {
			  as.add(intervals[i++]); 
		  }
		  
		  return as.toArray(new int[as.size()][]);
		  
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		ArrayIntervals ai = new ArrayIntervals();
		System.out.println(Arrays.deepToString(ai.insert(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}},new int[] {4,8})));
		
		

	}

}
