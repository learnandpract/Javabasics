package medium;

public class Bitwise_OR {
	
//	https://www.geeksforgeeks.org/size-of-the-smallest-subset-with-maximum-bitwise-or/
//	Input: {5, 1, 3, 4, 2}; 	Output : 2
//	7 is the maximum value possible of OR,	5|2 = 7 and 5|3 = 7
	
	private  int maxSubset(int[] arr){
		int maxOR =0;
		for(int i = 0 ; i< arr.length; i++) {
			maxOR|= arr[i];
		}
	   System.out.println(maxOR+" : maxOR ");
		 int maxSubsetSize = maxSubset(arr, 0, 0, 0, maxOR);
		 System.out.println(maxSubsetSize+" : maxSubsetSize ");
//		return maxSubsetSize;
		
		 int max = 0;
		 int dp[] = new int[1 << 17];
		 
		 System.out.println(dp.length+" dp length");
		 
		 dp[0] = 1;
		 
	     for (int a : arr) {
	            for (int i = max; i >= 0; --i)
	                dp[i | a] += dp[i];
	            max |= a;
	        }
	     
	      return dp[max];
	        
//		int mOR=0;
//		int count =0;
//		int n= arr.length;
//		int total = (int) Math.pow(2,n);
//		for(int j = 0 ; j <total; j++) {
//			int cur_or = 0;
//			mOR|= arr[j];
//			 for (int i = 0; i < n; ++i)
//			        if (j &(1<<i))
//			        	cur_or |= arr[i];
//			      if (cur_or > mOR) {
//			    	  mOR = cur_or;
//			        count = 1;
//			      } else if (cur_or == mOR) {
//			        ++count;
//			      }
//			    }
//		System.out.println(count+" : count ");
			
		
	}

	private  int maxSubset(int[] arr, int i,int curOr, int curSize, int maxOr){
		if (i == arr.length)
	    {  
	      if (curOr == maxOr)
	      {
	          return curSize;
	      }
	      else
	      {
	          return arr.length;
	      }
	    }	     
	    // Try the current element in the subset
	    int take = maxSubset(arr, i + 1, curOr | arr[i], curSize + 1, maxOr);
	     
	    // Skip the current element
	    int notTake = maxSubset(arr, i + 1, curOr, curSize, maxOr);
	     
	     
	    // Return minimum of take and notTake
	    return Math.min(take, notTake);
	  }
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bitwise_OR bw = new Bitwise_OR();
		bw.maxSubset(new int[] {5, 1, 3, 4, 2});
	}

}
