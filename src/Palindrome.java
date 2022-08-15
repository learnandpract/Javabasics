//Leetcode - 9 
public class Palindrome {

	Palindrome(){
		
	}
	public String paliChk(String a1) {
		char[] b = a1.toCharArray();
		int m = b.length/2;
		for(int i = 0 ; i<b.length-1 ; i++) {
			System.out.println("b[b.length-i]"+b[(b.length-1)-i]);
			System.out.println("b[i]"+b[i]);
			if(b[i]!=b[(b.length-1)-i]) {
				return "false";
			}
		}		
		return "true";
	}
	public boolean paliChk1(String a1) {
		int i = 0, j = a1.length()-1;
		while(i<j) {
		if(a1.charAt(i)!=a1.charAt(j)) {
			return false;
		}
		}			
		return true;
	}
	public void printpal() {
  String palindrome = "Dot saw I was Tod";		
		  char[] charArray = new char[palindrome.length()];
		  char[] result = new char[palindrome.length()];
		  for(int i = 0; i< palindrome.length(); i++){
//		  charArray[i]= palindrome.charAt(i);  
		  result[i] = palindrome.charAt(palindrome.length()-i-1);
		  }
//		  for(int i = 0; i< palindrome.length(); i++){
//		        result[i] = charArray[charArray.length-i-1];
//		    }
		  System.out.println(new String(result));
		    }

	public boolean intPal(int x) { //correct
		
		if(x<0 ||( x%10 ==0 &&x!= 0) ){
			return false;
		}
		
		int revNum = 0;
		
		while(x>revNum) { //traverse only half
			revNum = revNum*10+x%10;
			x= x/10;
		}		
		return x==revNum || x== revNum/10;
		
	}
	
	public void palind(int x) { //practise
		int revnum = 0;
		while(x>revnum) {
			revnum = revnum*10+x%10;
			x= x/10;
			
		}
		System.out.println(revnum+":revnum "+x+":x  "+revnum/10 +": revnum/10");
	}
	
	public boolean palindList(ListNode head) {//234
		ListNode fast = head ;
		ListNode slow = head;
		
		while(fast!= null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;			
		}
		if(fast!=null) {
			slow = slow.next;
		}
		slow = reverse(slow);
		fast  = head;
		
		while(slow!=null) {
			if(fast.val!=slow.val) {
				 return false;
			}
			fast = fast.next;
			slow= slow.next;	
		}
		return true;
		
	}
public ListNode reverse(ListNode head) {
	ListNode current = head;
	ListNode previous = null;
	
	while(current!=null) {
		ListNode next = current.next;
		current.next = previous;
		previous = current;
		current = next;
	}
	
	return previous;
	
	
}
	
	public static void main(String a[]) {
		String a1 = "abcdcba";
		Palindrome pd = new Palindrome();
//		pd.printpal();	
//		System.out.print(pd.paliChk(a1));		
//		System.out.print(a1);
		
		int x= 12521;
		Palindrome pd1 = new Palindrome();
		pd1.palind(x);
//		System.out.println(pd1.intPal(x)+" is palindrome");
		
	}
}
