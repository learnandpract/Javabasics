package grind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Practise {
//	7,1,5,3,6,4
	
public int maxProfit2(int[] prices) {
	
//	Input: prices = [3,3,5,0,0,3,1,4]
//			Output: 6
//	Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
//			Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
	
	int s1=-prices[0],s2=Integer.MIN_VALUE,s3=Integer.MIN_VALUE,s4=Integer.MIN_VALUE;
        
	for(int i=1;i<prices.length;++i) {            
		s1 = Math.max(s1, -prices[i]);
		s2 = Math.max(s2, s1+prices[i]);
		s3 = Math.max(s3, s2-prices[i]);
		s4 = Math.max(s4, s3+prices[i]);
	}
	System.out.println(s1+"s1");
	System.out.println(s2+"s2");
	System.out.println(s3+"s3");
	System.out.println(s4+"s4");
	return Math.max(0,s4);
	
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

public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        if(i > start && nums[i] == nums[i-1]) 
        	continue; // skip duplicates
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
} 
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack_st(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack_st(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}

public int[][] merge(int[][] intervals) { // overlapping
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

public int maxSubArray(int[] nums) {
  int mx =nums[0];
  int sum =mx;
  for(int i =0; i< nums.length;i++) {
	  sum+=nums[i];
	  if(sum<nums[i]) {
		sum = nums[i];  
	  }
	  mx = Math.max(sum,mx );
	  
  }
  
	return mx;
}


public int mysqrt(int x) {
    int left = 0;
    int right =x;
    
    while(left < right) {
       int  mid = left + (right - left)/2; // 2
        if(mid * mid <= x)
            left = mid + 1;
        else
            right = mid;
    }
    return left-1; //not left because- maximal k satisfying condition(k) is False is just equal to  minimal k satisfying condition(k) is True minus one.
    
}

public boolean canConstruct(String ransomNote, String magazine) {
//	Input: ransomNote = "aa", magazine = "aab"
//			Output: true
	//does not work for //"aab" "baa" -- return true	
	for(int i =0; i< magazine.length();i++) {
		for(int j =0;j<=i;j++) {
		if(ransomNote.equals(magazine.substring(j,i))){
			System.out.println(ransomNote);
			return true;
		}
		}		
	}	
	return false;    
}

public boolean canConstruc_1(String ransomNote, String magazine) {
	for(char c : ransomNote.toCharArray()) {
		int index = magazine.indexOf(c);		
		 if (index == -1) {
	            return false;
	        }
		 magazine = magazine.substring(0, index) + magazine.substring(index + 1);
	}	
	return true;
}

public int climbStairs(int n) {
	int[] dp = new int[n+1];
	//n=2, return 2 
	
	if(n<=2) {
		dp[n]=n;
	}
	dp[1] = 1;
    dp[2] = 2;
	
	for(int i = 3; i<= n;i++) {
		dp[i]=dp[i-1] +dp[i-2];
		
	}
	
	return dp[n];
    
}

public int longestPalindrome(String s) {
   int[] ch = new int[52];
   int count =0;
   
	
 for(int i=0;i<s.length();i++ ) {
	 ch[s.charAt(i)-'a']++;
	 
 }
 for(int j =0;j< ch.length;j++) {
	count+= ch[j]/2*2;
	if(count%2==0 && ch[j] % 2 == 1)
		count++;

 }
	
	return count;
}

public int[] merge(int[] nums1, int m, int[] nums2, int n) {
//  Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
	// 
  int temp  = 0 ;
  int temp1 =  0 ; 
 
 for(int i =m;i< nums1.length ;i++){
     nums1[i] = nums2[i-m];
 }
Arrays.sort(nums1);
return nums1;
 
}
public int majorityElement(int[] nums) {
	int count =0;
	int candidate =-1;
	
	for(int i =0;i< nums.length;i++) {
		if(count ==0) {
			nums[i] = candidate;			
		}if(candidate!= nums[i]) { //enemy
			count--;
		}else {
			count++;
		}		
	}
	return candidate ;    
}

public int[] twoSum(int[] numbers, int target) {

	int low =0; int high = numbers.length-1;
	
	while(low<high) {
		int sum = numbers[low] + numbers[high];
		if(sum == target) {
			return new int[] {low+1, high+1};
		} else if(sum>target) {
			high = high-1;
		}else {
			low=low+1;
		}
		
	}
	
    return null;
    
}


public int minimumTotal(List<List<Integer>> triangle) {	      
 for (int row = triangle.size() - 2; row >= 0; row--) {
   for (int col = 0; col <= row; col++) {
	  int bestBelow = Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1));
	   triangle.get(row).set(col, bestBelow + triangle.get(row).get(col));
	            }
	        }
	        return triangle.get(0).get(0);
	    }

public int minDistance(String word1, String word2) {
    int mn =0;
    char[] wd1 = word1.toCharArray();
    char[] wd2 = word2.toCharArray();
    
    int[] alpha = new int[26];
    
    for(int i =0;i< wd1.length;i++) {
    	alpha[wd1[i]-'a']++;
    }
    for(int i =0;i< wd2.length;i++) {    
    	alpha[wd2[i]-'a']--;    	
    	}
    for(int i =0; i< alpha.length;i++) {
    	if(alpha[i]>0) {
    		mn += alpha[i];
    	}
    	if(alpha[i]<0) {
    		mn += -alpha[i];
    	}
    }
    	System.out.println(mn+"mn"+(word1.length()+word2.length())+ " word length");
    	return mn;    			
    
    }
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]

public int[][] insert(int[][] intervals, int[] newInterval) {
	List<int[]> ls = new ArrayList();
	
//	List<List> res = new ArrayList();
	
	for(int i=0;i<intervals.length;i++) {
		if(intervals[i][1]<newInterval[0]) {
			ls.add(intervals[i]);	
		}else if(intervals[i][0]>newInterval[1]) {
			ls.add(newInterval);//***
			ls.add(intervals[i]);//todo	add new interval		
		}else {
			newInterval[0]=Math.min(intervals[i][0], newInterval[0]);
			newInterval[1]=Math.max(intervals[i][1], newInterval[1]);
		}
		
	}
	return ls.toArray(new int[ls.size()][]);
    
}
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]

public int[][] merge_1(int[][] intervals) {	
	
	Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));
	int[] newInterval = intervals[0];
	List<int[]> result = new ArrayList();
	
	result.add(newInterval);
	
	for(int i =0; i< intervals.length;i++) {
	   if(newInterval[1]>=intervals[i][0]) {
		   newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
	   }else {                             // Disjoint intervals, add the new interval to the list
				newInterval = intervals[i];
				result.add(newInterval);
			}
	   System.out.println(Arrays.deepToString(result.toArray(new int[result.size()][]))+"result");
	   }
	return result.toArray(new int[result.size()][]);
	
}

 	public static void main(String[] args) {
		Practise ps = new Practise();
//		System.out.println(ps.maxProfit2(new int[] {7,1,5,3,6,4}));
//		System.out.println(ps.maxProfit2(new int[] {7,1,5,3,6,4}));
//		System.out.println(ps.combinationSum(new int[] {2,3,6,7}, 7));
//		System.out.println(ps.subsetsWithDup(new int[] {1,2,3}));//[[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
//		System.out.println(ps.subsets(new int[] {1,2,3}));//[[], [1], [1, 2], [1, 2, 2], [2], [2, 2], [2]]
//		System.out.println(Arrays.deepToString(ps.merge(new int [][] {{1,3},{2,6},{8,10},{15,18}})));
//		System.out.println(Arrays.toString(ps.twoSum(new int[] {2,7,11,15}, 18)));
//		
//		int a = 10;
//		int ao = Integer.valueOf(255);
//		
//		System.out.println(ao);
//		System.out.println(ps.mysqrt(8));
//		System.out.println(ps.canConstruc_1("aab", "baa"));
//		System.out.println(ps.longestPalindrome("ccccddeg"));
//		System.out.println(Arrays.toString(ps.merge(new int[] {1,2,3,0,0,0},3, new int [] {2,5,6}, 3)));
//		System.out.println(Arrays.toString(ps.twoSum(new int[] {2,3,4},6)));
//		
//		List<List<Integer>> al = Arrays.asList(Arrays.asList(2),Arrays.asList(3,4),Arrays.asList(6,5,7),Arrays.asList(4,1,8,3));
//		System.out.println(ps.minimumTotal(al));
//		System.out.println(ps.minDistance("sea", "ate"));
//		System.out.println(Arrays.deepToString(ps.merge_1(new int[][] {{1,3},{2,6},{8,16},{15,18}})));
		
		int[] ps1 = new int[] {0,1,2,3,4};
		List<int []> ls = new ArrayList();
		ls.add(ps1);
		ps1[2]=5;
		System.out.println(Arrays.deepToString(ls.toArray()));

	}

}
