
public class RemoveDuplicates {
	public int removeDup(int[] n) {
		int i =0 ;
		for(int j = 1; j<n.length;j++) {
			if(n[j]!=n[i]) {
				i++;
				n[i] = n[j];
						
			}
				
		}
		return i+1;
		
	}
	
	
		public int removeval(int[] n, int val) {
			int i =0 ;
			for(int j = 1; j<n.length;j++) {
				if(n[j]!=val) {
					i++;
					n[i] = n[j];							
				}					
			}
			return i+1;
			
		}
public static void main(String[] args) {
	RemoveDuplicates rd = new RemoveDuplicates();
	
	int[] n =new int[] {1,1,2,2};
	int len = rd.removeDup(n);
	int len1 = rd.removeval(n,2);
	System.out.println(len+":len "+len1+": len2");
	
	System.out.println("hello".indexOf("ll"));
	
	
	
}
}
