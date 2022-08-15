package medium;

import java.util.HashMap;
import java.util.Map;

public class NoofRabbits {
	 public int numRabbits(int[] answers) {
	        Map<Integer, Integer> m = new HashMap<>();
	        for (int i : answers)
	            m.put(i, m.getOrDefault(i, 0) + 1); //{2,2,2,2}- m {2:4}
	        int res = 0;
	        for (int i : m.keySet()) {
	        	System.out.println(i+" ::i value::  "+ (i + 1) * (i + 1) +"  ::(i + 1) * (i + 1):: "+ m.get(i));
	            res += (m.get(i) + i) / (i + 1) * (i + 1); // 6/3*3 =2*3
	        }
	        return res;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoofRabbits no = new NoofRabbits();
		int[] ans = new int[] {1,1,2};
		System.out.println(no.numRabbits(ans)+ " num rabbits - 1");
		
		int[] ans1 = new int[] {1,2,2,2,2};
		System.out.println(no.numRabbits(ans1)+ " num rabbits - 2");
		
		

	}

}
