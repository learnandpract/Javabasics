package medium;

public class Array_Duplicate {
	
	   public int singleNonDuplicate(int[] nums) {
//		   Input: nums = [1,1,2,3,3,4,4,8,8] , 3,3,7,7,10,11,11
//				   Output: 2
	       int single = 0;
	       for(int i = 0 ; i< nums.length;i=i+2) {
	    	   if(nums[i] !=nums[i+1]) {
	    		   System.out.println("single: "+nums[i]);
//	    		   return nums[i];
	    		   break;
	    	   }
	       }
	       
	       int low = 0; 
	       int high = nums.length-1;
	       while(low<high) {
	    	   int mid = low+(high-low)/2;
	    	   if(mid%2==0 && nums[mid]==nums[mid+1] || (mid%2==1 && nums[mid-1]==nums[mid])) {
	    		   low = mid+1;
	    	   }else {
	    		   high = mid;
	    	   }
	    	   
	       }
	       System.out.println("Single using binary search :"+nums[low]);
	       
		   
		   return 0;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array_Duplicate ad = new Array_Duplicate();
		ad.singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8});
	}

}
