package Leetcode.dp.RussianDollEnvelopes;

import java.util.*;

public class BruteForce {

    private static boolean canFitInside(int[] candidate, int[] curr) {
        return curr[0] > candidate[0] && curr[1] > candidate[1];
    }

    private static boolean canFitOver(int[] candidate, int[] curr) {
        return curr[0] < candidate[0] && curr[1] < candidate[1];
    }

    private static int dfs(int[][] envelopes, int i, int N, Deque<int[]> list) {
        if(i == N) return list.size();

        int[] curr = envelopes[i];

        // should I add?
        int include = 0;
        if(list.isEmpty() || canFitInside(curr, list.peekLast()) || canFitOver(curr, list.peekFirst())) {
            if(list.isEmpty()) {
                list.offer(curr);
                include = dfs(envelopes, i+1, N, list);
                list.poll();
            } else if(canFitInside(curr, list.peekLast())) {
                list.offerLast(curr);
                include = dfs(envelopes, i+1, N, list);
                list.pollLast();
            } else if(canFitOver(curr, list.peekFirst())) {
                list.offerFirst(curr);
                include = dfs(envelopes, i+1, N, list);
                list.pollFirst();
            }
        }

        // should I not add?
        int notInclude = dfs(envelopes, i+1, N, list);

        return Math.max(notInclude, include);
    }

    private static int maxLayers(int[][] envelopes) {
        int N = envelopes.length;
        Deque<int[]> dq = new ArrayDeque<>();
        return dfs(envelopes, 0, N, dq);
    }

    public static void main(String[] args) {
        int[][] envelopes = new int[][]{
            {5, 4}, {6, 4}, {6, 7}, {2, 3}
        };
        int res = maxLayers(envelopes);
        System.out.println(res);
    }

}
