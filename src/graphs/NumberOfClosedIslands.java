package graphs;

import java.util.HashSet;

public class NumberOfClosedIslands {

    public static int numClosedIslands(int[][] grid) {

        HashSet<String> visited = new HashSet<>();

        int result = 0;
        for(int i=0; i<grid.length; i++) {
            int[] row = grid[i];
            for(int j=0; j<row.length; j++) {
                if(grid[i][j] == 0 && !visited.contains(i +","+ j)) {
                    result += dfs(i, j, grid, visited);
                }
            }
        }
        return result;
    }

    // return 1 if it's a closed island and 0 otherwise
    public static int dfs(int row, int col, int[][] grid, HashSet<String> visited) {

        if(row < 0 || col < 0 || row==grid.length || col==grid[0].length) {
            return 0;
        }

        // we hit water or we already visited the spot, then it's a closed island
        if(grid[row][col] == 1 || visited.contains(row+","+col)) {
            return 1;
        }

        visited.add(row+","+col);

        int down = dfs(row+1, col, grid, visited);
        int up = dfs(row-1, col, grid, visited);
        int right = dfs(row, col+1, grid, visited);
        int left = dfs(row, col-1, grid, visited);

        return Math.min(Math.min(Math.min(down, up),right),left);
    }

    public static void main(String[] args) {
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
