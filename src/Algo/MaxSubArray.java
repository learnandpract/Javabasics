package Algo;

public class MaxSubArray {
	
	public int Kadane(int[] A) {
		int max= Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i = 0; i< A.length;i++) {
			sum= A[i]+sum;
			sum = Math.max(sum, A[i]); // to handle negative numbers
			//if the maximum sum becomes less than the current element,
            // start from the current element
			max =Math.max(max, sum);
		}
		return max;
		
	}
	
	public int maxSubArray(int [] nums) {
		int max =0;
		
		for(int i =0;i< nums.length;i++) {
			int sum =0;
			System.out.print("\n");
			for(int j=i;j< nums.length ;j++) {
				sum+=nums[j];
				System.out.print(" "+nums[j]);
				max= Math.max(sum, max);
			}
			
		}
		
		return max;
		
	}

	public static void main(String[] args) {
		MaxSubArray mxs = new MaxSubArray();
		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.print(mxs.maxSubArray(A));

	}

}
