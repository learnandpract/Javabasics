package medium;

public class Med_watercontainer {
	
	public int areawater(int[] height) {
//	i/p:[1,8,6,2,5,4,8,3,7] Output: 49
		int j = height.length-1;
		int i = 0;
		int maxArea = 0;
		while(i<j) {
			maxArea = Math.max((j-i)*Math.min(height[i],height[j]),maxArea);
			if(height[i]<height[j]) 
				i++;
			else 
			    j--;
		}
		
		
		return maxArea;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Med_watercontainer mwc = new Med_watercontainer();
		int[] hgt = new int[] {1,8,6,2,5,4,8,3,7};
		int maxA = mwc.areawater(hgt);
		System.out.println(maxA);

	}

}
