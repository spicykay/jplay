package Leetcode.dp.LongestCommonSubsequence;

import java.util.*;

public class BottomUp {


    private static int longestCommonSubsequence(String s1, String s2) {
        String longer = null, shorter = null;
        if(s1.length() > s2.length()) {
            longer = s1;
            shorter = s2;
        } else {
            longer = s2;
            shorter = s1;
        }
        int R = shorter.length(), C = longer.length();
        int[][] memo = new int[R+1][C+1];
        for(int r = 0; r<=R; r++) {
            for(int c = 0; c<=C; c++) {
                if(r == 0 || c == 0) {
                    memo[r][c] = 0;
                } else if(shorter.charAt(r-1) == longer.charAt(c-1)) {
                    memo[r][c] = memo[r-1][c-1]+1;
                } else {
                    memo[r][c] = Math.max(memo[r][c-1], memo[r-1][c]);
                }
            }
        }
        return memo[R][C];
    }

    public static void main(String[] args) {

        int res = longestCommonSubsequence("abcde", "ace");
        System.out.println(res);
    }

}
