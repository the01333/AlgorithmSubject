package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

import java.util.Arrays;
import java.util.LinkedList;

public class NO_739 {
    public int[] dailyTemperatures(int[] temperatures) {
//        return v1_unPassed(temperatures);
        int len = temperatures.length;
        int[] res = new int[len];

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer findIndex = stack.pop();
                res[findIndex] = i - findIndex;
            }
            stack.push(i);
        }
        return res;
    }

    private static int[] v1_unPassed(int[] temperatures) {
        int len = temperatures.length;
        if (len == 1) return new int[]{0};

        int[] res = new int[len];
        for (int left = 0; left < len; left++) {
            for (int right = left + 1; right < len; right++) {
                if (temperatures[right] > temperatures[left]) {
                    res[left] = right - left;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NO_739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(new NO_739().dailyTemperatures(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(new NO_739().dailyTemperatures(new int[]{30, 60, 90})));
    }
}
