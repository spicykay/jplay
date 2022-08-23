package Leetcode.dp.coinchangeTwo;

import java.util.*;

public class BottomUp {
    private static int coinChange(int amount, int[] coins) {
        int N = coins.length;
        int[][] memo = new int[N+1][amount+1];
        memo[0][0] = 1;

        for(int i = 1; i<N+1; i++) {
            int coin = coins[i-1];
            for(int amt = 0; amt <= amount; amt++) {
                int prior = memo[i-1][amt];
                memo[i][amt] = prior;
                //System.out.printf("[coin: %d, amt: %d] prior: %d\n", coin, amt, prior);
                if(coin <= amt) {
                    int complementAmt = amt - coin;
                    memo[i][amt] += memo[i][complementAmt];
                }
            }
        }
        //System.out.println(Arrays.deepToString(memo));
        return memo[N][amount];
    }

    private static int coinChangeMemoryOptimized(int amount, int[] coins) {
        int N = coins.length;
        int[] memo = new int[amount+1];
        memo[0] = 1;

        for(int i = 1; i<N+1; i++) {
            int coin = coins[i-1];
            for(int amt = 0; amt <= amount; amt++) {
                int prior = memo[amt];
                if(coin <= amt) {
                    int complementSum = amt - coin;
                    prior += memo[complementSum];
                }
                memo[amt] = prior;
            }
        }
        //System.out.println(Arrays.deepToString(memo));
        return memo[amount];
    }

    public static void main(String[] args) {
        int res = coinChangeMemoryOptimized(5, new int[]{1, 2, 5});
        System.out.println(res);
    }

}
