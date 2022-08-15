
public class E_FiTribonacci {
	
	public int fibonacci(int n) { // recursion
		if(n<=1)
			return n;
		return fibonacci(n-1)+fibonacci(n-2);
	}
	public int fibonacci_dynamic(int n) {
		
		int[] fd = new int[n+2];
		fd[0] =0;
		fd[1]=1;
		
		for(int i = 2; i<=n;i++) {
		fd[i] = fd[i-1]+fd[i-2];
			System.out.println(fd[i]);
			
		}
	
		return fd[n];
	}
	
	
	
	
	public int tribonacci(int n) { //recursion
		
		if(n<=1) 
			return n;
		if(n==2)
			return 1;
		return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);	
		
			}
	
	public int tribonacci_dynamic(int n) {
     int[] td= new int[n+1];
     td[0]=0;
     td[1]=1;
     td[2]=1;
     
     for(int i=2;i<=n;i++) {
    	 td[i] = td[n-1]+td[n-2]+td[n-3];    	 
     }
     return td[n];
	}
	
public static void main(String a[]) {
	E_FiTribonacci eft = new E_FiTribonacci();
	
	for(int i = 0; i<=6;i++)
	 System.out.println(eft.fibonacci(i));//0 1 1 2 3 5 8
	
	
	 System.out.println(eft.fibonacci_dynamic(7) + " : fibonacci_dynamic");//0 1 1 2 3 5 8
	 
//	 System.out.println(eft.tribonacci_dynamic(7) + " : tribonacci_dynamic");//0 1 1 2 4 7 13
//	
//	for(int i = 0; i<=6;i++)
//		 System.out.println(eft.tribonacci(i));// 0 1 1 2 4 7 13
//	
	
	
}

}
