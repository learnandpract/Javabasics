package Algo;

public class EuclidGCD {
	public int gcd(int a , int b) {
		int gc = 0;
		while(b>0) {
		int r = a%b;
		a = b;
		b = r; 		
		}
		
		return a;
	}

	public static void main(String[] args) {
		EuclidGCD eu = new EuclidGCD();
		System.out.println(eu.gcd(105, 42));

	}

}
