package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

/**
 * @Description: 回文数可以优先考虑“中心扩展法”, 即以一个点为中心, 向左右两边扩展（奇数以 i, 偶数以 i 和 i + 1）
 * @Author: YCcLin
 * @Date: 2025/10/18 9:53
 */
public class NO_647 {
    public int countSubstrings(String s) {
        int n = s.length();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            // 以 i 为中心的奇数长度回文子串
            cnt += expandAroundCenter(s, i, i);
            // 以 i、i+1 为中心的偶数长度回文子串
            cnt += expandAroundCenter(s, i, i + 1);
        }

        return cnt;
    }

    /**
     * <p>中心扩展法</p><br/>
     * 对每个字符，分别作为奇数长度回文的中心（如 "aba" 的中心是 'b'）
     * 对每对相邻字符，作为偶数长度回文的中心（如 "abba" 的中心是两个 'b' 之间）
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int expandAroundCenter(String s, int left, int right) {
        int cnt = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            cnt++;
            left--;
            right++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new NO_647().countSubstrings("abc") == 3);
        System.out.println(new NO_647().countSubstrings("aaa") == 6);
    }
}
