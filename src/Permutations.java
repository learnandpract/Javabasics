import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

//	https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)

public static void main(String args[]) {
	Permutations pd = new Permutations();
	int nums[] = new int[]{5,7,7};
	List lt = pd.permute(nums);
//	System.out.println(Arrays.toString(lt.toArray())+" returned List ");
	System.out.println(lt+" returned List ");
	ArrayList al = new ArrayList();
	al.add(5);
	al.add(6);
	al.add(7);
	
//    pd.perm(al);
}

//private void perm(ArrayList al) {
//	// TODO Auto-generated method stub
//	
//	
//	System.out.println(Arrays.toString(al.toArray())+" Given List ");
//	
//	
//	
//}

public List<List<Integer>> permute(int[] nums) { //permutations-ii/
	   List<List<Integer>> list = new ArrayList<>();
	   // Arrays.sort(nums); // not necessary
	   backtrack_tbd(list, new ArrayList<>(), nums,new boolean[nums.length]);
	   return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
		  
	   if(tempList.size() == nums.length){
	      list.add(new ArrayList<>(tempList));
	   } else{
	      for(int i = 0; i < nums.length; i++){ 
	         if(tempList.contains(nums[i]))
	        	 continue;
	        	  // element already exists, skip
	         tempList.add(nums[i]);
	         System.out.println(Arrays.toString(tempList.toArray())+" templist");	         
	         backtrack(list, tempList, nums);
	         tempList.remove(tempList.size() - 1);
	         System.out.println(Arrays.toString(tempList.toArray())+" after removal");
	      }
	   }
	} 
	private void backtrack_tbd(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
	    if(tempList.size() == nums.length){
	        list.add(new ArrayList<>(tempList));
	    } else{
	        for(int i = 0; i < nums.length; i++){
	            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
	            used[i] = true; 
	            tempList.add(nums[i]);
	            backtrack_tbd(list, tempList, nums, used);
	            used[i] = false; 
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
	
	public List<List<Integer>> permute_tbd(int[] nums) {		
		List<List<Integer>> list = new ArrayList<>();
		
		permutate(list,new ArrayList<>(),nums);
		
		return list;
		
	}
	
	public void permutate(List<List<Integer>> list, List<Integer> temp ,int[] nums) {
		if(temp.size()==nums.length) {
			list.add(new ArrayList<>(temp));
		}
		for(int i =0; i< nums.length;i++) {
			if(temp.contains(nums[i]))
				continue;
			temp.add(nums[i]);
			permutate(list,temp,nums);
			temp.remove(temp.size()-1);
		}
		
	}
}