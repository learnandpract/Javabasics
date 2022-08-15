package medium;

import java.util.Map;
import java.util.TreeMap;

public class Carpooling {
//	Input: trips = [[2,1,5],[3,3,7]], capacity = 4
//			Output: false
	
	  public boolean carPool(int[][] trips, int capacity) {
	        Map<Integer, Integer> m = new TreeMap<>();
	        for (int[] t : trips) {
	            m.put(t[1], m.getOrDefault(t[1], 0) + t[0]);
	            m.put(t[2], m.getOrDefault(t[2], 0) - t[0]);
	        }
	        for (int v : m.values()) {
	            capacity -= v;
	            if (capacity < 0) {
	                return false;
	            }
	        }
	        return true;
	    }

	public static void main(String[] args) {	
		Carpooling cp = new Carpooling();
		System.out.println(cp.carPool(new int[][] {{2,1,5},{3,3,7}},4));

	}

}
