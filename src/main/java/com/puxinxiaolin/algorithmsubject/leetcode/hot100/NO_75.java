package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

import java.util.Arrays;

public class NO_75 {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 2) {
                swap(nums, mid, high--);
            } else {
                mid++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        NO_75 no75 = new NO_75();
        int[] n1 = {2, 0, 2, 1, 1, 0};
        int[] a1 = {0, 0, 1, 1, 2, 2};
        no75.sortColors(n1);
        System.out.println(Arrays.equals(n1, a1));
        
        int[] n2 = {2, 0, 1};
        int[] a2 = {0, 1, 2};
        no75.sortColors(n2);
        System.out.println(Arrays.equals(n2, a2));
    }
}
