
public class MaxSubArray {

	public int sumArray(int[] n) {
		int max = n[0];
		int sum = max;
		for(int i=1; i<n.length; i++) {
			sum += n[i];		// sum= Math.max(sum+n[i],n[i]); next 3 lines can be written as this	
			if(sum < n[i]) {			
				sum =n[i];
			}
			max = Math.max(sum, max);
		}
		
		return max;
		
//	     int runSum = n[0]; //from leetcode discussion
//	     int result = runSum; 
//	     for(int end = 1; end < n.length; end++) {
//	            runSum = runSum+n[end]>=n[end] ?    runSum + n[end] :  n[end];
//	            result = Math.max(runSum, result);
//	    }
//	    return result;

		}
	
	public int maxArray(int[] A) { //lc dynamic programming .. how?
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSubArray mx = new MaxSubArray();
//		int[] n = new int[] {1,2,-1,4,-2};
		int[] n = new int[] {-1,16,-1,-2};
		int max = mx.sumArray(n);
		System.out.print(max);
	}

}
