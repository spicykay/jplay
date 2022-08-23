package Leetcode.dp.MinimalPathSum;

import java.util.*;

public class BottomUp {

    // TODO
    private static int dfs(int[][] grid, int r, int c, int R, int C, int sum, Integer[][] memo) {
        if(c < 0 || c >= C || r < 0 || r >= R) return 0;
        sum += grid[r][c];
        if(R -1 == r && C -1 == c) {
            return sum;
        }
        //if(memo[r][c] != null) return memo[r][c];

        int res = Integer.MAX_VALUE;
        // down sum
        if(r + 1 < R) {
            res = dfs(grid, r+1, c, R, C, sum, memo);
        }

        if(c + 1 < C) {
            res = Math.min(res, dfs(grid, r, c + 1, R, C, sum, memo));
        }

        memo[r][c] = res;
        return res;
    }

    private static int minPathSum(int[][] grid) {
        int R = grid.length;
        if(R == 0) return -1;
        int C = grid[0].length;
        Integer[][] memo = new Integer[R+1][C+1];
        int res = dfs(grid, 0, 0, R, C, 0, memo);
        System.out.println(Arrays.deepToString(memo));
        return res;
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
