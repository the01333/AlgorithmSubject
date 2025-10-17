package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

public class NO_494 {
    private int count = 0;
    
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    private void backtrack(int[] nums, int target, int idx, int sum) {
        // 走到底判断当前和是否为目标值
        if (idx == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            // 如果不是继续回溯所有可能性, 只会有两种可能（加或减）
            backtrack(nums, target, idx + 1, sum + nums[idx]);
            backtrack(nums, target, idx + 1, sum - nums[idx]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new NO_494().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3) == 5);
        System.out.println(new NO_494().findTargetSumWays(new int[]{1}, 1) == 1);
    }
}
