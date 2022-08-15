package medium;

import java.util.HashMap;

public class sample_hashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, String> mp = new HashMap<Integer,String>();		
		mp.put(1, "a");
		mp.put(1, "c");
		mp.put(2, "b");		
		mp.put(3, "b");
		System.out.println(mp);
		
		
	}

}
