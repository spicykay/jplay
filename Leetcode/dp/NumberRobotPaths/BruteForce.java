package Leetcode.dp.NumberRobotPaths;

import java.util.*;

public class BruteForce {

    private static int dfs(int r, int c, int R, int C) {
        if(r+1 == R && c+1 == C) return 1;
        int ways = 0;
        if(c + 1 < C) {
            ways += dfs(r, c+1, R, C);
        }
        if(r+1 < R) {
            ways += dfs(r+1, c, R, C);
        }
        return ways;
    }

    private static int uniquePaths(int r, int c) {
        return dfs(0, 0, r, c);
    }

    public static void main(String[] args) {

        int res = uniquePaths(3, 5);
        System.out.println(res);
    }

}
