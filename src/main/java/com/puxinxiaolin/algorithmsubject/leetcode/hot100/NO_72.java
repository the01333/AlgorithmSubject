package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

public class NO_72 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        /*
         dp[i][j] 表示 word1 的前 i 个字符转换为 word2 的前 j 个字符的最少处理次数
         dp[i - 1][j - 1] 替换    dp[i][j - 1] 删除    dp[i - 1][j] 插入
         */
        int[][] dp = new int[n1 + 1][n2 + 1];
        
        // 第一行和第一列需要额外处理
        // 第一行是 word1 为空变为 word2 的最少次数
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列是 word2 为空变为 word1 的最少次数
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // 如果字符一样无需编辑, 只需继承上一次的次数
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 否则尝试三种编辑方式
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        System.out.println(new NO_72().minDistance("horse", "ros") == 3);
        System.out.println(new NO_72().minDistance("intention", "execution") == 5);
    }
}
