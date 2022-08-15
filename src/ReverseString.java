
public class ReverseString {
	
    public String reversePrefix(String word, char ch) {//2000
//     String rword = null;
     int len = word.indexOf(ch);
     String sb = word.substring(word.indexOf(ch)+1);
     char[] rword = new char[word.length()]; 
     
     for(int i = 0,j=len; i<len;i++,j--) {
    	 char b = word.charAt(i);
    	 char m = word.charAt(j);
    	 rword[i]=m;
    	 rword[j]=b; 	
     }
     
     for(int k = len+1; k<=(len+sb.length());k++) {
    	 rword[k]=word.charAt(k);
     }
     return (new String (rword));
    	
    }

	public static void main(String[] args) {
		String wd="abcde";
		System.out.println(" index of :"+wd.substring(wd.indexOf("c")+1));
		ReverseString rs = new ReverseString();
		System.out.println(rs.reversePrefix("abcde",'c'));

	}

}
