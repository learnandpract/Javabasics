import java.util.Arrays;

public class Reverse {

	public Reverse() {
		// TODO Auto-generated constructor stub
	}
	
	public int reve(int tbr) {
	int rd = 0;
	int r = 0;
	while(tbr>0) {
		r =r*10+ tbr%10;
		tbr = tbr/10;
	}
		
	
		return rd;
	}
	
	 public static String convertToTitle(int n) {//168
		 System.out.print("i");
		 return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));        
	    }
	 
	  public int trailingZeroes(int n) { //172        
		  return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	  }
	  
	  public int addDigits_1(int num) { //258, digital root
		  int addsum = 0;		  
		  while(num>0) {
			 addsum += num%10;	
			  num = num/10;
			  if(addsum>9 && num ==0 ) { // from lc
				  num= addsum;
				  addsum = 0 ;
			  }
				  
		  }
		  return addsum;
	  }
	  public int addDigits(int num) {
	        if (num == 0) return 0;
	        if (num % 9 == 0) return 9;
	        return num % 9;
	    }
	  public boolean uglyNum(int num) { 
	  for (int i=2; i<6 && num>0; i++)
		    while (num % i == 0)
		        num /= i;
		return num == 1;
	  }

	  
	  public int missingNumber(int[] nums) {//268

		    int xor = 0, i = 0;
			for (i = 0; i < nums.length; i++) {
				xor = xor ^ i ^ nums[i];
			}

			return xor ^ i;
		}
	  
	  
	  public int[] arrangeArray1(int[] nums) {//283
		  //{0,3,0,5,7} = {3,5,7,0,0}
		  int counter = 0;
		  for(int i = 0 ; i< nums.length;i++) {
			  if(nums[i]!=0) {
				  nums[counter++]= nums[i];
			  }
		  }
			for(int i=counter;i<nums.length;i++) {
				nums[i] = 0;			
		  }
		  return nums;		  
	  }
	  public int[] arrangeArray(int[] nums) {//283
		  // //{0,3,0,5,7} = {3,5,7,0,0}
		    int j = 0;
		    for(int i = 0; i < nums.length; i++) {
		        if(nums[i] != 0) {
		            int temp = nums[j];
		            nums[j] = nums[i];
		            nums[i] = temp;
		            j++;
		        }
		    }
		    return nums;
	  }
	  public int[] moveZeroes(int[] nm) {
		  //{0,3,0,5,7} = {3,5,7,0,0}
		    int countzero=0;
		    for(int i=0;i<nm.length;i++){
		    	System.out.println(nm[i]+": nums[i]");
		        if(nm[i]==0) {
		        	countzero++;
		            continue;
		        }
		        
		        int temp=nm[i-countzero];//nm[i-countzero] will be 0
		        nm[i-countzero]=nm[i];
		        nm[i]=temp;
		     }
		    return nm;
		}
	  
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hi lc");
		int num = 123;
		int n = 0;
		
		while(num>0) {
			n = n*10 + num%10;
//			System.out.println(num%10);
			num = num /10;
//			System.out.println(num);
			;
			
		}
		System.out.println(" reversed : "+n);
		System.out.println(" 1%10 : "+1%10);//1
		System.out.println(" 1/10 : "+1/10);//0
		
		System.out.println(" 123%10 : "+123%10); //3
		System.out.println(" 123/10 : "+123/10);//12
		
		
//		System.out.println(convertToTitle(28));
		Reverse rse = new Reverse();
//		System.out.println(rse.addDigits(381));
//		
//		System.out.println(rse.uglyNum(14));
//		
		int[] n1 = new int[]{0,1,3,4};
//		System.out.println(rse.missingNumber(n1));
		
		int[] n2 = new int[]{0,3,0,0,5,7};
		
//		System.out.println(Arrays.toString(rse.arrangeArray(n2)));
		
		System.out.println(Arrays.toString(rse.moveZeroes(n2)));
		
	}

}
