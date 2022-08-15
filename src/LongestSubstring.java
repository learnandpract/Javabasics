import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {
	public int chkLong(String entireSeq) {
		// not correct
		String longSeq= null;
		char a[] =  entireSeq.toCharArray();
		HashMap<Character,Integer> mp = new HashMap<Character,Integer>();
		
		int counter = 0;int longest =0;
		
		for(int i =0;i<a.length; i++) {
			if(mp.containsKey(a[i])) {
				if(counter>longest) {
					longest = counter;
					counter =0;
				}	
			}
				mp.put(a[i], counter++);	
									
			}	
			if(counter>longest) {
					longest = counter;
										
				}		
		return longest;
		
	}
	
	 public int lengthOfLongetSubstring(String s) {// med 3 - substring Without Repeating Characters
		   // the right one from lc // you can also use SLIDING WINDOW
//		 Input: s = "pwwkew"
//		 Output: 3  Explanation: The answer is "wke", with the length of 3.		 
	        if (s.length()==0) return 0;
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        int longest=0;
	        for (int i=0, counter=0; i<s.length(); ++i){
	            if (map.containsKey(s.charAt(i))){
	            	System.out.println(map.get(s.charAt(i))+" mp get charat i ");
	            	counter = Math.max(counter,map.get(s.charAt(i))+1);
	            
	            }
	            map.put(s.charAt(i),i);
	            longest = Math.max(longest,i-counter+1);
//	            if(longest<i-counter+1){
//	            longest = i-counter+1;
//	            }	           
	        }
	        return longest;
	    }
	   public int lengthOfLongestSubstring(String s) {
		   // the right one from lc
		   //s="abcabcbb" , 3
	        if (s.length()==0) return 0;
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        int max=0;
	        for (int i=0, j=0; i<s.length(); ++i){
	            if (map.containsKey(s.charAt(i))){
	            	System.out.println(map.get(s.charAt(i))+" mp get charat i ");
	                j = Math.max(j,map.get(s.charAt(i))+1);
	                System.out.println(j +":j "+ "when i = "+i);
	            }
	            map.put(s.charAt(i),i);
	            max = Math.max(max,i-j+1);
	        }
	        return max;
	    }
	   
	   public boolean anagram(String s, String t) {//242 original arrays sort = O(nlogn) 
		   char[] schar = s.toCharArray();
		   char[] tchar = t.toCharArray();
		   
		   Arrays.sort(schar);
		   Arrays.sort(tchar);
		   
		   for(int i =0; i<schar.length;i++) {
			   if(schar[i]!=tchar[i]) {
				   return false;
			   }
		   }		   
		   
		return true;   
	   }
	   
	   public boolean isAnagram(String s, String t) {//242 from lc discussion
	        if (s==null && t==null) return true;
	        else if (s==null || t==null) return false;
	        else if (s.length() != t.length()) return false;
	        
	        Map<Character, Integer> dict = new HashMap<>();
	        for(char c : s.toCharArray())
	        	dict.put(c, dict.getOrDefault(c, 0) + 1);
	        for(char c : t.toCharArray()) {
	            int count = dict.getOrDefault(c, 0);
	            if (count == 0) return false;
	            else dict.put(c, count - 1);
	        }
	        
	        return true;
	    }
	   
	   public boolean isAnagram_lc(String s, String t) {
	        int[] alphabet = new int[26];
	        for (int i = 0; i < s.length(); i++)
	        	alphabet[s.charAt(i) - 'a']++;
	        for (int i = 0; i < t.length(); i++)
	        	alphabet[t.charAt(i) - 'a']--;
	        for (int i : alphabet) 
	        	if (i != 0)
	        		return false;
	        return true;
	    }
	   
	   public boolean wordPattern(String pattern , String s) {
		   char[] ch = pattern.toCharArray();

		   String[] words = s.split(" ");
		   Map mp = new HashMap();
		   if(ch.length!= words.length) {
			   return false;
		   }
		   
		   for(int i = 0; i<ch.length; i++) {
			   if(mp.containsKey(ch[i])|| mp.containsValue(words[i])) {
			   if(!words[i].equals(mp.get(ch[i]))) {
				   return false;
			   }
			   }else {
			   mp.put(ch[i], words[i]);	
			   }
		   }		   
		   return true;
		   
	   }
	   
	   public char[] reverseString(char[] s) {//344
		   char[] t = new char[s.length];
		   for(int i = s.length-1 ; i>=0; i--) {
			   t[s.length-1-i] = s[i];	
		   }
		   return t;
	   }
//	    for(int i=0; i<s.length/2; i++){ //344, reverse   //Do it half the number of String length
//            char tmp = s[i];
//            s[i] = s[s.length-1-i];     //Front swap with other End side 
//            s[s.length-1-i] = tmp;      //End swap with other Front side
//        }
	   
	   public String reverseVowels(String s) {  //345 reverse vowels
//		   "helloji" => "hilloje"
		   if(s == null || s.length()==0) return s;
		    String vowels = "aeiouAEIOU";
		    char[] chars = s.toCharArray();
		    int start = 0;
		    int end = s.length()-1;
		    while(start<end){
		    	System.out.println(chars[start]+" chars[start]");
		        
		        while(start<end && !vowels.contains(chars[start]+"")){
		            start++;
		        }
		        
		        while(start<end && !vowels.contains(chars[end]+"")){
		            end--;
		        }
		        
		        char temp = chars[start];
		        chars[start] = chars[end];
		        chars[end] = temp;
		        
		        start++;
		        end--;
		    }
		    return new String(chars);
		}
	   
	   public boolean canConstruct(String ransomNote, String magazine) { //383
//		   ransomNote = "aa", magazine = "aab"
		   // aa can be constructed from aab - return true
//		   "aab"  "baa" - true
		   int[] table = new int[26];
		   for(char c : magazine.toCharArray()) {
			   table[c - 'a']++;
		   }
		   for (char c : ransomNote.toCharArray()) 
			   if (--table[c - 'a'] < 0)
				   return false;
		   
		   
		   return true;
	        
	    }
	   public boolean canConstruct3(String ransomNote, String magazine) {//383 , isAnagram 
		    Map<Character, Integer> map = new HashMap<>();
		    for (char c : magazine.toCharArray()) {
		        int count = map.containsKey(c) ? map.get(c) + 1 : 1;
		        map.put(c, count);// mp.put(c,map.getorDefault(c,0)+1)
		    }
		    for (char c : ransomNote.toCharArray()) {
		        int newCount = map.containsKey(c) ? map.get(c) - 1 : -1;
		        if (newCount == -1) return false;
		        map.put(c, newCount);
		    }
		    return true;
		}
	        
	   
		public int firstUniqChar(String s) { //387
		    //s = "loveleetcode" , o/p = 2	
//		char[] sc = s.toCharArray();
			Map<Character, Integer> mp = new LinkedHashMap<>();//HashMap does not guarantee the insertion order. Use LinkedHashMap to keep the order intact.
			Set setch = new HashSet(); // set is added for uses cases like "aaa"
		
		for(int i = 0; i<s.length();i++) {
			if(setch.contains(s.charAt(i))) {
				mp.remove(s.charAt(i));				
			}else {
				mp.put(s.charAt(i), i);
				setch.add(s.charAt(i));
			}
		
		}
		
			return mp.size()==0?-1: mp.entrySet().iterator().next().getValue();// gets the first one        
		}
		public int firstUniqChar1(String s) { // 387
	        int freq [] = new int[26];
	        for(int i = 0; i < s.length(); i ++)
	            freq [s.charAt(i) - 'a'] ++;
	        for(int i = 0; i < s.length(); i ++)
	            if(freq [s.charAt(i) - 'a'] == 1)
	                return i;
	        return -1;
	    }
		
//		using array  - to find the difference
		public char findiff(String s, String t) { //389
//			Input: s = "abcd", t = "abcde"
//					Output: "e"
			int[] arr = new int[26];
			 for (char c : s.toCharArray())			
				 arr[ c - 'a' ]++; // a=97, c-a = (97-97)++ , first ele = 0, second ele = 98-97 ,
			 for (char c : t.toCharArray()) {		          
		            if (--arr[c - 'a'] < 0) //-1
		                return c;
		        }
			
			return 0;
		}
		
		
	    public boolean wordBreak(String s, List<String> wordDict) {
	    	// 139, medium
//	    	"leetcode" , dict = [leet code]
	    	Set wordset = new HashSet<>(wordDict);
	    	return wb(s,wordset);
	    		    
	    }
	   
	    public boolean wb(String s, Set wordset) {
	    	int len = s.length();
	    	if(len==0)
	    		return true;
	    	for(int i = 1; i<= s.length();++i) {
	    		if(wordset.contains(s.substring(0,i)) && wb(s.substring(i),wordset) ) {
	    //wb(s.substring(i),wordset) is invoked only after the first condition holds good
	    			return true;
	    		}		
	    	}
	    	
	    	return false;
	    }
	    public List<List<String>> partition(String s) { //131 , medium 
//	    	Input: s = "aab" // return the palindromic substrings
//	    	Output: [["a","a","b"],["aa","b"]]
	    	List<List<String>> ansList = new ArrayList<List<String>>();
	    	List subsList = new ArrayList();	
	    	StringBuffer subs = null;
	    	for(int j = 0 ; j<s.length();j++) {
	    		subs = subs.append(s.charAt(j)) ;
	    		if(isPalindrome(subs)) {
	    			subsList.add(subs);
	    		}
	    	}	    	 		    	
	    	return ansList;
	    } 
	    
	    public boolean isPalindrome(StringBuffer subs) {	    
	    for(int i =0; i< subs.length();i++) {
	    	if(subs.charAt(i)!=subs.charAt(subs.length()-1)) {
				return false;
			}
	    }
	    	return true;
		}
	    
	    public List<List<String>> partitionlc(String s) {
	        List<List<String>> result = new ArrayList<List<String>>();
	        dfs(0, result, new ArrayList<String>(), s);
	        return result;
	    }

	    void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
	        if (start >= s.length()) result.add(new ArrayList<String>(currentList));
	        for (int end = start; end < s.length(); end++) {
	            if (isPalindromelc(s, start, end)) {
	                // add current substring in the currentList
	                currentList.add(s.substring(start, end + 1));
	                dfs(end + 1, result, currentList, s);
	                // backtrack and remove the current substring from currentList
	                currentList.remove(currentList.size() - 1);
	            }
	        }
	    }

	    boolean isPalindromelc(String s, int low, int high) {
	        while (low < high) {
	            if (s.charAt(low++) != s.charAt(high--)) return false;
	        }
	        return true;
	    }
	    
	public static void main(String[] args) {//
		LongestSubstring ls = new LongestSubstring();
		
//		int rtrnedSeq = ls.chkLong("abcabcbb"); // incorrect
//		int rtrnedSeq1 = ls.lengthOfLongestSubstring("abcabcbb");		
//		int rtrnedSeq = ls.chkLong("pwwkewke"); // incorrect
//		int rtrnedSeq1 = ls.lengthOfLongestSubstring("pwwkewke");
//		System.out.println(rtrnedSeq1);//correct 4
//		System.out.println(rtrnedSeq+" : rtrnedSeq");
//		System.out.println(ls.isAnagram("abba","aabb"));
		
//		
//		boolean bp = ls.wordPattern("abba","dog cat cat dog");
//		System.out.println(bp);
//		System.out.println(ls.reverseVowels("helloji"));
//		ls.canConstruct("aa", "aab");
		int i = ls.firstUniqChar("aaabc");
		System.out.println(i+" ::first unique char");
//		System.out.println(ls.findiff("abcd", "abcde")+" ::find diff");
//		String s = "leetcode";
//		System.out.println(s.substring(0,2)+" : substring");
//		ls.partitionlc("abba");
		
	}

}
