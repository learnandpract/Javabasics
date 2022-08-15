import java.util.ArrayList;
import java.util.List;

public class E_SummaryRanges {
	public List<String> sumrange(int[] nums ) { //[0,1,2,4,5,7]:["0->2","4->5","7"]
		List<String> res = new ArrayList<String>();
		for(int i = 0 ; i< nums.length;i++) {
			int start = i;
			while(i+1<nums.length && nums[i+1]-nums[i]==1) {
				i++;				
			}
			if(nums[i]>nums[start]) {
				res.add(nums[start]+"->"+nums[i]);
								
			}else {			
				res.add(""+nums[i]);
			}
			
		}
		
		return res;	
	}

	public static void main(String[] args) {
		E_SummaryRanges es = new E_SummaryRanges();
		int[] num = new int[] {0,1,2,4,5,7};
		System.out.println(es.sumrange(num));

	}

}
