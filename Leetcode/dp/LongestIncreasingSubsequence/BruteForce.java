package Leetcode.dp.LongestIncreasingSubsequence;

import java.util.*;

public class BruteForce {

    private static int dfs(int[] nums, int i, List<Integer> nList) {
        if(i == nums.length) return nList.size();

        int include = 0;
        if(nList.isEmpty() || nums[i] > nList.get(nList.size()-1)) {
            nList.add(nums[i]);
            include = dfs(nums, i+1, nList);
            nList.remove(nList.size()-1);
        }
        int notInclude = dfs(nums, i+1, nList);
        return Math.max(include, notInclude);
    }

    public static int longestSubLen(int[] nums) {
        return dfs(nums, 0, new ArrayList<>());
    }

    public static void main(String[] args) {
        int res = longestSubLen(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(res);
    }

}
