package grind75;

public class Week8 {

	 public int largestRectangleArea(int[] heights) { //[2,1,5,6,2,3] o/p =10
		 
		 int max=0;
		 for(int i =0; i<heights.length;i++) {
			 for(int j =i;j< heights.length;j++) {
				 int min = Integer.MAX_VALUE;
				 for(int k =i;k<=j;k++) {
					 min = Math.min(min, heights[k]);// you can do without k loop.
				 }
				 max = Math.max(max, min*j-i+1); 
			 }
		 }    
	     return max;		 
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Week8 wk8 = new Week8();
		System.out.println(wk8.largestRectangleArea(new int [] {2,1,5,6,2,3}));

	}

}
