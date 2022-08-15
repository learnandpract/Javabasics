package grind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class matrix01 {
//	  public List<List<Integer>> levelOrder(TreeNode root) {//BFS queue
//	        
//	        Queue<TreeNode> qtn = new LinkedList();
//	       if (root != null) 
//	        qtn.add(root);
//	        List<List<Integer>> mainres = new ArrayList();        
//	              
//	        while(!qtn.isEmpty()){
//	            int Lsize = qtn.size();
//	            List<Integer> res = new ArrayList();            
//	            for(int i =0;i<Lsize;i++){            
//	            TreeNode current = qtn.remove(); 
//	                res.add(current.val); 
//	                     
//	            if(current.left!=null){
//	                qtn.add(current.left);
//	            }
//	             if(current.right!=null){
//	                qtn.add(current.right);
//	            }   
//	                  
//	        }
//	            mainres.add(res);
//	          
//	        }
//	        return mainres;
//	    }
	 public List<List<Integer>> threeSum(int[] nums) {
	       
		// Input: nums = [-1,0,1,2,-1,-4]
		// Output: [[-1,-1,2],[-1,0,1]]
		        HashMap<Integer,Integer> mp = new HashMap();
		        List<List<Integer>> mainres = new ArrayList();
		        for(int i = 0; i< nums.length;i++){
		            // int partial = nums[i];
		        	//int partial = nums[i];
                  
		            mp = twoSum(nums,-nums[i]);
		           for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
		        	   List<Integer> res = new ArrayList();
		        	   res.add(nums[i]);
		        	   res.add(entry.getKey());
		        	   res.add(entry.getValue());
		        	   mainres.add(res);
		           }
		  
		           break;
		        }
		        return mainres;
		        
		    }
		    
		    public HashMap twoSum(int[] nums,int target){
		         HashMap<Integer,Integer> mp = new HashMap();
		        for(int i =0; i< nums.length;i++){
		            if(mp.containsKey(nums[i])){
		                return mp;
		            }else{
		                mp.put(target-nums[i],nums[i]);
		            }
		        }
		        return null;
		    }
    public List<List<Integer>> threeSum_lc(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;  
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
    public int lengthOfLongestSubstring(String s) {//abcabcbb
//        HashSet<Character> hs = new HashSet();
//        int max,i,j= 0;//      
//       while(j<s.length()){           
//            if(hs.contains(s.charAt(j))){            
//            	 hs.remove(s.charAt(i++));                                
//            }else{
//                hs.add(s.charAt(j++));
//                max = Math.max(max, hs.size());
//            }
//        }
//        return max;    	
    	  if (s.length()==0) return 0;
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        int longest=0;
	        for (int i=0, j=0; i<s.length(); ++i){
	            if (map.containsKey(s.charAt(i))){
	            	System.out.println(map.get(s.charAt(i))+" mp get charat i ");
	            	j = Math.max(j,map.get(s.charAt(i))+1);
	            	// say w is repeating in the end.then get the value of j 
	            	// that is max of j and the previous seen+1
	            	
	            
	            }
	            map.put(s.charAt(i),i);//char and its index
	            longest = Math.max(longest,i-j+1);
//	            if(longest<i-counter+1){
//	            longest = i-counter+1;
//	            }	           
	        }
	        return longest;
	    
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        //"aab" "baa" - true
         int[] chs = new int[26];
         for( int i =0; i<magazine.length();i++){
          chs[magazine.charAt(i)-'a']++;
         }
     for( int i =0; i<ransomNote.length();i++){
       if (--chs[ransomNote.charAt(i) - 'a'] < 0)
 			return false;
         }
       
         
         return true;
     } 
//    public int firstBadVersion(int n) {
//        int start = 1, end = n;
//        while (start < end) {
//            int mid = start + (end-start) / 2;
//            if (!isBadVersion(mid)) start = mid + 1;
//            else end = mid;            
//        }        
//        return start;
//    }
    public Node cloneGraph(Node node) {
    	HashMap<Integer,Node> map = new HashMap();
        return clone(node,map);
    }
    
    public Node clone(Node node,HashMap<Integer,Node> map) {
    	
        if (node == null)
        	return null;
        
        if (map.containsKey(node.val)) 
            return map.get(node.val);
        
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors) 
            newNode.neighbors.add(clone(neighbor,map));
        return newNode;
    } 	
    public int evalRPN(String[] tokens) {
        int a,b;
		Stack<Integer> S = new Stack<Integer>();
		for (String s : tokens) {
			if(s.equals("+")) {
				S.add(S.pop()+S.pop());
			}
			else if(s.equals("/")) {
				b = S.pop();
				a = S.pop();
				S.add(a / b);
			}
			else if(s.equals("*")) {
				S.add(S.pop() * S.pop());
			}
			else if(s.equals("-")) {
				b = S.pop();
				a = S.pop();
				S.add(a - b);
			}
			else {
				S.add(Integer.parseInt(s));
			}
		}	
		return S.pop();
	}
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites){
    	//Input: numCourses = 2, prerequisites = [[1,0]]
    	
    	int[] incomingEdges = new int[numCourses];
    	List<Integer>[] adjList = new List[numCourses];
    	
    	for(int i =0;i<adjList.length;i++) {
    		adjList[i] = new LinkedList<Integer>();
    	}
    	for(int j=0;j< prerequisites.length;j++) {
    		incomingEdges[prerequisites[j][1]]++; //[2, 1, 1, 1] --- [2, 1, 1, 0]
    		adjList[prerequisites[j][0]].add(prerequisites[j][1]);//[[], [0], [0, 1], [2, 3]] ----[[[], [0], [0], [1, 2]]]   		
    	}
    	
    	Queue<Integer> que = new LinkedList<Integer>();
    	for(int i =0;i< incomingEdges.length;i++) {
    		if(incomingEdges[i]==0) {
    			que.add(i);
    		}    		
    	}
    	int edgeCount= prerequisites.length;
    	while(!que.isEmpty()) {
    		int curr = que.remove();
    		for(int i =0;i< adjList[curr].size();i++) {
    			edgeCount--;
    			int pointer = (int)adjList[curr].get(i);
    			incomingEdges[pointer]--;
    			if(incomingEdges[pointer]==0) {
    				que.add(pointer);
    			} 
    		}
    	}
        return edgeCount==0;
    }
    
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
          for (int j = 0; j < coins.length; j++) {
            if (coins[j] <= i) {
              dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
          }
        }
        return dp[amount] > amount ? -1 : dp[amount];
      }
    
    public int change(int amount, int[] coins) { //518
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j]; 
                if (j >= coins[i - 1])
                	 dp[i][j] += dp[i][j-coins[i-1]];
            }
        }
        return dp[coins.length][amount];
    }
    
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int left =1;
        for(int i = 0;i< nums.length;i++){
            if(i>0)
           left= left* nums[i-1];
           result[i]=left;            
        }
        int right =1;
        for(int i = nums.length;i>=0;i--){
            if(i<nums.length-1)
           right= right* nums[i-1];
           result[i]*=right;            
        }
        return result;
        
    }
    
    public int longestPalindrome(String s) {
        
        //Input: s = "abccccdd" output: 7 dccaccd
        
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        
        System.out.println(ch);
        HashMap<Character,Integer> mp = new HashMap();
        for(int i = 0;i<s.length();i++){          
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);            
        }
        
          System.out.println(mp);
    return 0;
        
    }
//    https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
//    public int kthSmallest(TreeNode root, int k) {
//        Stack<TreeNode> stack = new Stack<>();
//        while(root != null || !stack.isEmpty()) {
//            while(root != null) {
//                stack.push(root);    
//                root = root.left;   
//            } 
//            root = stack.pop();
//            if(--k == 0) break;
//            root = root.right;
//        }
//        return root.val;
//    }
//    public boolean isValidBST(TreeNode root) {
//    	   if (root == null) return true;
//    	   Stack<TreeNode> stack = new Stack<>();
//    	   TreeNode pre = null;
//    	   while (root != null || !stack.isEmpty()) {
//    	      while (root != null) {
//    	         stack.push(root);
//    	         root = root.left;
//    	      }
//    	      root = stack.pop();
//    	      if(pre != null && root.val <= pre.val) return false;
//    	      pre = root;
//    	      root = root.right;
//    	   }
//    	   return true;
//    	}
    
    public int orangesRotting(int[][] grid) {
        int min=0;
        for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid[0].length;j++){
                if(grid[i][j]==2){
                    dfs(i,j,3,grid);                   
                }
            }
        }
        int res = Integer.MIN_VALUE;
            for(int i=0;i< grid.length;i++){
                for(int j=0;j< grid[0].length;j++){
                    if(grid[i][j] == 1) {
                        return -1;
                    }
                    res = Math.max(res, grid[i][j]);
                }
            }
            
            return res == 0 ? 0 : res - 3;       
       
    }
    
    public void dfs(int i , int j,int time, int[][] grid){
    if(i<0 || j<0|| i>=grid.length || j>=grid[0].length ||grid[i][j]==0 || (grid[i][j] > 2 && grid[i][j] <= time)){
        return;
    }
        if(grid[i][j]==2) {
        	  time = 3;
        }
           grid[i][j] = time;
        
        dfs(i+1,j,time + 1,grid);
        dfs(i-1,j,time + 1,grid);
        dfs(i,j+1,time + 1,grid);
        dfs(i,j-1,time + 1,grid);
        }
        


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		matrix01 mt = new matrix01();
//		System.out.println(mt.threeSum(new int[] {-1,0,1,2,-1,-4}));
//		System.out.println(mt.lengthOfLongestSubstring("pwwkew"));
//		System.out.println(mt.lengthOfLongestSubstring("abbbbac"));
//		System.out.println(mt.canConstruct("aab", "baa"));
//		System.out.println(mt.evalRPN(new String[] {"2","1","+","3","*"}));		
//	    System.out.println(mt.canFinish(4,new int[][] {{1,0},{2,0},{2,1},{3,2},{3,3}}));//3,3 - cycle
//	    System.out.println(mt.canFinish(4,new int[][] {{1,0},{2,0},{3,1},{3,2}}));
		System.out.println(mt.coinChange(new int[]{1,2,5}, 11));
		
//		System.out.println(mt.orangesRotting(new int[][] {{2,1,1},{1,1,0},{0,1,1}}));

	}

}
//public boolean canFinish(int numCourses, int[][] prerequisites) {//dfs
//    ArrayList[] graph = new ArrayList[numCourses];
//    for(int i=0;i<numCourses;i++)
//        graph[i] = new ArrayList();        
//    boolean[] visited = new boolean[numCourses];
//    for(int i=0; i<prerequisites.length;i++){
//        graph[prerequisites[i][1]].add(prerequisites[i][0]);
//    }
//    for(int i=0; i<numCourses; i++){
//        if(!dfs(graph,visited,i))
//            return false;
//    }
//    return true;
//}
//private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
//    if(visited[course])
//        return false;
//    else
//        visited[course] = true;
//    for(int i=0; i<graph[course].size();i++){
//        if(!dfs(graph,visited,(int)graph[course].get(i)))
//            return false;
//    }
//    visited[course] = false;
//    return true;
//}
