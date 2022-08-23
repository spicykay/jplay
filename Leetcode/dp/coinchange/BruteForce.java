package Leetcode.dp.coinchange;

import java.util.*;

public class BruteForce {

    private static int dfs(List<Integer> coins, int sum, int ct) {
        if(sum < 0) return -1;
        if(sum == 0) return ct;

        Integer min = null;
        for(Integer c : coins) {
            int res = dfs(coins, sum - c, ct + 1);
            if(res < 0) continue;
            if(min == null) {
                min = res;
            } else {
                min = Math.min(min, res);
            }
        }

        return min == null ? -1 : min;
    }


    private static int coinChange(List<Integer> coins, int amount) {
        return dfs(coins, amount, 0);

    }

    public static void main(String[] args) {
        List<Integer> coins = List.of(3);

        int res = coinChange(coins, 11);
        System.out.println(res);
    }
}
