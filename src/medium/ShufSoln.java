package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ShufSoln {
	int[] nums;
	
	    private int[] array;
	    private int[] original;

	    private Random rand = new Random();

	    private List<Integer> getArrayCopy() {
	        List<Integer> asList = new ArrayList<Integer>();
	        for (int i = 0; i < array.length; i++) {
	            asList.add(array[i]);
	        }
	        return asList;
	    }

	    public ShufSoln(int[] nums) {
//	        array = nums;
//	        original = nums.clone();
	
	    		this.nums = nums;
	    	
	    }
	    
	    public int[] reset() {
//	        array = original;
//	        original = original.clone();
//	        return array;
	    	return nums;
	    }
	    
	    public int[] shuffle() {
//	        List<Integer> aux = getArrayCopy();
//
//	        for (int i = 0; i < array.length; i++) {
//	            int removeIdx = rand.nextInt(aux.size());
//	            array[i] = aux.get(removeIdx);
//	            aux.remove(removeIdx);
//	        }
//
//	        return array;	    	
	    	int[] res = new int[nums.length];
			res = nums.clone();
			
			for(int i = 0; i < nums.length; i++){
				int rand = (int)(Math.random()*(nums.length - i)) + i;
				swap(res, i, rand);
				
			}
			System.out.println(Arrays.toString(res));
			return res;
	    }
	    public void swap(int[] nums, int i, int j){
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	    public int sec_least(int[] arr)
	    {
	        int least = Integer.MAX_VALUE; //least
	        int sleast = Integer.MAX_VALUE;  //second least


	        for(int i=0; i<arr.length; i++)
	        {
	            if(arr[i]<least) 
	            {
	                sleast = least;
	                least = arr[i];
	            }

	            else if(arr[i]<sleast)
	            {
	                sleast = arr[i];
	            }
	        }

	        return sleast;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {2, 5, 6, 3,4};
		//
		ShufSoln obj = new ShufSoln(nums);
//		int[] param_1 = obj.reset();
//		int[] param_2 = obj.shuffle();
//		System.out.println(Arrays.toString(param_2));
		
		int sc = obj.sec_least(nums);
		System.out.println(sc);
		
		
		
	
		
	}

}
