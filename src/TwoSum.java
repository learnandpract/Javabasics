//Leetcode - 1
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
TwoSum(){
	
}
public int[] twoSum(int[] nums, int target) { //correct
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}


public int[] ts(int n[],int tg) { //practise
	HashMap mp1 = new HashMap();
	for(int i = 0 ; i<n.length;i++) {
		int comp = tg - n[i];
		if(mp1.containsKey(comp)) {
			return new int[] {comp,n[i]};//not actual numbers , send indices. look above		
		}else {
			mp1.put(n[i],i);
			
		}
	}
	
	return new int[] {};
	
}

public int[] twoSum167(int[] input, int target) {
	int[] n = new int[2];
	HashMap<Integer,Integer> mp = new HashMap();
	
	for(int i = 0; i<input.length;i++) {
		if(mp.containsKey(input[i])) {
			n[0] = i;
			n[1] = mp.get(input[i]);
		}else {
			mp.put(target -input[i], i);
		}
	}
	
	return n;
}
public int[] twoSum167_array(int[] num, int target) {// without hashmap
    int[] indice = new int[2];
    if (num == null || num.length < 2) return indice;
    int left = 0, right = num.length - 1;
    while (left < right) {
        int v = num[left] + num[right];
        if (v == target) {
            indice[0] = left + 1;
            indice[1] = right + 1;
            break;
        } else if (v > target) {
            right --;
        } else {
            left ++;
        }
    }
    return indice;
}
public int maxOperations(int[] nums, int k) {//3,1,3,4,3-6
Map<Integer,Integer> mp = new HashMap();
int count =0;
for(int i:nums){
    if(mp.containsKey(i) && mp.get(i)>0){
        mp.put(i,mp.get(i)-1);
        count++;
        
    }else{
        mp.put(k-i,mp.getOrDefault(k-i,0)+1);
    }
}
return count;
}



public static void main(String a[]) {
	TwoSum ts =new  TwoSum();
//	int[] nums = new int[5];
//	nums[0]=1;
//	nums[1]=2;
//	nums[2]=3;
	int[] nums = new int[] {1,2,3,4,5};
	int target = 7;
//	int[] rs = ts.twoSum(nums,target);
//	System.out.println(Arrays.toString(rs));
	
	int[] rs1 = ts.twoSum167(nums,target);
	System.out.println(Arrays.toString(rs1));
	
	System.out.println(ts.maxOperations(new int[] {3,1,3,4,3}, 6));
	
}
}

