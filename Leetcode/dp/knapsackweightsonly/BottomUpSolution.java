package Leetcode.dp.knapsackweightsonly;

import java.util.*;


/**
 * - The idea of any bottom-up solution is to:
 *      - work from the smallest cases and "combine" them together
 *      - Continue this until we get our desired solution
 * - By looping through each item, we determine which sums we can construct
 *   based on if there exists a smaller sum that we can build on top of.
 *
 * Example:
 * - Suppose we already built all possible sums of [1, 3, 3].
 * - We now want to know which sums we can build using all of [1,3,3,5].
 *
 * d[i][s] = dp[i-1][s] || dp[i-1][s-weights.get(i-1)].
 */
class BottomUpSolution {

    public static List<Integer> knapsackWeightOnly(List<Integer> weights) {
        int L = weights.size();
        final List<Integer> res = new ArrayList<>();
        Integer solutions = weights.stream().reduce(0, (a, b) -> a + b);

        /**
         * We define a memo
         *
         *    0  1  2 // each column represents 1 possible solution.
         * 0 [ ][ ][ ]
         * 1 [ ][ ][ ] // for each row, r: i = r + 1. i represents the weight index
         */
        boolean[][] memo = new boolean[L+1][solutions+1];
        // naturally, the solution 0,0 would be true.
        memo[0][0] = true;
        System.out.printf("L: %d, solutions: %d\n", L, solutions);

        // we iterate through the memo's length
        // we don't care about index 0, because i = r - 1. So if we want to process i = 0, we start at r = 1.
        for(int i = 1; i<memo.length; i++) {
            // we iterate through each possible solution
            for(int j = 0; j<memo[i].length; j++) {
                int curr = weights.get(i-1);
                // if the prior row has that solution, we want to transfer it.
                // Because the solutions for [1, 3, 3] would contain all solutions for [1, 3]
                if(memo[i-1][j]) {
                    memo[i][j] = true;
                }

                // we want to add the solutions for this row based on the last row.
                if(j - curr >= 0 && memo[i-1][j - curr]) {
                    memo[i][j] = true;
                }
            }
        }

        for(int i = 0; i<memo[L].length; i++) {
            if(memo[L][i]) {
                res.add(i);
            }
        }

        return res;
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
