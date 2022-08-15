import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
	
	public int[][] pascalTri(int n) { //118 , original
//		Input: numRows = 5
//		Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
		
		int[][] p = new int[n][] ;
		p[0]  = new int[] {1};
		for(int j =1; j<n; j++) {
			p[j] =  new int[j+1];
			p[j][0] =1;
			p[j][j] =1;
			for(int k =1;k<=j-1;k++) {			
				p[j][k]= p[j-1][k-1]+p[j-1][k]; // p[3][2]= p[2][1]+p[2][2] 
			}				
		}		
		return p;
		
	}
	
	public List<List<Integer>> generatePascalTri(int numRows) //118 lc
	{
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<numRows;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
				row.set(j, row.get(j)+row.get(j+1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;
		
	}

	public List<Integer> generatePascalTri_2(int numRows) //119 lc
	{
//		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<numRows;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
				row.set(j, row.get(j)+row.get(j+1));
//			allrows.add(new ArrayList<Integer>(row));
		}
		return row;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangle pt = new PascalTriangle();
//		System.out.println(Arrays.toString(pt.pascalTri(5)));
		System.out.println(pt.generatePascalTri(5));
		System.out.println(pt.generatePascalTri_2(5));
	}

}

