package Algo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class QuickSelect {
	public static int rand(int min, int max)
    {
        if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Invalid range");
        }
        return new Random().nextInt(max - min + 1) + min;
    }
 
    public static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QuickSelect qs = new QuickSelect();
		
		int[] nums = { 7, 4, 6, 3, 9, 1 };
        int k = 3;
 
//        System.out.println("k'th smallest element is " +
//                qs.quickSelect(nums, 0, nums.length - 1, k - 1));
        
        System.out.println("k'th largest element is " +
                qs.findKthLargest(nums, k ));
        System.out.println("k'th largest element is " +
                qs.findKthSmallestpq(nums, k ));
        
    }

	private  int quickSelect(int[] nums, int left, int right, int k) {
		
		  if (left == right) {
	            return nums[left];
	        }
	 
	        // select a `pIndex` between left and right
	        int pIndex = rand(left, right);
	 
	        pIndex = partition(nums, left, right, pIndex);
	 
	        // The pivot is in its final sorted position
	        if (k == pIndex) {
	            return nums[k];
	        }
	 
	        // if `k` is less than the pivot index
	        else if (k < pIndex) {
	            return quickSelect(nums, left, pIndex - 1, k);
	        }
	 
	        // if `k` is more than the pivot index
	        else {
	            return quickSelect(nums, pIndex + 1, right, k);
	        }	
	
	}
	
	public int partition(int[] nums, int left,int right, int pIndex) {
		int pivot = nums[pIndex]; 	
		
		swap(nums, pIndex, right);
		 
        // elements less than the pivot will be pushed to the left of `pIndex`;
        // elements more than the pivot will be pushed to the right of `pIndex`;
        // equal elements can go either way
        pIndex = left;
 
        // each time we find an element less than or equal to the pivot, `pIndex`
        // is incremented, and that element would be placed before the pivot.
        for (int i = left; i < right; i++)
        {
            if (nums[i] <= pivot)
            {
                swap(nums, i, pIndex);
                pIndex++;
            }
        }
 
        // move pivot to its final place
        swap(nums, pIndex, right);
 
        // return `pIndex` (index of the pivot element)
        return pIndex;
	}
	
	public int findKthLargest(int[] nums, int k) {

	    final PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(int val : nums) {
	        pq.offer(val);// [4,7]

	        if(pq.size() > k) {
	            pq.poll();
	        }
	    }
	    return pq.peek();
	}
	
	
	public int findKthSmallestpq(int[] nums, int k) {

	    final PriorityQueue<Integer> pq = new PriorityQueue<>(new CustomComparator());
	    for(int val : nums) {
	        pq.offer(val); //[7,4]

	        if(pq.size() > k) {
	            pq.poll();
	        }
	    }
	    return pq.peek();
	}
	
	class CustomComparator implements Comparator<Integer> {
		 
	    @Override
	    public int compare(Integer number1, Integer number2) {
	        int value =  number1.compareTo(number2);
	       
	        // elements are sorted in reverse order
	        if (value > 0) {
	            return -1;
	        }
	        else if (value < 0) {
	            return 1;
	        }
	        else {
	            return 0;
	        }
	    }
	}

	}


