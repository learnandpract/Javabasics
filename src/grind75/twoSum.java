package grind75;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class twoSum {
//	Input: nums = [2,7,11,15], target = 9
//			Output: [0,1]
	
	   public List<String> fizzBuzz(int n) {
	        List<String> res = new ArrayList<String>();
	        for(int i =1; i<=n;i++){
	            if(i%15==0){
	                res.add("FizzBuzz");                
	            }else if(i%3==0){
	                res.add("Fizz");    
	            }
	            else if(i%5==0){
	                res.add("Buzz");    
	            }else{
	                res.add(Integer.toString(i));
	            }
	        }
	           return res;
	    }
public int[] twoSummt(int[] nums, int target) {
	int[] res = new int[2];
	Map<Integer,Integer> mp = new HashMap<>();
	for(int i = 0; i<nums.length;i++) {
		if(mp.containsKey(nums[i])) {
		res[0] = i;
		res[1] = mp.get(nums[i]);
		}else {
			mp.put(target-nums[i],i);
		}
	}
	
	return res;
        
    }
public int[] twoSumlc(int[] nums, int target) { //correct LC
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}

public void twoSum_tbd1(int[] nums,int target){//2,7,11,15
	Map<Integer, Integer> mp = new HashMap<>();
    for(int i =0; i< nums.length;i++){
        if(mp.containsKey(nums[i])){
        	System.out.println(mp.get(nums[i])+" :: "+nums[i]);
        }else{
            mp.put(target-nums[i],nums[i]);
        }
    }
}

public boolean isValid(String s) { // Validparentheses
//	Input: s = "()" Output: true
	Stack<Character> st = new Stack<>();
	for(int i =0;i<s.length();i++) {
		if(s.charAt(i)=='(') {
			st.push(')');
		}
		else if(s.charAt(i)=='[') {
			st.push(']');
		}
		else if(s.charAt(i)=='{') {
			st.push('}');
		}
		else if(st.isEmpty() || st.pop() !=s.charAt(i)) { // chk ugw
			return false;
		}else {
		
		}
	}
	
	return st.isEmpty(); // IMP
    
}

//public ListNode mergeLists(ListNode list1, ListNode list2) {//corrct
//	ListNode mainres = new ListNode() ;
//	ListNode res = mainres;
//	while(list1!=null && list2!=null) {
//	if(list1.val<list2.val) {
//		res.next = list1;
//		list1=list1.next;
//	}else {
//		res.next = list2;
//		list2=list2.next;
//	}
//	res = res.next;
//	}    	   	
//	return mainres.next;        
//}

public int maxProfit(int[] prices) {//121. Best Time to Buy and Sell Stock
//	Input: prices = [7,1,5,3,6,4]
//			Output: 5 , day 2 - day 5
	int max = Integer.MIN_VALUE;
	int diff =Integer.MAX_VALUE;
	for(int i =0;i< prices.length;i++) {
		
		if(prices[i]<diff) {
			diff= prices[i];			//diff = Math.min(prices[i],diff);
		}
		max=Math.max(max,prices[i]-diff);
	}
	return max;
    
}

public int maxProfit_tbd(int[] prices) {//121. Best Time to Buy and Sell Stock
//	Input: prices = [7,1,5,3,6,4]
//			Output: 5 , day 2 - day 5
	int maxP = Integer.MIN_VALUE;
	int diff = Integer.MAX_VALUE;
	for(int i =0;i< prices.length;i++) {
		diff = Math.min(prices[i],diff);
		maxP= Math.max(maxP,prices[i]-diff);
		
	}
	
	return maxP;
	
	
}

public boolean isPalindrome(String s) {
	//works for simplecase with no special chars.
//	for(int i=0,j=s.length()-1;i<s.length()/2;i++,j--) {
//		System.out.println(s.charAt(i)+" i char: "+s.charAt(j)+" j char");			
//		if(s.charAt(i) !=s.charAt(j)) {
////			return false;
//		}
//	}	
	int left =0;
	int right = s.length();
	while(left< right) {
		if(!Character.isLetterOrDigit(s.charAt(left))){
			left++;
		}
		if(!Character.isLetterOrDigit(s.charAt(right))){
			right--;
		}else if(Character.toLowerCase(left)!= Character.toLowerCase(right)) {
			return false;
		}
		left++;
		right--;
	}
	
//	return true;
	String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();// replaces "Str 9:" with "str9"
	//but takes extra o(n) space. 
	return true;    
}
// E_BinaryTree-invert tree
//Merge2lists nodes - 
//public TreeNode invertTree_Q(TreeNode root) {//226 - BFS -Que-levelorder 
//	//o/p = [4, 7, 2, 9, 6, 3, 1]
//	Queue<TreeNode> que = new LinkedList<TreeNode>();
//	que.add(root);
//	
//	while(!que.isEmpty()) {
//		TreeNode current = que.remove();
//		TreeNode left = current.left;
//		current.left = current.right;
//		current.right = left;    		
//		if(current.left!=null) {
//			que.add(current.left);    			
//		}
//		if(current.right!= null) {
//			que.add(current.right);
//		}
//	}    	
//	return root;    	
//} 
//public ListNode mergelist(ListNode l1,ListNode l2) {
//	ListNode result = new ListNode();
//	ListNode prev = result;
//	while (l1 != null && l2 != null) {
//		System.out.println(l1.val +": l1val "+ l2.val+": l2val");
//		
//	if(l1.val<=l2.val) {
//      prev.next = l1;
//	  l1 = l1.next;
//	}
//	else {
//	  prev.next = l2;
//	  l2=l2.next;
//	}
//	prev = prev.next;
//	  }
//	
////	while(result != null) {
////	      System.out.println(result.val + " result ");
////	      result = result.next;
////	    }
//	return result.next;
//}
public boolean isAnagram(String s, String t) {
	if(s.length()!= t.length()) {
		return false;
	}
	int[] count = new int[26];
	for(int i = 0;i<s.length();i++) {
		count[s.charAt(i)-'a']++;
		count[t.charAt(i)-'a']--;
		
	}
	for(int j =0;j< count.length;j++) {
		if(count[j]!=0) {
			return false;
		}
	}
	return true;
    
}
public int search(int[] nums, int target) { // Binary search
 int low =0;
 int mid = 0;
 int high= nums.length-1; 
	while(low<high) {
		  mid= low+(high-low)/2; //check ugw
		if(nums[mid]==target) {
			return mid;
		}else if(nums[mid]>target) {
			high=mid-1;				
		}else{
			low=mid+1;
		}
		
	}
	return -1;
}

public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {//733 ,DFS
	
	int original = image[sr][sc];
	fill(image,sr,sc,newColor,image[sr][sc]);
	return image;
}
public void fill(int[][] image, int sr, int sc, int newColor, int oldColor) {
	
	if(sr<0||sc<0||sr >= image.length||sc>=image[0].length||image[sr][sc]!=oldColor) {
		return;
		
	}
		image[sr][sc]=newColor;
	fill(image,sr+1,sc,newColor,oldColor);
	fill(image,sr-1,sc,newColor,oldColor);
	fill(image,sr,sc+1,newColor,oldColor);
	fill(image,sr,sc-1,newColor,oldColor);
}

public int maxSubArray(int[] nums) {    
//	Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//			Output: 6	
	int max = nums[0];
	int sum =max;
	for(int i =0; i< nums.length-1;i++) {
		sum+= nums[i];
		if(sum<nums[i]) // less than zero case
			sum =nums[i];
		else {
			max= Math.max(sum,max);
		}		
	}	
	return max;
}
//max sub array of fixed size k
public int maxSubArrayk(int[] nums,int k) {    
//	Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//			Output: 6	
	int max = Integer.MIN_VALUE;
	int rsum =0;
	for(int i =0; i< nums.length-1;i++) {
		rsum+= nums[i];
		if(i>=k-1) { 					//for (int i=k; i<n; i++)
			max= Math.max(rsum, max);   // curr_sum += arr[i] - arr[i-k];
			rsum -=nums[i-(k-1)];	        
		}		
	}	
	return max;
}

public int firstBadVersion(int n) {
 
	int left =1;
	int right = n-1;
	
	while(left<right) {
		int mid  = left+(right-left)/2;		
		if(isBadVersion(mid)) { // 1 2 3 4 5 6 7 8 9
			right = mid;
			
		}else {
			left = mid+1;
		}
	}
	
	return left;
}
public boolean isBadVersion(int n) {
	if(n==4) return true;
	return false;
}

//public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/1347857/C%2B%2BJavaPython-Iterate-in-BST-Picture-explain-Time%3A-O(H)-Space%3A-O(1)
//	//Binary Search Tree
//    int small = Math.min(p.val, q.val);
//    int large = Math.max(p.val, q.val);
//    while (root != null) {
//        if (root.val > large) // p, q belong to the left subtree
//            root = root.left;
//        else if (root.val < small) // p, q belong to the right subtree
//            root = root.right;
//        else // Now, small <= root.val <= large -> This root is the LCA between p and q
//            return root;
//    }
//    return null;
//}

public int[][] insert(int[][] intervals, int[] newInterval) {//57
//  Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//	Output: [[1,5],[6,9]]
//	Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//			Output: [[1,2],[3,10],[12,16]]
	
    List<int[]> result = new ArrayList<>();
   
    for(int[] i : intervals){
        if(newInterval == null || i[1] < newInterval[0]){
            result.add(i);
        }else if(i[0] > newInterval[1]){
           // be careful abt the sequence here
            result.add(newInterval);
            result.add(i);
            newInterval = null;
        }else{
            
            newInterval[0] = Math.min(newInterval[0], i[0]);//get min
            newInterval[1] = Math.max(newInterval[1], i[1]);//get max
        }
    }
   
   if(newInterval != null)
       result.add(newInterval);
   
   return result.toArray(new int[result.size()][]);
}

public int[][] insert_tbd(int[][] intervals, int[] newInterval) {
	
//	Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//	Output: [[1,2],[3,10],[12,16]]
	// if intervals[i][1]< newInterval[0]- res.add
	// merge interval
	//else if intervals[i][0]>newInterval[1] - res.add
	
	List<int []> res = new ArrayList();
	for(int i = 0; i< intervals.length;i++)
		if(intervals[i][1]<newInterval[0]) {//intervals[i][1]<newInterval[0]
		res.add(intervals[i]);
		}else if(intervals[i][0]>newInterval[1]) {
			res.add(newInterval);// check-missed this
			res.add(intervals[i]);
		     // 
		}else {
			newInterval[0]=Math.min(intervals[i][0], newInterval[0]);
			newInterval[1]=Math.max(intervals[i][1], newInterval[1]);
		}
	return res.toArray(new int[res.size()][]);
}
public int[][] merge(int[][] intervals) {//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
		//Output: [[1,6],[8,10],[15,18]]
	if (intervals.length <= 1)
		return intervals;

	// Sort by ascending starting point
	Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

	List<int[]> result = new ArrayList<>();
	int[] newInterval = intervals[0];//[1,3]
	result.add(newInterval);
	for (int[] interval : intervals) {
		if (interval[0] <= newInterval[1]) //[1,3],[2,6] Overlapping intervals, move the end if needed
			newInterval[1] = Math.max(newInterval[1], interval[1]);
		else {                             // Disjoint intervals, add the new interval to the list
			newInterval = interval;
			result.add(newInterval);
		}
	}

	return result.toArray(new int[result.size()][]);
}



public int[][] updateMatrix(int[][] mat) {    
	
	return mat;
}

public int uniquePaths(int cols, int rows) {
	int[][] dp = new int[rows][cols];

	for(int row=0;row<rows;row++)
		dp[row][0] = 1;

	for(int col=0;col<cols;col++)
		dp[0][col] = 1;

	for(int i=1;i<rows;i++)
		for(int j=1;j<cols;j++)
			dp[i][j] = dp[i-1][j] + dp[i][j-1];

	return dp[rows-1][cols-1];
}
public int[][] kClosest(int[][] points, int k) {
//	Input: points = [[1,3],[-2,2]], k = 1
//			Output: [[-2,2]] mindist =8
	Arrays.sort(points,(a,b)->squareddist(a)-squareddist(b));
	return Arrays.copyOf(points, k);
    
}
public int squareddist(int[] point) {
	
	return point[0]*point[0] +point[1]*point[1];
}

public int[][] kClosest_pq(int[][] points, int K) {
	//we are looking for the k closest points to the original point, 
//	which means we are maintaining the heap with the size of k (to optimize the memory). if a new point is offered in the heap, think about which point we need to take out of the heap? It's the FURTHEST point from the original point. So, by defining it as MAXIMUM HEAP, 
//	we can just simply call poll() to take it out from the heap
//	Instead, we can maintain a max-heap with size K. Then for each point, we add it to the heap. Once the size of the heap is greater than K, we are supposed to extract one from the max heap to ensure the size of the heap is always K. Thus, the max heap is always maintain top K smallest elements from the first one to crruent one. Once the size of the heap is over its maximum capacity, 
//	it will exclude the maximum element in it, since it can not be the proper candidate anymore
	
    PriorityQueue<int[]> mxheap = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
    for (int[] p : points) {
    	mxheap.offer(p);
        if (mxheap.size() > K) {
        	int chk [] = new int[2];        	
        	chk = mxheap.poll();
        	System.out.println(Arrays.toString(chk));
        }
    }
    int[][] res = new int[K][2];
    while (K > 0) {
        res[--K] = mxheap.poll();
    }
    return res;
}

	public static void main(String[] args) {
	twoSum ts = new twoSum();
//	System.out.println(Arrays.toString(ts.twoSumlc(new int[] {2,7,11,15}, 9)));
//	ts.twoSum_tbd1(new int[] {2,7,11,15}, 9);
//	System.out.println(ts.isValid("()[]{"));
//	System.out.println(ts.maxProfit_tbd(new int [] {7,1,5,3,6,4}));
//	System.out.println(ts.isPalindrome("racecar"));
//	
//	System.out.println(ts.isAnagram("anagram", "nagaram"));
//	System.out.println(ts.search(new int[] {-1,0,3,5,9,12},9));
//	System.out.println(Arrays.deepToString(ts.floodFill(new int[][] {{1,1,1},{1,1,0},{1,0,1}},1,1,2)));
//	System.out.println(ts.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4,9}));
//	System.out.println(ts.maxSubArrayk(new int[] {-2,1,-3,4,-1,2,1,-5,4,9},3));
//	System.out.println(Arrays.deepToString(ts.insert_tbd(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[] {4,8})));
	System.out.println(Arrays.deepToString(ts.merge(new int[][] {{1,3},{2,6},{8,10},{15,18}})));
//	System.out.println(ts.uniquePaths(3, 7)+" unique paths");
//	System.out.println(Arrays.deepToString(ts.kClosest_pq(new int[][] {{3,3},{5,-1},{-2,4}},1)));
//	System.out.println(ts.fizzBuzz(3));
	

	}

}
