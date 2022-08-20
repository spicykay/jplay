package Leetcode.dp.partition_equal_subset_sum;

import java.util.*;

class Solution {
    public static boolean canPartition(List<Integer> nums) {
        int sum = nums.stream().reduce(0, (a, b) -> a + b), L = nums.size();
        int[][] memo = new int[L+1][2];
        memo[0][1] = sum;
        for(int i = 1; i< L+1; i++) {
            int curr = nums.get(i-1);
            memo[i][0] = memo[i-1][0] + curr;
            memo[i][1] = memo[i-1][1] - curr;
            if(memo[i][0] == memo[i][1]) return true;
        }
        return false;
    }

    public static boolean canPartitionMemoryOptimized(List<Integer> nums) {
        int sum = nums.stream().reduce(0, (a, b) -> a + b), L = nums.size();
        // int[][] memo = new int[L+1][2];
        int[] sums = new int[2];
        // memo[0][1] = sum;
        sums[1] = sum;
        for(int i = 0; i< L; i++) {
            int curr = nums.get(i);
            int left = sums[0] + curr;
            int right = sums[1] - curr;
            if(left == right) return true;
            sums[0] = left;
            sums[1] = right;
        }
        return false;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(3, 4, 7);
        boolean res = canPartitionMemoryOptimized(nums);
        System.out.println(res);
    }
}
