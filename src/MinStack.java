
public class MinStack { //155
//	in stack elements changes in LIFO order, so the min value keeps repeating in the 
//	elements above it but gets updated in the elements below it when it is removed.
		private Node head;
		
	    public void push(int x) {
	    	if(head== null)
	    		head = new Node(x,x,null);
	    	else
	    		head = new Node(x,Math.min(x, head.min),head);	        
	    }
	    
	    public void pop() {
	        head = head.next;
	    }
	    
	    public int top() {
			return head.val;
	        
	    }
	    
	    public int getMin() {
			return head.min;
	        
	    }
	
	    private class Node {
	    	int val;
	    	int min;
	    	Node next;
	    	
	    	private Node(int val, int min, Node next) {
	    		this.val = val;
	    		this.min = min;
	    		this.next= next;	    		
	    	}
	    	
	    }
	    

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin()); // return -3
		minStack.pop();
		System.out.println(minStack.top());    // return 0
		System.out.println(minStack.getMin()); // return -2

	}

}
