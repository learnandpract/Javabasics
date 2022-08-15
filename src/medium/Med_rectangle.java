package medium;

import java.util.HashMap;
import java.util.Map;

public class Med_rectangle { //2001
	
	 public long interchangeableRectangles(int[][] rectangles) {
		 int length = rectangles.length;
		 int counter =0;
		 Double ratio = 0.0;
		 Map<Double,Integer> freq = new HashMap<>();
		 
		 for(int i=0; i<length;i++) {
			 ratio =  Double.valueOf(rectangles[i][0])/Double.valueOf(rectangles[i][1]);
			 counter += freq.getOrDefault(ratio, 0);
			 freq.put(ratio,freq.getOrDefault(ratio, 0)+1);
		 }
		 
		 return counter;
	 }
	 

	public static void main(String[] args) {
	int rect[][]	= new int[][]{{4,8},{3,6},{10,20},{15,45}};
	Med_rectangle mdr = new Med_rectangle();
	
	System.out.println(mdr.interchangeableRectangles(rect)+" counter");
		

	}

}
