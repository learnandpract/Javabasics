import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class E_BinaryTree {

	
	//94. Binary Tree Inorder Traversal
//	Depth First Traversals: 
//		(a) Inorder  (Left, Root, Right) : 4 2 5 1 3 
//		(b) Preorder (Root, Left, Right) : 1 2 4 5 3 
//		(c) Postorder(Left, Right, Root) : 4 5 2 3 1
	
	public List<Integer> inOrderT(TreeNode root){
		List<Integer> res = new ArrayList<>();		
		helper(root,res);	
		
		return res;
	}
	public void helper(TreeNode root,List<Integer> res) {
		int counter = 0;
		if(root!=null) {
			if(root.left!=null) {
				System.out.println(root.left.val+": count"+ counter++ +" left val");
				helper(root.left,res);
			}
			System.out.println(root.val+": count"+ counter++ +" val the real one");
			res.add(root.val);
			if(root.right!=null) {
				System.out.println(root.right.val+": count"+ counter++ +" right val");
				helper(root.right,res);
			}
		}
		
	}
	
    public List < Integer > inorderTStack(TreeNode root) { //94
//    	Algorithm Inorder(tree)
//    	   1. Traverse the left subtree, i.e., call Inorder(left-subtree)
//    	   2. Visit the root.
//    	   3. Traverse the right subtree, i.e., call Inorder(right-subtree)
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
            	System.out.println(curr.val +" curr val ");
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) { //144
//    	Algorithm Preorder(tree)
//    	   1. Visit the root.
//    	   2. Traverse the left subtree, i.e., call Preorder(left-subtree)
//    	   3. Traverse the right subtree, i.e., call Preorder(right-subtree) 
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
    
    public List<Integer> postorderTraversal(TreeNode root) {//145
//    	Algorithm Postorder(tree)
//    	   1. Traverse the left subtree, i.e., call Postorder(left-subtree)
//    	   2. Traverse the right subtree, i.e., call Postorder(right-subtree)
//    	   3. Visit the root.
    	
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.add(cur);
                res.add(0, cur.val);
                cur = cur.right;
            }
            cur = stack.pop();
            cur = cur.left;
        }
        
        return res;
    }
    
    
 public TreeNode invertTree(TreeNode root) { //grind75
	 if (root == null) {
         return null;
     }
     TreeNode tn= new TreeNode();   
     while(root!=null) {
    	 tn.right = root.left ; 
    	 tn.left = root.right;
    	 
    	 
     }
     
     return tn;
	 
    }
 public List<List<Integer>> levelOrder_lc(TreeNode root) {//BFS queue
     
     Queue<TreeNode> qtn = new LinkedList();
    if (root != null) 
     qtn.add(root);
     List<List<Integer>> mainres = new ArrayList();        
           
     while(!qtn.isEmpty()){
         int Lsize = qtn.size();
         List<Integer> res = new ArrayList();            
         for(int i =0;i<Lsize;i++){            
         TreeNode current = qtn.remove(); 
             res.add(current.val); 
                  
         if(current.left!=null){
             qtn.add(current.left);
         }
          if(current.right!=null){
             qtn.add(current.right);
         }   
               
     }
         mainres.add(res);
       
     }
     return mainres;
 }
    public List<Integer> levelOrder_Q(TreeNode root){//part of 226 level order traversal[4,2,7,1,3,6,9]
    	// is breadth first traversal
    	//Level Order Traversal is the algorithm to process all nodes of a tree 
    	//by traversing through depth, first the root, then the child of the root, etc.
    	//4 2 7 1369
    	List<Integer> result  = new ArrayList<>();
    	if(root==null) 
    		return result;
    	Queue<TreeNode> que = new LinkedList<TreeNode>();
    	que.add(root); // gets only root val i.e - 4
    	  System.out.println(que.size()+" que size");
    	  
    	for(TreeNode s : que) { 
    		  System.out.println(s.val+" : node"); 
    		  
    		}
    	while(!que.isEmpty()) {
//    		List<Integer> currentLevel = new ArrayList<Integer>();
    		for(int i =0; i<que.size();i++) {
    			TreeNode current = que.remove();
    			result.add(current.val);
    			if(current.left!=null) {
    				que.add(current.left);    				
    			}
    			if(current.right!=null) {
    				que.add(current.right);    				
    			}
//    			for(TreeNode s : que) { 
//    	    		  System.out.println(s.val+" : node inside for");     	    		  
//    	    		}
    		}
//    		for(TreeNode s : que) { 
//      		  System.out.println(s.val+" : node out of for");       		  
//      		}
//    		result.add(currentLevel);
    	}
    	return result;
    }
    
    public void levelOrder(TreeNode root){//part of 226 level order traversal[4,2,7,1,3,6,9]
    	// is breadth first traversal
    	//Level Order Traversal is the algorithm to process all nodes of a tree 
    	//by traversing through depth, first the root, then the child of the root, etc.
    	  int h = height(root);
          int i;
          for (i = 1; i <= h; i++) {
        	  
        	  System.out.println("");
              printCurrentLevel(root, i);
          }
    }
    void printCurrentLevel(TreeNode root, int level)
    {
    	if (root == null)
            return;
        if (level == 1)
            System.out.print(root.val + " ");
        
        else if (level > 1) {
        	
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        } 
    }
    int height(TreeNode root)
    {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
 
            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
    
    public TreeNode invertTree_Q(TreeNode root) {//226 - BFS -Que-levelorder 
    	//o/p = [4, 7, 2, 9, 6, 3, 1]
    	Queue<TreeNode> que = new LinkedList<TreeNode>();
    	que.add(root);
    	
    	while(!que.isEmpty()) {
    		TreeNode current = que.remove();
    		TreeNode left = current.left;
    		current.left = current.right;
    		current.right = left;    		
    		if(current.left!=null) {
    			que.add(current.left);    			
    		}
    		if(current.right!= null) {
    			que.add(current.right);
    		}
    	}    	
    	return root;    	
    } 
//Since each node in the tree is visited / added to the queue only once, the time complexity is O(n)O(n), where nn is the number of nodes in the tree.
  // Space complexity is O(n)O(n), since in the worst case, the queue will contain all nodes in one level of the binary tree. For a full binary tree, the leaf level has 
   
        
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/1347857/C%2B%2BJavaPython-Iterate-in-BST-Picture-explain-Time%3A-O(H)-Space%3A-O(1)
  	//Binary Search Tree //6,3
	  int small = Math.min(p.val, q.val);//3
      int large = Math.max(p.val, q.val);//6
      while (root != null) {
          if (root.val > large) // p, q belong to the left subtree
              root = root.left;
          else if (root.val < small) // p, q belong to the right subtree
              root = root.right;
          else // Now, small <= root.val <= large -> This root is the LCA between p and q
              return root;
      }
      return null;
  }  
 
    public List<Integer> inorderTMorris(TreeNode root) { //94
        List<Integer> nodes = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode pre = cur.left;
                while ((pre.right != null) && (pre.right != cur)) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    nodes.add(cur.val);
                    cur = cur.right;
                }
            } else {
                nodes.add(cur.val);
                cur = cur.right;
            }
        }
        return nodes;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) { // 100
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
    
    public boolean isSymmetric(TreeNode root) { //101
        return root==null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
    
    
    private boolean isSymmetricISC(TreeNode root){
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        TreeNode left, right;
        
        while(!stack.empty()){
            left = stack.pop();
            right = stack.pop();
            
            if(left == null && right == null){
                continue;
            }
            if(left==null || right == null || left.val != right.val){
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

    public int maxDepth(TreeNode root) { //104  
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    //Ideally BFS works well when the tree is wider. DFS to be chosen when the tree is deeper.
    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        
        int depth = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            depth++;
            while (size-- > 0) {
                TreeNode node = nodes.poll();
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
            }
        }
        return depth;
    }
    
    public int maxDepthDFS(TreeNode root) {
        if(root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        stack.push(root);
        depth.push(1);
        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int curDepth = depth.pop();
            max = Math.max(curDepth, max);
            // PUSH RIGHT FIRST - to pop left first
            if (node.right != null) {
                stack.push(node.right);
                depth.push(curDepth+1);
            }
            if (node.left != null) {
                stack.push(node.left);
                depth.push(curDepth+1);
            }
        }
        return max;
    }
    
    
    public TreeNode invertBT(TreeNode root) {
    	
	      if (root == null) return null;
	      
	      TreeNode inverted = root.right;
	    	root.right = invertBT(root.left);
	    	root.left = invertBT(inverted);    		
	    	
	    	return root;
	    }
    
   public List<Integer> inorderTraversal_tbd(TreeNode root) {	   
	   List<Integer> res = new ArrayList();
//	   
////	   res.add(root.val);//left,root,right
//	   while(root!=null) {
//	   while(root!=null) {
//		   res.add(root.val);
//		   root = root.left;
////		   res.add(root.val);
//	   }
//
//	   res.add(root.val);
//	   root = root.right;
//	   }
//	   
//	   System.out.println(res+"Original");
	   return res;
	   
               
    }
   public List<Integer> rightSideView(TreeNode root) {
       List<Integer> result = new ArrayList<Integer>();
       rightView(root, result, 0);
       return result;
   }
   
   public void rightView(TreeNode curr, List<Integer> result, int currDepth){
       if(curr == null){
           return;
       }
       System.out.println("currDepth :: "+currDepth+" :: curr val :: "+ curr.val+" ::result.size :: "+result.size());
       if(currDepth == result.size()){
           result.add(curr.val);
       }
       
       rightView(curr.right, result, currDepth + 1);
       rightView(curr.left, result, currDepth + 1); // needed if the right node (ex: 9 missing, then it has print left node -7)
       
   }
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1); //[1,null,2,3] https://www.tutorialcup.com/leetcode-solutions/insert-into-a-binary-search-tree-leetcode-solution.htm
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		E_BinaryTree bt = new E_BinaryTree();
//		System.out.println(bt.inorderTraversal_tbd(root));
//		System.out.print(bt.rightSideView(root));
//		System.out.println(bt.inOrderT(root));
		
//		System.out.println(bt.inorderTStack(root)+" In order");//[1, 3, 2]
////		System.out.println(bt.inorderTMorris(root));
//		System.out.println(bt.preorderTraversal(root)+" Pre order");
//		System.out.println(bt.postorderTraversal(root)+" Post order ");
//		
		TreeNode root1 = new TreeNode(4); //[1,null,2,3] https://www.tutorialcup.com/leetcode-solutions/insert-into-a-binary-search-tree-leetcode-solution.htm
		root1.left = new TreeNode(2);
		root1.left.left = new TreeNode(1);
		root1.left.right = new TreeNode(3);
		root1.right = new TreeNode(7);
		root1.right.left = new TreeNode(6);
//		root1.right.right = new TreeNode(9);
//		bt.levelOrder(root1);
//		System.out.println(bt.levelOrder_Q(root1)+" level order "); // level order traversal//
		
//		System.out.println(bt.lowestCommonAncestor(root1, root1.right.left, root1.left.right).val);
		System.out.print(bt.rightSideView(root1));
		//6,3
		
//	System.out.println(bt.levelOrder_Q(bt.invertTree_Q(root1))+" level order invert"); // level order traversal//
//		TreeNode inverted = bt.invertTree_Q(root1);
		
		
	
	}
}
