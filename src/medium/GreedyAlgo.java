package medium;

import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgo {
	private static double getMaxValue(int[] wt, int[] val,int capacity)
	{
		ItemValue[] iVal = new ItemValue[wt.length];

		for (int i = 0; i < wt.length; i++) {
			iVal[i] = new ItemValue(wt[i], val[i], i);
		}

		// sorting items by value;
		Arrays.sort(iVal, new Comparator<ItemValue>() {
			@Override
			public int compare(ItemValue o1, ItemValue o2)
			{
				return o2.cost.compareTo(o1.cost);
			}
		});

		double totalValue = 0d;

		for (ItemValue i : iVal) {

			int curWt = (int)i.wt;
			int curVal = (int)i.val;

			if (capacity - curWt >= 0) {
				// this weight can be picked while
				capacity = capacity - curWt;
				totalValue += curVal;
			}
			else {
				// item cant be picked whole
				double fraction
				= ((double)capacity / (double)curWt);
				totalValue += (curVal * fraction);
				capacity= (int)(capacity - (curWt * fraction));
				break;
			}
		}

		return totalValue;
	}

	// item value class
	static class ItemValue {
		Double cost;
		double wt, val, ind;

		// item value function
		public ItemValue(int wt, int val, int ind)
		{
			this.wt = wt;
			this.val = val;
			this.ind = ind;
			cost = new Double((double)val / (double)wt);
		}
	}
	
	public int findMinArrowShots(int[][] points) {// 452
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }


	public static void main(String[] args) {
		// By taking full items of 10 kg, 20 kg and 
//		2/3rd of last item of 30 kg
	        int[] wt = { 10, 40, 20, 30 };
	        int[] val = { 60, 40, 100, 120 };
	        int capacity = 50;
	 
//	        double maxValue = getMaxValue(wt, val, capacity);// geekforgeek
//	 
//	        // Function call
//	        System.out.println("Maximum value we can obtain = "
//	                           + maxValue);
	        //-------------------------------
	        GreedyAlgo ga = new GreedyAlgo();
	        int[][] points = new int[][] {{7,10}, {1,5}, {3,6}, {2,4}, {1,4}};	        
	        
	        Arrays.sort(points, (a, b) -> a[1] - b[1]); //sort by their ending position	        
	        System.out.println(Arrays.deepToString(points) +" points");
	        
	        int[][] points1 = new int[][] {{7,10}, {1,5}, {3,6}, {2,4}, {1,4}};	 
	        Arrays.sort(points1,(a,b) -> Integer.compare(a[0], b[0])); // sort by their starting position
	        System.out.println(Arrays.deepToString(points1) +" points1");
	        
	        int arrowCnt = ga.findMinArrowShots(points);
	        System.out.println(arrowCnt);
	        
	}

}
