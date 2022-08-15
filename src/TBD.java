import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class TBD {
	
	
	  public int minSteps(String s, String t) {// s = "bab", t = "aba", O/P = 1
		  int step = 0; // does not work, orig
		  
		  char[] sch = s.toCharArray();
		  
		  char[] tch = t.toCharArray();
		  
		  Arrays.sort(sch);//[c, d, e, e, e, l, o, t]
		  Arrays.sort(tch);//[a, c, c, e, i, p, r, t]
		  
		  for(int i = 0; i< sch.length;i++) {
			  if(sch[i]!=tch[i]) {
				  step++;
			  }			  
		  }  		  
		  return step;
	        
	    }
	  
	  public int minSteps_1(String s, String t) { //lc
	        int n = s.length(), ans = 0;
	        int[] arr = new int[26];
	        for(int i = 0; i < n; i++) {
	            arr[s.charAt(i) - 'a']++;
	            arr[t.charAt(i) - 'a']--;
	        }
	        for(int i = 0; i < 26; i++) if(arr[i] > 0) ans += arr[i];
	        return ans;
	    }
	 
	    public int[] findOriginalArray_1(int[] A) { // from lc
	        int n = A.length, i = 0;
	        if (n % 2 == 1) return new int[0];
	        int[] res = new int[n / 2];
	        Map<Integer, Integer> count = new TreeMap<>(); // sorts
	        for (int a : A) //1,3,4,2,6,8
	            count.put(a, count.getOrDefault(a, 0) + 1); //{1=1, 2=1, 3=1, 4=1, 6=1, 8=1}
	        for (int x : count.keySet()) {
	            if (count.get(x) > count.getOrDefault(x + x, 0))
	                return new int[0];
	            for (int j = 0; j < count.get(x); ++j) {
	                res[i++] = x;
	                count.put(x + x, count.get(x + x) - 1); //{1=1, 2=0, 3=1, 4=1, 6=1, 8=1}
	            }
	        }
	        return res;
	    }
	    
	    public boolean backspaceCompare_1(String s, String t) {
	    	return formatString(s).equals(formatString(t));
	    }
	    public String formatString(String s) {
	        //s = "ab#c", t = "ad#c"
	        StringBuilder s1= new StringBuilder(s);
	  	        int count = 0;
	        for(int i = 0; i< s.length();i++){
	        	count++;
	            if(s.charAt(i)=='#'){
	                 count--;
	                 s1.deleteCharAt(count);
	            
	            if(count>0){
	            	 count--;
	                 s1.deleteCharAt(count);
	            	
	            }
	            }	            
	        }
	        return s1.toString();
	    }
	    
//	    public String formatString(String s) {
//	    	  StringBuilder s1= new StringBuilder();
//	    	for(int i = 0; i< s.length();i++){                                  
//	            if(s.charAt(i)=='#'){
//	                 s1= new StringBuilder(s1.substring(0,s1.length()-1);
//	            }else{
//	                s1= s1.append(s.charAt(i));
//	            }
//	    }   
//	        return s1.toString();
//	    }
	    
	    public boolean backspaceCompare(String S, String T) {
	        return build(S).equals(build(T));
	    }

	    public String build(String S) {
	        Stack<Character> ans = new Stack();
	        for (char c: S.toCharArray()) {
	            if (c != '#')
	                ans.push(c);
	            else if (!ans.empty())
	                ans.pop();
	        }
	        return String.valueOf(ans);
	    }
	    
	    public boolean backspaceCompare_2(String S, String T) {
	        int i = S.length() - 1, j = T.length() - 1, back;
	        while (true) {
	            back = 0;
	            while (i >= 0 && (back > 0 || S.charAt(i) == '#')) {
	                back += S.charAt(i) == '#' ? 1 : -1;
	                i--;
	            }
	            back = 0;
	            while (j >= 0 && (back > 0 || T.charAt(j) == '#')) {
	                back += T.charAt(j) == '#' ? 1 : -1;
	                j--;
	            }
	            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
	                i--;
	                j--;
	            } else {
	                break;
	            }
	        }
	        return i == -1 && j == -1;
	    }
	    public boolean wordBreak(String s, List<String> wordDict) {
//	    	Input: s = "leetcode", wordDict = ["leet","code"]
//	    			Output: true
	    HashSet set = new HashSet(wordDict);
	    return wb(s,set);
	        
	    }
	    public boolean wb(String s, HashSet set) {
	        if (s.length() == 0) {
	            return true;
	        }
	    	
	    	for(int i = 1 ; i<=s.length();i++) {
	    		if(set.contains(s.substring(0,i)) && wb(s.substring(i),set)){
	    			return true;
	    			
	    		}
	    	}
	    	
	    	return false;
	    }
	    
	    public boolean validMountainArray(int[] arr) {
//	    	int ;
	    	int i =0;
	      while(i+1 < arr.length && arr[i]<arr[i+1]) 
	    		  i++;
	     if (i == 0 || i == arr.length-1)
		       return false;
	       while(i+1 < arr.length && arr[i]>arr[i+1]) 
	    		  i++;
	    	      	
	          	
	    	return i==arr.length-1;	    	
	    }
	    
	    public boolean isHappy(int n) {
	        //n = 19
	    	while(n>=1) {
	    		int sumsq=0;
	    		while(n>=0) {
	    		int x= n%10; //x =9
	    		//n=n/10; //n=1
	    		n=n/10;
	    		sumsq+=Math.pow(x, 2);
	    		}
	    		n=sumsq;	    		
	    	}
	    	
	    	return n==1;
	    }
	    
	    public void findComplement(int num) {
	        int n = 0;
	        while (n < num) {
	            n = (n << 1) | 1;
	        }
	        System.out.print(n);
	    }
	    
	    

	public static void main(String[] args) {
	 TBD td = new TBD();
//	 System.out.println(td.maxProfit(new int[]{7,1,5,3,6,4}));
//	  String word = "rock";
//	  String word2 = word.replace('r', 'd');
//	  System.out.println(word+" : word");
//       System.out.println(word2+" : word2");
//       StringBuilder builder = new StringBuilder("rock");
//       builder.replace(0, 1, "d");
//       System.out.println(builder+": builder");
//	 td.findOriginalArray_1(new int[] {1,3,4,2,6,8});
//	 System.out.println(td.minSteps_1("leetcode", "practice"));
//	 System.out.println(td.backspaceCompare_2("ab#c", "ad#c"));//"ab#c", "ad#c"
//	 "ab##", "c#d#"
	 List<String> wordDict = new ArrayList();
	 wordDict.add("apple");
	 wordDict.add("pen");
//	 System.out.println(td.wordBreak("applepenapple",wordDict));
	 
//	 System.out.println(td.validMountainArray(new int[] {9,8,7,6,5,4,3,2,1,0}));
	 
//       System.out.println("leet".indexOf(wordDict.get(0)));
	//td.findComplement(4);
	 HashSet st = new HashSet();

	}


	

}
