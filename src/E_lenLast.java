import java.util.Arrays;

public class E_lenLast {
	
	public int lenlast(String a ) { //58 accepted original
		int i =0;
		String b[] = a.split(" ");
//		System.out.println(Arrays.toString(b));
//		
//		System.out.println(b[b.length-1].length());
		
		
		return b[b.length-1].length();
	}

	
	public int[] plusone(int a[] ) {//66
	
	int num =0;
	int power = 0;
	
	for(int i=a.length-1 ;i>=0;i--) {		
		num += a[i] *(Math.pow(10, power)); //3 , 23 , 
		power++;	
	}
		System.out.println(num);
		
		int num1=0;		
		for(int i=0 ;i<a.length;i++) {			
			num1 = num1*10 + a[i];			
		}
		System.out.println(num1+1);
		
		return a;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E_lenLast ell = new E_lenLast();
		String a = " the joy of  gbliving  ";
		ell.lenlast(a);
		
		int b[]= new int[]{1,2,3};
		ell.plusone(b);
		

	}

}
