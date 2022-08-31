package Leetcode.dp.LongestCommonSubsequence;

import java.util.*;

public class TopDown {

    private static int dfs(String longer, String shorter, int l, int s) {
        if(l == 0 || s == 0) return 0;
        if(longer.charAt(l-1) == shorter.charAt(s-1)) {
            return dfs(longer, shorter, l-1, s-1) + 1;
        } else {
            return Math.max(dfs(longer, shorter, l-1, s), dfs(longer, shorter, l, s-1));
        }
    }


    private static int dfsMemoized(String longer, String shorter, int l, int s, Integer[][] memo) {
        if(l == 0 || s == 0) {
            memo[l][s] = 0;
            return 0;
        }
        if(memo[l][s] != null) return memo[l][s];
        int max = 0;
        if(longer.charAt(l-1) == shorter.charAt(s-1)) {
            max = dfs(longer, shorter, l-1, s-1) + 1;
        } else {
            max = Math.max(dfs(longer, shorter, l-1, s), dfs(longer, shorter, l, s-1));
        }
        memo[l][s] = max;
        return max;
    }


    private static int longestCommonSubsequence(String s1, String s2) {
        String longer = null, shorter = null;
        if(s1.length() > s2.length()) {
            longer = s1;
            shorter = s2;
        } else {
            longer = s2;
            shorter = s1;
        }
        Integer[][] memo = new Integer[longer.length() +1][shorter.length()+1];
        return dfsMemoized(longer, shorter, longer.length(), shorter.length(), memo);
    }

    public static void main(String[] args) {

        int res = longestCommonSubsequence("abcde", "ace");
        System.out.println(res);
    }

}
