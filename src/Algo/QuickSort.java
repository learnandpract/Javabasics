package Algo;

import java.util.Arrays;

public class QuickSort {
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i] ;
		arr[i] = arr[j];
		arr[j]= temp;		
	}

	private int partition(int[] arr, int start, int end) {
		
		int pivot = arr[end];
		
		int pIndex = start;
		
		for(int i = start; i< end;i++) {
			if(arr[i]<=pivot) {
				swap(arr,i,pIndex);
				pIndex++;				
			}
		}
		swap(arr,end,pIndex);
		
		return pIndex;
		
	}


	public void quicks(int[] arr,int start,int end) {
		  if (start >= end) {
	            return;
	        }
		
		int pivot = partition(arr,start, end);
		
		quicks(arr,start,pivot-1);
		quicks(arr,pivot+1,end);
	}


	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] arr= new int[] {9, -3, 5, 2, 6, 8, -6, 1, 3 };
		qs.quicks(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		

	}

}
