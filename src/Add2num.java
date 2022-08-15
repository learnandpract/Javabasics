//https://docs.google.com/spreadsheets/d/1KkCeOIBwUFfKrHGGZe_6EJRCIqaM6MJBo0uSIMSD9bs/edit#gid=782922309
//The idea is that an algorithm is O(log n) if instead of scrolling through a structure 1 by 1,
//you divide the structure in half over and over again and do a constant number of operations
//for each split. Search algorithms where the answer space keeps getting split are O(log n). 
//An example of this is binary search, where you keep splitting an ordered array 
//in half over and over again until you find the number.

//Note: You don't necessarily need to be splitting in even halves.

//The key process in quickSort is partition(). Target of partitions is, given an array and an element x of array as pivot, 
//put x at its correct position in sorted array and put all smaller elements (smaller than x)
//before x, and put all greater elements (greater than x) after x.
//All this should be done in linear time.

//https://guides.codepath.com/compsci/Binary-Trees-Iterative-Traversal

// String contains - uses indexOf internally and is slow. O(n)
// Hashset contains - uses hashcode - fast - O(1)

//Since PriorityQueue is not thread-safe, java provides PriorityBlockingQueue class 
//that implements the BlockingQueue interface to use in java multithreading environment.

//char[] c = b.toCharArray();
//Arrays.sort(c)
//str.charAt(i)
//for removing in list:
// Iterator<String> itr = list.iterator();
//while(itr.hasNext()){String str = itr.next; if(str.isEmpty())itr.remove;}
//Iterator<Map.Entry<String, String>> itr = counter.entrySet().iterator();
//List<String> places = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
//smap.put(t.charAt(i),smap.getOrDefault(t.charAt(i),0)+1);



public class Add2num { //2 medium
//	Input: l1 = [2,4,3], l2 = [5,6,4]
//			Output: [7,0,8]			Explanation: 342 + 465 = 807.
	public ListNode addlistnodes(ListNode l1,ListNode l2) {
		  ListNode dummyHead = new ListNode(0);
		    ListNode p = l1, q = l2, curr = dummyHead;
		    int carry = 0;
		    while (p != null || q != null) {
		        int x = (p != null) ? p.val : 0;
		        int y = (q != null) ? q.val : 0;
		        int sum = carry + x + y;
		        carry = sum / 10;
		        curr.next = new ListNode(sum % 10);
		        curr = curr.next;
		        if (p != null) p = p.next;
		        if (q != null) q = q.next;
		    }
		    if (carry > 0) {
		        curr.next = new ListNode(carry);
		    }
		    return dummyHead.next;
	}
	
	public ListNode addlistnodes_1(ListNode l1,ListNode l2) {
		  ListNode dummyHead = new ListNode(0);
		    ListNode  curr = dummyHead;
		    int carry = 0;
		    while (l1 != null || l2 != null) {
//		        int x = (p != null) ? p.val : 0;
//		        int y = (q != null) ? q.val : 0;
		        int sum = carry + l1.val + l2.val;
		        carry = sum / 10;
		        curr.next = new ListNode(sum % 10);
		        curr = curr.next;
		        if (l1 != null) l1 = l1.next;
		        if (l2 != null) l2 = l2.next;
		    }
		    if (carry > 0) {
		        curr.next = new ListNode(carry);
		    }
		    return dummyHead.next;
	}
	
	public ListNode addlistnodes_tbd(ListNode l1,ListNode l2) {
		ListNode lsn = new ListNode();
		ListNode curr = lsn;
		int carry =0;
		while(l1!=null ||l2!=null) {
			
			int sum = carry +l1.val+l2.val;
			carry = sum/10;
			lsn.next = new ListNode(sum%10);
			lsn = lsn.next;
			if(l1!=null)
				l1=l1.next;
			if(l2!=null)
				l2=l2.next;
			
		}
		if(carry>0) {
			lsn.next = new ListNode(carry);
		}
			
		
		
		return curr.next;
		
	}
	
	
	public static void main(String[] args) {
	
		Add2num num = new Add2num();
		
		
//		 System.out.println(103/10 + " "+ 103%10);
		 
		 
//		ListNode l1 = new ListNode(2,new ListNode(4),new ListNode(3) );
//		ListNode l2 = new ListNode(5,new ListNode(6),new ListNode(4) );
		
		ListNode l1 = new ListNode(8,new ListNode(4),new ListNode(9) );//948
		ListNode l2 = new ListNode(5,new ListNode(6),new ListNode(4) );//465
		
//		System.out.println(num.addlistnodes(l1, l2));
		ListNode result = num.addlistnodes_tbd(l1, l2);//1413
		
		   while(result != null) {
			      System.out.println(result.val + " ");
			      result = result.next;
			    }
		
	}
	

}
