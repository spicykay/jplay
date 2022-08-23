package Leetcode.dp.LongestIncreasingSubsequence;

import java.util.*;

public class BottomUp {

    public static int longestSubLen(int[] nums) {
        int N = nums.length, max = 0;
        int[] memo = new int[N+1];

        for(int i = 1; i<=N; i++) {
            int curr = nums[i-1];
            memo[i] = memo[0] + 1;
            for(int j = 1; j<i; j++) {
                int jVal = nums[j-1];
                if(jVal < curr) {
                    memo[i] = Math.max(memo[i], memo[j]+1);
                }
            }
            max = Math.max(max, memo[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int res = longestSubLen(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(res);
    }

}
