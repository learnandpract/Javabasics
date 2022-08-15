import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Substring {

	public boolean subSeq(String s, String t ) {//392 s = "acb", t = "ahbgdc"
		int j =0;
		for(int i=0; i<t.length();i++) {
			if(j<s.length() && t.charAt(i)==s.charAt(j)) {
				j++;
			}			
		}
	
		if(j<s.length()) {
			
			return false;
		}
		return true;
	}
	
	  public boolean isSubsequence(String s, String t) 
	    {//392- faster
	        if(t.length() < s.length()) return false;
	        int prev = 0;
	        for(int i = 0; i < s.length();i++)
	        {
	            char tempChar = s.charAt(i);
	            prev = t.indexOf(tempChar,prev);
	            if(prev == -1) return false;
	            prev++;
	        }
	        
	        return true;
	    }
	  
	   public String reformat(String s) { //1417
//		   Input: "a0b1C2"
//		  Output: "0a1b2C"
		   List<Character> digits = new ArrayList();
		   List<Character> alpha = new ArrayList();
		   	   
		   StringBuilder ans = new StringBuilder();
		   
		   for(int i = 0 ;i<s.length();i++) {
//			System.out.println(Integer.valueOf(s.charAt(i))+" char at i");			
			if(Integer.valueOf(s.charAt(i))>=96 && Integer.valueOf(s.charAt(i))<= 122) 
				alpha.add(s.charAt(i));								
			else 
				digits.add(s.charAt(i));
		   }
		   
		   boolean char_first = alpha.size()>=digits.size()?true:false;
		   for(int j=0; j<s.length();j++) {
		   if(char_first){
			   ans.append(alpha.remove(0));
		   }else {
			   ans.append(digits.remove(0));
		   }
		   char_first =!char_first;
		   }
		   
		   return ans.toString();
	        
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "acb";String t = "ahbgdc";
		Substring sq = new Substring();
		System.out.println(sq.isSubsequence(s,t));
//		System.out.print(sq.reformat("covid2019"));
		
	}

}
