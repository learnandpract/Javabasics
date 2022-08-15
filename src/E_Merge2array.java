import java.util.Arrays;

public class E_Merge2array {
	public int[] mergearray(int A[], int m, int B[], int n) {
		int i = m-1;
		int j = n-1;
		int k = m+n-1;
		
		while(i>=0 && j>=0) {			
			
			if(A[i]>B[j]) 
				A[k--] = A[i--];
				else 
				A[k--] = B[j--];
				
			}
			
		while(j>=0) //only need to combine with remaining B
			A[k--] = B[j--];
		
		return A;
		
	}
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
//    	nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//    			Output: [1,2,2,3,5,6]
    	int k = m+n-1;
    	int i = m-1;
    	int j = n-1;
    		while(i>0 && j>=0) {
    			if(nums1[i]>nums2[j]) {
    				nums1[k--] =nums1[i--]; 
    			}else {
    				nums1[k--]= nums2[j--];
    			}
    		
    	}
    		while(j>=0) {
    			System.out.println(nums1[k--] + " :: "+nums2[j--]);
    		
//    			nums1[k--] = nums2[j--];
    		}
    		return nums1;        
    }
	
	
public static void main(String[] args) {
	int[] A= new int[] {1,2,3,0,0,0,0};
	int[] B= new int[] {1,2,5,6};
	E_Merge2array em = new E_Merge2array();
	System.out.println(Arrays.toString(em.merge(A, 3, B, 4)));
	
}
}
