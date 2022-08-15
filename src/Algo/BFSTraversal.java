package Algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSTraversal {
	//https://algorithms.tutorialhorizon.com/breadth-first-search-bfs-in-2d-matrix-2d-array/
    public void BFS(int[][] grid) {

        int h = grid.length;
        if (h == 0)
            return;
        int l = grid[0].length;

        boolean[][] visited = new boolean[h][l];

        Queue<String> queue = new LinkedList<>();

        queue.add(0 + "," + 0);

        System.out.println("Breadth-First Traversal: ");
        while (queue.isEmpty() == false) {

            String x = queue.remove();
            int row = Integer.parseInt(x.split(",")[0]);
            int col = Integer.parseInt(x.split(",")[1]);

            if (row < 0 || col < 0 || row >= h || col >= l || visited[row][col])
                continue;

            visited[row][col] = true;
            System.out.print(grid[row][col] + " ");
            queue.add(row + "," + (col - 1)); //go left
            queue.add(row + "," + (col + 1)); //go right
            queue.add((row - 1) + "," + col); //go up
            queue.add((row + 1) + "," + col); //go down
        }
    }
    
    
    public void DFS(int[][] grid) { //DFS Iterative 
    	//https://algorithms.tutorialhorizon.com/depth-first-search-dfs-in-2d-matrix-2d-array-iterative-solution/
    	//https://algorithms.tutorialhorizon.com/depth-first-search-dfs-in-2d-matrix-2d-array-iterative-solution/

        int h = grid.length;
        if (h == 0)
            return;
        int l = grid[0].length;

        boolean[][] visited = new boolean[h][l];

        Stack<String> stack = new Stack<>();

        stack.push(0 + "," + 0);

        System.out.println("Depth-First Traversal: ");
        while (stack.empty() == false) {

            String x = stack.pop();
            int row = Integer.parseInt(x.split(",")[0]);
            int col = Integer.parseInt(x.split(",")[1]);

            if(row<0 || col<0 || row>=h || col>=l || visited[row][col])
                continue;

            visited[row][col]=true;
            System.out.print(grid[row][col] + " ");
            stack.push(row + "," + (col-1)); //go left
            stack.push(row + "," + (col+1)); //go right
            stack.push((row-1) + "," + col); //go up
            stack.push((row+1) + "," + col); //go down
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {//733 ,DFS(can also use stack)
    	//https://algorithms.tutorialhorizon.com/depth-first-search-dfs-in-2d-matrix-2d-array-recursive-solution/
    	
    	int original = image[sr][sc];
    	fill(image,sr,sc,newColor,image[sr][sc]);
    	return image;
    }
    public void fill(int[][] image, int sr, int sc, int newColor, int oldColor) {
    	
    	if(sr<0||sc<0||sr >= image.length||sc>=image[0].length||image[sr][sc]!=oldColor) {
    		return;    		
    	}
    		image[sr][sc]=newColor;
    	fill(image,sr+1,sc,newColor,oldColor);
    	fill(image,sr-1,sc,newColor,oldColor);
    	fill(image,sr,sc+1,newColor,oldColor);
    	fill(image,sr,sc-1,newColor,oldColor);
    }
    public int numIslands_trial(char[][] grid) {//200 medium
		 int count =0;
		 int m =  grid.length;
		 int n = grid[0].length;
		 // get rows and column length
		 
		 for(int i = 0; i< m;i++) {
			 for(int j =0;j<n;j++) { // matrix iteration
				 if(grid[i][j]=='1') {// then check recursively if the next row/column/diagonal is 1					
					dfs(grid,i,j);
					 ++count;					 
				 }				 
			 }
		 }	
	        return count;
	    }
    public void dfs(char[][] grid, int i , int j) {
		 if(i<0 || j<0 ||i>= grid.length || j>= grid[0].length|| grid[i][j]!='1') {
			 return;
		}
		 grid[i][j] ='0';
		 dfs(grid,i+1,j);
		 dfs(grid,i-1,j);
		 dfs(grid,i,j+1);		
		 dfs(grid,i,j-1);
	 }

    public static void main(String[] args) {

        int [][] grid = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        BFSTraversal d = new BFSTraversal();
        d.BFS(grid);
    }
}