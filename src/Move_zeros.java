import java.util.Arrays;

public class Move_zeros {

	public int[] movezero(int[] arr) { //1089
//		Input:  [1,0,2,3,0,4,5,0] : [1,0,0,2,3,0,4,5] : [1,0,0,2,3,0,0,4]
//		Output: [1,0,0,2,3,0,0,4]
		for(int i =0; i<arr.length;i++) {
			if(arr[i]==0) {					
				for(int j =arr.length-1;j>i;j--) {
//					System.out.println(j+" : j "+ arr[j] +" : arr[j]" +  arr[j-1]+" arr[j-1]" );
					arr[j]=arr[j-1];
				}
				i++;
			}			
		}
		return arr;
		
	}
	
    public int[] moveZeroes_end(int[] nums) { // 283
//    	Input: [1,2,3,0,4,5,0]
//    	Output: [1,2,3,4,5,0,0]
//    if (nums == null || nums.length == 0) {
//        return;
//    }    
    int cur = 0;
    for (int i = 0; i < nums.length; ++i) {
        if (nums[i] != 0) {
            int temp = nums[cur];
            nums[cur++] = nums[i];
            nums[i] = temp;
        }
    }
    return nums;
    }
    
    public int[] merge_tbd(int[] nums1, int m, int[] nums2, int n) {
    //  Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    //Output: [1,2,2,3,5,6]
    int p1= m-1;
    int p2= n-1;

    for(int i= m+n-1;i>=0;i--) {
    	if(nums1[p1]>nums2[p2]) {
    		nums1[i] = nums1[p1--];
    	}else {
    		nums1[i] = nums2[p2--];
    	}
    }
    	
    	return nums1;
     
    }
//    Lo := 1; Mid := 1; Hi := N;
//    while Mid <= Hi do
//    	Invariant: a[1..Lo-1]=0 and a[Lo..Mid-1]=1 and a[Hi+1..N]=2; a[Mid..Hi] are unknown.
//   	case a[Mid] in
//    		0: swap a[Lo] and a[Mid]; Lo++; Mid++
//    		1: Mid++
//    		2: swap a[Mid] and a[Hi]; Hi--
	public void merge3colors(int[] nums) {
		int low =0;
		int high = nums.length-1;
		int mid =0;
		
		while(mid<=high) {
			if(nums[mid]==0) {				
				int temp = nums[mid];
				nums[mid]=nums[low];
				nums[low] = temp;
				low++;
				mid++;		
			}else if(nums[mid]==1) {
				mid++;
			}else {				
				int temp = nums[mid];
				nums[mid] = nums[high];
				nums[high] = temp;
				high--;				
			}			
		}
		System.out.println(Arrays.toString(nums));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Move_zeros mz = new Move_zeros();
//		int[] arr1 = mz.movezero(new int[] {1,0,2,3,0,4,5,0});
		
//		System.out.println(Arrays.toString(arr1));
		
//		int[] arr2 = mz.moveZeroes_end(new int[] {1,2,3,0,4,5,0});
//		
//		System.out.println(Arrays.toString(arr2));
		mz.merge3colors(new int[] {0,1,2,1,0,1});

	}

}
