import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class E_BinaryTree1 {
	
//	Binary Search tree :Each tree node has a max of 2 children.
//	Search tree because it can be used to search for a num in O(log(n)) time.
//	All nodes of left subtree are less than the root node
//	All nodes of right subtree are more than the root node
	
	 public TreeNode sortedArrayToBST(int[] num) {// 108. [-10,-3,0,5,9] o/p: [0,-10,5,null,-3,null,9] 
         if (num.length == 0) { // I think the time is O(n), since T(n) = 2T(n/2) + O(1).
        		// The space is O(logn) since there are at most logn recursion stacks in the meantime.
        return null;
    }
    TreeNode head = helper(num, 0, num.length - 1);
    return head;
	 }
	 

	private TreeNode helper(int[] num, int low, int high) {
		if(low>high){
			return null;
		}
		int mid = low + (high-low)/2;
		TreeNode nd = new TreeNode(num[mid]);
		nd.left = helper(num ,low, mid-1);
		nd.right = helper(num ,mid+1, high);
		
		return nd;
	}
	private class Node {
		TreeNode node;
		int left, right;
		public Node(TreeNode node, int left, int right) {
			this.node = node;
			this.left = left;
			this.right = right;
		}
	}
	public TreeNode sortedArrayToBST_DFS(int[] nums) { //108
		if (nums == null || nums.length == 0) return null;
		TreeNode root = new TreeNode(0);
		Stack<Node> stack = new Stack<>();
		Node node = new Node(root, 0, nums.length - 1);
		stack.push(node);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			int mid = cur.left + (cur.right - cur.left) / 2;
			cur.node.val = nums[mid];		
			if (cur.left < mid) {
				cur.node.left = new TreeNode(nums[cur.left+(mid-1-cur.left)/2]);
				stack.push(new Node(cur.node.left, cur.left, mid - 1));
			}
			if (cur.right > mid) {
				cur.node.right = new TreeNode(nums[mid+1+(cur.right-mid-1)/2]);
				stack.push(new Node(cur.node.right, mid + 1, cur.right));
			}
		}
		return root;
	}

	  public TreeNode sortedArrayToBST_dfs(int[] nums) { //108
	        if (nums == null || nums.length == 0) {
	            return null;
	        }
	        
	        Queue<Node> queue = new LinkedList<>();
	        int left = 0;
	        int right = nums.length - 1;
	        int val = nums[left + (right - left) / 2];
	        TreeNode root = new TreeNode(val);
	        queue.offer(new Node(root, left, right));
	        
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	            	Node cur = queue.poll();
	                
	                int mid = cur.left + (cur.right - cur.left) / 2;
	                
	                if (mid != cur.left) {
	                    TreeNode leftChild = new TreeNode(nums[cur.left + (mid - 1 - cur.left) / 2]);
	                    cur.node.left = leftChild;
	                    queue.offer(new Node(leftChild, cur.left, mid - 1));
	                }
	                
	                if (mid != cur.right) {
	                    TreeNode rightChild = new TreeNode(nums[mid + 1 + (cur.right - mid - 1) / 2]);
	                    cur.node.right = rightChild;
	                    queue.offer(new Node(rightChild, mid + 1, cur.right));
	                }
	            }
	        }
	        
	        return root;
	    }
	  
	  public boolean isBalanced(TreeNode root) { //110
//	        if(root == null){
//	            return true;
//	        }
	        return helper(root) != -1;
	    }
	    private int helper(TreeNode root){
	        if(root == null){
	            return 0;
	        }
	        int left = helper(root.left);
	        int right = helper(root.right);
	        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
	            return -1;
	        }
	        return Math.max(left, right) + 1;
	    }
	    
	    public int minDepth(TreeNode root) { // 111 dfs - but BFS is much better
	    	 //If root's left subtree has a depth of 500 and the right subtree has a depth of 1, the code is going to traverse all the way down the 500 left subtree first before finally traversing the right subtree with a measly depth of 1 and figuring out "d'oh!" that's the min depth.
	        if (root == null) {
	            return 0;
	        }

	        int left = minDepth(root.left);
	        int right = minDepth(root.right);
	        if (left == 0 || right == 0) {
	            return Math.max(left, right) + 1;
	        }
	        else {
	            return Math.min(left, right) + 1;
	        }
	    }
	    /** Solution 2: BFS level order traversal */
	    public int minDepth2(TreeNode root) { //111
	        if (root == null) {
	            return 0;
	        }
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        int level = 1;
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                TreeNode curNode = queue.poll();
	                if (curNode.left == null && curNode.right == null) {
	                    return level;
	                }
	                if (curNode.left != null) {
	                    queue.offer(curNode.left);
	                }
	                if (curNode.right != null) {
	                    queue.offer(curNode.right);
	                }
	            }
	            level++;
	        }
	        return level;
	    }
	    
	    public boolean pathSumrc(TreeNode root, int sum) {//112 return true if tree has root to leaf path
//	    	Idea is to subtract the value of current node from sum until it reaches a leaf node and the subtraction equals 0,
//	    	then we know that we got a hit. Otherwise the subtraction at the end could not be 0.
	        if(root == null) return false;
	    	if(root.right == null && root.left== null && sum-root.val ==0) return true;
	    	return (pathSumrc(root.left, sum-root.val) || pathSumrc(root.right, sum-root.val) );
	    			
	    	    	
	    }
	    


	public static void main(String[] args) {
		E_BinaryTree1 bst = new E_BinaryTree1(); 
//		TreeNode ny =   bst.sortedArrayToBST(new int[] {-10,-3,0,5,9});
//		System.out.println( new E_BinaryTree().inOrderT(bst.sortedArrayToBST(new int[] {-10,-3,0,5,9})));
//		while(ny.left != null) {
//		 System.out.printf("%d ", ny.val);
//		 
//		}
		
			TreeNode root = new TreeNode(1); //[1,null,2,3] https://www.tutorialcup.com/leetcode-solutions/insert-into-a-binary-search-tree-leetcode-solution.htm
			root.left = null;
			root.right = new TreeNode(2);
			root.right.left = new TreeNode(3);
		System.out.println(bst.isBalanced(root) +" is balanced");
		
	}

}
