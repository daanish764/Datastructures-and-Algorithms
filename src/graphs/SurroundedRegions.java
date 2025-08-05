package graphs;

import java.util.Arrays;

public class SurroundedRegions {

    public static void solve(char[][] board) {
        for(int row=0; row<board.length; row++) {
            for(int col=0; col<board[0].length; col++) {
                if(row==0 || row==board.length-1 || col==0 || col==board[0].length-1) {
                    if(board[row][col] == 'O') {
                        dfs(row, col, board);
                    }
                }
            }
        }


        for(int row=0; row<board.length; row++) {
            for(int col=0; col<board[0].length; col++) {
                if(board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }

        for(int row=0; row<board.length; row++) {
            for(int col=0; col<board[0].length; col++) {
                if(board[row][col] == 'F') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    public static void dfs(int row, int col, char[][] board) {

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }

        if(board[row][col]=='O') {
            board[row][col] ='F';

            dfs(row-1, col, board);
            dfs(row+1, col, board);
            dfs(row, col-1, board);
            dfs(row, col+1, board);
        }

    }



    public static void main(String[] args) {



        char[][] board = {
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        };



        Arrays.stream(board).forEach(System.out::println);
        System.out.println("---------------");
        solve(board);

        Arrays.stream(board).forEach(System.out::println);
    }

}
