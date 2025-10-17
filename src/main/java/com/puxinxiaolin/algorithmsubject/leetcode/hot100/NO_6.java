package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

/*
row = 5
1       9         17        25
2     8 10     16 18     24 26
3   7   11   15   19   23   27   31
4 6     12 14     20 22     28 30
5       13        21        29

1 9
 */
public class NO_6 {
    public String convert(String s, int numRows) {
        int len = s.length();
        char[] chars = s.toCharArray();
        char[] ans = new char[len];
        // 特判: 只有1行或行数大于字符串长度直接返回
        if (numRows == 1 || numRows > len) {
            return s;
        }

        for (int i = 0, idx = 0, left = (numRows - 1) * 2, right = 0; i < numRows; i++, left -= 2, right += 2) {
            // 每次把当前行的第一个字符直接放入
            ans[idx++] = chars[i];
            // 取出符合当前行的字符串
            for (int j = i; j < len; ) {
                // 本质就是加 left 和 right
                j += left;
                // 排除最后一行，避免字符重复连续添加
                if (left != 0 && j < len) {
                    ans[idx++] = chars[j];
                }
                j += right;
                // 排除第一行，避免字符重复连续添加
                if (right != 0 && j < len) {
                    ans[idx++] = chars[j];
                }
            }
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        System.out.println(new NO_6().convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
        System.out.println(new NO_6().convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
    }
}
