package Algo;

import java.util.Arrays;

public class MergeSort {
	
	private void merge(int[] arr, int left, int mid, int right) {
		 int lt = mid - left + 1;
		 int rt = right - mid;
		 
		 int L[] = new int[lt];
		 int R[] = new int[rt];
		 
		 for(int i = 0; i<lt;i++) {
			 L[i]= arr[left+i];			 
		 }
		 for(int j = 0;j< rt; j++) {
			 R[j] = arr[mid+1+j];
		 }
		 
		 int i = 0, j = 0;
		  
	        // Initial index of merged subarray array
	        int k = left;
	        while (i < lt && j < rt) {
	            if (L[i] <= R[j]) {
	                arr[k] = L[i];
	                i++;
	            }
	            else {
	                arr[k] = R[j];
	                j++;
	            }
	            k++;
	        }
	  
	        /* Copy remaining elements of L[] if any */
	        while (i < lt) {
	            arr[k] = L[i];
	            i++;
	            k++;
	        }
	  
	        /* Copy remaining elements of R[] if any */
	        while (j < rt) {
	            arr[k] = R[j];
	            j++;
	            k++;
	        }
	    }
	
	private void sort(int[] arr, int left, int right) {
		
		if(left == right)
			return;
		int mid = left+ (right-left)/2;
		
		sort(arr,left,mid);
		sort(arr,mid+1,right);
		
		System.out.println(left +" :left " +right+" : right "+mid +" :mid "+Arrays.toString(arr));
		
		merge(arr,left,mid,right);	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = new int[]{ 12, 14, 13, 11, 7, 5, 6 };
		MergeSort ms = new MergeSort();
		ms.sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

	

}
