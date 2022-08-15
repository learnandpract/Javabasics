
public class E_Bits_Manip {
	public int reverseBits(int n) { //190
	    if (n == 0) return 0;
	    
	    int result = 0;
	    for (int i = 0; i < 32; i++) {
	        result <<= 1;
	        if ((n & 1) == 1) result++;
	        n >>= 1;
	    }
	    return result;
	}
	
	public static int hammingWeight(int n) { // 191 number of 1s
		int ones = 0;
	    	while(n!=0) {
	    		ones = ones + (n & 1);
	    		n = n>>>1;
	    	}
	    	return ones;
	}
	
	public int  hammingDistance(int x, int y) { //461
        int ones = 0;
        int n = x ^ y; //5^3(0101 ^ 0011)
        while (n>0) { //n=6(0110 - so 2 ones) isequal to while there is a bit set go into the loop.. above 191
            ++ones; //counts how may bits we have turned off(set to 0) so far
            n &= n - 1; // this operation in fact removes the last 1 bit from n
        }
        return ones;
    }
	  public int rangeBitwiseAnd(int m, int n) {
		  while(n>m)
           n = n & n-1;
		  	return m&n;
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		E_Bits_Manip ebm = new E_Bits_Manip();
		int n = 13;
//		System.out.println(ebm.reverseBits(n));
//		System.out.println(ebm.hammingDistance(5, 3)+" Hamming distance " +Integer.bitCount(5 ^ 3));
		System.out.println(ebm.rangeBitwiseAnd(5,12));
		
//		
	}

}
