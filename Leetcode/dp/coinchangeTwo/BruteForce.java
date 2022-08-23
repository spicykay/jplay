package Leetcode.dp.coinchangeTwo;

import java.util.*;

public class BruteForce {

    private static int dfs(int sum, int i, int[] coins, Integer[][] memo) {
        if(sum == 0) return 1;
        if(sum < 0) return 0;
        if(memo[i][sum] != null) return memo[i][sum];

        int ways = 0;
        for(; i<coins.length; i++) {
            int coin = coins[i];
            if(coin > sum) continue;
            ways += dfs(sum - coin, i, coins, memo);
        }
        memo[i][sum] = ways;
        return ways;
    }

    private static int coinChange(int amount, int[] coins) {
        Integer[][] memo = new Integer[coins.length+1][amount+1];
        return dfs(amount, 0, coins, memo);
    }

    public static void main(String[] args) {
        List<Integer> coins = List.of(1, 2, 5);

        int res = coinChange(5, new int[]{1, 2, 5});
        System.out.println(res);
    }

}
