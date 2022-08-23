package Leetcode.dp.NumberRobotPaths;

import java.util.*;

public class TopDown {

    private static int dfs(int r, int c, int R, int C, Integer[][] memo) {
        if(r+1 == R && c+1 == C) return 1;
        if(memo[r][c] != null) return memo[r][c];

        int ways = 0;
        if(c + 1 < C) {
            ways += dfs(r, c+1, R, C, memo);
        }
        if(r+1 < R) {
            ways += dfs(r+1, c, R, C, memo);
        }
        memo[r][c] = ways;
        return ways;
    }

    private static int uniquePaths(int r, int c) {
        Integer[][] memo = new Integer[r+1][c+1];
        return dfs(0, 0, r, c, memo);
    }

    public static void main(String[] args) {

        int res = uniquePaths(3, 5);
        System.out.println(res);
    }

}
