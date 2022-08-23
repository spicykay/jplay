package Leetcode.dp.MinimalPathSum;

import java.util.*;

public class BruteForce {

    private static int dfs(int[][] grid, int r, int c, int R, int C, int sum) {
        sum += grid[r][c];
        if(R -1 == r && C -1 == c) {
            return sum;
        }
        int res = Integer.MAX_VALUE;
        // down sum
        if(r + 1 < R) {
            res = dfs(grid, r+1, c, R, C, sum);
        }

        if(c + 1 < C) {
            res = Math.min(res, dfs(grid, r, c + 1, R, C, sum));
        }

        return res;
    }

    private static int minPathSum(int[][] grid) {
        int R = grid.length;
        if(R == 0) return -1;
        int C = grid[0].length;
        return dfs(grid, 0, 0, R, C, 0);
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
