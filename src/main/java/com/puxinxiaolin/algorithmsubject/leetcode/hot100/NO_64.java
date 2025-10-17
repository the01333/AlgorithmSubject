package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

import java.util.Arrays;

public class NO_64 {
    private int ans = Integer.MAX_VALUE;
    private int[][] memory;

    public int minPathSum(int[][] grid) {
        // 自己手写的 dfs, 可惜超时
//        dfs(grid, 0, 0, 0);
//        return ans;

        // 自己手写的 dfs + 记忆化搜索, 能过
        int h = grid.length, w = grid[0].length;
        memory = new int[h][w];
        for (int i = 0; i < h; i++) Arrays.fill(memory[i], -1);

        return dfsPlus(grid, h - 1, w - 1);

        // dp 解法
//        return dp(grid);
    }

    /**
     * dp 写法
     * 
     * @param grid
     * @return
     */
    private static int dp(int[][] grid) {
        int h = grid.length, w = grid[0].length;
        // dp[i][j] 表示 (i, j) 位置的最小路径和
        // dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        int[][] dp = new int[h][w];
        dp[0][0] = grid[0][0];

        // 第一列和第一行特殊处理
        for (int j = 1; j < w; j++) dp[0][j] = dp[0][j - 1] + grid[0][j];
        for (int i = 1; i < h; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[h - 1][w - 1];
    }

    /**
     * 自己手写的进行优化, dfs + 记忆化搜索
     *
     * @param grid 距离矩阵
     * @param x 行
     * @param y 列
     * @return 
     */
    private int dfsPlus(int[][] grid, int x, int y) {
        if (x < 0 || y < 0) return Integer.MAX_VALUE;
        if (x == 0 && y == 0) return grid[0][0];
        if (memory[x][y] != -1) return memory[x][y];
        
        memory[x][y] = grid[x][y] + Math.min(dfsPlus(grid, x - 1, y), dfsPlus(grid, x, y - 1));
        return memory[x][y];
    }

    /**
     * 自己手写的 dfs, 可惜超时
     *
     * @param grid 距离矩阵
     * @param x    行
     * @param y    列
     * @param sum  每个阶段的累加和
     */
    private void dfs(int[][] grid, int x, int y, int sum) {
        sum += grid[x][y];
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            ans = Math.min(ans, sum);
            return;
        }

        if (x + 1 < grid.length) dfs(grid, x + 1, y, sum);
        if (y + 1 < grid[0].length) dfs(grid, x, y + 1, sum);
    }

    public static void main(String[] args) {
        System.out.println(new NO_64().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}) == 7);
        System.out.println(new NO_64().minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}) == 12);
    }
}
