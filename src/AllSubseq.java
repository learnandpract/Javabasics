import java.util.ArrayList;
import java.util.List;

public class AllSubseq {
	
	public String printseq(String seq1) {
		int N = (int) Math.pow(2,seq1.length());
		List<String> result = new ArrayList<>();
		
		for(int i = 0 ; i < N;i++) {
			 StringBuilder sb = new StringBuilder(); 
			for(int j = 0; j<seq1.length();j++) {
				
				  if ((i & (1 << j)) != 0) {
					  sb.append(seq1.charAt(j));
					  System.out.println(seq1.charAt(j) +" ::charatj:: "+(i & (1 << j))+" ::1<< j:: " + i +" :i: "+(1 << j));	 
				  }
//				System.out.println((i & (1 << j))+" ::1<< j:: " + i +" :i: "+(1 << j));
//				System.out.println(seq1.charAt(i)+" icharj"+seq1.charAt(j+1));
				
			}
			 System.out.println(sb.toString());
			result.add("'" + sb.toString() + "'");
		}
		   System.out.println(result);
		return null;
	}
	
	public void prinstSubseqr(String ip, String opstr) {
		if(ip.length()==0) {			
			 System.out.println(opstr);
			 return;
		}
		
		prinstSubseqr(ip.substring(1),opstr);
		prinstSubseqr(ip.substring(1),opstr+ip.charAt(0));
	}
	public void prinstSubseqr(String ip) {
		prinstSubseqr(ip,"");
	}
	
	
	public static void main(String[] args) {
		AllSubseq seq = new AllSubseq();
//		seq.printseq("Apple");
		
		seq.prinstSubseqr("xyz");
		
	}
	

}
