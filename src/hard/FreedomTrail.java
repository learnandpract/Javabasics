package hard;

public class FreedomTrail {//
	

	public int findRotateSteps_wrong(String ring, String key) { //ring = "godding", key = "gd"
        int steps = 0;
        int kc = 0;
        int rc = ring.length();
        
        for(int i =0; i< key.length();i++) {
        	for(int j=0;j<ring.length();j++) {
        		if(key.charAt(i) == ring.charAt(i)) {
        			steps+=Math.min(j,rc-j );
        			
        		}
        		
        	}
        }
        
        
		return steps+key.length();
    }
	 public int findRotateSteps(String ring, String key) {
	        int n = ring.length();
	        int m = key.length();
	        int[][] dp = new int[m + 1][n];
	        
	        for (int i = m - 1; i >= 0; i--) {
	            for (int j = 0; j < n; j++) {
	                dp[i][j] = Integer.MAX_VALUE;
	                for (int k = 0; k < n; k++) {
	                    if (ring.charAt(k) == key.charAt(i)) {
	                        int diff = Math.abs(j - k);
	                        int step = Math.min(diff, n - diff);
	                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
	                    }
	                }
	            }
	        }
	        
	        return dp[0][0] + m;
	    }

	public static void main(String[] args) {
		FreedomTrail ft = new FreedomTrail();
		System.out.println(ft.findRotateSteps("godding", "gd"));

	}

}
