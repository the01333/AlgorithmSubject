package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

public class NO_221 {
    // 矩阵的宽高以及当前最长边长
    int h, w, square = 0;
    // 以 (i,j) 为左上角所能构成的最大正方形的边长
    int[][] largestSide;

    public int maximalSquare(char[][] matrix) {
        h = matrix.length;
        w = matrix[0].length;
        largestSide = new int[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == '1') {
                    square = Math.max(square, dfs(matrix, i, j));
                }
            }
        }
        return square * square;
    }

    /**
     * 只有当前位置为 1 才能进入递归
     *
     * @param matrix
     * @param row
     * @param col
     * @return
     */
    private int dfs(char[][] matrix, int row, int col) {
        if (row >= h || col >= w || matrix[row][col] == '0') {
            return 0;
        }

        if (largestSide[row][col] > 0) {
            return largestSide[row][col];
        }

        int bottom = dfs(matrix, row + 1, col);
        int right = dfs(matrix, row, col + 1);
        int bottomRight = dfs(matrix, row + 1, col + 1);

        // 只有当前位置为 1 才能进入递归, 所以这里至少 + 1
        largestSide[row][col] = 1 + Math.min(bottom, Math.min(right, bottomRight));
        return largestSide[row][col];
    }

    public static void main(String[] args) {
        System.out.println(new NO_221().maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }) == 4);
        System.out.println(new NO_221().maximalSquare(new char[][]{
                {'0', '1'},
                {'1', '0'}
        }) == 1);
        System.out.println(new NO_221().maximalSquare(new char[][]{
                {'0'}
        }) == 0);
    }
}
