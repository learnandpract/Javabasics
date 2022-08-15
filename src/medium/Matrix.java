package medium;

import java.util.Arrays;

//dynamic programming

public class Matrix {

	  public int minimizeTheDifference(int[][] mat, int target) {//1981	, from lc	  
		  Integer[][] dp = new Integer[mat.length][5001];
	        return minDiff(mat, 0, target,0, dp);
	        
	    }
	  
	  public int minDiff(int[][] mat,int index,int target, int val, Integer[][] dp){
	        if(index == mat.length){
	            return Math.abs(val - target);
	        }
	        if(dp[index][val] != null){
	            return dp[index][val];
	        }
	        
	        int res = Integer.MAX_VALUE;
	        for(int i = 0; i < mat[0].length; i++){
	        	System.out.println("i: "+i);
	            res = Math.min(res, minDiff(mat, index + 1, target, val + mat[index][i], dp));
	        }
	        
	        return dp[index][val] = res;
	    }
	  
	    public int findTargetSumWays(int[] nums, int target) {
	       int index = nums.length-1;
	       int curr_sum = 0;
	    	return dp_tg(nums,target,index,curr_sum);   	
	    }
	    public int dp_tg(int[]nums,int target,int index,int curr_sum) {
	    	if(index<0 && curr_sum == target) {
	    		return 1;
	    	}
	    	if(index<0) {
	    		return 0;
	    	}
	    	int positive = dp_tg(nums,target,index-1,curr_sum+nums[index]);
	    	int negative = dp_tg(nums,target,index-1,curr_sum-nums[index]);
	    	
	    	return positive+negative;
	    	
	    }
	    
	    public int[][] dto2d(int[] original, int m, int n){//2022 - easy
//	    	int[][] mat = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
	    	int[][] d2 = new int[m][n];
	    	for(int i = 0 ; i<m;i++) {
	    		d2[i][n-1] = original[i];
	    		
	    		
	    	}
	    	for(int j=0;j<n;j++) {
    			d2[m-1][j]= original[m-1+j];
    		}
	    	
	    	return d2;
	    	
	    	
	    }
	  
	  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matrix mt = new Matrix();
//		int[][] mat = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
//		System.out.println(mt.minimizeTheDifference(mat, 13));
		
		int[] nums = new int[] {1,1,1,1,1};
		int target = 3;
		System.out.println(mt.findTargetSumWays(nums, target)+" :target ways");
		
		int[] orig = new int[] {1,2,3,4};
		
		System.out.println(Arrays.deepToString(mt.dto2d(orig,2,2)));

	}

}
