package medium;
//https://www.youtube.com/watch?v=I-ZXPVRMD_g - minimum arrows to burst balloons
// 1648
//https://leetcode.com/problems/sell-diminishing-valued-colored-balls/discuss/927560/C%2B%2B-Binary-Answer-or-Sort%2BGreedy
//More Binary Answer/greedy algo Problems
//410. Split Array Largest Sum (Hard)
//1482. Minimum Number of Days to Make m Bouquets (Medium)
//1300. Sum of Mutated Array Closest to Target (Medium)
//1044. Longest Duplicate Substring (Hard)
//668. Kth Smallest Number in Multiplication Table (Hard)
//719. Find K-th Smallest Pair Distance (Hard)
//1283. Find the Smallest Divisor Given a Threshold (Medium)
//
//56 Merge Intervals (Med) <- very similar 
//merge sort- https://www.interviewbit.com/tutorial/merge-sort-algorithm/
//435 Non-overlapping Intervals <- very similar
//252 Meeting Rooms
//253 Meeting Rooms II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//Dynamic programming-
//https://leetcode.com/problems/target-sum/discuss/455024/DP-IS-EASY!-5-Steps-to-Think-Through-DP-Questions.
public class AAIntro {
	public static void main(String[] args) {
	AAIntro aaintro = new AAIntro();
	
	int[][] points = new int[][] {{7,10,3}, {1,5,4}, {3,6,7}, {2,4,6}, {1,4,3}};
	
//	for(int[] points1d: points ) {
//		System.out.println(points1d[0]+" points1d[0]");
//	}
	
	
	System.out.println(points.length+": points length"); //5 rows
	
	System.out.println(points[0].length+": points[0] length"); //3 columns
	
	System.out.println(Arrays.toString(points[0])+" arrays tostring");//print first row of array
	System.out.println(Arrays.deepToString(points)+" arrays deepstring");//print entire array
	System.out.println(Arrays.toString(points)+" arrays string");//print entire array
	
//	return res.toArray((new int[res.size()][])); when u have to return int[][]
	//[I@6d06d69c [ beginning of array, I=int, and then hashcode
	
	System.out.println("Leetdfdferr".indexOf("Leer") +" :: "+"Leetdfdferr".indexOf("Lee"));//-1 :: 0
	System.out.println("Leetdfdferr".indexOf("tdf"));//3
	
	System.out.println("Leetdfdferr".indexOf("t",2));//3
	
	System.out.println("Leetdfdferr".substring(0,3) +" :Leetdfdferr.substring(0,3)"); //Lee
	System.out.println("Leetdfdferr".substring(3) +" :Leetdfdferr.substring(3)");//tdfdferr
	
	System.out.println(Integer.valueOf('z')+":z " + Integer.valueOf('Z') +": Z "
			+Integer.valueOf('a')+":a " +Integer.valueOf('A')+":A "
			+Integer.valueOf('0')+":0 " +Integer.valueOf('9')+":9 "); 
//	as.toArray(new int[as.size()][]); Arraylist to array
	
//	m.put(t[1], m.getOrDefault(t[1], 0) + t[0]);
	
	ArrayList<Integer> numsList = new ArrayList<Integer>();
	 Map<ArrayList<Integer>, Integer> res = new HashMap<ArrayList<Integer>, Integer>();
	 numsList.add(0);
	 numsList.add(1);
	 if(!res.containsKey(numsList)) {
	 res.put(numsList, 5);
	 }
	 ArrayList<Integer> numsList1 = new ArrayList();
	 numsList1.add(1);
	 numsList1.add(0);
	 if(!res.containsKey(numsList1)) {
		 res.put(numsList1, 5);
		 }
	 
	 System.out.println(res+" :: res");
	 List<String> resu = new ArrayList<String>();
	 resu.add("chk");
	 resu.add("chk2");
	 String[] arr = resu.toArray(new String[0]); // resu.toArray(new String[resu.size()])
	 System.out.println(Arrays.toString(resu.toArray()));//[chk, chk2] arraylist to primitive array
	
	 System.out.println(resu+" :: resu");
	 
	 HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
	 hm.put(1,10);
	 hm.put(2, 20);
	 
	 for(Map.Entry<Integer, Integer> entry :hm.entrySet()) {
		 entry.getKey();
		 entry.getValue();
	 }
	 
	 Iterator<Map.Entry<Integer,Integer>> itr = hm.entrySet().iterator();
	 
	 while(itr.hasNext()) {
		 itr.next();
		 itr.remove();
		 break;
		 
	 }
	 System.out.print(hm+"hm");
	 
	 
	 
	}
	//
	  
	
	  
	
	
}
