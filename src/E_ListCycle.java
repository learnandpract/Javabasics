
public class E_ListCycle {
	
	public boolean hasCycle(ListNode head) {//141
		ListNode ln1 = head;
		ListNode ln2 = head;
		
		while(ln2!=null && ln2.next!=null) {
			ln1= ln1.next;
			ln2= ln2.next.next;
			if(ln1 == ln2) return true;
		}		
		
		return false;
	}
	
	public ListNode getIntersection(ListNode headA , ListNode headB) { // see the comment for the solution
		if(headA== null || headB == null) return null;
		ListNode a = headA; ListNode b = headB;
		while(a!=b) {
			a=(a==null)?headB :a.next;
			b=(b==null)?headA :b.next;
		}
		
		return a;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
