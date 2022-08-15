 public class ListNode {
     int val;
     ListNode next;
     ListNode prev;
     
      ListNode() {
    	  
      }
      ListNode(int val) { 
    	  this.val = val;
    	  }
      
      ListNode(int val, ListNode next,ListNode nextnext){
      this.val = val; 
      this.next = next;
      this.next.next = nextnext; 
      
      }
      ListNode(ListNode prev, int val){
    	  this.val = val;
    	  this.prev= prev;
      }
  }