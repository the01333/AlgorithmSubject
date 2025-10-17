package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

import java.util.Arrays;

public class NO_581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] newNums = nums.clone();
        Arrays.sort(newNums);
        
        int i = 0, j = nums.length - 1;
        while (i <= j && nums[i] == newNums[i]) i++;
        while (i <= j && nums[j] == newNums[j]) j--;
        return j - i + 1;
    }

    public static void main(String[] args) {
        NO_581 no581 = new NO_581();
        System.out.println(no581.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}) == 5);
        System.out.println(no581.findUnsortedSubarray(new int[]{1, 2, 3, 4}) == 0);
        System.out.println(no581.findUnsortedSubarray(new int[]{1}) == 0);
    }
}
