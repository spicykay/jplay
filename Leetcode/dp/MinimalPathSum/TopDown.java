package Leetcode.dp.MinimalPathSum;

import java.util.*;

public class TopDown {

    private static int minPathSum(int[][] grid) {
        int R = grid.length;
        if(R == 0) return -1;
        int C = grid[0].length;
        int[][] memo = new int[R][C];

        // fill in the columns
        for(int c = 0; c<C; c++) {
            int prior = c == 0 ? 0 : memo[0][c-1];
            memo[0][c] = prior + grid[R - 1][C - c - 1];
        }

        // fill in the rows
        for(int r = 0; r < R; r++) {
            int priorRowVal = r == 0 ? 0 : memo[r-1][0];
            memo[r][0] = priorRowVal + grid[R - r - 1][C - 1];
        }

        // calculate the numbers
        for(int r = 1; r < R; r++) {
            for(int c = 1; c < C; c++) {
                memo[r][c] = grid[R - r - 1][C - c - 1] + Math.min(memo[r - 1][c], memo[r][c-1]);
            }
        }

        return memo[R-1][C-1];
    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        int res = minPathSum(grid);
        System.out.println(res);
    }

}
