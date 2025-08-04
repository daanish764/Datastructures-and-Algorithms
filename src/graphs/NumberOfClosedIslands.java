package graphs;

import java.util.HashSet;

public class NumberOfClosedIslands {

    public static int numClosedIslands(int[][] grid) {

        HashSet<String> visited = new HashSet<>();

        int result = 0;
        for(int row=0; row<grid.length; row++) {
            for(int col=0; col<grid[0].length; col++) {
                if(grid[row][col] == 0 && !visited.contains(row + "," + col)) {
                    result += dfs(row, col, grid, visited);
                }
            }
        }
        return result;
    }

    // return 1 if it's a closed island and 0 otherwise
    public static int dfs(int row, int col, int[][] grid, HashSet<String> visited) {

        // if we reach the edge (this means we dont reach water, then it's not a closed island
        if(row < 0 || col < 0 || row==grid.length || col==grid[0].length) { return 0; }

        if(grid[row][col] == 1 || visited.contains(row+","+col)) {
            return 1;
        }
        visited.add(row+","+col);

        int down = dfs(row+1, col, grid, visited);
        int up = dfs(row-1, col, grid, visited);
        int right = dfs(row, col+1, grid, visited);
        int left = dfs(row, col-1, grid, visited);


        boolean isClosed = up==1 && down==1 && right==1 && left==1;

        return isClosed ? 1 : 0;
    }

    public static void main(String[] args) {
        // 0 is land
        // 1 is water
        // an island is closed if it is surrounded by land
        // 1 on top bottom left right
        // the edge of the board is not considered water
        int[][] grid = {
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };

        System.out.println(numClosedIslands(grid));
    }
}
