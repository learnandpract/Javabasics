package medium;

import java.util.Arrays;

public class Part_subsets {
	
	 public boolean canPartitionKSubsets_trial(int[] nums, int k) {//698  
//		 Input: nums = [4,3,2,3,5,2,1], k = 4
//		 Output: true
//		 Map<Integer, Integer> res = new HashMap();
		 int count = 0;	
		 
		 for(int i = 0;i<nums.length ;i++) {
			 for(int j = i; j< nums.length;j++) {
				 int sum = nums[i]+nums[j]; //4+3, 4+2,4+3...
//				 res.getOrDefault(sum,0);
//				   res.put(sum,);	
				 }			 
		 }
		 return false;
	 }
		 
		 public boolean canPartitionKSubsets(int[] A, int k) { // from lc - 698 
		        if (k > A.length) return false;
		        int sum = 0;
		        for (int num : A) sum += num;
		        if (sum % k != 0) return false;
		        boolean[] visited = new boolean[A.length];
		        Arrays.sort(A);
		        return dfs(A, 0, A.length - 1, visited, sum / k, k);
		    }

		    public boolean dfs(int[] A, int sum, int st, boolean[] visited, int target, int round) {
		        if (round == 0) return true;
		        if (sum == target && dfs(A, 0, A.length - 1, visited, target, round - 1))
		            return true;
		        for (int i = st; i >= 0; --i) {
		            if (!visited[i] && sum + A[i] <= target) {
		                visited[i] = true;
		                if (dfs(A, sum + A[i], i - 1, visited, target, round))
		                    return true;
		                visited[i] = false;
		            }
		        }
		        return false;
		    }

	public static void main(String[] args) {
		Part_subsets ps = new Part_subsets();
		System.out.println(ps.canPartitionKSubsets(new int[] {4,3,2,3,5,2,1},4));

	}

}
