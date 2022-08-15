package Algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Dummy {
	
	public int majority(int[] a) {
		
		int mj = 0; //TODO
		//{2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2}
		HashMap<Integer,Integer> mp = new HashMap<>();
//		for(int i = 0; i<a.length;i++) {		
//			mp.put(a[i], mp.getOrDefault(a[i], 0)+1);//{1=1, 2=6, 3=1, 5=1, 7=1, 8=1}
//			mj = Math.max(mj, mp.get(a[i]));		
//		}
	       for (int i: a) {
	            mp.put(i, mp.getOrDefault(i, 0) + 1);
	            mj = Math.max(mj, mp.get(a[i]));
	        }
		
		for(Map.Entry<Integer, Integer> entry:mp.entrySet()) {
			if(entry.getValue()== mj) {
				return entry.getKey();
			}			
		}		
		return -1;
		
	}
	
	public void findMinElement(int[] a) {
		int min = Integer.MAX_VALUE;
		for(int i =0;i<a.length;i++) {
			min = Math.min(a[i],min ) ;
		}
		
		System.out.println(min+"minimum");
		
	}
	
	 public  void insertionSort(int[] arr)
	    {
	        // Start from the second element
	        // (the element at index 0 is already sorted)
	        for (int i = 1; i < arr.length; i++)
	        {
	            int value = arr[i];
	            int j = i;
	 
	            // find index `j` within the sorted subset `arr[0…i-1]`
	            // where element `arr[i]` belongs
	            while (j > 0 && arr[j - 1] > value)
	            {
	                arr[j] = arr[j - 1];
	                j--;
	            }
	            arr[j] = value;
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Stack<Integer> st = new Stack<>();
//		
//		st.push(1);
//		st.push(2);
//		while(!st.isEmpty()) {
//			int i = st.pop();
//			System.out.println(i);
//			
//		}
	Dummy dm = new Dummy();
//		System.out.println(dm.majority(new int[] {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2}));
		
		System.out.println(1<<0);
		dm.findMinElement(new int[] {3, 8, 5, 4, 1, 9, -2 });
		int[] arr = {3, 8, 5, 4, 1, 9, -2 };
		dm.insertionSort(arr);	
		
		System.out.println(Arrays.toString(arr));

	}

}
