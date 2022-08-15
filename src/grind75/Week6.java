package grind75;

import java.util.ArrayList;
import java.util.List;

public class Week6 {
    public boolean canPartition(int[] nums) { // partition equal subset sum
        int totalSum =0;
        for(int num:nums){
            totalSum+=num;
        }
        if(totalSum%2!=0) return false;
        int subSetSum = totalSum/2;
        return dfs(nums, nums.length-1, subSetSum);
    }
    
    public boolean dfs(int[] nums, int n, int subSetSum ){        
        if(subSetSum==0){
            return true;
        }        
     return dfs(nums,n-1,subSetSum-nums[n-1]) || dfs(nums,n-1,subSetSum);        
    }
    public boolean canPartition_memo(int[] nums) { //memo- top down
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;
        Boolean[][] memo = new Boolean[n + 1][subSetSum + 1];//in subset function if (mem[pos][sum]==true) then returns true but if its false then it will keep on computing but the problem was that boolean array automatically initialises array with false..so i cant differentiate... so for that we need to take object boolean array so that it initialises with null or assign null value manually to boolean array.
        return dfs(nums, n - 1, subSetSum, memo);
    }

    public boolean dfs(int[] nums, int n, int subSetSum, Boolean[][] memo) {
        // Base Cases
        if (subSetSum == 0)
            return true;
        if (n == 0 || subSetSum < 0)
            return false;
        // check if subSetSum for given n is already computed and stored in memo
        if (memo[n][subSetSum]!=null)//memo[3][11]
            return memo[n][subSetSum];
        boolean result = dfs(nums, n - 1, subSetSum - nums[n - 1], memo) ||
                dfs(nums, n - 1, subSetSum, memo);
        // store the result in memo
        memo[n][subSetSum] = result;
        return result;
    }

    public boolean canPartition_dp(int[] nums) {
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;
        boolean dp[][] = new boolean[n + 1][subSetSum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            int curr = nums[i - 1];
            for (int j = 0; j <= subSetSum; j++) {
                if (j < curr)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || (dp[i - 1][j - curr]);//dp[i][j]=true if the sum j can be formed by array elements in subset {nums[0]} {nums[i]}nums[0]..nums[i],otherwise \text{dp}[i][j] = \text{false}dp[i][j]=false
            }
        }
        return dp[n][subSetSum];//[true, true, false, false, false, true, true, false, false, false, true, true]
    }
    public boolean canPartition_optimized(int[] nums) {
        int sum = 0;
        int n = nums.length;        
        for(int i : nums) sum+=i;        
        if(sum%2!=0) return false;        
        sum /= 2;
        
        boolean[] dp = new boolean[sum+1];       
        dp[0] = true;
        for (int j : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= j) {
                    dp[i] = dp[i] || dp[i-j];
                }
            }
        }
        return dp[sum]; 
    }
    public int myAtoi(String input) { // from soln, clear-
        int sign = 1; 
        int result = 0; 
        int index = 0;
        int n = input.length();
        
        // Discard all spaces from the beginning of the input string.
        while (index < n && input.charAt(index) == ' ') { 
            index++; 
        }
        
        // sign = +1, if it's positive number, otherwise sign = -1. 
        if (index < n && input.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < n && input.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        
        // Traverse next digits of input and stop if it is not a digit
        while (index < n && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';

            // Check overflow and underflow conditions. 
            if ((result > Integer.MAX_VALUE / 10) || 
                (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {     
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.    
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            // Append current digit to the result.
            result = 10 * result + digit;
            index++;
        }
        
        // We have formed a valid number without any overflow/underflow.
        // Return it after multiplying it with its sign.
        return sign * result;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> res = new ArrayList();
    	backtrack(res, new ArrayList<Integer>(), nums,0);
    	return res;
    }

    public void backtrack(List<List<Integer>> res, ArrayList tempList, int[] nums, int start) {   	
    	
    	res.add(new ArrayList<Integer>(tempList));
    	
    		for(int i = start;i<nums.length;i++ ) {
    			tempList.add(nums[i]);    			
    			backtrack(res,tempList,nums,i+1);    			
    			tempList.remove(tempList.size()-1);  
    	}
    }
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> result = new ArrayList<Integer>();
//        rightView(root, result, 0);
//        return result;
//    }
//    
//    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
//        if(curr == null){
//            return;
//        }
//        System.out.println("currDepth :: "+currDepth+" :: curr val :: "+ curr.val+" ::result.size :: "+result.size());
//        if(currDepth == result.size()){
//            result.add(curr.val);
//        }
//        
//        rightView(curr.right, result, currDepth + 1);
//        rightView(curr.left, result, currDepth + 1); // needed if the right node (ex: 9 missing, then it has print left node -7)
//        
//    }
    public String longestPalindrome(String s) {//https://www.youtube.com/watch?v=LgG2Km9GvJw
//    	https://leetcode.com/problems/longest-palindromic-substring/discuss/2987/Clean-Java-solution-using-DP-yet-the-time-complexity-is-O(N2)
//Base case for DP solution is dp[i][i] = true. When substring case like "aba", the i - j <= 2 is to cover the base case where b itself is a Palindrom since i + 1 and j - 1 is the same.
    	//see dp in DynamicProg and brute in PalindrmStr
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);// for odd
            int len2 = expandAroundCenter(s, i, i + 1);// for even
            int len = Math.max(len1, len2);
            if (len > end - start) { // to get substring, u need to know start and end
                start = i - (len - 1) / 2;
                end = i + len / 2;
                System.out.println(" inside if : "+s.substring(start, end + 1));
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    
    public int uniquePaths(int m, int n) {
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
  
//    public TreeNode buildTree(int[] preorder, int[] inorder) { // binary tree_2
//        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
//        for(int i = 0; i < inorder.length; i++) {
//            inMap.put(inorder[i], i);
//        }
//        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
//        return root;
//    }
//
//    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
//        if(preStart > preEnd || inStart > inEnd) return null;
//        TreeNode root = new TreeNode(preorder[preStart]);
//        int inRoot = inMap.get(root.val);
//        int numsLeft = inRoot - inStart;
//
//        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
//        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
//        return root;
//    }
    public int maxArea(int[] height) { //11 container
        int left =0;
         int right= height.length-1;
         int maxArea=0;
    while(left<right){
        int width = right -left;
        maxArea= Math.max(maxArea,Math.min(height[right],height[left])*width);
        if(height[left]<=height[right]) {
        	left++;        	
        }else {
        	right--;
        }
    }
         
         return maxArea;
     }
 
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        List<Integer> result = new ArrayList<>();
        // int[] tot= new int[m*n];
        int up =0;
        int left =0;
        int down = m-1;
        int right = n-1;              
        
        while(result.size()<m*n){
            for(int i=left;i<=right;i++){
                result.add(matrix[up][i]);
            }
            for(int i=up+1;i<= down;i++){
                result.add(matrix[i][right]);
            }
            
            if(up!=down){
            for(int i= right-1;i>=left;i--){
                result.add(matrix[down][i]);
            }
            }
            if(left!=right){
             for(int i= down-1;i>=up;i--){
                result.add(matrix[i][left]);
            }
            }
            left++;
            up++;
            down--;
            right--;
            }
        return result;
        }
    
	public static void main(String[] args) {
		Week6 wk6 = new Week6();
//		System.out.println(wk6.canPartition(new int[] {1,5,5,11}));
//		System.out.println(wk6.canPartition_memo(new int[] {1,5,5,11}));
//		System.out.println(wk6.canPartition_optimized(new int[] {3,4,2,1}));
//		System.out.println(wk6.subsets(new int[] {1,2,3}));
//		System.out.println(wk6.uniquePaths(3, 7));
		System.out.println(wk6.longestPalindrome("aabaac"));
//		System.out.println(wk6.maxArea(new int [] {1,8,6,2,5,4,8,3,7}));		

	}

}
