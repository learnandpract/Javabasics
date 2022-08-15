package hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//handles the more complex situation by avoiding adding the duplicated sub-sequence straight out
public class DistrintSubseq {
	 public int distinctSubseqII(String S) {
		 int n = S.length();
		 int M = (int)1e9 + 7;
		 
	        int[] count = new int[26];
	        int sum = 0;
	        for (int i = 0; i < n; i++) {
	            int index = S.charAt(i) - 'a';
	            int cur = (1 + sum - count[index] + M) % M;
	            sum = (sum + cur) % M;
	            count[index] = (count[index] + cur) % M;
	        }
	        return sum;
	    }
	 
	 public int distinctSubseq(String S) {
	       final int mod = 1_000_000_007; // java features
	       
	       // use map to remove duplicate counts
	       Map<Character, Integer> map = new HashMap<>();
	       int n = S.length();
	       
	       // sub-problem: dp[i] represents number of distinct subsequence until from 0 to i
	       int[] dp = new int[n + 1];

	       /* base case: assign empty string to dp[0], because when we concat every new character we should not only concat it to each previous string to form a new string, but also itself */
	       /* (concat with " " represents itself) */
	       dp[0] = 1; // " "

	       for (int i = 1; i < n + 1; i++) {
	           /** every time when we traverse to a new character, we should form some new strings by concat previous
	            * strings with new character, so we will have two options: use it or does not use it 
	            * for dp[i], 
	            * if we use new character, we will have new dp[i - 1] number of new string, 
	            * if we do not use new character, we also have dp[i - 1] different strings 
	            * so the total number of dp[i] should be (dp[i - 1] * 2) % mod */
	           dp[i] = (dp[i - 1] * 2) % mod;
	           
	           /** if current character has already been seen before, we will have some duplicate count if we simply
	            * use the equation dp[i - 1] * 2. so we need to find the previous position of current character, and 
	            * then subtract total number of different string that formed by previous same character to remove duplicate*/
	           if (map.containsKey(S.charAt(i - 1))) {
	               /* WARNING: in order to avoid negative number, we have to add an extra mod value in the bracket */
	               dp[i] = (dp[i] - dp[map.get(S.charAt(i - 1))] + mod) % mod;
	           }
	           map.put(S.charAt(i - 1), i - 1);
	       }
	       /* WARNING: DO NOT FORGET to subtract the empty string that we initialized in base case */
	       return dp[n] - 1;
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistrintSubseq ds = new DistrintSubseq();
		System.out.println(ds.distinctSubseqII("abcb"));//abcb =13 , abcx =15
		
		String s = "[abc]";
		s=s.replaceAll("\\[","");
		s=s.replaceAll("\\]","");
		System.out.print(s);

	}

}
