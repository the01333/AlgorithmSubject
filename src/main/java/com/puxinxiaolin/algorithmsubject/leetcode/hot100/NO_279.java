package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

/**
 * @Description: dp[5] = Math.min(dp[5], dp[5 - 2 * 2] + 1) => dp[5] = Math.min(dp[5], dp[1] + 1)
 * @Author: YCcLin
 * @Date: 2025/10/16 11:10
 */
public class NO_279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {  
            dp[i] = i;
            // 枚举平方数的基数
            for (int j = 1; i - j * j >= 0; j++) {
                // + 1 是因为还要算上当前平方数
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NO_279().numSquares(12) == 3);
        System.out.println(new NO_279().numSquares(13) == 2);
    }
}
