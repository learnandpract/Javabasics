package medium;

public class PalindrmStr {
	 public int countSubstrings(String s) {
	        int count=0;
	        for(int i=0;i<s.length();i++){
	            count+=extractPalindrome(s,i,i);//odd length
	            count+=extractPalindrome(s,i,i+1);//even length
	        }
	        return count;
	    }
	    public int extractPalindrome(String s, int left, int right){
	        int count=0;
	        while(left>=0 && right<s.length()&& (s.charAt(left)==s.charAt(right))){
	            left--;
	            right++;
	            count++;
	        }
	        return count;
	    }
	
	    
	    public String longestPalindrome(String s) {//https://www.youtube.com/watch?v=LgG2Km9GvJw
	        if (s == null || s.length() < 1) return "";
	        int start = 0, end = 0;
	        for (int i = 0; i < s.length(); i++) {
	            int len1 = expandAroundCenter(s, i, i);// for odd
	            int len2 = expandAroundCenter(s, i, i + 1);// for even
	            int len = Math.max(len1, len2);
	            if (len > end - start) {
	                start = i - (len - 1) / 2;
	                end = i + len / 2;
	                System.out.println(" inside if : "+s.substring(start, end + 1));
	            }
	        }
	        return s.substring(start, end + 1);
	    }

	    private int expandAroundCenter(String s, int left, int right) {
	        int L = left, R = right;
	        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	            L--;
	            R++;
	        }
	        return R - L - 1;
	    }
	    
	    public String longestPalindrome_trial(String s) {
	        int maxS =0;
	        String result = null;
	        for(int i =0;i<s.length()-1;i++){
	            for(int j=i+1;j<s.length();j++){
	           if(isPalindrome(s,i,j)){
	        	   if(s.substring(i,j).length()>maxS) {	        		   
	               maxS= s.substring(i,j+1).length() ;
	               result=s.substring(i,j+1);
	        	   }
	           }
	            }
	        }
	        return result;
	    }       
	              
	    public boolean isPalindrome(String t, int i , int j){
	     
	     
	        while(i<j) {
	        if(t.charAt(i++)!= t.charAt(j--))
	        {
	            return false;
	        }
	        }
	        return true;
	    }
	
	    
	public static void main(String[] args) {
		PalindrmStr ps = new PalindrmStr();
		System.out.println(ps.longestPalindrome("babad"));
				

	}

}
