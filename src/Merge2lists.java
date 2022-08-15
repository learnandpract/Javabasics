// LInked list problems - 21 , 83, 203
public class Merge2lists { //21 //given 2 sorted , merge it and return sorted
	public ListNode mergelist(ListNode l1,ListNode l2) {
		ListNode result = new ListNode();
		ListNode prev = result;
		while (l1 != null && l2 != null) {
			System.out.println(l1.val +": l1val "+ l2.val+": l2val");
			
		if(l1.val<=l2.val) {
	      prev.next = l1;
		  l1 = l1.next;
		}
		else {
		  prev.next = l2;
		  l2=l2.next;
		}
		prev = prev.next;
		  }
		
//		while(result != null) {
//		      System.out.println(result.val + " result ");
//		      result = result.next;
//		    }
		return result.next;
	}
	
    public ListNode mergeLists(ListNode list1, ListNode list2) {//practise,grind75
    	ListNode mainres = new ListNode() ;
    	ListNode res = mainres;
    	while(list1!=null && list2!=null) {
    	if(list1.val<list2.val) {
    		res.next = list1;
    		list1=list1.next;
    	}else {
    		res.next = list2;
    		list2=list2.next;
    	}
    	res = res.next;
    	}    	   	
		return mainres.next;        
    }    
    
	public ListNode deleteDup(ListNode head) {//83 given - sorted linked, delete duplicate
		ListNode result = head;
		while(result.next!=null) {
			if(result.val == result.next.val) {
				result.next = result.next.next;
			}else {
				result = result.next;
			}			
		}
		return head;
	}
	
	public ListNode removeElements(ListNode head, int val) { //203
//		ListNode cur = head; // wont delete the first element, thats why use the dummy node.
//		we use dummy node so that we don't lose the reference to the head pointer. 
//		 while (head != null && head.val == val) head = head.next;
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode cur = dummy;
	    
//	    ListNode cur = head;
	    while(cur.next != null) {
	        if(cur.next.val == val) {
	            cur.next = cur.next.next;
	        }
	        else
	            cur = cur.next;
	    }
	    return dummy.next; // head
	}
	
//	public ListNode reverseList(ListNode head) { //12345 -> 54321
//		ListNode curr = null;
//		while(head!=null) {
//			ListNode dummy  = head.next;
//			head.next = curr;
//			curr = head;
//			head = dummy;
//		}	
//		
//		return curr;
//	}
//	Take 1 -> 2 -> 3 -> N for example, we reverse the list by
//	put 1's previous node null as 1's next,
//	put 2's previous node 1 as 2's next,
//	put 3's previous node 2 as 3's next,
//	return 3 // put null's previous node 3 as null's next
	public ListNode reverseList(ListNode head) { //https://www.youtube.com/watch?v=jY-EUKXYT20
        ListNode current  = head;
        ListNode previous = null;
        ListNode next = null;
        
        while(current != null){
        	next  = current.next;
            current.next = previous;// first - null;
            previous = current;
            current = next;
        }
        return previous;
    }
	
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;		
		
	}
	
	
	
	public static void main(String[] args) {
		Merge2lists ml = new Merge2lists();
		ListNode l1 = new ListNode(1,new ListNode(2),new ListNode(4));
		ListNode l2 = new ListNode(1,new ListNode(3),new ListNode(4));
//		
		ListNode result = ml.mergeLists(l1, l2);
		 while(result != null) {
		      System.out.println(result.val + " result ");
		      result = result.next;
		    }
//		
//			ListNode l3 = new ListNode(1,new ListNode(1),new ListNode(4));
//			ListNode result1 = ml.deleteDup(l3);
//			 while(result1 != null) {
//			      System.out.println(result1.val + " result1 ");
//			      result1 = result1.next;
//			    }
			 
		ListNode l4 = new ListNode(1);
		l4.next = new ListNode(4);
		l4.next.next = new ListNode(5);
		l4.next.next.next = new ListNode(6);
		l4.next.next.next.next = new ListNode(7);		
//		 while(l4 != null) {
//		      System.out.println(l4.val + " l4 ");
//		      l4 = l4.next;
//		    }
		 
//		 ListNode res4  = ml.removeElements(l4, 1);
//		 while(res4 != null) {
//		      System.out.println(res4.val + " res4 ");
//		      res4 = res4.next;
//		    }	
		
//		 ListNode res4  = ml.reverseList(l4);
//		 while(res4 != null) {
//		      System.out.println(res4.val + " res4 ");
//		      res4 = res4.next;
//		    }		
	}	
}
