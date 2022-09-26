package Leetcode.dp.EditDistance;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int res = editDistance("algomonster", "almost");
        System.out.println(res);
    }

    private static int editDistance(String s1, String s2) {
        int R = s1.length(), C = s2.length();
        int[][] memo = new int[R+1][C+1];


        for(int r = 0; r<=R; r++) {
            for(int c = 0; c<=C; c++) {
                if(r == 0 || c == 0) {
                    memo[r][c] = c == 0 ? r : c;
                    continue;
                }
                if(s1.charAt(r-1) == s2.charAt(c-1)) {
                    memo[r][c] = memo[r-1][c-1];
                } else {
                    memo[r][c] = Math.min(memo[r-1][c-1], Math.min(memo[r][c-1], memo[r-1][c])) + 1;
                }
            }
        }

        //System.out.println(Arrays.deepToString(memo));
        return memo[R][C];
    }
}
