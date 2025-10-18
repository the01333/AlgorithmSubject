package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

/**
 * @Description: <br/>
 * G(n)：有 n 个节点时, 能组成的二叉搜索树的数量 <br/>
 * f(i)：以第 i 个节点为根节点时, 能组成的二叉搜索树的数量 <br/>
 * 故此推出公式： <br/>
 * <strong>
 * G(n) = f(1) + f(2) + ... + f(n - 1) + f(n) <br/>
 * f(i) = G(i - 1) * G(n - i) <br/>
 * </strong>
 * @Author: YCcLin
 * @Date: 2025/10/18 12:29
 */
public class NO_96 {
    public int numTrees(int n) {
        // dp[i] 相当于 G(i), i 个节点能组成的二叉搜索树的数量
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            // 以第 j 个节点为根节点的二叉搜索树的数量
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NO_96().numTrees(3) == 5);
        System.out.println(new NO_96().numTrees(1) == 1);
    }
}
