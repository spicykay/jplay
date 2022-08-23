package Leetcode.dp.coinchange;

import java.util.*;

public class BottomUp {


    private static int coinChange(List<Integer> coins, int amount) {
        int[] memo = new int[amount+1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        for(int i = 1; i<=amount; i++) {
            for(int c: coins) {
                if(c > i) continue;
                int priorSum = i - c;
                if(memo[priorSum] == Integer.MAX_VALUE) continue;
                memo[i] = Math.min(memo[i], memo[priorSum] + 1);
            }
        }

        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }

    public static void main(String[] args) {
        List<Integer> coins = List.of(1, 2, 5);

        int res = coinChange(coins, 11);
        System.out.println(res);
    }
}
