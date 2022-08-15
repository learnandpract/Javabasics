import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyBoard {
	   public String[] findWords(String[] words) {
		   String str = "qwertyuiop";
		   String str1 = "asdfghjkl";
		   Set<Character> wordset1 = new HashSet<Character>();
		   Set<Character> wordset2 = new HashSet<Character>();
		   
		   
		   for(char c :str.toCharArray()) {
			   wordset1.add(c);
		   }
		   
		   for(char c :str1.toCharArray()) {
			   wordset2.add(c);
		   }
	   List<String> result = new ArrayList<String>();
		   for(String wd : words) {
		   if(isValid(wd,wordset1)|| isValid(wd, wordset2)) {
			result.add(wd);   
		   }
		   }		 
		   
	        return result.toArray(new String[0]);
	    }
	   public boolean isValid(String wd, Set wordset) {
		   
				  for(char c:wd.toCharArray()) {
					  if(!wordset.contains(c)) {
						  return false;
					  }
				  }
				  
				  
		   return true;
		   
	   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyBoard kb = new KeyBoard();
		
		System.out.println(Arrays.toString(kb.findWords(new String[] {"alaska","dad"})));

	}

}
