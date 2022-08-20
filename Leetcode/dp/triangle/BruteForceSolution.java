package Leetcode.dp.triangle;

import java.util.*;


public class BruteForceSolution {

    private static int dfs(int sum, int r, int c, List<List<Integer>> triangle) {
        int R = triangle.size();
        if(R == 0) return sum;
        int C = triangle.get(0).size();
        List<Integer> row = triangle.get(r);
        int curr = row.get(c);
        if(r >= R-1) {
            return curr;
        }
        int left = curr + dfs(sum, r+1, c, triangle);
        int right = curr + dfs(sum, r+1, c+1, triangle);


        return Math.min(left, right);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        return dfs(0, 0, 0, triangle);
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
