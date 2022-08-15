import java.util.Arrays;

public class LongCommonPrefix {

	 public String longestCommonPrefix(String[] strs) {
		    if (strs.length == 0) return "";
		    String prefix = strs[0];
		    System.out.println(prefix+"  :first st prefix");
		    
		    for (int i = 1; i < strs.length; i++) {
		    	System.out.println(strs[i].indexOf(prefix)+"  :strs[i].indexOf(prefix)  "+strs[i]+"  :strs[i] " );
		        while (strs[i].indexOf(prefix) != 0) { // -1
		        	System.out.println(prefix+" : inside != 0prefix " +strs[i]+"  :strs[i]"); //it will have one more than reqd
		            prefix = prefix.substring(0, prefix.length() - 1);
		            if (prefix.isEmpty()) return "";
		        }
		    }
		    return prefix;
	 }

	public static void main(String[] args) {
		
		LongCommonPrefix lcp = new LongCommonPrefix();
		String[] a = {"leet","leetc","leem","lema"};
		String prefix = lcp.longestCommonPrefix(a);
		System.out.println(prefix+": Prefix");
		
		System.out.println("Leetdfdferr".indexOf("Leer") +" :: "+"Leetdfdferr".indexOf("Lee"));
		System.out.println("Leetdfdferr".indexOf("tdf"));
		
				
	}
	
}
