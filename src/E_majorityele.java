import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E_majorityele {//169
	public int getMajority(int[] n) {
		int counter =Integer.MIN_VALUE;
		HashMap<Integer, Integer> mp = new HashMap();
		for(int i=0;i<n.length;i++) {
			
			if(mp.containsKey(n[i])) {
				int c = (int) mp.get(n[i])+1;				
				mp.put(n[i],c );
//				counter = Math.max(counter, c++);
			}else {
				mp.put(n[i],1);
			}
			   if (mp.get(n[i])>n.length/2) {
		            counter = n[i];
		            break;
		        }
			
		}
		
		return counter;
	}
	
	public int majorityElement(int[] nums) {
//When an element appears more than n/2 times in the array, the middle one must be the "majority" number when array is sorted.
	     Arrays.sort(nums);
	     return nums[nums.length/2];
	}
	   public int majorityElement_BM(int[] nums) {//Boyer-Moore Voting Algorithm
	        int count = 0;
	        Integer candidate = null;

	        for (int num : nums) {
	            if (count == 0) {
	                candidate = num;
	                System.out.println(count+": count in 0.. "+num+": number");
	            }		           
//	            count += (num == candidate) ? 1 : -1;
	            if((num == candidate)) {
	            	count += 1;	            	
	            	System.out.println(count+": count.. "+num+": number");
	            }else {
	            	System.out.println(count+": count in else.. "+num+": number in else");
	            	count +=-1;
	            }
	        }

	        return candidate;
	    }
	   public int majorityElement1_BM(int[] nums) {//1,3,2,1,2,2,3
	   int major = nums[0];
	   int count =1;
	   for(int i =1;i< nums.length;i++) {
		   if(count==0) {
			   count++;
			   major=nums[i];
		   }else if(nums[i]== major) {
			   count++;			   
		   }else {
			   count--;
		   }		   
	   }
		   return major;
	   }

//	  public int majorityElement(int[] nums) {
//	        Map<Integer, Integer> counts = getMajority(nums);
//
//	        Map.Entry<Integer, Integer> majorityEntry = null;
//	        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
//	        	
//	            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
//	            	System.out.println(entry.getValue()+" entry.getValue()");
//	            	if(majorityEntry != null)
//	            	 System.out.println(majorityEntry.getValue()+" mj");
//	                majorityEntry = entry;
//	            }
//	        }
//
//	        return majorityEntry.getKey();
//	    }
	   
	   public boolean containsNearbyDuplicate(int[] nums, int k) {//219
	        Set<Integer> set = new HashSet<Integer>();
	        for(int i = 0; i < nums.length; i++){
	            if(i > k) {
	            	System.out.println(i-k-1+" : ..i-k-1.."+nums[i-k-1] +" ..nums[i-k-1].." );
	            	set.remove(nums[i-k-1]);
	            	}
	            if(!set.add(nums[i])) {
	            	System.out.println(nums[i]+ " : in set add");
	            	return true;
	            }
	        }
	        return false;
	 }
	   
	public static void main(String[] args) {
		// 
		E_majorityele em = new E_majorityele();
		int[] nj = new int[] {1,3,2,1,2,2,3};
//		int mj = em.getMajority(new int[] {1,2,1,2,2});
		System.out.println(em.majorityElement1_BM(nj));
//		System.out.println(em.containsNearbyDuplicate(nj, 4));

	}

}
