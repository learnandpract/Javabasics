package Algo;

public class BinarySearch {
	//https://leetcode.com/problems/first-bad-version/discuss/769685/Python-Clear-explanation-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems.
	 
	public int findNum(int nums[],int target) {
//		nums[] = [2, 3, 5, 7, 9],				target = 7				 
//				Output: Element found at index 3
		
		int left =0 ,  right = nums.length-1;
		
		while(left<=right) {
			
		int mid = left + (right-left)/2;
		
		if(target == nums[mid]) 
			return mid;		
		else if(target<nums[mid]) {
			right = mid-1;
		}else
			left = mid+1;
		}
		return -1;				
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
	
	public int searchInsert(int[] nums,int target) {
		int left =0;
		int right = nums.length;
//		Input: [1,3,5,6,7], 2
//		Output: 1
		while(left<right) {			
			int mid = left+ (right-left)/2;			
			if(nums[mid]>=target) {
				right= mid;
			}else {
				left = mid+1;
			}

		}
		return left;		
	}
		
	
	public static void main(String a[]) {
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.findNum(new int[] {2, 3, 5, 7, 9}, 7));
		System.out.println(bs.searchInsert(new int[] {1,3,5,6,7}, 2));		
	}	

}
