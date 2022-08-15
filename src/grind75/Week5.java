package grind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Week5 {
	
	 public void sortColors(int[] nums) {
//       Input: nums = [2,0,1]
//       Output: [0,1,2]
   int num1 =0;
   int num2 =0;
   int num0 =0;
   
    	for(int i=0;i< nums.length;i++) {
    		if(nums[i]==0) 
    		  num0++;
    		if(nums[i]==1)
    			num1++;
    		if(nums[i]==2)
    			num2++;
    		
    	}    	
    	for(int i=0;i<nums.length;i++) {
    		if(i<num0)
    			nums[i] =0;
    		else if(i<num1+num0)
    			nums[i]=1;
    		else 
    			nums[i]=2;	    		
    	}
   
         System.out.println(Arrays.toString(nums)+" nums array");   
  }
	 void sortColors_1p(int A[]) {
		int n= A.length;
		    int n0 = -1, n1 = -1, n2 = -1;
		    for (int i = 0; i < n; ++i) {//{2,0,2,1,1,0}
		        if (A[i] == 0) 
		        {
		            A[++n2] = 2;//[2, 2, 2, 1, 1, 0]// n2 was 0 in first [0, 1, 1, 2, 2, 2]
		            A[++n1] = 1;//[1, 2, 2, 1, 1, 0]					 [0, 1, 1, 1, 2, 2]
		            A[++n0] = 0;//[0, 2, 2, 1, 1, 0]					 [0, 0, 1, 1, 2, 2]
		        }
		        else if (A[i] == 1) 
		        {
		            A[++n2] = 2; //[0, 2, 2, 2, 1, 0]
		            A[++n1] = 1; //[0, 1, 2, 2, 1, 0] [0, 1, 1, 2, 2, 0]
		        }
		        else if (A[i] == 2) 
		        {
		            A[++n2] = 2;//[2, 0, 2, 1, 1, 0] [0, 2, 2, 1, 1, 0]
		        }
		    }
		    System.out.println(Arrays.toString(A)+" nums array");   
		}
public void swap(int[] nums,int i , int j) {
	int temp = nums[i];
	nums[i]=nums[j];
	nums[j]=temp;	
	
}

public List<List<Integer>> combinationSum(int[] candidates, int target) {
//	 candidates = [2,3,6,7], target = 7 --Output: [[2,2,3],[7]]
	 List<List<Integer>> res = new ArrayList();	
    backtrack(res,new ArrayList(),candidates,0,target );
    return res;
}

public void backtrack(List<List<Integer>> res, List tempList,int [] candidates, int start, int rem) {
	if(rem<0)
		return;
	else if (rem==0) {
		//res.add(tempList);does not work, need to create new list
		res.add(new ArrayList<>(tempList));
	}	else {	
	for(int i = start; i< candidates.length;i++) {
	//	rem = rem -candidates[i]; does not work , send it directly at backtrack
		tempList.add(candidates[i]);
		backtrack(res,tempList,candidates, i,rem -candidates[i]);
		tempList.remove(tempList.size()-1);		
	}
	}
	
}
public int myAtoi(String str) {
    int index = 0, sign = 1, total = 0;
    if(str.length() == 0) return 0;

    while(index < str.length() && str.charAt(index) == ' ')
        index++;

    if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
        sign = str.charAt(index) == '+' ? 1 : -1;
        index++;
    }
    
    if(index < str.length() && !Character.isDigit(str.charAt(index))) return 0;
    
    int result = 0;
    while(index < str.length()) {
        if(!Character.isDigit(str.charAt(index))) break;
        char current = str.charAt(index++);
        int previous = result;
        result *= 10;
        if(previous != result/10) {
            return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
//Case 1: If the current number is less than INT_MAX / 10 = 214748364, we can append any digit, and the new number will always be less than INT_MAX.
//Case 2: If the current number is more than INT_MAX / 10 = 214748364, appending any digit will result in a number greater than INT_MAX.
        }
        result += (current - '0');
        if(result < 0) {
            return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
    return result * sign;
}
	 

public List<List<String>> accountsMerge_notowrking(List<List<String>> accounts) { //721
	//[["John","johnsmith@mail.com","john_newyork@mail.com"],
//	   ["John","johnsmith@mail.com"]]
	Map<String,HashSet<String>> mp = new HashMap<>();
	List<List<String>> res = new ArrayList();
	for(int i =0; i< accounts.size();i++) {
		 HashSet<String> hs = new HashSet<>();		
		 Boolean seen = false;
		 for(int j =1; j< accounts.get(i).size();j++) {
				hs.add(accounts.get(i).get(j));
		 }
		if(mp.containsKey(accounts.get(i).get(0))){
			for(String st :hs) {
				if(mp.get(accounts.get(i).get(0)).contains(st) || seen) {
					seen = true;
					mp.get(accounts.get(i).get(0)).add(st);					
				}				
			}			
			if(!seen) {				
					mp.put(accounts.get(i).get(0),hs);					
			}
			seen = false;
		}else{			  
				   mp.put(accounts.get(i).get(0),hs);
				
		}		
	}	
	return res;
    
}

public List<List<String>> accountsMerge(List<List<String>> accounts) {
//	First create an undirected adjacency list of (email -> Set(email)) where two emails are connected if they belong to the same account.
//	Maintain that graph, and also another email -> name mapping that'll be useful later for returning.
//	Then do a DFS through the emails available (use the email -> name mapping for ease).
//	Connected components will be collected in each DFS run. Use TreeSet to collect the emails so that you don't have to sort it in the end.

    Map<String, Set<String>> graph = new HashMap<>();  //<email node, neighbor nodes>
    Map<String, String> name = new HashMap<>();        //<email, username>
    // Build the graph;
    for (List<String> account : accounts) {
        String userName = account.get(0);
        for (int i = 1; i < account.size(); i++) {
            if (!graph.containsKey(account.get(i))) {
                graph.put(account.get(i), new HashSet<>());
            }
            name.put(account.get(i), userName);
//{johnnybravo@mail.com=John, johnsmith@mail.com=John, john00@mail.com=John, john_newyork@mail.com=John}
            
            if (i == 1) continue;
            graph.get(account.get(i)).add(account.get(i - 1));
            graph.get(account.get(i - 1)).add(account.get(i));
//graph={johnnybravo@mail.com=[], johnsmith@mail.com=[john00@mail.com, john_newyork@mail.com], john00@mail.com=[johnsmith@mail.com], john_newyork@mail.com=[johnsmith@mail.com]}
        }
    }
    
    Set<String> visited = new HashSet<>();
    List<List<String>> res = new LinkedList<>();
    // DFS search the graph;
    for (String email : name.keySet()) {
        List<String> list = new LinkedList<>();
        if (visited.add(email)) {
            dfs(graph, email, visited, list);
            Collections.sort(list);
            list.add(0, name.get(email));
            res.add(list);
        }
    }
    
    return res;
}

public void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
    list.add(email);
    for (String next : graph.get(email)) {
        if (visited.add(next)) {
            dfs(graph, next, visited, list);
        }
    }
}

public List<List<String>> accountsMerge_UF(List<List<String>> acts) {
    Map<String, String> owner = new HashMap<>();
    Map<String, String> parents = new HashMap<>();
    Map<String, TreeSet<String>> unions = new HashMap<>();
    for (List<String> a : acts) {
        for (int i = 1; i < a.size(); i++) {
            parents.put(a.get(i), a.get(i));//{johnnybravo@mail.com=johnnybravo@mail.com, johnsmith@mail.com=johnsmith@mail.com, john00@mail.com=john00@mail.com, john_newyork@mail.com=john_newyork@mail.com}
            owner.put(a.get(i), a.get(0));//{johnnybravo@mail.com=John, johnsmith@mail.com=John, john00@mail.com=John, john_newyork@mail.com=John}
        }
    }
    for (List<String> a : acts) {
        String p = find(a.get(1), parents);
        for (int i = 2; i < a.size(); i++)
            parents.put(find(a.get(i), parents), p);//{johnnybravo@mail.com=johnnybravo@mail.com, johnsmith@mail.com=johnsmith@mail.com, john00@mail.com=johnsmith@mail.com, john_newyork@mail.com=johnsmith@mail.com}
    }
    for(List<String> a : acts) {
        String p = find(a.get(1), parents);
        if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
        for (int i = 1; i < a.size(); i++)
            unions.get(p).add(a.get(i));//{johnnybravo@mail.com=[johnnybravo@mail.com], johnsmith@mail.com=[john00@mail.com, john_newyork@mail.com, johnsmith@mail.com]}
    }
    List<List<String>> res = new ArrayList<>();
    for (String p : unions.keySet()) {
        List<String> emails = new ArrayList(unions.get(p));
        emails.add(0, owner.get(p));
        res.add(emails);
    }
    return res;
}
private String find(String s, Map<String, String> p) {
    return p.get(s) == s ? s : find(p.get(s), p);
}
public int[][] merge(int[][] intervals) { // overlapping
//	https://leetcode.com/discuss/general-discussion/794725/General-Pattern-for-greedy-approach-for-Interval-based-problems/658450
//	Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//			Output: [[1,6],[8,10],[15,18]]	
	List<int []> ls = new ArrayList();
	Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0], i2[0]));
	
	int[] prev = intervals[0]; // pointer for previous
	
	for(int i =1; i< intervals.length;i++) {		
			int[] current = intervals[i]; // get the current to compare with previous
	        if(prev[1]>current[0]) { //[1,3],[2,6] = [1,6]
	        	prev[1] = Math.max(prev[1],current[1] ); // new prev
	        }else {
	        	ls.add(prev);
	        	prev= current;
	        }
	}	
	ls.add(prev);
	return ls.toArray(new int[ls.size()][]);
    
}
public boolean wordBreak(String s, List<String> wordDict) {//139 DP, from soln - O(n^3) can also do bfs
    Set<String> wordDictSet = new HashSet<>(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
        for (int j = 0; j < i; j++) {
            if (dp[j] && wordDictSet.contains(s.substring(j, i))) {//dp[j]== firstone
                dp[i] = true;
                break;
            }
        }
    }
    return dp[s.length()];
}


	public static void main(String[] args) {
		Week5 wk = new Week5();
//		wk.sortColors_1p(new int[] {2,0,2,1,1,0});
//		System.out.println(wk.myAtoi(" 12 4"));
		List fl = Arrays.asList(new String[] {"John","johnsmith@mail.com","john_newyork@mail.com"});
		List sl = Arrays.asList(new String[] {"John","johnsmith@mail.com","john00@mail.com"});
		List tl = Arrays.asList(new String[] {"John","johnnybravo@mail.com"});
		
		List<List<String>> all = new ArrayList<List<String>>();
		all.add(fl);
		all.add(sl);
		all.add(tl);
//		wk.accountsMerge(all);
//		System.out.println(wk.combinationSum(new int[] {2,3,6,7}, 7));
//		System.out.println(Arrays.deepToString(wk.merge(new int [][] {{1,3},{2,6},{8,10},{15,18}})));
		
		System.out.println(wk.wordBreak("leetcode", Arrays.asList(new String []{"leet","code"})));
	}

}
