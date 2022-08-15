import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class E_BinaryTree_2 {
//	(b) Preorder (Root, Left, Right) : 1 2 4 5 3 
	
	public List preorder(TreeNode root) {
		List result = new LinkedList();
		Deque dq = new LinkedList(); // stack is thread safe, so deque is faster.	
		
		dq.push(root);		
		while(!dq.isEmpty()) {
			TreeNode tn = (TreeNode) dq.pop();
			if(tn!=null) {
				result.add(tn.val);
				dq.push(tn.right);
				dq.push(tn.left);
			}			
		}
		return result;		
	}
	   public List<Integer> preorderTraversal(TreeNode root) {
	        Stack<TreeNode> stack = new Stack<>();
	        List<Integer> res = new ArrayList<>();
	        TreeNode cur = root;
	        while(!stack.isEmpty() || cur != null){
	            while(cur != null){
	            	res.add(cur.val);
	                stack.push(cur);
	                cur = cur.left;
	            }
	            cur = stack.pop();
	            cur = cur.right;
	        }
	        return res;
	    }

	   
	    int preorderIndex;
	    Map<Integer, Integer> inorderIndexMap;
	    
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

	        for(int i = 0; i < inorder.length; i++) {
	            inMap.put(inorder[i], i);
	        }

	        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
	        return root;
	    }

	    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
	        if(preStart > preEnd || inStart > inEnd) return null;

	        TreeNode root = new TreeNode(preorder[preStart]);
	        int inRoot = inMap.get(root.val);
	        int numsLeft = inRoot - inStart;

	        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
	        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

	        return root;
	    }
	   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E_BinaryTree_2 ebt2 = new E_BinaryTree_2();
		E_BinaryTree bt = new E_BinaryTree();
		
		TreeNode root = new TreeNode(1); //[1,null,2,3] https://www.tutorialcup.com/leetcode-solutions/insert-into-a-binary-search-tree-leetcode-solution.htm
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
//		System.out.println(ebt2.preorder(root));
		System.out.println(bt.levelOrder_Q(ebt2.buildTree(new int[] {3,9,20,15,7}, new int [] {9,3,15,20,7})));
		
	}

}
