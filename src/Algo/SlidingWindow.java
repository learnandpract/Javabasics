package Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlidingWindow {
	
	   public int lengthOfLongestSubstring_BP(String s) { /// BRUTE Force O(n^3)
	        int n = s.length();
	        int res = 0;
	        for (int i = 0; i < n; i++) {
	            for (int j = i; j < n; j++) {
	                if (checkRepetition(s, i, j)) {
	                    res = Math.max(res, j - i + 1);
	                } } }
	        return res;
	    }
	    private boolean checkRepetition(String s, int start, int end) {
	        int[] chars = new int[128];
	        for (int i = start; i <= end; i++) {
	            char c = s.charAt(i);
	            chars[c]++;
	            if (chars[c] > 1) {
	                return false;
	            }
	        }
	        return true;
	    }
	    public int lengthOfLongestSubstring_SW(String s) {//pwkeww
	    	 Map<Character, Integer> map = new HashMap<>();
	         int left = 0, right = 0, counter = 0, res = 0;
	         
	         while(right<s.length()) {
	        	 char c = s.charAt(right);
	        	 map.put(c, map.getOrDefault(c, 0)+1);
	        	 if(map.get(c)>1) {
	        		 counter++;// check
	        	 }
	        	 right++;// increment for while
	        	 
	        	 while(counter>0) {
	        		 char temp = s.charAt(left); // next iteration you will get k, left index 2 
	        		 if(map.get(temp)>1)
	        			 counter--;
	        		 map.put(temp, map.get(temp)-1);//before-{p=1, e=1, w=2, k=1}, {p=0, e=1, w=2, k=1} {p=0, e=1, w=1, k=1}
	        		 left++;
	        	 }
	        	 res= Math.max(res, right-left);	// executes even when counter=0        	 
	         }	         
	         return res;	    	
	    }
	    
	    public int lengthOfLongestSubstring_sw1(String s) { //optimized
	        int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<>(); // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {
	                i = Math.max(map.get(s.charAt(j)), i);//{p=1, e=4, w=2, k=3} //{p=1, e=4, w=5, k=3}
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);
	        }
	        return ans;
	    }
	    
//	    int[] chars = new int[128];
//	    while (right < s.length()) { // from soln
//            char r = s.charAt(right);
//            chars[r]++;
//            while (chars[r] > 1) {
//                char l = s.charAt(left);
//                chars[l]--;
//                left++;
//            }
//            res = Math.max(res, right - left + 1);
//            right++;
//        }

	    public String minWindow(String s, String t) {
//	    	Input: s = "ADOBECODEBANC", t = "ABC"
//	    			Output: "BANC"
	    	String res = null;
	    	Map<Character,Integer> mp = new HashMap();
	    	for(char ch: t.toCharArray()) {
	    		mp.put(ch, mp.getOrDefault(ch,0)+1);//A=1,B=1,C=1
	    	}
	    	
	    	int left =0,right=0,counter=mp.size(),len=Integer.MAX_VALUE;
	    	int head =0;
	    	
	    	while(right<s.length()) {
	    		char ch = s.charAt(right);
	    		
	    		if(mp.containsKey(ch)) {//ADOBECODEBANC //right =6//right =11
	    			mp.put(ch, mp.get(ch)-1);//{A=0, B=1, C=1},B=0,//{A=1, B=0, C=0}, A=1, B=-1, C=0//A=0,B=-1, C=0
	    			if(mp.get(ch)==0)
	    				counter--;//2, which means u ve 2 more to match.    			
	    		}
	    		right++;
	    							//ADOBECODEBANC
	    		while(counter ==0) {//A,B,C=0 // ADOBEC , //CODEBA//ebanc
 			//move left-shave off extra unnecessary char from the string.
	    			char temp = s.charAt(left);//second- left =1 , temp = D, left =5 temp =C, counter= 1
	    			if(mp.containsKey(temp)) {
	    				mp.put(temp,mp.get(temp)+1);//{A=1, B=0, C=0}//A,B,C =0
	    				if(mp.get(temp)>0) {
	    					counter++;
	    				}
	    			}
	    			if(right-left<len) { //6-0//11-5//13-8//13-9
	    				len= right-left;
	    				head= left;	//0    				
	    			}
	    			left++;
	    		}	    		
	    	}   
	    	if(len == Integer.MAX_VALUE) return "";
	        return s.substring(head, head+len); 
	    }
	    
	    public List findAnagrams(String s, String t) {
//	    	I/p = cbaebabacd "abc" , o/p = [0,6]
	    	String res = null;
	    	Map<Character,Integer> mp = new HashMap();
	    	for(char ch: t.toCharArray()) {
	    		mp.put(ch, mp.getOrDefault(ch,0)+1);
	    	}
	    	List result = new ArrayList();
	    	int left =0,right=0,counter=mp.size(),len=Integer.MAX_VALUE;
	    	int head =0;
	    	
	    	while(right<s.length()) {
	    		char ch = s.charAt(right);
	    		
	    		if(mp.containsKey(ch)) {
	    			mp.put(ch, mp.get(ch)-1);
	    			if(mp.get(ch)==0)
	    				counter--;//2, which means u ve 2 more to match.    			
	    		}
	    		right++;
	    							
	    		while(counter ==0) {
 			//move left pointer//shave off extra unnecessary char from the string.
	    			char temp = s.charAt(left);
	    			if(mp.containsKey(temp)) {
	    				mp.put(temp,mp.get(temp)+1);
	    				if(mp.get(temp)>0) {
	    					counter++;
	    				}
	    			}
	    			if(right-left== t.length()) { 
	    				  result.add(left); 				
	    			}
	    			left++;
	    		}	    		
	    	}   
	    	
	        return result; 
	    }
	    
	    
	    public int maximumUniqueSubarray(int[] nums) {//[9,7,4,3,10,4,5,6,4,2,9]
	    int score =0;
	    
	    int left =0;
	    int right =0;
	    int sum =0;
//	    int counter=0;
	    
	   Set<Integer> st = new HashSet<>();
	    
	    while(left< nums.length  && right< nums.length) { 	
	    	if(!st.contains(nums[right])) {
	    		sum+= nums[right];
	    		score = Math.max(score , sum);	
	    		st.add(nums[right++]);	    	
	    	}else {
	    		sum = sum-nums[left]; 
	    		st.remove(nums[left++]); //[2, 3, 4, 7, 9] - [2, 3, 4, 7]
	    	}
	    	
	    	
	    }
	    	return score;
	    }
	      
	    
	public static void main(String[] args) {
		// 
		SlidingWindow sw = new SlidingWindow();
		System.out.println(sw.lengthOfLongestSubstring_sw1("pwkeww"));
//		System.out.println(sw.minWindow("ADOBECODEBANC","ABC"));
//		System.out.println(sw.findAnagrams("cbaebabacd","abc"));
		System.out.println(sw.maximumUniqueSubarray(new int [] {9,7,4,3,10,4,5,6,4,2,9}));
		

	}

}
