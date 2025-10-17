package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

public class NO_5 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int startIndex = 0, len = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = chars.length - 1; j > i; j--) {
                if (j - i + 1 <= len) break;
                
                if (isPalindromic(chars, i , j)) {
                    // 更新待追加的长度
                    len = j - i + 1;
                    // 更新开始索引
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + len);
    }

    private boolean isPalindromic(char[] chars, int l, int r) {
        while (l < r) {
            if (chars[l++] != chars[r--]) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new NO_5().longestPalindrome("babad"));
        System.out.println(new NO_5().longestPalindrome("cbbd"));
    }
}
