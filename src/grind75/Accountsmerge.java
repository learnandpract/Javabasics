package grind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//public class Accountsmerge {
public class Accountsmerge {
	//Whenever we must work with a set of elements (emails) that are connected 
//	(belong to the same user), we should always consider visualizing our input as a graph.
//	In this problem, converting the input into a graph will facilitate the process of "merging" two accounts.
	//https://leetcode.com/problems/accounts-merge/discuss/109157/JavaC%2B%2B-Union-Find
	//3-ways in discussion
	//below in solution*
    int parent [];
    int size [];
    
    Accountsmerge(int sz) {
    	parent = new int[sz];
        size = new int[sz];
        
        for (int i = 0; i < sz; ++i) {
            // Initially each group is its own representative
        	parent[i] = i;//[0,1,2]
            // Intialize the size of all groups to 1
            size[i] = 1;
        }
    }
    
    // Finds the representative of group x
    public int findRepresentative(int x) {
        if (x == parent[x]) {
            return x;
        }
        
        // This is path compression
        return parent[x] = findRepresentative(parent[x]);
    }
    
    // Unite the group that contains "a" with the group that contains "b"
    public void unionBySize(int p, int q) {
        int rootP = findRepresentative(p);
        int rootQ = findRepresentative(q);
        
        // If nodes a and b already belong to the same group, do nothing.
        if (rootP == rootQ) {
            return;
        }
        
        // Union by size: point the representative of the smaller // union by rank
        // group to the representative of the larger group.
        if (size[rootP] >= size[rootQ]) {
            size[rootP] += size[rootQ];
            parent[rootQ] = rootP;
        } else {
            size[rootQ] += size[rootP];
            parent[rootP] = rootQ;
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accountList) {
        int accountListSize = accountList.size();
        Accountsmerge dsu = new Accountsmerge(accountListSize);
        
        // Maps email to their component index
        Map<String, Integer> emailGroup = new HashMap<>();
        
        for (int i = 0; i < accountListSize; i++) {
            int accountSize = accountList.get(i).size();
            
            for (int j = 1; j < accountSize; j++) {
                String email = accountList.get(i).get(j);
                String accountName = accountList.get(i).get(0);
                
                // If this is the first time seeing this email then
                // assign component group as the account index
                if (!emailGroup.containsKey(email)) {
                    emailGroup.put(email, i);//{johnnybravo@mail.com=2, johnsmith@mail.com=0, john00@mail.com=1, john_newyork@mail.com=0}
                } else {
                    // If we have seen this email before then union this
                    // group with the previous group of the email
                    dsu.unionBySize(i, emailGroup.get(email));
                }
            }
        }
        
        // Store emails corresponding to the component's representative
        Map<Integer, List<String>> components = new HashMap<Integer, List<String>>();
        for (String email : emailGroup.keySet()) {//{johnnybravo@mail.com=2, johnsmith@mail.com=0, john00@mail.com=1, john_newyork@mail.com=0}
            int group = emailGroup.get(email);
            int groupRep = dsu.findRepresentative(group);
            
            if (!components.containsKey(groupRep)) {
                components.put(groupRep, new ArrayList<String>());
            }
            
            components.get(groupRep).add(email);//{1=[johnsmith@mail.com, john00@mail.com, john_newyork@mail.com], 2=[johnnybravo@mail.com]}
        }
        
        // Sort the components and add the account name
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int group : components.keySet()) {
            List<String> component = components.get(group);
            Collections.sort(component); 
            component.add(0, accountList.get(group).get(0));//[[John, johnsmith@mail.com, john_newyork@mail.com], [John, johnsmith@mail.com, john00@mail.com], [John, johnnybravo@mail.com]]
            mergedAccounts.add(component);
        }
        
        return mergedAccounts;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sln = new Solution();
		List fl = Arrays.asList(new String[] {"John","johnsmith@mail.com","john_newyork@mail.com"});
		List sl = Arrays.asList(new String[] {"John","johnsmith@mail.com","john00@mail.com"});
		List tl = Arrays.asList(new String[] {"John","johnnybravo@mail.com"});
		
		List<List<String>> all = new ArrayList<List<String>>();
		all.add(fl);
		all.add(sl);
		all.add(tl);
		sln.accountsMerge(all);
	}

}
