package Leetcode.dp.NumberRobotPaths;

import java.util.*;

public class BottomUp {

    private static int uniquePaths(int r, int c) {
        int[][] memo = new int[r+1][c+1];
        for(int i = 0; i<r; i++) {
            memo[i][c] = 1;
        }

        for(int i = 0; i<c; i++) {
            memo[r][i] = 1;
        }

        for(int col = c - 1; col >=1; col--) {
            for(int row = r - 1; row >= 1; row--) {
                memo[row][col] = memo[row+1][col] + memo[row][col+1];
            }
        }

        return memo[1][1];
    }

    public static void main(String[] args) {

        int res = uniquePaths(3, 5);
        System.out.println(res);
    }

}
