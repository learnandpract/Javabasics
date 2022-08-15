import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestTimetoSell {//121 lc
	
	 public int maxProfit(int[] prices) {
	     
	     int maxP = 0;
	  
	     for(int i=0;i<prices.length-1;i++) {
	    	 for(int j=i+1 ;j<prices.length ; j++) {
	    		 int profit = prices[j]-prices[i];
	    		 if(profit> maxP) {
	    			 maxP = profit;
	    			 
	    		 }	    		 
	    	 }	
	     }
		 return  maxP;
	    }
	 public int maxProfit_op(int prices[]) { //121 one pass lc
//		 Input: prices = [7,1,5,3,6,4] 
//				Output: 5 : 6-1
	        int minprice = Integer.MAX_VALUE;
	        int maxprofit = 0;
	        for (int i = 0; i < prices.length; i++) {
	            if (prices[i] < minprice) //   minPrice = Math.min(minPrice,prices[i]);           
	                minprice = prices[i];
	            else if (prices[i] - minprice > maxprofit)// maxprofit = Math.max(maxprofit,prices[i]- minPrice);
	                maxprofit = prices[i] - minprice;
	        }
	        return maxprofit;
	    }
	 
	   public int maxProfit_122(int[] prices) { //122 medium - 
//		   Input: prices = [1,2,3,4,5]
//				   Output: 4
	        int maxprofit = 0;
	        for (int i = 1; i < prices.length; i++) {
	            if (prices[i] > prices[i - 1])
	                maxprofit += prices[i] - prices[i - 1];
	        }
	        return maxprofit;
	    }
	   public int maxProfit_121easy(int[] prices) {
//		   Input: prices = [7,1,5,3,6,4]
//				   Output: 5
		   // keep a pointer for min price.
		   // keep calclulatin max as u go.
		   
		   int minp= Integer.MAX_VALUE;
		   int maxp =0;
		   
		   for(int i = 0;i<prices.length ; i++) {
			   minp = Math.min(minp,prices[i]);
			   maxp = Math.max(prices[i]-minp, maxp);			   
		   }
	   
		   return maxp;
	   }
	 
	   //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/149383/Easy-DP-solution-using-state-machine-O(n)-time-complexity-O(1)-space-complexity
	   //SP
	   
	    public int maxProfit1_sp(int[] prices) { // buy and sell any day - once
	    	int s0=-prices[0];
	    	int s1= 0;	    	
	    	for(int i =1; i< prices.length;i++) {
	    		s0 = Math.max(s0, -prices[i]);
	    		s1= Math.max(s1, s0+prices[i]);	    		
	    	}   	        
	    	return Math.max(0, s1); 
	    }
	    public int maxProfit2_sp(int[] prices) { // buy and sell any times*
	        int s0= -prices[0]; // buy with min price
	        int s1=0;
	        for(int i =0;i< prices.length;i++) {
	        	s0=Math.max(s0,s1-prices[i]); //when we buy its always minus the previous selling price. 
	        	s1=Math.max(s1,s0+prices[i]);
	        }	                
	        return Math.max(s1,0);
	    	
	    }
	   
	    public int maxProfit3_sp(int[] prices) {// max profit with 2 txn-buy and sell-BSBS
	    	 int s0= -prices[0]; // buy with min price
		     int s1=0;
		     int s2=0;
		     int s3=0;
		     for(int i=1;i<prices.length;++i) {            
		 		s0 = Math.max(s0, -prices[i]);
		 		s1 = Math.max(s1, s0+prices[i]);
		 		s2 = Math.max(s2, s1-prices[i]);
		 		s3 = Math.max(s3, s2+prices[i]);
		 	}
		     
		     return Math.max(s3,0);
	    }
	   
	  private int maxProfit4_sp(int[] prices, int k) { // max profit with k txn
	 	
	        if(prices.length==0 || k==0) return 0;
	        if(k>prices.length){
	            //engage in every profitable transaction
	            int ans = 0;
	            for(int i=1; i<prices.length; i++){
	                ans += Math.max(prices[i]-prices[i-1],0);
	            }
	            return ans;
	        }
	        //s0 has option to buy or hold
	        //s1 has option to sell or hold 
	        //...
	        int [] states = new int[k*2];
	        Arrays.fill(states, Integer.MIN_VALUE);
	        for(int price : prices){
	            states[0]=Math.max(states[0],-price);
	            for(int i=1; i<states.length; i++){
	                if(i%2==1)
	                    states[i]=Math.max(states[i], states[i-1]+price);//sell
	                else
	                    states[i]=Math.max(states[i], states[i-1]-price); //buy
	            }
	        }
	        return Math.max(0, states[states.length-1]);
	    }
	 
	   public int findMinDifference(List<String> timePoints) {
		  
		   boolean[] mark = new boolean[24 * 60];
	        for (String time : timePoints) {
	            String[] t = time.split(":");
	            int h = Integer.parseInt(t[0]);
	            int m = Integer.parseInt(t[1]);
	            if (mark[h * 60 + m]) 
	            	return 0;
	            mark[h * 60 + m] = true;
	        }
	        
	        int prev = 0, min = Integer.MAX_VALUE;
	        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
	        for (int i = 0; i < 24 * 60; i++) {
	            if (mark[i]) {
	                if (first != Integer.MAX_VALUE) {
	                    min = Math.min(min, i - prev);
	                }
	                first = Math.min(first, i);
	                last = Math.max(last, i);
	                prev = i;
	            }
	        }
	        
	        min = Math.min(min, (24 * 60 - last + first));	//1440-1439   
		   return min; 
		   
	   }
	public static void main(String[] args) {
		BestTimetoSell bt = new BestTimetoSell();
		int[] price = new int[] {5,1,10,50,20};// {0, 6, -3, 7}; //{7,1,5,3,6,4};
//		System.out.println(bt.maxProfit(price));
//		System.out.println(bt.maxProfit_121easy(price));
		
		System.out.println(bt.maxProfit4_sp(new int [] {7,1,5,3,6,4},2));
		
//		List timeL = new ArrayList();
//		timeL.add("23:29");
//		timeL.add("00:50");
//		
//		System.out.println(bt.findMinDifference(timeL)); 

	}

}
