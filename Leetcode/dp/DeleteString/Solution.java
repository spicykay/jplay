package Leetcode.dp.DeleteString;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] costs = new int[]{1, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(deleteString(costs, "abb", "bba"));
    }

    private static int deleteString(int[] costs, String s1, String s2) {
        int R = s1.length(), C = s2.length();
        int[][] memo = new int[R+1][C+1];

        for(int r = 0; r<=R; r++) {
            for(int c = 0; c<=C; c++) {
                if(r == 0 && c == 0) {
                    memo[r][c] = 0;
                    continue;
                }
                if(r == 0 || c == 0) {
                    int prior = r == 0 ? memo[r][c-1] : memo[r-1][c];
                    memo[r][c] = prior + (c == 0 ? costs[s2.charAt(r-1) - 'a'] : costs[s1.charAt(c-1) - 'a']);
                    continue;
                }
                if(s1.charAt(c - 1) == s2.charAt(r - 1)) {
                    memo[r][c] = memo[r-1][c-1];
                } else {
                    int leftCost = memo[r][c-1] + costs[s1.charAt(c-1) - 'a'];
                    int topCost = memo[r-1][c] + costs[s2.charAt(r-1) - 'a'];
                    memo[r][c] = Math.min(leftCost, topCost);
                }
            }
        }
        System.out.println(Arrays.deepToString(memo));
        return memo[R][C];
    }

}
