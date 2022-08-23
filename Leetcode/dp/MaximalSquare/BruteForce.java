package Leetcode.dp.MaximalSquare;

import java.util.*;

public class BruteForce {


    private static int maximalSquare(int[][] grid) {
        int R = grid.length;
        if(R == 0) return -1;
        int C = grid[0].length;
        return 0;
    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{
            {1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 1, 0}
        };
        int res = maximalSquare(grid);
        System.out.println(res);
    }

}
