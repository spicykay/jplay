package Leetcode.MinimumPathSum;

import java.util.Arrays;

class Solution {

    private int dfs(int[][] grid, int[][] memo, int x, int y, int R, int C) {
        int r = R - x, c = C - y;
        if(x == 1 && y == 1) return grid[r][c];
        int val = grid[r][c], right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;


        // get right
        if(c + 1 < C) {
            if(memo[x][y-1] != -1) {
                right = memo[x][y-1];
            } else {
                right = dfs(grid, memo, x, y-1, R, C);
            }
        }

        // get bottom
        if(r + 1 < R) {
            if(memo[x-1][y] != -1) {
                down = memo[x-1][y];
            } else {
                down = dfs(grid, memo, x-1, y, R, C);
            }
        }

        //System.out.printf("r/c[%d, %d]; x,y[%d, %d]; val: %d; r,l[%d, %d]\n", r, c, x, y, val, right, down);

        return val + Math.min(right, down);
    }

    public int minPathSum(int[][] grid) {
        int R = grid.length;
        if(R == 0) return 0;
        int C = grid[0].length;
        // initialize memo
        int[][] memo = new int[R+1][C+1];
        for(int i = 0; i<memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        memo[1][1] = grid[R-1][C-1];

        return dfs(grid, memo, R, C, R, C);
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
