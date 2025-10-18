package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

import java.util.Arrays;

public class NO_300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        
        int res = 0;
        // dp[i] 表示以 nums[i] 结尾的最长递增子序列长度
        int[] dp = new int[nums.length];
        // 每个元素都可以单独形成长度为 1 的子序列
        Arrays.fill(dp, 1);
        
        // 决定每次的结束索引: 0 ~ 数组长度 - 1
        for (int i = 0; i < nums.length; i++) {
            // 从头到结束索引进行遍历: 0 ~ i
            for (int j = 0; j < i; j++) {
                // 只要当前遍历的元素小于当前轮的结尾元素, 则更新 dp[i]
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new NO_300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}) == 4);
        System.out.println(new NO_300().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}) == 4);
        System.out.println(new NO_300().lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}) == 1);
    }
}
