package hard;

import java.util.HashMap;

public class nOrgs {
	//check if its divisible by 3, if not eat one orange until its divisible by 3.
	// then check divisible by 3 and then divisible by 2
	//if one remaining count 1 day
	  private HashMap<Integer,Integer> mp = new HashMap<>();
		public int minDays(int n) {	
			        if(n <= 2)
			            return n;
			        if(mp.containsKey(n)) {
			            return mp.get(n);	
			        }			        
			        int two   = n % 2  + 1 + minDays(n/2);
			        System.out.println(n+" n after two");
			        int three = n % 3  + 1 + minDays(n/3);		
			        System.out.println(two+" : two : "+ three+" : three : "+n +" : n after 3");
			        mp.put(n, Math.min(two,three));
			        return mp.get(n);
			    }			
//		  int two   = n % 2 /* extra day */ + 1 /* one day to eat n/2     */ + minDays(n/2);
//	      int three = n % 3 /* extra day */ + 1 /* one day to eat 2*(n/3) */ + minDays(n/3);
//	      mp.put(n, 1 + Math.min(n % 2 + minDays(n/2), n % 3 + minDays(n/3)));    
	public static void main(String[] args) {	
		nOrgs org = new nOrgs();
		System.out.println(org.minDays(10));

	}

}
