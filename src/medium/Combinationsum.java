package medium;

import java.util.*;

public class Combinationsum {
//	Input: candidates = [2,3,6,7], target = 7
//			Output: [[2,2,3],[7]]
	
	// list | target
	// [2]  | 7-2 =5
	// [2,2]| 5-2 =3
	// [2,2,3] -> add to res , remove previous added val
	
	
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
		 List<List<Integer>> res = new ArrayList();	
		 Arrays.sort(candidates);//?
		 bactrack(res,new ArrayList(),candidates,0,target);
	     return res;
	        
	    }
	 public void bactrack(List<List<Integer>> res, List temp,int[] candidates,int start, int rem ){
		 if(rem < 0) return; 
		 else if(rem ==0) {
			 res.add(new ArrayList<>(temp));
		 }else {
		 for(int i =start;i< candidates.length;i++) {			
			 temp.add(candidates[i]);
			 bactrack(res,temp,candidates,i,rem - candidates[i]);
			 temp.remove(temp.size()-1);
		 }
		 }	 
		 
	 }
	 
	 public List<List<Integer>> combinationSum_dp(int[] candidates, int target) {
	        // sort candidates to try them in asc order
	        Arrays.sort(candidates); 
	        // dp[t] stores all combinations that add up to t
	        List<List<Integer>>[] dp = new ArrayList[target+1];  
	        // build up dp
	        for(int t=0; t<=target; t++) {
	            // initialize
	            dp[t] = new ArrayList();
	            // initialize
	            List<List<Integer>> combList = new ArrayList();
	            
	            // for each t, find possible combinations
	            for(int j=0; j<candidates.length && candidates[j] <= t; j++) {
	                if(candidates[j] == t) {
	                    combList.add(Arrays.asList(candidates[j])); // itself can form a list
	                } else {
	                    for(List<Integer> prevlist: dp[t-candidates[j]]) { // here use our dp definition
	                        // i thought it makes more sense to compare with the last element
	                        // only add to list when the candidates[j] >= the last element
	                        // so the list remains ascending order, can prevent duplicate (ex. has [2 3 3], no [3 2 3])
	                        // equal is needed since we can choose the same element many times   
	                        if(candidates[j] >= prevlist.get(prevlist.size()-1)){
	                            List temp = new ArrayList(prevlist); // temp is needed since 
	                            temp.add(candidates[j]); // cannot edit prevlist inside 4eeach looop
	                            combList.add(temp);
	                        }
	                    }
	                }
	            }
	            dp[t] = combList;
	        }
	        return dp[target];
	    }    
	 
	 
	public static void main(String[] args) {
		Combinationsum cs = new Combinationsum();
		System.out.println(cs.combinationSum_dp(new int[] {2,3,6,7},7));
		

	}

}
