package Leetcode.dp.coinchange;

import java.util.*;

public class TopDown {

    private static int dfs(List<Integer> coins, int sum, int ct, Integer[][] memo) {
        if(sum < 0) return -1;
        if(sum == 0) return ct;

        Integer min = null;
        for(Integer c : coins) {
            if(sum - c < 0) continue;
            Integer res = memo[sum - c][ct+1];
            if(res == null) {
                res = dfs(coins, sum - c, ct + 1, memo);
            }
            if(res < 0) continue;
            min = min == null ? res : Math.min(min, res);
        }
        min = min == null ? -1 : min;

        memo[sum][ct] = min;
        return min;
    }


    private static int coinChange(List<Integer> coins, int amount) {
        Integer[][] memo = new Integer[amount+1][amount+1];
        return dfs(coins, amount, 0, memo);

    }

    public static void main(String[] args) {
        List<Integer> coins = List.of(1, 2, 5);

        int res = coinChange(coins, 11);
        System.out.println(res);
    }
}
