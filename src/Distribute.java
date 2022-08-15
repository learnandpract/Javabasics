import java.util.Arrays;

public class Distribute {

	
	  public int[] distributeCandies(int candies, int num_people) {
	        int[] people = new int[num_people];
	        for (int give = 0; candies > 0; candies -= give) {
	            people[give % num_people] +=  Math.min(candies, ++give);
	        }
	        return people;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Distribute ds = new Distribute();
		System.out.print(Arrays.toString(ds.distributeCandies(10 , 3)));

	}
	
  
}
