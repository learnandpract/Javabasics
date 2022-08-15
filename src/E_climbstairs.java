
public class E_climbstairs {
	//https://leetcode.com/problems/decode-ways/discuss/30451/Evolve-from-recursion-to-dp
	
	
	public int climbStairs_RC( int n) { // Recursion
		 int [] arr = new int [n+1];
        
		if (n <= 1) return 1;
		   int res = 0;
	        for (int i = 1; i <= n; i++)
	            res = climbStairs_RC(i-1) + climbStairs_RC(i-2);
	        return res;
    }	
	
	 public  int totalWays(int n) //Memoization
	    {
		  int [] dp = new int [n+1];
	        // base case
	        if (n < 0) {
	            return 0;
	        }	 
	        // base case: there is one way to cover it with no steps
	        if (n == 0) {
	            return 1;
	        }	 
	        // if the subproblem is not seen before
	        if (dp[n] == 0)
	        {
	            // combine results of taking 1 step or 2 steps or 3 steps at a time
	            dp[n] = totalWays(n - 1) + totalWays(n - 2);
	        }	 
	        // return the subproblem solution
	        return dp[n];
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
	E_climbstairs ec = new E_climbstairs();
	System.out.println(ec.climbStairs_DP(13));
	
	System.out.println(ec.climbStairs_RC(13));
	
	System.out.println(ec.totalWays(13));
	
}
}
