package com.javatechie;

public class CountNoOfIsland {
	public static void main(String[] args) {
		//int[][] a={{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
		//int[][] a= {{0, 1, 1, 0, 0},{1 ,0, 0, 1, 0},{0 ,0 ,1 ,0 ,0},{1 ,0 ,0 ,0 ,1}};
		int[][] a= {{1 ,0 ,0 ,1},{0 ,1 ,1 ,0},{0 ,1 ,1 ,0},{1 ,0 ,0 ,1}};
		System.out.println("No of Island "+countNoOfIsland(a));
		
	}

	private static int countNoOfIsland(int[][] a) {
		int row=a.length;
		int col=a[0].length;
		int noOfIsland=0;
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(a[i][j]==1)
				{
					//markCurrentIsland(a,i,j,row,col);
					dfs(a,i,j);
					noOfIsland++;
				}
			}
		}
		return noOfIsland;
	}
	
	
	private static void dfs(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] != 1) {
            return;
        }

        grid[i][j] =2; // Mark current cell as visited

        // Check adjacent cells in all eight directions
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j + 1);
        dfs(grid, i + 1, j - 1);
        dfs(grid, i - 1, j + 1);
        dfs(grid, i - 1, j - 1);
    }

	private static void markCurrentIsland(int[][] a, int x, int y, int row, int col) {
		if(x<0||x>=row || y<0 || y>=col || a[x][y]!=1)
			return;
		a[x][y]=2;
		markCurrentIsland(a,x+1,y,row,col);
		markCurrentIsland(a,x-1,y,row,col);
		markCurrentIsland(a,x,y+1,row,col);
		markCurrentIsland(a,x,y-1,row,col);
		
	}
	
	
}
