package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

import java.util.Arrays;

/**
 * @Description: 下一个排列
 * 1️⃣先找到第一个小于右侧的数 x（从右往左, 确保了 x 右边的数是递减的）
 * 2️⃣找到 x 右侧最小的大于 x 的数 y（从右往左）, 交换 x 和 y
 * 3️⃣对 y 右边的所有数做升序排列
 * @Author: YCcLin
 * @Date: 2025/10/17 10:30
 */
public class NO_31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // 1. 从右往左, 先找到第一个小于右侧的数 x
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        // 如果找到了进入第二步, 否则反转整个数组
        if (i >= 0) {
            // 2. 找到 x 右侧最小的大于 x 的数 y, 交换 x 和 y
            int j = n - 1;
            while (nums[j] <= nums[i]) j--;

            swap(nums, i, j);
        }

        // 3. 对 y 右边的数进行升序排列
        reverse(nums, i + 1, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        NO_31 test = new NO_31();
        int[] n = {1, 2, 3};
        test.nextPermutation(n);
        System.out.println(Arrays.equals(n, new int[]{1, 3, 2}));

        n = new int[]{3, 2, 1};
        test.nextPermutation(n);
        System.out.println(Arrays.equals(n, new int[]{1, 2, 3}));

        n = new int[]{1, 1, 5};
        test.nextPermutation(n);
        System.out.println(Arrays.equals(n, new int[]{1, 5, 1}));
    }
}
