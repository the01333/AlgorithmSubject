package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

public class NO_8 {
    public int myAtoi(String s) {
        if (s == null) return 0;

        // 删除空格
        s = s.trim();
        if (s.isEmpty()) return 0;

        int i = 0;
        boolean isNegative = false;
        // 有符号去除符号
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            isNegative = s.charAt(i) == '-';
            i++;
        }

        long res = 0;
        // 通过数字法可以去除前导 0
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int num = s.charAt(i) - '0';
            res = res * 10 + num;

            if (!isNegative && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (isNegative && -res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return isNegative ? (int) -res : (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new NO_8().myAtoi("42") == 42);
        System.out.println(new NO_8().myAtoi("-042") == -42);
        System.out.println(new NO_8().myAtoi("1337c0d3") == 1337);
        System.out.println(new NO_8().myAtoi("0-1") == 0);
        System.out.println(new NO_8().myAtoi("words and 987") == 0);
    }
}
