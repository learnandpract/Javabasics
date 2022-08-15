package Algo;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
	private List<Integer> ans = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] arr) {//54
        dfs(arr, 0, 0, false);
        return ans;
    }

    private void dfs(int[][] arr, int row, int col, boolean goup) {
        if (row < 0 || col < 0 || row >= arr.length || col >= arr[row].length || arr[row][col] == 101)//less than 100 
        	return;
        ans.add(arr[row][col]);
        arr[row][col] = 101;

        if (goup) 
        	dfs(arr, row - 1, col, true);

        dfs(arr, row, col + 1, false);
        dfs(arr, row + 1, col, false);
        dfs(arr, row, col - 1, false);
        dfs(arr, row - 1, col, true);
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
