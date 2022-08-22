package Leetcode.dp.triangle;

import java.util.*;


public class BottomUpSolution {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int R = triangle.size();
        if(R == 0) return 0;
        int[][] memo = new int[R+1][R+1];

        for(int r = R-1; r >= 0; r--) {
            for(int c = 0; c<triangle.get(r).size(); c++) {
                int curr = triangle.get(r).get(c);
                int prior = Math.min(memo[r+1][c], memo[r+1][c+1]);
                memo[r][c] = curr + prior;
            }
        }
        return memo[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = List.of(
            List.of(2),
            List.of(3, 4),
            List.of(6, 5, 7),
            List.of(4, 1, 8, 3)
        );
        int res = minimumTotal(triangle);
        System.out.println(res);
    }

}
