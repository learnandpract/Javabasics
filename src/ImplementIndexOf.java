
//The two most common O(n) string searching algorithms are:
//
//Boyer Moore: https://en.wikipedia.org/wiki/Boyer–Moore_string-search_algorithm
//KMP: https://en.wikipedia.org/wiki/Knuth–Morris–Pratt_algorithm
public class ImplementIndexOf {
	//34
	public int implIndex(String haystack, String needle) {
		  for (int i = 0; ; i++) { // The length of haystack
	      for (int j = 0; ; j++) { // The length of needle
	      if (j == needle.length()) 
	    	  return i; // If at this point we have navigated through the entire length of needle, we have found a solution, haystack[i].
	      if (i + j == haystack.length())
	    	  return -1; // This happens when we run out of elements in haystack, but there are still elements in needle. 
	      if (needle.charAt(j) != haystack.charAt(i + j))
	    	  break; // We stop comparing after needle[j], so only i will be incremented and cycle repeats itself.
	      			//  otherwise if the chars are equal  j will be incremented.
			    }
			 }
		}
	
	//34 KMP
	  public int strStr(String haystack, String needle) {
	        if (needle.length() == 0) 
	        	return 0;
	        if (needle.length() > haystack.length() || haystack.length() == 0) 
	        	return -1;
	        
	        char[] ndl = needle.toCharArray();
	        char[] hay = haystack.toCharArray();	        
	        int[] pai = new int[ndl.length];
	        
	        pai[0] = -1;
	        int k = -1;
	        
	        for (int i = 1; i < ndl.length; i++) {
	            while (k > -1 && ndl[k + 1] != ndl[i]) {
	                k = pai[k];
	            }
	            if (ndl[k + 1] == ndl[i]) {
	                k++;
	            }
	            pai[i] = k;

	        }
	        k = -1;
	        for (int i = 0; i < hay.length; i++) {
	            while (k > -1 && ndl[k + 1] != hay[i]) {
	                k = pai[k];
	            }
	            if (ndl[k + 1] == hay[i]) {
	                k++;
	                if (k == ndl.length - 1) {
	                    return i - k;
	                }
	            }
	        }
	        return -1;
	    }
	  
	//35  
	  public int searchInsert(int[] n, int target) { // original
		  int rs = 0;
		  for(int i=0; i< n.length;i++) {
			  if(n[i] == target) {
				  return i;				  
			  }else if(target <n[i]) {
				  return i;	
			  }		  
		  }
		  if(target>rs){
		  	 return n.length;
		  			  }
		  return rs;
		  
	  }
	  
	    public int binarysearchInsert(int[] n, int target) {
	        int low = 0, high = n.length-1;
	        while(low<=high){
	            int mid = (low+high)/2;
	            if(n[mid] == target) return mid;
	            else if(n[mid] > target) high = mid-1;
	            else low = mid+1;
	        }
	        return low;
	    }
	
	
	public static void main(String[] args) {
		
		ImplementIndexOf io = new ImplementIndexOf();
		int rs = io.implIndex("hello", "elm");
		System.out.println(rs+": rs");
		
		int rs1 = io.strStr("hello", "lo");
		System.out.println(rs1+": str str");
		
		int[] n = new int[]{1,2,4};
		
		int rs2 = io.searchInsert(new int[]{6,7,8}, 5);
		System.out.println(rs2+": rs2");
		
		int rs3 = io.binarysearchInsert(new int[]{6,7,8}, 5);
		System.out.println(rs3+": rs3");
		
		
	}
	
}
