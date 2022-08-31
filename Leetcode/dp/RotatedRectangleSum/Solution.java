package Leetcode.dp.RotatedRectangleSum;

import java.util.Arrays;

public class Solution {

    public static int maxRectangle(int[][] matrix) {
        int R = matrix.length;
        if(R < 3) return 0;
        int C = matrix[0].length;
        if(C < 3) return 0;

        int[][] dimonds = new int[R][C];

        for(int r = R-3; r>=0; r--) {
            for(int c = C - 2; c >= 1; c--) {
                int dSize = calculateDiamond(matrix, r, c);
                // check right flank
                if(r+1 < R && c + 1 < C && matrix[r+1][c+1] > 0) {
                    int combinedSize = dSize + matrix[r+1][c+1];
                }
            }
        }
        System.out.println(Arrays.deepToString(dimonds));
        return 0;
    }

    private static int calculateDiamond(int[][] m, int r, int c) {
        int sum = 0;

        // calculate the center.
        for(int i = 0; i<3; i++) {
            sum += m[r+i][c];
        }
        // calculate left and right flanks
        sum = sum + m[r+1][c-1] + m[r+1][c+1];
        return sum;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1, 2, 3, 4, 0},
            {5, 6, 7, 8, 1},
            {3, 2, 4, 1, 4},
            {4, 3, 5, 1, 6}
        };
        System.out.println(maxRectangle(matrix));

    }

}
