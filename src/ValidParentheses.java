import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
	
	public boolean validP(String b) {
		char[] c = b.toCharArray();
		Stack<Character> s = new Stack<Character>() ;
		
		for(int i = 0 ; i<b.length();i++) {
			System.out.println(c[i]);
			if(c[i]=='(') 
				s.push(')');
			else if(c[i]=='[') 
				s.push(']');
			else if(c[i]=='{') 
				s.push('}');
			else if(s.isEmpty() || s.pop() != c[i]){
				System.out.println(s+" : s");
				return false;				
			}
		}			
		return s.isEmpty() ;
	}
	
	  public boolean validateStackSequences(int[] pushed, int[] popped) {// 946-medium
	        Stack<Integer> stack = new Stack<>();
	        int i = 0;
	        for (int x : pushed) {
	            stack.push(x);
	            while (!stack.empty() && stack.peek() == popped[i]) {
	                stack.pop();
	                i++;
	            }
	        }
	        return stack.empty();
	    }
	
	  public List<String> generateParenthesis(int n) {//"((()))","(()())","(())()","()(())","()()()"
		  List<String> ls = new ArrayList();
		  
	  backtrck(ls, new StringBuilder(),0,0,n);
			  
		  return ls;
	     
		  
	    }
	  
	  public void backtrck(List ls, StringBuilder sb, int start,int end, int len) {
//		  List<String> ans = new ArrayList();
		  if(sb.length()== len*2) {
			  ls.add(sb.toString());
			  return;
		  }
		  
		  if(start< len) {
			  sb.append("(");
			  backtrck(ls,sb,start+1,end,len);
			  sb.deleteCharAt(sb.length()-1);
		  }
		  if(end<start) {
			  sb.append(")");
			  backtrck(ls,sb,start,end+1,len);
			  sb.deleteCharAt(sb.length()-1);
		  }
		  
		  
	  }
	  
	public static void main(String[] args) {
		ValidParentheses a = new ValidParentheses();
		String b= "([])";
//		System.out.println(a.validP(b));
		
//		System.out.println(a.validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,5,3,2,1})+"== Validate sequences");
		System.out.println(a.generateParenthesis(3));
		
		
	}
	

}
