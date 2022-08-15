package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class tbd {
    public boolean digitCount(String num) {
        int[] cnt = new int[11];
        char[] charArr = num.toCharArray();
        for (char d : charArr) {
            ++cnt[d - '0'];
        }
        for (int i = 0; i < charArr.length; ++i) {
            if (cnt[i] != charArr[i] - '0') {
                return false;
            }
        }
        return true;
    }
	
    
    public long maximumImportance(int n, int[][] roads) {
        // degree edges of nodes
        final int[] degree = new int[n];
        for (int[] road : roads) {
          degree[road[0]]++;
          degree[road[1]]++;
        }

        // assign larger value to larger degree node
        Arrays.sort(degree); //[2, 3, 4, 2, 1]=[1, 2, 2, 3, 4]
        long result = 0;
        for (int i = 0; i < n; i++) {
          result += (long) degree[i] * (i + 1);
        }
        return result;
      }
	
	public static void main(String args[])
	  {
		tbd tb = new tbd();
		System.out.println(tb.digitCount("1210"));
		System.out.println(tb.maximumImportance(5, new int[][] {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}}));	
		
		
		}

}
