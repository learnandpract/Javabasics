
public class LInkedList {
	static Node head;
	
	static class Node{
		int data ;
		Node next ;
		Node(int d){
			data = d;
			next =null;
		}
	}
	private void push(int i) {
		Node nd = new Node(i);
		nd.next = head;
		head = nd;		
	}
	
	private void printMiddle() {
		Node fast_ptr = head;
		Node slow_ptr = head;
		
		while(fast_ptr !=null && fast_ptr.next!=null) {
			fast_ptr = fast_ptr.next.next;
			slow_ptr = slow_ptr.next;
		}
		System.out.println("Middle : " +slow_ptr.data);						
	}

	
	public Node reverseList(Node head) { 
		//1->2->3->4
		//1<-2<-3<-4
		
		Node current = head;
		Node prev = null;	
		Node next = null;
		
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			
		}
		head = prev;
		
		
		return head;
		
	}
	
	  void printList(Node node)
	    {
	        while (node != null) {
	            System.out.print(node.data + " ");
	            node = node.next;
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LInkedList ls = new LInkedList();
		for(int i = 0; i< 5;i++) {
			ls.push(i);
		}
		ls.printMiddle();
		
		ls.head= new Node(1);
		ls.head.next  = new Node(2);
		ls.head.next.next  = new Node(3);
		ls.head.next.next.next  = new Node(4);
		
		head = ls.reverseList(head);
		ls.printList(head);
		

	}



	

}
