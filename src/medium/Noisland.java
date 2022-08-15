package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Noisland {
	private int n;
	private int m;
	 public int numIslands_trial(char[][] grid) {//200 medium
		 int count =0;
		 m =  grid.length;
		 n = grid[0].length;
		 // get rows and column length
		 
		 for(int i = 0; i< m;i++) {
			 for(int j =0;j<n;j++) { // matrix iteration
				 if(grid[i][j]=='1') {// then check recursively if the next row/column/diagonal is 1
					
					dfs(grid,i,j);
					 ++count;
					 
				 }
				 
			 }
		 }	
	        return count;
	    }
	 public void dfs(char[][] grid, int i , int j) {
		 if(i<0 || j<0 ||i>=m || j>=n|| grid[i][j]!='1') {
			 return;
		}
		 grid[i][j] ='0';
		 dfs(grid,i+1,j);
		 dfs(grid,i-1,j);
		 dfs(grid,i,j+1);		
		 dfs(grid,i,j-1);
	 }
	 
	
	  public List<String> summaryRanges(int[] nums) {
//		  Input: nums = [0,1,2,4,5,7]
//		  Output: ["0->2","4->5","7"]
	        List<String> ls = new ArrayList() ;
	        for(int i =1 ;i<=nums.length;i++) {
	        	int temp = nums[i-1];
	        while( i<nums.length && nums[i]-nums[i-1]==1) {
	        	i++;	        	
	        }
	        ls.add(temp+"->"+nums[i-1]);
	        
	        }
	        	        
	        return ls;
	    }
	
	public static void main(String[] args) {
		Noisland ni = new Noisland();
//		System.out.println(ni.numIslands_trial(new char[][] {
//			{'1','1','1','1','0'},
//			{'1','1','0','1','0'},
//			{'1','1','0','0','0'},
//			{'0','0','0','0','0'}
//		}));
		
		System.out.println(ni.summaryRanges(new int[]{0,1,2,4,5,7}));
	}

}
