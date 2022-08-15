package hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
//	Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//			Output: 5
//	Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
	public int ladderLength_1(String beginWord, String endWord, Set<String> wordList) {
		Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

		int len = 1;
		int strLen = beginWord.length();
		HashSet<String> visited = new HashSet<String>();
		
		beginSet.add(beginWord);//hit
		endSet.add(endWord);//cog
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}

			Set<String> temp = new HashSet<String>();
			for (String word : beginSet) {
				char[] chs = word.toCharArray();

				for (int i = 0; i < chs.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char old = chs[i];
						chs[i] = c;
						String target = String.valueOf(chs);

						if (endSet.contains(target)) {
							return len + 1;
						}

						if (!visited.contains(target) && wordList.contains(target)) {
							temp.add(target);
							visited.add(target);
						}
						chs[i] = old;
					}
				}
			}

			beginSet = temp;
			len++;
		}
		
		return 0;
	}
//	 beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		 Queue<String> queue = new LinkedList<String>();
		    queue.add(beginWord);
		    int level = 0;
		    while(!queue.isEmpty()){
		        int size = queue.size();
		        for(int i = 0; i < size; i++){
		            String cur = queue.remove();
		            if(cur.equals(endWord)){
		            	return level + 1;
		            	}
		            for(int j = 0; j < cur.length(); j++){
		                char[] word = cur.toCharArray();
		                for(char ch = 'a'; ch < 'z'; ch++){
		                    word[j] = ch;
		                    String check = new String(word);
		                    if(!check.equals(cur) && wordList.contains(check)){
		                        queue.add(check);
		                        wordList.remove(check);
		                    }
		                }
		            }
		        }
		        level++;
		    }
		    return 0;	
	
	}
	
	   public int minMutation(String start, String end, String[] bank) {
//		   Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
//				   Output: 3
		   char[] ct = new char[]{'A','C','G','T'};
		   Set bankSet = new HashSet();
		   int level = 0;
		   
		   for(int i = 0; i<bank.length;i++ ) {
			   bankSet.add(bank[i]);		   
			  }
		   Queue que = new LinkedList<>();
		   que.add(start);
		   
		   while(!que.isEmpty()) {
			   String current = (String) que.remove();
			   if(current.equals(end)) {
				   return level;
			   }
			   for(int j = 0; j< current.length();j++) {
				   char[] word = current.toCharArray();
			       for(int k = 0; k< ct.length;k++) {
			    	   word[j]= ct[k];
			    	   String ch = new String(word);
			    	   if(!ch.equals(current) && bankSet.contains(ch)) {
			    		   que.add(ch);
			    		   bankSet.remove(ch);
			    	   }
			       }				   
			   }
			   level++;
		   }		
		   return 0;
	   }
	public static void main(String a[]) {
		WordLadder wl = new WordLadder();
		Set<String> wordList = new HashSet();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		
//		System.out.println(wl.ladderLength_1("hit", "cog", wordList));
//		"hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
		
		System.out.println(wl.minMutation("AAAAACCC","AACCCCCC",new String[] {"AAAACCCC","AAACCCCC","AACCCCCC"}));
	}
}
