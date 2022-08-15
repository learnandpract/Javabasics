import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class dummy {
	
    public int addDigits(int x) {
//    	Intput : 38 , o/p : 3+8=11, 1+1 =2- return
        int ans = 0;
      
        while(x>0) {
        	ans +=  x%10;
        	x = x/10; 
        if(ans>9 && x ==0) {
        	x=ans;
        	ans = 0;
        	
        }
        }
        
    	return ans;
    	
    }
    
  public boolean canConstruct(String ransomNote, String magazine) {
//	  Input: ransomNote = "aab", magazine = "baa"
//			  Output: true
	  
	  for(int i = 0 ; i< magazine.length();i++) {
		  if(ransomNote.charAt(i)== (magazine.charAt(i))) {
			  i++;
			for(int j = 1 ; j< ransomNote.length();j++) {
				if(ransomNote.charAt(j)!= (magazine.charAt(i))) {
					return false;
				}				
			}
			break;
		  }	else {
			  return false;
		  }
	  }	  
	return true;
        
    }
  public int[][] diagonalSort(int[][] mat) {
//	  Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
//			  Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]	  
	  HashMap mp = new HashMap();
	  
	  int col = mat[0].length; //4
	  int row = mat.length;
	  for(int j=0; j<col; j++) {
          List<Integer> arr = new ArrayList();
          int k=j;
          for(int i=0; i<row&&k<col; i++) {
              arr.add(mat[i][k++]);//3,2,1 -- 3,1,2 --1,2 --1
          }
          Collections.sort(arr); //1,2,3 -- 1,2,3--1,2 --1
          k=j;
          int l=0;
          for(int i=0; i<row&&k<col; i++) {
              mat[i][k++] = arr.get(l);
              l++;
          }
      }
      
	  
	  for(int i=1; i< mat.length; i++) {
		  List<Integer> al = new ArrayList(); 
		  int k = i ;
		  
		  for (int j = 0; j < mat[0].length && k< mat.length; j++) {
			  al.add(mat[k++][j]);//2,1 --1
	  }
		  Collections.sort(al); //1,2 --1
		  k=i;
          int l=0;
          for(int j=0; j<mat[0].length && k<mat.length; j++) {
              mat[k++][j] = al.get(l);
              l++;
          }
	  }
	  
	  return mat;
      
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] np = new boolean[2];
		for(boolean i:np) {
			System.out.println(i);
			
		}
		dummy dm = new dummy();
		System.out.println(" 1%10 : "+1%10);//1
		System.out.println(" 1/10 : "+1/10);//0
		
		System.out.println(" 123%10 : "+123%10); //3
		System.out.println(" 123/10 : "+123/10);//12
		
//		System.out.println(dm.addDigits(38)+" Add digits");
//		System.out.println(dm.canConstruct("aab", "baa"));
		int[][] mat = new int[][] {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
		dm.diagonalSort(mat);
		
	}

}
