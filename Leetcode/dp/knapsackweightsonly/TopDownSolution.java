package Leetcode.dp.knapsackweightsonly;

import java.util.*;

class TopDownSolution {
    private static void dfs(List<Integer> weights, Set<Integer> res, int sum, int i, boolean[][] memo) {
        if(memo[i][sum]) return;
        if(i == weights.size()) {
            res.add(sum);
            return;
        }
        memo[i][sum] = true;
        dfs(weights, res, sum + weights.get(i), i+1, memo);
        dfs(weights, res, sum, i+1, memo);
    }

    public static List<Integer> knapsackWeightOnly(List<Integer> weights) {
        final Set<Integer> res = new HashSet<>();
        int totSum = 0;
        for(int weight: weights) {
            totSum += weight;
        }
        boolean[][] memo = new boolean[weights.size()+1][totSum +1];
        dfs(weights, res, 0, 0, memo);
        return new ArrayList<>(res);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        List<Integer> weights = List.of(1, 3, 3, 5);
        List<Integer> res = knapsackWeightOnly(weights);
        Collections.sort(res);
        System.out.println(res.toString());
    }
}
