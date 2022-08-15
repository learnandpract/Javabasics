
public class Longestharmoniousarray {
	//Input: nums = [1,3,2,2,5,2,3,7]
//	Output: 5 : longest harmonious subsequence is [3,2,2,2,3]
    public int findSeq(int[] n) {  //Input: nums = [1,3,2,2,5,2,3,7]  	
    	int count = 0;
    	int res = 0;
    	for(int i = 0;i< n.length-1;i++) {
    		if(n[i]==n[i+1] || Math.abs(n[i]-n[i+1])==1) {
//    			i=i+1;
    			count++;
    		}else {
    			res=Math.max(count,res);
//    			count=0;
    		}
    	}
        
    	return res;
    }
    public int findLHS(int[] nums) {// from lc soln
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i])
                    count++;
                else if (nums[j] + 1 == nums[i]) {
                    count++;
                    flag = true;
                }
            }
            if (flag)
                res = Math.max(count, res);
        }
        return res;
    }
    
    public int maxProduct(int[] nums) { //152
      int prod=nums[0];
      int sub;
      
        for(int i=0;i<nums.length;i++) {
        	sub = nums[i];
        	prod=Math.max(prod, nums[i]);
        	for(int j=i+1;j< nums.length;j++) {
        		sub *= nums[j];
        		prod=Math.max(sub,prod);
        	}
//        	prod=(Math.max(nums[i+1], prod));
//            prod=Math.max(nums[i]*nums[i+1],prod);
        
        }
        return prod;
    	
    	
    }
	
	public static void main(String[] args) {
		Longestharmoniousarray lhm = new Longestharmoniousarray();
//		System.out.println(lhm.findLHS(new int[] {1,3,2,2,5,2,3,7}));
		System.out.println(lhm.maxProduct(new int[] {-2,3,-4}));
		

	}

}
