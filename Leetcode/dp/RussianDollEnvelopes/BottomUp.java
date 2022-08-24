package Leetcode.dp.RussianDollEnvelopes;

import java.util.*;

public class BottomUp {

    private static boolean canFitInside(int[] candidate, int[] curr) {
        return curr[0] > candidate[0] && curr[1] > candidate[1];
    }

    private static boolean canFitOver(int[] candidate, int[] curr) {
        return curr[0] < candidate[0] && curr[1] < candidate[1];
    }

    private static int maxLayers(int[][] e) {
        int N = e.length;
        Arrays.sort(e, (a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1]));
        int[] memo = new int[N];
        int max = 0;

        for(int i = 0; i<N; i++) {
            int[] curr = e[i];
            int layers = 0;
            for(int j = i-1; j>=0; j--) {
                if(canFitInside(e[j], curr)) {
                    layers = Math.max(layers, memo[j]);
                }
            }

            memo[i] = layers + 1;
            max = Math.max(max, memo[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] envelopes = new int[][]{
            {5, 4}, {6, 4}, {6, 7}, {2, 3}
        };
        int res = maxLayers(envelopes);
        System.out.println(res);
    }

}
