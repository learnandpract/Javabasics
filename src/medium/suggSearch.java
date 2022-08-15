package medium;

import java.util.*;

public class suggSearch {
	  int lower_bound(String[] products, int start, String word) {
	        int i = start, j = products.length, mid;
	        while (i < j) {
	            mid = (i + j) / 2;
	            if (products[mid].compareTo(word) >= 0)
	                j = mid;
	            else
	                i = mid + 1;
	        }
	        return i;
	    }
	public  List<List<String>> suggestedProducts(String[] products, String searchWord) {
	        Arrays.sort(products);
	        List<List<String>> result = new ArrayList<>();
	        int start = 0, bsStart = 0, n = products.length;
	        String prefix = new String();
	        for (char c : searchWord.toCharArray()) {
	            prefix += c;

	            // Get the starting index of word starting with `prefix`.
	            start = lower_bound(products, bsStart, prefix);

	            // Add empty vector to result.
	            result.add(new ArrayList<>());

	            // Add the words with the same prefix to the result.
	            // Loop runs until `i` reaches the end of input or 3 times or till the
	            // prefix is same for `products[i]` Whichever comes first.
	            for (int i = start; i < Math.min(start + 3, n); i++) {
	                if (products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix))
	                    break;
	                result.get(result.size() - 1).add(products[i]);
	            }

	            // Reduce the size of elements to binary search on since we know
	            bsStart = Math.abs(start);
	        }
	        return result;
	    }
	
	  public List<List<String>> suggestedProducts_trial(String[] products, String searchWord) {
	         Arrays.sort(products);
	        char[] swch = searchWord.toCharArray();
	        List<List<String>> mainres = new ArrayList();
	         for(int j =1; j<=searchWord.length();j++){    
	            List<String> res = new ArrayList();
	               for(int i = 0; i< products.length;i++){
	           // for(char sch:searchWord.toCharArray()){
	            //if(products[i].startsWith(Character.toString(sch))){
	              if(products[i].startsWith(searchWord.substring(0,j)) && !res.contains(products[i]) &&res.size()<3){  
	                res.add(products[i]);
	            }
	            }
	            
	         mainres.add(res);
	        }
	        return mainres;
	    }
	  
	  class Trie {
		  //https://leetcode.com/problems/search-suggestions-system/discuss/436
		  ////https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
	        Trie[] sub = new Trie[26];
	        LinkedList<String> suggestion = new LinkedList<>();
	    }
	    public List<List<String>> suggestedProducts_trie(String[] products, String searchWord) {
	        Trie root = new Trie();
	        for (String p : products) { // build Trie.
	            insert(p, root); // insert a product into Trie.
	        }
	        return search(searchWord, root);
	    }
	    private void insert(String p, Trie root) {
	        Trie t = root;
	        for (char c : p.toCharArray()) { // insert current product into Trie.
	            if (t.sub[c - 'a'] == null)
	                t.sub[c - 'a'] = new Trie();
	            t = t.sub[c - 'a'];
	            t.suggestion.offer(p); // put products with same prefix into suggestion list.
	            Collections.sort(t.suggestion);
	            if (t.suggestion.size() > 3) // maintain 3 lexicographically minimum strings.
	                t.suggestion.pollLast();        
	        }
	    }
	    private List<List<String>> search(String searchWord, Trie root) {
	        List<List<String>> ans = new ArrayList<>();
	        for (char c : searchWord.toCharArray()) { // search product.
	            if (root != null) // if there exist products with current prefix.
	                root = root.sub[c - 'a'];
	            ans.add(root == null ? Arrays.asList() : root.suggestion); // add it if there exist products with current prefix.
	        }
	        return ans;
	    }
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		suggSearch sg = new suggSearch();
		System.out.println(sg.suggestedProducts_trie(new String[] {"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
		

	}

}
