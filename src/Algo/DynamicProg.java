package Algo;

import java.util.ArrayList;
import java.util.List;

//I used to solve DP problems after DP problems without really it clicking in my head. I would see a solution and wonder "how the heck did they come with that solution..."
//Here is my practical guide to solving DP problems.
//The order of solving a dp problem should be 
//1) come up with a recurrence relation first
//2) code it up. The first part only needs a pen and paper.
//When coming up with a recurrence relation, separately come up with a general case and base cases.
//**2.1 when coming up with a general case, assign well defined English meaning to your dp term, dp[...][...][...]... e.g. for https://leetcode.com/problems/longest-increasing-subsequence/, dp[i] = the length of the longest increasing subsequence that ENDS on element i.
//**2.2 once you define your meaning, express the answer to the original problem in terms of your dp terms. If you can't do this, then it means your dp definition likely lacks certain necessary information. e.g. for longest increasing subsequence, ans == max(dp[i]) for 0 <= i < n, n == length of an input array (because you don't know where an optimal solution ends)
//**2.3 base cases are usually straightforwardly defined if you follow the top-down approach. i.e. the conditions in which your recursive function ends. If your recursive function is stuck in an infinite loop, you are probably missing a base case (though it is possible your general case is messed up and creates a cycle. see my point 
//3)People usually prefer either the top-down or the bottom-up style. Stick with one or the other and always code in some template. Then, writing code is a matter of translating your recurrence relation. This way, you avoid mistakes.
//4)At its core, DP problems are really graph problems. Here each dp[...][...][...] terms are nodes and edges are drawn based on recurrence relations. For your problem to have a DP solution, this graph MUST BE a DAG. This is usually what textbooks mean "optimal substructure". For me, this connection of DP to its graph representation greatly helped.
//Once you "get" the solid understanding, then solve problems to find and internalize common patterns.
//To me, the practice of 2.1 and understanding of 4 were the tipping point. After that, DP became really easy for me and a weapon to solve many problems, that even have other solutions (usually greedy, which is harder to come up with)
public class DynamicProg {
//	https://leetcode.com/discuss/general-discussion/458695/dynamic-programming-patterns -- aatalyk**
//	https://leetcode.com/discuss/general-discussion/1000929/solved-all-dynamic-programming-dp-problems-in-7-months
//	https://leetcode.com/discuss/general-discussion/662866/DP-for-Beginners-Problems-or-Patterns-or-Sample-Solutions 
	//categorized
//	https://leetcode.com/discuss/interview-question/1380561/template-for-dynamic-programming
	
	//fibonacci
	
	public long fibonacci(int target) {
		
		long[] dp = new long[target+1];
		
		dp[0] =0;
		dp[1]=1;
		dp[2] =1;
		
		for(int i =3;i<= target;i++) {
			dp[i] = dp[i-1] + dp[i-2];
			
		}
		return  dp[target];
	}
	
	//gridTraveler 
	
	public int gridTraveler(int rows, int cols) {
		int[][] dp = new int[rows+1][cols+1];
		dp[1][1] = 1;
		
		for(int i =0;i<=rows;i++) {
			for(int j =0;j<=cols;j++) {
				int current = dp[i][j];
				  if (j + 1 <= cols)
			          dp[i][j + 1] += current;
			        if (i + 1 <= rows)
			          dp[i + 1][j] += current;
			}
			
			
		}
		
		return dp[rows][cols];
	}
	
	public boolean cansum(int target, int[] nums) {
		boolean[] dp = new boolean[target+1];
		dp[0]= true;
		for(int i =0;i<target;i++) {
			if(dp[i]==true) {
				for(int num:nums) {
					if(i+num<=target)
					  dp[i+num] = true;
				}
			}
		}
		
		return dp[target];
	}
	
	public List<List<Integer>> howsum(int[] candidates, int target) { //similar to 39
		List<List<Integer>>[] dp = new List[target + 1];
		
		dp[0].add(new ArrayList<>());
		
		for(int i =0;i<=target;i++) {
			for(int num:candidates) {
				if(i+num< target) {
					dp[i+num].addAll(new ArrayList<>(dp[i]));
				}
			}
			
		}
		 return dp[target];
		
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		//combination sum - 39
	    List<List<Integer>>[] dp = new List[target + 1];
	    for (int i = 0; i <= target; i++)
	        dp[i] = new ArrayList<>();
	    dp[0].add(new ArrayList<>());
	    for (int candidate: candidates) {
	        for (int j = candidate; j <= target; j++) {                
	            for (List<Integer> comb: dp[j - candidate]) {
	                List<Integer> newComb = new ArrayList(comb);
	                newComb.add(candidate);
	                dp[j].add(newComb);
	            }                    
	        }
	    }
	    return dp[target];
	}
	
	
	  public String longestPalindrome(String s) {
//Base case for DP solution is dp[i][i] = true. When substring case like "aba", the i - j <= 2 is to cover the base case where b itself is a Palindrom since i + 1 and j - 1 is the same.

	        if(s == null || s.length() == 0) {
	            return "";
	        }
	        int len = s.length();
	        boolean[][] dp = new boolean[len][len];
	        int start = 0;
	        int end = 0;
	        int max = 0;
	        for(int i = 0; i < s.length(); i++) {
	            for(int j = 0; j <= i; j++) {
	                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
	                    dp[j][i] = true;
	                }
	                if(dp[j][i] && max < i - j + 1) {
	                    max = i - j + 1;
	                    start = j;
	                    end = i;
	                }
	            }
	        }
	        return s.substring(start, end + 1);
	    }
	    public int uniquePaths(int m, int n) {// 62 unique paths
	        int count =0;
	        int[][] dp = new int[m][n];
	        
	        for(int i = 0; i< m;i++) {
	       	 for(int j =0; j< n;j++) {
	       		 if(i==0||j==0) {
	       			 dp[i][j] =1;
	       		 }else {
	       			 dp[i][j] = dp[i-1][j]+dp[i][j-1];//previous dp
	       		 }  		     	
	       	 }    	  	
	        }
	        return dp[m-1][n-1];        
	       }
	    public int climbStairs_DP(int n) {	//Dynamic programming        
	        if(n <=2){
	            return n;
	        }
	        int [] dp = new int [n+1];
	        
	        dp[1] = 1;
	        dp[2] = 2;
	        
	        for(int i = 3; i<=n;i++){
	            dp[i] = dp[i-1] + dp [i-2];
	        }
	        return dp[n];
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicProg prog = new DynamicProg();
		System.out.println(prog.longestPalindrome("ababa"));
		System.out.println(prog.fibonacci(50));
		System.out.println(prog.gridTraveler(3, 3));
		System.out.println(prog.cansum(7,new int[] {5,3,4}));
		System.out.println(prog.howsum(new int[] {5,3,4},7));
		
		

	}

}
