package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

import java.util.Arrays;

public class NO_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, temp, 0, nums1.length);
        System.arraycopy(nums2, 0, temp, nums1.length, nums2.length);
        System.out.println(Arrays.toString(temp));
        
        Arrays.sort(temp);
        
        int len = temp.length;
        if (len % 2 == 0) {
            return (double) (temp[len / 2 - 1] + temp[len / 2]) / 2;
        } else {
            return temp[len / 2];
        }
    }

    public static void main(String[] args) {
        System.out.println(new NO_4().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(new NO_4().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
