package Algo;


public class BMVoting {
//	https://satyadeepmaheshwari.medium.com/boyer-moore-voting-algorithm-in-plain-english-4a343fb4c6a1
public int majority(int[] nums) {
	int count =0;
	int candidate =-1;
	
	for(int i =0;i< nums.length;i++) {
		if(count ==0) {
			candidate =nums[i] ;			
		}
		if(candidate!= nums[i]) { //enemy
			count--;
		}else {
			count++;
		}		
	}
	return candidate ;    
}



	public static void main(String[] args) {
		BMVoting dm = new BMVoting();
		System.out.println(dm.majority(new int[] {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2}));
		System.out.println(dm.majority(new int[] {2, 4,4,3, 2, 2, 4,3,3}));
	}


}
